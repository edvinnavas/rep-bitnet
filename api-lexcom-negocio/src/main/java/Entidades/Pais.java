package Entidades;

import java.io.Serializable;

public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_pais;
    private String nombre;

    public Pais(Long id_pais, String nombre) {
        this.id_pais = id_pais;
        this.nombre = nombre;
    }

    public Pais() {
    }

    public Long getId_pais() {
        return id_pais;
    }

    public void setId_pais(Long id_pais) {
        this.id_pais = id_pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pais{" + "id_pais=" + id_pais + ", nombre=" + nombre + '}';
    }
    
}
