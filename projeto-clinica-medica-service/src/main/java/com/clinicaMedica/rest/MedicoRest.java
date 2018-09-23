package com.clinicaMedica.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinicaMedica.domain.Consulta;
import com.clinicaMedica.domain.Medico;
import com.clinicaMedica.services.MedicoService;

@RestController
@CrossOrigin
public class MedicoRest {
	private Logger log = LoggerFactory.getLogger(Consulta.class);
	@Autowired
	private MedicoService service;

	@GetMapping(path = "/api/medicos")
	public ResponseEntity<?> findAll(Pageable pageable) {
		log.debug("[findAll] Requisição para buscar todos medicos");
		Page<Medico> medicos = service.findAll(pageable);
		log.debug("=========" + medicos);
		return ResponseEntity.ok().body(medicos);

	}

	@GetMapping(path = "/api/medicos/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		log.debug("[find] Requisição para buscar Medico. id={}", id);
		boolean exists = service.exists(id);
		if (exists) {
			log.debug("[find] Medico encontrado.");
			return ResponseEntity.ok(service.findOne(id));
		}
		log.debug("[find] Medico NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(path = "/api/medicos/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		log.debug("[delete] Requisição para deletar Medico. id={}", id);
		boolean exists = service.exists(id);
		if (exists) {
			log.debug("[delete] Medico encontrado.");
			service.delete(id);
			log.debug("[delete] Medico deletado com sucesso.");
			return ResponseEntity.ok().build();
		}
		log.debug("[delete] Medico NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	@PostMapping(path = "/api/medicos")
	public ResponseEntity<?> insert(@Valid @RequestBody Medico medico) {
		log.debug("[insert] Requisição para inserir Medico...");
		Medico insertedMedico = service.insert(medico);
		log.debug("[insert] Medico inserido com sucesso. id={}", insertedMedico.getId());
		return ResponseEntity.ok(insertedMedico);
	}

	@PutMapping(path = "/api/medicos/{id}")
	public ResponseEntity<?> update(@Valid @PathVariable("id") Long id, @RequestBody Medico medico) {
		log.debug("[update] Requisição para atualizar de Medico...");
		boolean exists = service.exists(id);
		if (exists) {
			log.debug("[update] Medico encontrado.");
			Medico updatedMedico = service.update(medico);
			log.debug("[update] Medico atualizado com sucesso.");
			return ResponseEntity.ok(updatedMedico);
		}
		log.debug("[update] Medico NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

}