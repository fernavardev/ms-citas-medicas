package com.fernavardev.ms_citas_medicas.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernavardev.ms_citas_medicas.model.CitaMedica;
import com.fernavardev.ms_citas_medicas.repository.CitaMedicaRepository;

@Service
public class CitaMedicaServiceImpl implements CitaMedicaService {

    private static final Logger log = LoggerFactory.getLogger(CitaMedicaServiceImpl.class);

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    @Override
    public List<CitaMedica> getAllCitas() {
        log.info("Obteniendo todas las citas medicas");
        return citaMedicaRepository.findAll();
    }

    @Override
    public CitaMedica getCitaById(Long id) {
        log.info("Buscando cita medica con id {}", id);
        return citaMedicaRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("No se encontro una cita con id {}", id);
                    return new RuntimeException("No se encontró una cita con id " + id);
                });
    }

    @Override
    public CitaMedica createCita(CitaMedica cita) {
        log.info("Creando nueva cita para paciente {}", cita.getPaciente());
        return citaMedicaRepository.save(cita);
    }

    @Override
    public CitaMedica updateCita(Long id, CitaMedica cita) {
        log.info("Actualizando cita medica con id {}", id);
        if (citaMedicaRepository.existsById(id)) {
            cita.setId(id);
            return citaMedicaRepository.save(cita);
        } else {
            log.warn("No se encontro una cita para actualizar con id {}", id);
            throw new RuntimeException("No se encontró una cita con id " + id);
        }
    }

    @Override
    public void deleteCita(Long id) {
        log.info("Eliminando cita medica con id {}", id);
        if (citaMedicaRepository.existsById(id)) {
            citaMedicaRepository.deleteById(id);
        } else {
            log.warn("No se encontro una cita para eliminar con id {}", id);
            throw new RuntimeException("No se encontró una cita con id " + id);
        }
    }

    @Override
    public List<CitaMedica> getCitasByEstado(String estado) {
        log.info("Buscando citas por estado {}", estado);
        List<CitaMedica> citas = citaMedicaRepository.findByEstadoIgnoreCase(estado);
        if (citas.isEmpty()) {
            log.warn("No existen citas con estado {}", estado);
            throw new RuntimeException("No existen citas con estado: " + estado);
        }
        return citas;
    }

    @Override
    public List<CitaMedica> getCitasDisponibles() {
        log.info("Buscando citas disponibles");
        List<CitaMedica> citas = citaMedicaRepository.findByEstadoIgnoreCase("disponible");
        if (citas.isEmpty()) {
            log.warn("No existen citas disponibles");
            throw new RuntimeException("No existen citas disponibles");
        }
        return citas;
    }

    @Override
    public List<CitaMedica> getCitasByMedico(String medico) {
        log.info("Buscando citas del medico {}", medico);
        List<CitaMedica> citas = citaMedicaRepository.findByMedicoIgnoreCase(medico);
        if (citas.isEmpty()) {
            log.warn("No existen citas para el medico {}", medico);
            throw new RuntimeException("No existen citas para el medico: " + medico);
        }
        return citas;
    }

    @Override
    public List<CitaMedica> getCitasByEspecialidad(String especialidad) {
        log.info("Buscando citas por especialidad {}", especialidad);
        List<CitaMedica> citas = citaMedicaRepository.findByEspecialidadIgnoreCase(especialidad);
        if (citas.isEmpty()) {
            log.warn("No existen citas para la especialidad {}", especialidad);
            throw new RuntimeException("No existen citas para la especialidad: " + especialidad);
        }
        return citas;
    }

    @Override
    public CitaMedica reservarCita(Long id) {
        log.info("Reservando cita con id {}", id);
        CitaMedica cita = citaMedicaRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("No se encontro una cita para reservar con id {}", id);
                    return new RuntimeException("No se encontró una cita con id " + id);
                });

        cita.setEstado("reservada");
        return citaMedicaRepository.save(cita);
    }

    @Override
    public CitaMedica cancelarCita(Long id) {
        log.info("Cancelando cita con id {}", id);
        CitaMedica cita = citaMedicaRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("No se encontro una cita para cancelar con id {}", id);
                    return new RuntimeException("No se encontró una cita con id " + id);
                });

        cita.setEstado("cancelada");
        return citaMedicaRepository.save(cita);
    }
}