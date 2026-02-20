package com.mappers;

import com.DTO.TaskDTO;
import com.models.Task;

public class TaskMapper {
	public static TaskDTO mapToTaskDto(Task task) {
		TaskDTO taskDTO = new TaskDTO(task.getId(), task.getTitolo(), task.getStato().toString());
		return taskDTO;
	}
}
