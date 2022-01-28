package entidades;

import java.io.Serializable;

public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_rol;
    private String nombre;
    private String descripcion;

    public Rol(Long id_rol, String nombre, String descripcion) {
        this.id_rol = id_rol;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Rol() {
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
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
        return "Rol{" + "id_rol=" + id_rol + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
