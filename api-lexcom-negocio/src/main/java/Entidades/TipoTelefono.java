package Entidades;

import java.io.Serializable;

public class TipoTelefono implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_tipo_telefono;
    private String nombre;
    private String descripcion;

    public TipoTelefono(Long id_tipo_telefono, String nombre, String descripcion) {
        this.id_tipo_telefono = id_tipo_telefono;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public TipoTelefono() {
    }

    public Long getId_tipo_telefono() {
        return id_tipo_telefono;
    }

    public void setId_tipo_telefono(Long id_tipo_telefono) {
        this.id_tipo_telefono = id_tipo_telefono;
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
        return "TipoTelefono{" + "id_tipo_telefono=" + id_tipo_telefono + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
