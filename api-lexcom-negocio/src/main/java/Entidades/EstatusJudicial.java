package Entidades;

import java.io.Serializable;
import java.util.Calendar;

public class EstatusJudicial implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private EstadoJudicial estado_judicial;
    private Long id_estatus_judicial;
    private String nombre;
    private Long activo;
    private String descripcion;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;

    public EstatusJudicial(EstadoJudicial estado_judicial, Long id_estatus_judicial, String nombre, Long activo, String descripcion, Calendar fecha_hora_modificacion, String usuario_modificacion) {
        this.estado_judicial = estado_judicial;
        this.id_estatus_judicial = id_estatus_judicial;
        this.nombre = nombre;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
    }

    public EstatusJudicial() {
    }

    public EstadoJudicial getEstado_judicial() {
        return estado_judicial;
    }

    public void setEstado_judicial(EstadoJudicial estado_judicial) {
        this.estado_judicial = estado_judicial;
    }

    public Long getId_estatus_judicial() {
        return id_estatus_judicial;
    }

    public void setId_estatus_judicial(Long id_estatus_judicial) {
        this.id_estatus_judicial = id_estatus_judicial;
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
        return "EstatusJudicial{" + "estado_judicial=" + estado_judicial + ", id_estatus_judicial=" + id_estatus_judicial + ", nombre=" + nombre + ", activo=" + activo + ", descripcion=" + descripcion + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + '}';
    }
    
}
