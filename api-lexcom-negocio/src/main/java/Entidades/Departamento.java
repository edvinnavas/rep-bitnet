package Entidades;

import java.io.Serializable;

public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Pais pais;
    private Long id_departamento;
    private String nombre;

    public Departamento(Pais pais, Long id_departamento, String nombre) {
        this.pais = pais;
        this.id_departamento = id_departamento;
        this.nombre = nombre;
    }

    public Departamento() {
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Long getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Long id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Departamento{" + "pais=" + pais + ", id_departamento=" + id_departamento + ", nombre=" + nombre + '}';
    }
    
}
