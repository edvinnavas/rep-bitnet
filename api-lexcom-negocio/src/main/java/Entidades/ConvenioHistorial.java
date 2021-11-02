package Entidades;

import java.io.Serializable;
import java.util.Calendar;

public class ConvenioHistorial implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_convenio_historial;
    private Long id_convenio;
    private EstadoConvenio estado_convenio_anterior;
    private EstadoConvenio estado_convenio_actual;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;

    public ConvenioHistorial(Long id_convenio_historial, Long id_convenio, EstadoConvenio estado_convenio_anterior, EstadoConvenio estado_convenio_actual, Calendar fecha_hora_modificacion, String usuario_modificacion) {
        this.id_convenio_historial = id_convenio_historial;
        this.id_convenio = id_convenio;
        this.estado_convenio_anterior = estado_convenio_anterior;
        this.estado_convenio_actual = estado_convenio_actual;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
    }

    public ConvenioHistorial() {
    }

    public Long getId_convenio_historial() {
        return id_convenio_historial;
    }

    public void setId_convenio_historial(Long id_convenio_historial) {
        this.id_convenio_historial = id_convenio_historial;
    }

    public Long getId_convenio() {
        return id_convenio;
    }

    public void setId_convenio(Long id_convenio) {
        this.id_convenio = id_convenio;
    }

    public EstadoConvenio getEstado_convenio_anterior() {
        return estado_convenio_anterior;
    }

    public void setEstado_convenio_anterior(EstadoConvenio estado_convenio_anterior) {
        this.estado_convenio_anterior = estado_convenio_anterior;
    }

    public EstadoConvenio getEstado_convenio_actual() {
        return estado_convenio_actual;
    }

    public void setEstado_convenio_actual(EstadoConvenio estado_convenio_actual) {
        this.estado_convenio_actual = estado_convenio_actual;
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
        return "ConvenioHistorial{" + "id_convenio_historial=" + id_convenio_historial + ", id_convenio=" + id_convenio + ", estado_convenio_anterior=" + estado_convenio_anterior + ", estado_convenio_actual=" + estado_convenio_actual + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + '}';
    }
    
}
