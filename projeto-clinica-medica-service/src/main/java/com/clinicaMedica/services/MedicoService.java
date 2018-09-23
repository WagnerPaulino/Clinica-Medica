package com.clinicaMedica.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clinicaMedica.domain.Medico;
import com.clinicaMedica.repositorys.MedicoRepository;

@Service
public class MedicoService {
	@Autowired
	private MedicoRepository repository;

	@Cacheable(value = "medico")
	public Page<Medico> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Medico findOne(Long id) {
		return repository.findById(id).orElse(new Medico());
	}

	public boolean exists(Long id) {
		return repository.existsById(id);
	}

	@Transactional
	@CacheEvict(value = "medico", allEntries = true)
	public void delete(Long id) {
		repository.delete(repository.findById(id).orElse(new Medico()));
	}

	@Transactional
	@CachePut(value = "medico")
	@CacheEvict(value = "medico", allEntries = true)
	public Medico insert(Medico newMedico) {
		return repository.save(newMedico);
	}

	@Transactional
	@CachePut(value = "medico")
	@CacheEvict(value = "medico", allEntries = true)
	public Medico update(Medico newMedico) {
		return repository.save(newMedico);
	}
}