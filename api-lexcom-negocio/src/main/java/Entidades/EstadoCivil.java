package Entidades;

import java.io.Serializable;

public class EstadoCivil implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_estado_civil;
    private String nombre;
    private String descripcion;

    public EstadoCivil(Long id_estado_civil, String nombre, String descripcion) {
        this.id_estado_civil = id_estado_civil;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public EstadoCivil() {
    }

    public Long getId_estado_civil() {
        return id_estado_civil;
    }

    public void setId_estado_civil(Long id_estado_civil) {
        this.id_estado_civil = id_estado_civil;
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
        return "EstadoCivil{" + "id_estado_civil=" + id_estado_civil + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
