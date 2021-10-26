package Entidades;

import java.io.Serializable;

public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_genero;
    private String nombre;
    private String descripcion;

    public Genero(Long id_genero, String nombre, String descripcion) {
        this.id_genero = id_genero;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Genero() {
    }

    public Long getId_genero() {
        return id_genero;
    }

    public void setId_genero(Long id_genero) {
        this.id_genero = id_genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Genero{" + "id_genero=" + id_genero + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
