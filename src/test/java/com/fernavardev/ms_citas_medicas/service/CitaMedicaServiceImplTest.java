package com.fernavardev.ms_citas_medicas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.fernavardev.ms_citas_medicas.model.CitaMedica;
import com.fernavardev.ms_citas_medicas.repository.CitaMedicaRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CitaMedicaServiceImplTest {

    @Mock
    private CitaMedicaRepository citaMedicaRepository;

    @InjectMocks
    private CitaMedicaServiceImpl citaMedicaService;

    private CitaMedica cita;

    @BeforeEach
    void setUp() {
        cita = new CitaMedica(
                "Ana Torres",
                "Dr. Pérez",
                "Medicina General",
                "2026-03-29",
                "09:00",
                "disponible",
                "Control general"
        );
        cita.setId(1L);
    }

    @Test
    void deberiaObtenerTodasLasCitas() {
        List<CitaMedica> listaMock = Arrays.asList(cita);

        when(citaMedicaRepository.findAll()).thenReturn(listaMock);

        List<CitaMedica> resultado = citaMedicaService.getAllCitas();

        assertEquals(1, resultado.size());
        assertEquals("Ana Torres", resultado.get(0).getPaciente());

        verify(citaMedicaRepository).findAll();
    }

    @Test
    void deberiaReservarCitaCorrectamente() {
        when(citaMedicaRepository.findById(1L)).thenReturn(Optional.of(cita));
        when(citaMedicaRepository.save(any(CitaMedica.class))).thenReturn(cita);

        CitaMedica resultado = citaMedicaService.reservarCita(1L);

        assertNotNull(resultado);
        assertEquals("reservada", resultado.getEstado());

        verify(citaMedicaRepository).findById(1L);
        verify(citaMedicaRepository).save(cita);
    }
}