package Entidades;

import java.io.Serializable;

public class Nacionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_nacionalidad;
    private String nombre;
    private String descripcion;

    public Nacionalidad(Long id_nacionalidad, String nombre, String descripcion) {
        this.id_nacionalidad = id_nacionalidad;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Nacionalidad() {
    }

    public Long getId_nacionalidad() {
        return id_nacionalidad;
    }

    public void setId_nacionalidad(Long id_nacionalidad) {
        this.id_nacionalidad = id_nacionalidad;
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
        return "Nacionalidad{" + "id_nacionalidad=" + id_nacionalidad + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
