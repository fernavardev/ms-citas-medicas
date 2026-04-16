package com.fernavardev.ms_citas_medicas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fernavardev.ms_citas_medicas.model.CitaMedica;
import com.fernavardev.ms_citas_medicas.repository.CitaMedicaRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final CitaMedicaRepository repository;

    public DataLoader(CitaMedicaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {

            repository.save(new CitaMedica("Ana Torres", "Dr. Pérez", "Medicina General",
                    "2026-03-29", "09:00", "disponible", "Control general"));

            repository.save(new CitaMedica("Luis Soto", "Dra. Ramírez", "Pediatría",
                    "2026-03-29", "10:00", "reservada", "Control niño sano"));

            repository.save(new CitaMedica("María Pérez", "Dr. González", "Dermatología",
                    "2026-03-30", "11:30", "cancelada", "Revisión de piel"));

            repository.save(new CitaMedica("Carlos Díaz", "Dr. Pérez", "Medicina General",
                    "2026-03-30", "12:00", "disponible", "Chequeo preventivo"));

            repository.save(new CitaMedica("Fernanda Rojas", "Dra. Salinas", "Traumatología",
                    "2026-03-31", "09:30", "reservada", "Dolor de rodilla"));

            repository.save(new CitaMedica("Pedro Molina", "Dr. Vega", "Cardiología",
                    "2026-03-31", "10:30", "disponible", "Control cardiologico"));

            repository.save(new CitaMedica("Valentina Castro", "Dra. Ramírez", "Pediatría",
                    "2026-04-01", "08:30", "reservada", "Consulta por fiebre"));

            repository.save(new CitaMedica("Jorge Herrera", "Dr. González", "Dermatología",
                    "2026-04-01", "11:00", "disponible", "Evaluacion dermatologica"));

            repository.save(new CitaMedica("Camila Muñoz", "Dr. Torres", "Neurología",
                    "2026-04-02", "09:15", "disponible", "Control neurologico"));

            repository.save(new CitaMedica("Sebastián López", "Dra. Salinas", "Traumatología",
                    "2026-04-02", "10:45", "cancelada", "Revisión de tobillo"));

            repository.save(new CitaMedica("Daniela Fuentes", "Dr. Vega", "Cardiología",
                    "2026-04-03", "12:15", "reservada", "Evaluacion cardiovascular"));

            repository.save(new CitaMedica("Tomás Navarro", "Dr. Pérez", "Medicina General",
                    "2026-04-03", "13:00", "disponible", "Consulta preventiva"));
        }
    }
}