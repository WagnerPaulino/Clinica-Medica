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
import com.clinicaMedica.services.ConsultaService;

@RestController
@CrossOrigin
public class ConsultaRest {
private Logger log = LoggerFactory.getLogger(Consulta.class);
	
	@Autowired
	private ConsultaService service;
	
	@GetMapping(path = "/api/consultas")
	public ResponseEntity<?> findAll(Pageable pageable) {
		log.debug("[findAll] Requisição para buscar todos consultas");
		Page<Consulta> consultas = service.findAll(pageable);
		log.debug("=========" + consultas);
		return ResponseEntity.ok().body(consultas);

	}

	@GetMapping(path = "/api/consultas/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Long id) {
		log.debug("[find] Requisição para buscar Consulta. id={}", id);
		boolean exists = service.exists(id);
		if (exists) {
			log.debug("[find] Consulta encontrado.");
			return ResponseEntity.ok(service.findOne(id));
		}
		log.debug("[find] Consulta NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping(path = "/api/consultas/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		log.debug("[delete] Requisição para deletar Consulta. id={}", id);
		boolean exists = service.exists(id);
		if (exists) {
			log.debug("[delete] Consulta encontrado.");
			service.delete(id);
			log.debug("[delete] Consulta deletado com sucesso.");
			return ResponseEntity.ok().build();
		}
		log.debug("[delete] Consulta NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}

	@PostMapping(path = "/api/consultas")
	public ResponseEntity<?> insert(@Valid @RequestBody Consulta consulta) {
		log.debug("[insert] Requisição para inserir Consulta...");
		Consulta insertedConsulta = service.insert(consulta);
		log.debug("[insert] Consulta inserido com sucesso. id={}", insertedConsulta.getId());
		return ResponseEntity.ok(insertedConsulta);
	}

	@PutMapping(path = "/api/consultas/{id}")
	public ResponseEntity<?> update(@Valid @PathVariable("id") Long id, @RequestBody Consulta consulta) {
		log.debug("[update] Requisição para atualizar de Consulta...");
		boolean exists = service.exists(id);
		if (exists) {
			log.debug("[update] Consulta encontrado.");
			Consulta updatedConsulta = service.update(consulta);
			log.debug("[update] Consulta atualizado com sucesso.");
			return ResponseEntity.ok(updatedConsulta);
		}
		log.debug("[update] Consulta NÃO encontrado.");
		return ResponseEntity.notFound().build();
	}
}
