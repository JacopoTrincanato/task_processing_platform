package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.models.Progetto;
import com.repositories.ProgettoRepository;
import com.utilities.BaseService;

public class ProgettoService implements BaseService<Progetto, Long> {
	
	@Autowired
	private ProgettoRepository progettoRepo;

	@Override
	public Progetto save(Progetto entity) {
		// TODO Auto-generated method stub
		return progettoRepo.save(entity);
	}

	@Override
	public Optional<Progetto> findById(Long id) {
		// TODO Auto-generated method stub
		return progettoRepo.findById(id);
	}

	@Override
	public List<Progetto> findAll() {
		// TODO Auto-generated method stub
		return progettoRepo.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		progettoRepo.deleteById(id);
	}
}
