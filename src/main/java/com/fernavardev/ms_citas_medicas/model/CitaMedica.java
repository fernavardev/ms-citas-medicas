package com.fernavardev.ms_citas_medicas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cita_medica")
public class CitaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "El paciente no puede estar vacio")
    @Size(min = 2, max = 100, message = "El paciente debe tener entre 2 y 100 caracteres")
    @Column(name = "paciente", nullable = false)
    private String paciente;

    @NotBlank(message = "El medico no puede estar vacio")
    @Size(min = 2, max = 100, message = "El medico debe tener entre 2 y 100 caracteres")
    @Column(name = "medico", nullable = false)
    private String medico;

    @NotBlank(message = "La especialidad no puede estar vacia")
    @Size(min = 2, max = 100, message = "La especialidad debe tener entre 2 y 100 caracteres")
    @Column(name = "especialidad", nullable = false)
    private String especialidad;

    @NotBlank(message = "La fecha no puede estar vacia")
    @Column(name = "fecha", nullable = false)
    private String fecha;

    @NotBlank(message = "La hora no puede estar vacia")
    @Column(name = "hora", nullable = false)
    private String hora;

    @NotBlank(message = "El estado no puede estar vacio")
    @Pattern(
        regexp = "^(disponible|reservada|cancelada)$",
        message = "El estado solo puede ser: disponible, reservada o cancelada"
    )
    @Column(name = "estado", nullable = false)
    private String estado;

    @NotBlank(message = "La observacion no puede estar vacia")
    @Size(min = 5, max = 300, message = "La observacion debe tener entre 5 y 300 caracteres")
    @Column(name = "observacion", nullable = false, length = 300)
    private String observacion;

    public CitaMedica() {
    }

    public CitaMedica(String paciente, String medico, String especialidad,
                      String fecha, String hora, String estado, String observacion) {
        this.paciente = paciente;
        this.medico = medico;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.observacion = observacion;
    }

    public Long getId() {
        return id;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getMedico() {
        return medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getEstado() {
        return estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}