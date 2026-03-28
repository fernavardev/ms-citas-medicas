package com.fernavardev.ms_citas_medicas.controller;

import com.fernavardev.ms_citas_medicas.model.CitaMedica;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CitaMedicaController {

    private List<CitaMedica> citas;

    public CitaMedicaController() {
        citas = new ArrayList<>();

        citas.add(new CitaMedica(1, "Ana Torres", "Dr. Pérez", "Medicina General",
                "2026-03-29", "09:00", "disponible", "Control general"));

        citas.add(new CitaMedica(2, "Luis Soto", "Dra. Ramírez", "Pediatría",
                "2026-03-29", "10:00", "reservada", "Control niño sano"));

        citas.add(new CitaMedica(3, "María Pérez", "Dr. González", "Dermatología",
                "2026-03-30", "11:30", "cancelada", "Revisión de piel"));

        citas.add(new CitaMedica(4, "Carlos Díaz", "Dr. Pérez", "Medicina General",
                "2026-03-30", "12:00", "disponible", "Chequeo preventivo"));

        citas.add(new CitaMedica(5, "Fernanda Rojas", "Dra. Salinas", "Traumatología",
                "2026-03-31", "09:30", "reservada", "Dolor de rodilla"));

        citas.add(new CitaMedica(6, "Pedro Molina", "Dr. Vega", "Cardiología",
                "2026-03-31", "10:30", "disponible", "Control cardiológico"));

        citas.add(new CitaMedica(7, "Valentina Castro", "Dra. Ramírez", "Pediatría",
                "2026-04-01", "08:30", "reservada", "Consulta por fiebre"));

        citas.add(new CitaMedica(8, "Jorge Herrera", "Dr. González", "Dermatología",
                "2026-04-01", "11:00", "disponible", "Evaluación dermatológica"));
    }

    @GetMapping("/citas")
    public List<CitaMedica> obtenerCitas() {
        return citas;
    }

    @GetMapping("/citas/{id}")
    public Object obtenerCitaPorId(@PathVariable int id) {
        for (CitaMedica cita : citas) {
            if (cita.getId() == id) {
                return cita;
            }
        }
        return "No se encontró una cita con id " + id;
    }

    @GetMapping("/citas/estado/{estado}")
    public Object obtenerCitasPorEstado(@PathVariable String estado) {
        List<CitaMedica> resultado = new ArrayList<>();

        for (CitaMedica cita : citas) {
            if (cita.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(cita);
            }
        }

        if (resultado.isEmpty()) {
            return "No existen citas con estado: " + estado;
        }

        return resultado;
    }

    @GetMapping("/citas/disponibles")
    public Object obtenerCitasDisponibles() {
        List<CitaMedica> resultado = new ArrayList<>();

        for (CitaMedica cita : citas) {
            if (cita.getEstado().equalsIgnoreCase("disponible")) {
                resultado.add(cita);
            }
        }

        if (resultado.isEmpty()) {
            return "No existen citas disponibles";
        }

        return resultado;
    }

    @GetMapping("/citas/medico/{medico}")
    public List<CitaMedica> obtenerCitasPorMedico(@PathVariable String medico) {
        List<CitaMedica> resultado = new ArrayList<>();

        for (CitaMedica cita : citas) {
            if (cita.getMedico().equalsIgnoreCase(medico)) {
                resultado.add(cita);
            }
        }

        return resultado;
    }

    @GetMapping("/citas/especialidad/{especialidad}")
    public List<CitaMedica> obtenerCitasPorEspecialidad(@PathVariable String especialidad) {
        List<CitaMedica> resultado = new ArrayList<>();

        for (CitaMedica cita : citas) {
            if (cita.getEspecialidad().equalsIgnoreCase(especialidad)) {
                resultado.add(cita);
            }
        }

        return resultado;
    }

    @GetMapping("/citas/reservar/{id}")
    public String reservarCitaDemostrativa(@PathVariable int id) {
        for (CitaMedica cita : citas) {
            if (cita.getId() == id) {
                return "La cita con id " + id + " fue reservada correctamente";
            }
        }

        return "No se puede reservar. No existe una cita con id " + id;
    }

    @GetMapping("/citas/cancelar/{id}")
    public String cancelarCitaDemostrativa(@PathVariable int id) {
        for (CitaMedica cita : citas) {
            if (cita.getId() == id) {
                return "La cita con id " + id + " fue cancelada correctamente";
            }
        }

        return "No se puede cancelar. No existe una cita con id " + id;
    }
}