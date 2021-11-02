package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class Convenio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_convenio;
    private Long id_expediente;
    private TipoConvenio tipo_convenio;
    private EstadoConvenio estado_convenio;
    private Double saldo_actual;
    private Double interes;
    private Double mora;
    private Double gasto_otros;
    private Double rebaja_interes;
    private Double subtotal_pagar;
    private Double costas;
    private Double monto_costas;
    private Double total;
    private Double cuota_inicial;
    private Double total_pagar;
    private Calendar fecha_pago_inicial;
    private Long numero_cuotas;
    private FrecuenciaConvenio frecuencia_convenio;
    private Double monto_cuota;
    private Calendar fecha_creacion;
    private Calendar fecha_activacion;
    private Calendar fecha_terminacion;
    private String descripcion;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;
    private List<ConvenioHistorial> lst_convenio_historial;

    public Convenio(Long id_convenio, Long id_expediente, TipoConvenio tipo_convenio, EstadoConvenio estado_convenio, Double saldo_actual, Double interes, Double mora, Double gasto_otros, Double rebaja_interes, Double subtotal_pagar, Double costas, Double monto_costas, Double total, Double cuota_inicial, Double total_pagar, Calendar fecha_pago_inicial, Long numero_cuotas, FrecuenciaConvenio frecuencia_convenio, Double monto_cuota, Calendar fecha_creacion, Calendar fecha_activacion, Calendar fecha_terminacion, String descripcion, Calendar fecha_hora_modificacion, String usuario_modificacion, List<ConvenioHistorial> lst_convenio_historial) {
        this.id_convenio = id_convenio;
        this.id_expediente = id_expediente;
        this.tipo_convenio = tipo_convenio;
        this.estado_convenio = estado_convenio;
        this.saldo_actual = saldo_actual;
        this.interes = interes;
        this.mora = mora;
        this.gasto_otros = gasto_otros;
        this.rebaja_interes = rebaja_interes;
        this.subtotal_pagar = subtotal_pagar;
        this.costas = costas;
        this.monto_costas = monto_costas;
        this.total = total;
        this.cuota_inicial = cuota_inicial;
        this.total_pagar = total_pagar;
        this.fecha_pago_inicial = fecha_pago_inicial;
        this.numero_cuotas = numero_cuotas;
        this.frecuencia_convenio = frecuencia_convenio;
        this.monto_cuota = monto_cuota;
        this.fecha_creacion = fecha_creacion;
        this.fecha_activacion = fecha_activacion;
        this.fecha_terminacion = fecha_terminacion;
        this.descripcion = descripcion;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
        this.lst_convenio_historial = lst_convenio_historial;
    }

    public Convenio() {
    }

    public Long getId_convenio() {
        return id_convenio;
    }

    public void setId_convenio(Long id_convenio) {
        this.id_convenio = id_convenio;
    }

    public Long getId_expediente() {
        return id_expediente;
    }

    public void setId_expediente(Long id_expediente) {
        this.id_expediente = id_expediente;
    }

    public TipoConvenio getTipo_convenio() {
        return tipo_convenio;
    }

    public void setTipo_convenio(TipoConvenio tipo_convenio) {
        this.tipo_convenio = tipo_convenio;
    }

    public EstadoConvenio getEstado_convenio() {
        return estado_convenio;
    }

    public void setEstado_convenio(EstadoConvenio estado_convenio) {
        this.estado_convenio = estado_convenio;
    }

    public Double getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(Double saldo_actual) {
        this.saldo_actual = saldo_actual;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Double getMora() {
        return mora;
    }

    public void setMora(Double mora) {
        this.mora = mora;
    }

    public Double getGasto_otros() {
        return gasto_otros;
    }

    public void setGasto_otros(Double gasto_otros) {
        this.gasto_otros = gasto_otros;
    }

    public Double getRebaja_interes() {
        return rebaja_interes;
    }

    public void setRebaja_interes(Double rebaja_interes) {
        this.rebaja_interes = rebaja_interes;
    }

    public Double getSubtotal_pagar() {
        return subtotal_pagar;
    }

    public void setSubtotal_pagar(Double subtotal_pagar) {
        this.subtotal_pagar = subtotal_pagar;
    }

    public Double getCostas() {
        return costas;
    }

    public void setCostas(Double costas) {
        this.costas = costas;
    }

    public Double getMonto_costas() {
        return monto_costas;
    }

    public void setMonto_costas(Double monto_costas) {
        this.monto_costas = monto_costas;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getCuota_inicial() {
        return cuota_inicial;
    }

    public void setCuota_inicial(Double cuota_inicial) {
        this.cuota_inicial = cuota_inicial;
    }

    public Double getTotal_pagar() {
        return total_pagar;
    }

    public void setTotal_pagar(Double total_pagar) {
        this.total_pagar = total_pagar;
    }

    public Calendar getFecha_pago_inicial() {
        return fecha_pago_inicial;
    }

    public void setFecha_pago_inicial(Calendar fecha_pago_inicial) {
        this.fecha_pago_inicial = fecha_pago_inicial;
    }

    public Long getNumero_cuotas() {
        return numero_cuotas;
    }

    public void setNumero_cuotas(Long numero_cuotas) {
        this.numero_cuotas = numero_cuotas;
    }

    public FrecuenciaConvenio getFrecuencia_convenio() {
        return frecuencia_convenio;
    }

    public void setFrecuencia_convenio(FrecuenciaConvenio frecuencia_convenio) {
        this.frecuencia_convenio = frecuencia_convenio;
    }

    public Double getMonto_cuota() {
        return monto_cuota;
    }

    public void setMonto_cuota(Double monto_cuota) {
        this.monto_cuota = monto_cuota;
    }

    public Calendar getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Calendar fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Calendar getFecha_activacion() {
        return fecha_activacion;
    }

    public void setFecha_activacion(Calendar fecha_activacion) {
        this.fecha_activacion = fecha_activacion;
    }

    public Calendar getFecha_terminacion() {
        return fecha_terminacion;
    }

    public void setFecha_terminacion(Calendar fecha_terminacion) {
        this.fecha_terminacion = fecha_terminacion;
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

    public List<ConvenioHistorial> getLst_convenio_historial() {
        return lst_convenio_historial;
    }

    public void setLst_convenio_historial(List<ConvenioHistorial> lst_convenio_historial) {
        this.lst_convenio_historial = lst_convenio_historial;
    }

    @Override
    public String toString() {
        return "Convenio{" + "id_convenio=" + id_convenio + ", id_expediente=" + id_expediente + ", tipo_convenio=" + tipo_convenio + ", estado_convenio=" + estado_convenio + ", saldo_actual=" + saldo_actual + ", interes=" + interes + ", mora=" + mora + ", gasto_otros=" + gasto_otros + ", rebaja_interes=" + rebaja_interes + ", subtotal_pagar=" + subtotal_pagar + ", costas=" + costas + ", monto_costas=" + monto_costas + ", total=" + total + ", cuota_inicial=" + cuota_inicial + ", total_pagar=" + total_pagar + ", fecha_pago_inicial=" + fecha_pago_inicial + ", numero_cuotas=" + numero_cuotas + ", frecuencia_convenio=" + frecuencia_convenio + ", monto_cuota=" + monto_cuota + ", fecha_creacion=" + fecha_creacion + ", fecha_activacion=" + fecha_activacion + ", fecha_terminacion=" + fecha_terminacion + ", descripcion=" + descripcion + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + ", lst_convenio_historial=" + lst_convenio_historial + '}';
    }
    
}
