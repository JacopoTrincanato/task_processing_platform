package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.models.Task;
import com.repositories.TaskRepository;
import com.utilities.BaseService;

public class TaskService implements BaseService<Task, Long> {

	@Autowired
	private TaskRepository taskRepo;
	
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

}
