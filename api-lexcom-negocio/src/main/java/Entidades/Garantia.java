package Entidades;

import java.io.Serializable;
import java.util.Calendar;

public class Garantia implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_garantia;
    private String nombre;
    private Long activo;
    private String descripcion;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;

    public Garantia(Long id_garantia, String nombre, Long activo, String descripcion, Calendar fecha_hora_modificacion, String usuario_modificacion) {
        this.id_garantia = id_garantia;
        this.nombre = nombre;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
    }

    public Garantia() {
    }

    public Long getId_garantia() {
        return id_garantia;
    }

    public void setId_garantia(Long id_garantia) {
        this.id_garantia = id_garantia;
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
        return "Garantia{" + "id_garantia=" + id_garantia + ", nombre=" + nombre + ", activo=" + activo + ", descripcion=" + descripcion + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + '}';
    }
    
}
