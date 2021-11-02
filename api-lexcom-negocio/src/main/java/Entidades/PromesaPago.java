package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class PromesaPago implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_promesa_pago;
    private Long id_convenio;
    private EstadoPromesaPago estado_promesa_pago;
    private Calendar fecha_pago;
    private Double monto_pago;
    private String descripcion;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;
    private List<PromesaPagoHistorial> lst_promesa_pago_historial;

    public PromesaPago(Long id_promesa_pago, Long id_convenio, EstadoPromesaPago estado_promesa_pago, Calendar fecha_pago, Double monto_pago, String descripcion, Calendar fecha_hora_modificacion, String usuario_modificacion, List<PromesaPagoHistorial> lst_promesa_pago_historial) {
        this.id_promesa_pago = id_promesa_pago;
        this.id_convenio = id_convenio;
        this.estado_promesa_pago = estado_promesa_pago;
        this.fecha_pago = fecha_pago;
        this.monto_pago = monto_pago;
        this.descripcion = descripcion;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
        this.lst_promesa_pago_historial = lst_promesa_pago_historial;
    }

    public PromesaPago() {
    }

    public Long getId_promesa_pago() {
        return id_promesa_pago;
    }

    public void setId_promesa_pago(Long id_promesa_pago) {
        this.id_promesa_pago = id_promesa_pago;
    }

    public Long getId_convenio() {
        return id_convenio;
    }

    public void setId_convenio(Long id_convenio) {
        this.id_convenio = id_convenio;
    }

    public EstadoPromesaPago getEstado_promesa_pago() {
        return estado_promesa_pago;
    }

    public void setEstado_promesa_pago(EstadoPromesaPago estado_promesa_pago) {
        this.estado_promesa_pago = estado_promesa_pago;
    }

    public Calendar getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Calendar fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public Double getMonto_pago() {
        return monto_pago;
    }

    public void setMonto_pago(Double monto_pago) {
        this.monto_pago = monto_pago;
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

    public List<PromesaPagoHistorial> getLst_promesa_pago_historial() {
        return lst_promesa_pago_historial;
    }

    public void setLst_promesa_pago_historial(List<PromesaPagoHistorial> lst_promesa_pago_historial) {
        this.lst_promesa_pago_historial = lst_promesa_pago_historial;
    }

    @Override
    public String toString() {
        return "PromesaPago{" + "id_promesa_pago=" + id_promesa_pago + ", id_convenio=" + id_convenio + ", estado_promesa_pago=" + estado_promesa_pago + ", fecha_pago=" + fecha_pago + ", monto_pago=" + monto_pago + ", descripcion=" + descripcion + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + ", lst_promesa_pago_historial=" + lst_promesa_pago_historial + '}';
    }
    
}
