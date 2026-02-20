package com.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="notifiche")
public class Notifica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 5, max = 30, message = "Il titolo non può essere più corto di 5 caratteri e più lungo di 30")
	@NotBlank(message = "Il valore del titolo non può essere vuoto o null")
	private String destinatario;
	
	@Size(min = 5, max = 100, message = "il messaggio non può essere più cort0 di 5 caratteri e più lungo di 100")
	@NotBlank(message = "Il valore del messaggio non può essere vuoto o null")
	private String messaggio;
	
	@NotNull
	private LocalDateTime dataInvio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public LocalDateTime getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(LocalDateTime dataInvio) {
		this.dataInvio = dataInvio;
	}
}
