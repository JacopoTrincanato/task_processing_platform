package com.models;

import java.time.LocalDate;

import com.enums.Priorita;
import com.enums.Stato;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 5, max = 30, message = "Il titolo non può essere più corto di 5 caratteri e più lungo di 30")
	@NotBlank(message = "Il valore del titolo non può essere vuoto o null")
	private String titolo;
	
	@Size(min = 5, max = 250, message = "la descrizione non può essere più corta di 5 caratteri e più lunga di 250")
	@NotBlank(message = "Il valore della descrizione non può essere vuoto o null")
	private String descrizione;
	
	@Enumerated(EnumType.STRING)
	private Stato stato;
	
	@Enumerated(EnumType.STRING)
	private Priorita priorita;
	
	@NotNull
	private LocalDate deadLine;
	
	@ManyToOne
	@JoinColumn(name = "progetto_id", nullable = false)
	private Progetto progetto;
	
	public boolean isScaduto() {
		return this.deadLine.isBefore(LocalDate.now());
	}
	
	public void completa() {
		this.stato = Stato.DONE;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public Priorita getPriorita() {
		return priorita;
	}

	public void setPriorita(Priorita priorita) {
		this.priorita = priorita;
	}

	public LocalDate getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(LocalDate deadLine) {
		this.deadLine = deadLine;
	}

	public Progetto getProgetto() {
		return progetto;
	}

	public void setProgetto(Progetto progetto) {
		this.progetto = progetto;
	}
	
}
