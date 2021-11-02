package Entidades;

import java.io.Serializable;

public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_municipio;
    private Departamento departamento;
    private String nombre;

    public Municipio(Long id_municipio, Departamento departamento, String nombre) {
        this.id_municipio = id_municipio;
        this.departamento = departamento;
        this.nombre = nombre;
    }

    public Municipio() {
    }

    public Long getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Long id_municipio) {
        this.id_municipio = id_municipio;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Municipio{" + "id_municipio=" + id_municipio + ", departamento=" + departamento + ", nombre=" + nombre + '}';
    }
    
}
