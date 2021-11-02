package Entidades;

import java.io.Serializable;

public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_departamento;
    private Pais pais;
    private String nombre;

    public Departamento(Long id_departamento, Pais pais, String nombre) {
        this.id_departamento = id_departamento;
        this.pais = pais;
        this.nombre = nombre;
    }

    public Departamento() {
    }

    public Long getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Long id_departamento) {
        this.id_departamento = id_departamento;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Departamento{" + "id_departamento=" + id_departamento + ", pais=" + pais + ", nombre=" + nombre + '}';
    }
    
}
