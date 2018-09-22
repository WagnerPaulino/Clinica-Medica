package com.clinicaMedica.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinicaMedica.domain.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
