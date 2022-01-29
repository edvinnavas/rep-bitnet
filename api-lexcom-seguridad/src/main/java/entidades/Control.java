package entidades;

import java.io.Serializable;

public class Control implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_control;
    private Aplicacion aplicacion;
    private String nombre;
    private Long activo;
    private String descripcion;

    public Control(Long id_control, Aplicacion aplicacion, String nombre, Long activo, String descripcion) {
        this.id_control = id_control;
        this.aplicacion = aplicacion;
        this.nombre = nombre;
        this.activo = activo;
        this.descripcion = descripcion;
    }

    public Control() {
    }

    public Long getId_control() {
        return id_control;
    }

    public void setId_control(Long id_control) {
        this.id_control = id_control;
    }

    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
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
        return "Control{" + "id_control=" + id_control + ", aplicacion=" + aplicacion + ", nombre=" + nombre + ", activo=" + activo + ", descripcion=" + descripcion + '}';
    }
    
}
