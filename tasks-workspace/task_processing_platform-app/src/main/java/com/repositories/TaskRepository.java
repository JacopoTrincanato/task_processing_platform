package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enums.Stato;
import com.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByStato(Stato stato);
}
