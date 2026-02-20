package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.TaskDTO;
import com.mappers.TaskMapper;
import com.models.Task;
import com.services.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@GetMapping
	public ResponseEntity<List<TaskDTO>> getAllTasks() {
		List<TaskDTO> tasks = service.findAll().stream()
				.map(TaskMapper::mapToTaskDto)
				.toList();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Task> aggiungiTask(@Valid @RequestBody Task task) {
		return new ResponseEntity<Task>(service.save(task), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> aggiornaTask(@Valid @RequestBody Task task, @PathVariable Long id) {
		if (service.findById(id).isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		task.setId(id);
		return new ResponseEntity<>(service.save(task), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Task> eliminaTask(@Valid @RequestBody Task task, @PathVariable Long id) {
		if (service.findById(id).isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/*@PostMapping("/{id}/process")
	public ResponseEntity<TaskDTO>  */
	
}
