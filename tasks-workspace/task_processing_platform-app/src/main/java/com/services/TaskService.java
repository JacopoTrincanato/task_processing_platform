package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.TaskDTO;
import com.enums.Stato;
import com.mappers.TaskMapper;
import com.models.Progetto;
import com.models.Task;
import com.repositories.ProgettoRepository;
import com.repositories.TaskRepository;
import com.utilities.BaseService;
import com.utilities.TaskProcessor;

import jakarta.transaction.Transactional;

@Service
public class TaskService implements BaseService<Task, Long> {

	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private ProgettoRepository progettoRepo;
	
	@Autowired
	private TaskProcessor processor;
	
	@Override
	@Transactional
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
	
	@Transactional
	public Task completaTask(Long id) {
		Task taskDaProcessare = taskRepo.findById(id).orElse(null);
		
		if (taskDaProcessare.getStato() != Stato.DONE) {
			processor.submit(taskDaProcessare);
		}
		
		taskRepo.save(taskDaProcessare);
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
		List<Task> tasks = progettoDaEsaminare.getTasks();
		double percentualeCompletata = tasks.stream()
				.filter(t -> t.getStato() == Stato.DONE)
				.count() * 100 / tasks.size();
		return percentualeCompletata;
		
	}

}
