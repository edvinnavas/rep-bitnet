package Entidades;

import java.io.Serializable;
import java.util.Calendar;

public class PromesaPagoHistorial implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_promesa_pago_historial;
    private Long id_promesa_pago;
    private EstadoPromesaPago estado_promesa_pago_anterior;
    private EstadoPromesaPago estado_promesa_pago_actual;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;

    public PromesaPagoHistorial(Long id_promesa_pago_historial, Long id_promesa_pago, EstadoPromesaPago estado_promesa_pago_anterior, EstadoPromesaPago estado_promesa_pago_actual, Calendar fecha_hora_modificacion, String usuario_modificacion) {
        this.id_promesa_pago_historial = id_promesa_pago_historial;
        this.id_promesa_pago = id_promesa_pago;
        this.estado_promesa_pago_anterior = estado_promesa_pago_anterior;
        this.estado_promesa_pago_actual = estado_promesa_pago_actual;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
    }

    public PromesaPagoHistorial() {
    }

    public Long getId_promesa_pago_historial() {
        return id_promesa_pago_historial;
    }

    public void setId_promesa_pago_historial(Long id_promesa_pago_historial) {
        this.id_promesa_pago_historial = id_promesa_pago_historial;
    }

    public Long getId_promesa_pago() {
        return id_promesa_pago;
    }

    public void setId_promesa_pago(Long id_promesa_pago) {
        this.id_promesa_pago = id_promesa_pago;
    }

    public EstadoPromesaPago getEstado_promesa_pago_anterior() {
        return estado_promesa_pago_anterior;
    }

    public void setEstado_promesa_pago_anterior(EstadoPromesaPago estado_promesa_pago_anterior) {
        this.estado_promesa_pago_anterior = estado_promesa_pago_anterior;
    }

    public EstadoPromesaPago getEstado_promesa_pago_actual() {
        return estado_promesa_pago_actual;
    }

    public void setEstado_promesa_pago_actual(EstadoPromesaPago estado_promesa_pago_actual) {
        this.estado_promesa_pago_actual = estado_promesa_pago_actual;
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
        return "PromesaPagoHistorial{" + "id_promesa_pago_historial=" + id_promesa_pago_historial + ", id_promesa_pago=" + id_promesa_pago + ", estado_promesa_pago_anterior=" + estado_promesa_pago_anterior + ", estado_promesa_pago_actual=" + estado_promesa_pago_actual + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + '}';
    }
    
}
