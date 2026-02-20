package com.DTO;

public final class TaskDTO {
	private final Long id;
	private final String titolo;
	private final String stato;
	
	public TaskDTO(Long id, String titolo, String stato) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.titolo = titolo;
		this.stato = stato;
	}
	public Long getId() {
		return id;
	}
	public String getTitolo() {
		return titolo;
	}
	public String getStato() {
		return stato;
	}
	
	
}
