package com.utilities;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import org.springframework.stereotype.Component;

import com.enums.Stato;
import com.models.Task;
import com.services.NotificaService;

@Component
public class TaskProcessor implements Processor<Task> {

	private final ExecutorService executor;
	private final BlockingQueue<Task> queue;
	private final NotificaService notificaService;
	
	public TaskProcessor(ExecutorService executor, BlockingQueue<Task> queue, NotificaService notificaService) {
		super();
		this.executor = executor;
		this.queue = queue;
		this.notificaService = notificaService;
	}

	public void submit(Task t) {
		queue.offer(t);
	}
	
	public void start() {
		for (int i = 0; i < 4; i++) {
			executor.submit(this::consume);
		}
	}
	
	@Override
	public void process(Task item) {
		// TODO Auto-generated method stub
		if (item.getStato() == Stato.TODO) {
			item.setStato(Stato.IN_PROGRESS);
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		item.setStato(Stato.DONE);
		notificaService.inviaNotifica("Task " + item.getTitolo() + " completato");
	}
	
	private void consume() {
		while(true) {
			Task task = new Task();
			try {
				task = queue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			process(task);
		}
	}

}
