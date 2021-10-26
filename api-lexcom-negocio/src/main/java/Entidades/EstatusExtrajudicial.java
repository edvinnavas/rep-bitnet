package Entidades;

import java.io.Serializable;
import java.util.Calendar;

public class EstatusExtrajudicial implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private EstadoExtrajudicial estado_extrajudicial;
    private Long id_estatus_extrajudicial;
    private String nombre;
    private Long activo;
    private String descripcion;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;

    public EstatusExtrajudicial(EstadoExtrajudicial estado_extrajudicial, Long id_estatus_extrajudicial, String nombre, Long activo, String descripcion, Calendar fecha_hora_modificacion, String usuario_modificacion) {
        this.estado_extrajudicial = estado_extrajudicial;
        this.id_estatus_extrajudicial = id_estatus_extrajudicial;
        this.nombre = nombre;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
    }

    public EstatusExtrajudicial() {
    }

    public EstadoExtrajudicial getEstado_extrajudicial() {
        return estado_extrajudicial;
    }

    public void setEstado_extrajudicial(EstadoExtrajudicial estado_extrajudicial) {
        this.estado_extrajudicial = estado_extrajudicial;
    }

    public Long getId_estatus_extrajudicial() {
        return id_estatus_extrajudicial;
    }

    public void setId_estatus_extrajudicial(Long id_estatus_extrajudicial) {
        this.id_estatus_extrajudicial = id_estatus_extrajudicial;
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
        return "EstatusExtrajudicial{" + "estado_extrajudicial=" + estado_extrajudicial + ", id_estatus_extrajudicial=" + id_estatus_extrajudicial + ", nombre=" + nombre + ", activo=" + activo + ", descripcion=" + descripcion + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + '}';
    }
    
}
