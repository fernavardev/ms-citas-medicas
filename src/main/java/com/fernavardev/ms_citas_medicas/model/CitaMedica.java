package com.fernavardev.ms_citas_medicas.model;

public class CitaMedica {

    private int id;
    private String paciente;
    private String medico;
    private String especialidad;
    private String fecha;
    private String hora;
    private String estado;
    private String observacion;

    public CitaMedica() {
    }

    public CitaMedica(int id, String paciente, String medico, String especialidad,
                      String fecha, String hora, String estado, String observacion) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.observacion = observacion;
    }

    public int getId() {
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

    public void setId(int id) {
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