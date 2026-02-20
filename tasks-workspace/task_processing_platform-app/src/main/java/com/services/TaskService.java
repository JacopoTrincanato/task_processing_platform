package com.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.DTO.TaskDTO;
import com.enums.Stato;
import com.mappers.TaskMapper;
import com.models.Progetto;
import com.models.Task;
import com.repositories.ProgettoRepository;
import com.repositories.TaskRepository;
import com.utilities.BaseService;
import com.utilities.TaskProcessor;

public class TaskService implements BaseService<Task, Long> {

	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private ProgettoRepository progettoRepo;
	
	@Autowired
	private TaskProcessor processor;
	
	@Override
	public Task save(Task entity) {
		// TODO Auto-generated method stub
		return taskRepo.save(entity);
	}

	@Override
	public Optional<Task> findById(Long id) {
		// TODO Auto-generated method stub
		return taskRepo.findById(id);
	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return taskRepo.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		taskRepo.deleteById(id);
	}
	
	public Task completaTask(Long id) {
		List<Task> tasksDaProcessare = taskRepo.findAll().stream()
				.filter(t -> t.getStato() != Stato.DONE)
				.toList();
		
		Task taskDaProcessare = tasksDaProcessare.get(Integer.valueOf(id.toString()));
		
		processor.process(taskDaProcessare);
		
		return taskDaProcessare;
	}
	
	public List<TaskDTO> trovaTaskScaduti() {
		return taskRepo.findAll().stream()
				.filter(Task::isScaduto)
				.map(TaskMapper::mapToTaskDto)
				.toList();
	}
	
	public double percentualeCompletamento(Long idProgetto) {
		Progetto progettoDaEsaminare = progettoRepo.findById(idProgetto).get();
		long numeroDiTaskCompletate = progettoDaEsaminare.getTasks().stream()
				.filter(t -> t.getStato() == Stato.DONE)
				.count();
		double percentualeCompletata = (numeroDiTaskCompletate / progettoDaEsaminare.getTasks().size()) * 100;
		return percentualeCompletata;
		
	}

}
