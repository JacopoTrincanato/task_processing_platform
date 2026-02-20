package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
