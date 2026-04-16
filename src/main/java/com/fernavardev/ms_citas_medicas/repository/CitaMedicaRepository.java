package com.fernavardev.ms_citas_medicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernavardev.ms_citas_medicas.model.CitaMedica;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long> {

    List<CitaMedica> findByEstadoIgnoreCase(String estado);

    List<CitaMedica> findByMedicoIgnoreCase(String medico);

    List<CitaMedica> findByEspecialidadIgnoreCase(String especialidad);
}