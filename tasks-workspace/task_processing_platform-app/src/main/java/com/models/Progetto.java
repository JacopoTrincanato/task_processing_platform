package com.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="progetto")
public class Progetto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 5, max = 30, message = "Il nome non può essere più corto di 5 caratteri e più lungo di 30")
	@NotBlank(message = "Il valore del nome non può essere vuoto o null")
	private String nome;
	
	@Size(min = 5, max = 30, message = "Il nome non può essere più corto di 5 caratteri e più lungo di 30")
	@NotBlank(message = "Il valore del nome non può essere vuoto o null")
	private String descrizione;
	
	@NotNull
	private LocalDate dataCreazione;
	
	@OneToMany(mappedBy = "progetto")
	List<Task> tasks;
	
	public void addTask(Task t) {
		tasks.add(t);
	}
	
	public void removeTask(Task t) {
		tasks.remove(t);
	}
}
