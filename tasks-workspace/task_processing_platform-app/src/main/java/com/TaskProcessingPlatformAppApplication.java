package com;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.models.Task;

@SpringBootApplication
public class TaskProcessingPlatformAppApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public ExecutorService executor() {
	    return Executors.newFixedThreadPool(4);
	}

	@Bean
	public BlockingQueue<Task> queue() {
	    return new LinkedBlockingQueue<>();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TaskProcessingPlatformAppApplication.class, args);
	}

}
