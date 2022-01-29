package entidades;

import java.io.Serializable;

public class Aplicacion implements Serializable {

    private static final long serialVersionUID = 1L; 
    
    private Long id_aplicacion;
    private String nombre; 
    private Long activo;
    private String descripcion;

    public Aplicacion(Long id_aplicacion, String nombre, Long activo, String descripcion) {
        this.id_aplicacion = id_aplicacion;
        this.nombre = nombre;
        this.activo = activo;
        this.descripcion = descripcion;
    }

    public Aplicacion() {
    }

    public Long getId_aplicacion() {
        return id_aplicacion;
    }

    public void setId_aplicacion(Long id_aplicacion) {
        this.id_aplicacion = id_aplicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getActivo() {
        return activo;
    }

    public void setActivo(Long activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Aplicacion{" + "id_aplicacion=" + id_aplicacion + ", nombre=" + nombre + ", activo=" + activo + ", descripcion=" + descripcion + '}';
    }
    
}
