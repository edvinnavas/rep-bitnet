package Entidades;

import java.io.Serializable;
import java.util.Calendar;

public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Corporacion corporacion;
    private Long id_actor;
    private String nombre;
    private Long activo;
    private String descripcion;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;

    public Actor(Corporacion corporacion, Long id_actor, String nombre, Long activo, String descripcion, Calendar fecha_hora_modificacion, String usuario_modificacion) {
        this.corporacion = corporacion;
        this.id_actor = id_actor;
        this.nombre = nombre;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
    }

    public Actor() {
    }

    public Corporacion getCorporacion() {
        return corporacion;
    }

    public void setCorporacion(Corporacion corporacion) {
        this.corporacion = corporacion;
    }

    public Long getId_actor() {
        return id_actor;
    }

    public void setId_actor(Long id_actor) {
        this.id_actor = id_actor;
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

    public Calendar getFecha_hora_modificacion() {
        return fecha_hora_modificacion;
    }

    public void setFecha_hora_modificacion(Calendar fecha_hora_modificacion) {
        this.fecha_hora_modificacion = fecha_hora_modificacion;
    }

    public String getUsuario_modificacion() {
        return usuario_modificacion;
    }

    public void setUsuario_modificacion(String usuario_modificacion) {
        this.usuario_modificacion = usuario_modificacion;
    }

    @Override
    public String toString() {
        return "Actor{" + "corporacion=" + corporacion + ", id_actor=" + id_actor + ", nombre=" + nombre + ", activo=" + activo + ", descripcion=" + descripcion + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + '}';
    }
    
}
