package Entidades;

import java.io.Serializable;

public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Departamento departamento;
    private Long id_municipio;
    private String nombre;

    public Municipio(Departamento departamento, Long id_municipio, String nombre) {
        this.departamento = departamento;
        this.id_municipio = id_municipio;
        this.nombre = nombre;
    }

    public Municipio() {
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Long getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Long id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Municipio{" + "departamento=" + departamento + ", id_municipio=" + id_municipio + ", nombre=" + nombre + '}';
    }
    
}
