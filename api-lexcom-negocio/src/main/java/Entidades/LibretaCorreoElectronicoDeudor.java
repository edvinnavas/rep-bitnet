package Entidades;

import java.io.Serializable;
import java.util.Calendar;

public class LibretaCorreoElectronicoDeudor implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_libreta_correo_electronico_deudor;
    private Long id_deudor;
    private String correo_electronico;
    private String descripcion;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;

    public LibretaCorreoElectronicoDeudor(Long id_libreta_correo_electronico_deudor, Long id_deudor, String correo_electronico, String descripcion, Calendar fecha_hora_modificacion, String usuario_modificacion) {
        this.id_libreta_correo_electronico_deudor = id_libreta_correo_electronico_deudor;
        this.id_deudor = id_deudor;
        this.correo_electronico = correo_electronico;
        this.descripcion = descripcion;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
    }

    public LibretaCorreoElectronicoDeudor() {
    }

    public Long getId_libreta_correo_electronico_deudor() {
        return id_libreta_correo_electronico_deudor;
    }

    public void setId_libreta_correo_electronico_deudor(Long id_libreta_correo_electronico_deudor) {
        this.id_libreta_correo_electronico_deudor = id_libreta_correo_electronico_deudor;
    }

    public Long getId_deudor() {
        return id_deudor;
    }

    public void setId_deudor(Long id_deudor) {
        this.id_deudor = id_deudor;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
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
        return "LibretaCorreoElectronicoDeudor{" + "id_libreta_correo_electronico_deudor=" + id_libreta_correo_electronico_deudor + ", id_deudor=" + id_deudor + ", correo_electronico=" + correo_electronico + ", descripcion=" + descripcion + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + '}';
    }
    
}
