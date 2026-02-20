package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Notifica;
import com.repositories.NotificaRepository;
import com.utilities.BaseService;

@Service
public class NotificaService implements BaseService<Notifica, Long> {

	@Autowired
	private NotificaRepository notificaRepo;
	
	@Override
	public Notifica save(Notifica entity) {
		// TODO Auto-generated method stub
		return notificaRepo.save(entity);
	}

	@Override
	public Optional<Notifica> findById(Long id) {
		// TODO Auto-generated method stub
		return notificaRepo.findById(id);
	}

	@Override
	public List<Notifica> findAll() {
		// TODO Auto-generated method stub
		return notificaRepo.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		notificaRepo.deleteById(id);
	}
	
	public String inviaNotifica(String notifica) {
		return notifica;
	}

}
