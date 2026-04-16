package com.fernavardev.ms_citas_medicas.service;

import java.util.List;

import com.fernavardev.ms_citas_medicas.model.CitaMedica;

public interface CitaMedicaService {

    List<CitaMedica> getAllCitas();

    CitaMedica getCitaById(Long id);

    CitaMedica createCita(CitaMedica cita);

    CitaMedica updateCita(Long id, CitaMedica cita);

    void deleteCita(Long id);

    List<CitaMedica> getCitasByEstado(String estado);

    List<CitaMedica> getCitasDisponibles();

    List<CitaMedica> getCitasByMedico(String medico);

    List<CitaMedica> getCitasByEspecialidad(String especialidad);

    CitaMedica reservarCita(Long id);

    CitaMedica cancelarCita(Long id);
}