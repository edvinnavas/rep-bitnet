package Entidades;

import java.io.Serializable;
import java.util.Calendar;

public class LibretaDireccionesDeudor implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_libreta_direcciones_deudor;
    private Long id_deudor;
    private Municipio municipio;
    private Long zona;
    private String direccion;
    private String descripcion;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;

    public LibretaDireccionesDeudor(Long id_libreta_direcciones_deudor, Long id_deudor, Municipio municipio, Long zona, String direccion, String descripcion, Calendar fecha_hora_modificacion, String usuario_modificacion) {
        this.id_libreta_direcciones_deudor = id_libreta_direcciones_deudor;
        this.id_deudor = id_deudor;
        this.municipio = municipio;
        this.zona = zona;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
    }

    public LibretaDireccionesDeudor() {
    }

    public Long getId_libreta_direcciones_deudor() {
        return id_libreta_direcciones_deudor;
    }

    public void setId_libreta_direcciones_deudor(Long id_libreta_direcciones_deudor) {
        this.id_libreta_direcciones_deudor = id_libreta_direcciones_deudor;
    }

    public Long getId_deudor() {
        return id_deudor;
    }

    public void setId_deudor(Long id_deudor) {
        this.id_deudor = id_deudor;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Long getZona() {
        return zona;
    }

    public void setZona(Long zona) {
        this.zona = zona;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        return "LibretaDireccionesDeudor{" + "id_libreta_direcciones_deudor=" + id_libreta_direcciones_deudor + ", id_deudor=" + id_deudor + ", municipio=" + municipio + ", zona=" + zona + ", direccion=" + direccion + ", descripcion=" + descripcion + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + '}';
    }
    
}
