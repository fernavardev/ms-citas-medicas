package com.fernavardev.ms_citas_medicas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fernavardev.ms_citas_medicas.model.CitaMedica;
import com.fernavardev.ms_citas_medicas.service.CitaMedicaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "*")
public class CitaMedicaController {

    @Autowired
    private CitaMedicaService citaMedicaService;

    @GetMapping
    public List<CitaMedica> obtenerCitas() {
        return citaMedicaService.getAllCitas();
    }

    @GetMapping("/{id}")
    public CitaMedica obtenerCitaPorId(@PathVariable Long id) {
        return citaMedicaService.getCitaById(id);
    }

    @PostMapping
    public CitaMedica crearCita(@Valid @RequestBody CitaMedica cita) {
        return citaMedicaService.createCita(cita);
    }

    @PutMapping("/{id}")
    public CitaMedica actualizarCita(@PathVariable Long id, @Valid @RequestBody CitaMedica cita) {
        return citaMedicaService.updateCita(id, cita);
    }

    @DeleteMapping("/{id}")
    public void eliminarCita(@PathVariable Long id) {
        citaMedicaService.deleteCita(id);
    }

    @GetMapping("/estado/{estado}")
    public List<CitaMedica> obtenerCitasPorEstado(@PathVariable String estado) {
        return citaMedicaService.getCitasByEstado(estado);
    }

    @GetMapping("/disponibles")
    public List<CitaMedica> obtenerCitasDisponibles() {
        return citaMedicaService.getCitasDisponibles();
    }

    @GetMapping("/medico/{medico}")
    public List<CitaMedica> obtenerCitasPorMedico(@PathVariable String medico) {
        return citaMedicaService.getCitasByMedico(medico);
    }

    @GetMapping("/especialidad/{especialidad}")
    public List<CitaMedica> obtenerCitasPorEspecialidad(@PathVariable String especialidad) {
        return citaMedicaService.getCitasByEspecialidad(especialidad);
    }

    @PutMapping("/reservar/{id}")
    public CitaMedica reservarCita(@PathVariable Long id) {
        return citaMedicaService.reservarCita(id);
    }

    @PutMapping("/cancelar/{id}")
    public CitaMedica cancelarCita(@PathVariable Long id) {
        return citaMedicaService.cancelarCita(id);
    }
}