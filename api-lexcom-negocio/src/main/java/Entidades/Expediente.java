package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class Expediente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Actor actor;
    private Deudor deudor;
    private Long numero_caso;
    private EstatusExtrajudicial estatus_extrajudicial;
    private EstatusJudicial estatus_judicial;
    private Garantia garantia;
    private Moneda moneda;
    private CodigoResultado codigo_resultado;
    private Cosecha cosecha;
    private Antiguedad antiguedad;
    private IntencionPago intencion_pago;
    private RazonDeuda razon_deuda;
    private Calendar fecha_ingreso;
    private Calendar fecha_recepcion;
    private Double monto_inicial;
    private Double saldo;
    private String numero_cuenta;
    private String numero_cuenta_otro;
    private String gestor_extrajudicial;
    private String gestor_judicial;
    private Long estado;
    private Long pdf;
    private Long inv;
    private Long maycom;
    private Long nit;
    private Long anticipo;
    private String descripcion;
    private String descripcion_adicional;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;
    private List<BitacoraGestionCobros> lst_bitacora_gestion_cobros;
    private List<BitacoraGestionJuridico> lst_bitacora_gestion_juridico;

    public Expediente(Actor actor, Deudor deudor, Long numero_caso, EstatusExtrajudicial estatus_extrajudicial, EstatusJudicial estatus_judicial, Garantia garantia, Moneda moneda, CodigoResultado codigo_resultado, Cosecha cosecha, Antiguedad antiguedad, IntencionPago intencion_pago, RazonDeuda razon_deuda, Calendar fecha_ingreso, Calendar fecha_recepcion, Double monto_inicial, Double saldo, String numero_cuenta, String numero_cuenta_otro, String gestor_extrajudicial, String gestor_judicial, Long estado, Long pdf, Long inv, Long maycom, Long nit, Long anticipo, String descripcion, String descripcion_adicional, Calendar fecha_hora_modificacion, String usuario_modificacion, List<BitacoraGestionCobros> lst_bitacora_gestion_cobros, List<BitacoraGestionJuridico> lst_bitacora_gestion_juridico) {
        this.actor = actor;
        this.deudor = deudor;
        this.numero_caso = numero_caso;
        this.estatus_extrajudicial = estatus_extrajudicial;
        this.estatus_judicial = estatus_judicial;
        this.garantia = garantia;
        this.moneda = moneda;
        this.codigo_resultado = codigo_resultado;
        this.cosecha = cosecha;
        this.antiguedad = antiguedad;
        this.intencion_pago = intencion_pago;
        this.razon_deuda = razon_deuda;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_recepcion = fecha_recepcion;
        this.monto_inicial = monto_inicial;
        this.saldo = saldo;
        this.numero_cuenta = numero_cuenta;
        this.numero_cuenta_otro = numero_cuenta_otro;
        this.gestor_extrajudicial = gestor_extrajudicial;
        this.gestor_judicial = gestor_judicial;
        this.estado = estado;
        this.pdf = pdf;
        this.inv = inv;
        this.maycom = maycom;
        this.nit = nit;
        this.anticipo = anticipo;
        this.descripcion = descripcion;
        this.descripcion_adicional = descripcion_adicional;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
        this.lst_bitacora_gestion_cobros = lst_bitacora_gestion_cobros;
        this.lst_bitacora_gestion_juridico = lst_bitacora_gestion_juridico;
    }

    public Expediente() {
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Deudor getDeudor() {
        return deudor;
    }

    public void setDeudor(Deudor deudor) {
        this.deudor = deudor;
    }

    public Long getNumero_caso() {
        return numero_caso;
    }

    public void setNumero_caso(Long numero_caso) {
        this.numero_caso = numero_caso;
    }

    public EstatusExtrajudicial getEstatus_extrajudicial() {
        return estatus_extrajudicial;
    }

    public void setEstatus_extrajudicial(EstatusExtrajudicial estatus_extrajudicial) {
        this.estatus_extrajudicial = estatus_extrajudicial;
    }

    public EstatusJudicial getEstatus_judicial() {
        return estatus_judicial;
    }

    public void setEstatus_judicial(EstatusJudicial estatus_judicial) {
        this.estatus_judicial = estatus_judicial;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public CodigoResultado getCodigo_resultado() {
        return codigo_resultado;
    }

    public void setCodigo_resultado(CodigoResultado codigo_resultado) {
        this.codigo_resultado = codigo_resultado;
    }

    public Cosecha getCosecha() {
        return cosecha;
    }

    public void setCosecha(Cosecha cosecha) {
        this.cosecha = cosecha;
    }

    public Antiguedad getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Antiguedad antiguedad) {
        this.antiguedad = antiguedad;
    }

    public IntencionPago getIntencion_pago() {
        return intencion_pago;
    }

    public void setIntencion_pago(IntencionPago intencion_pago) {
        this.intencion_pago = intencion_pago;
    }

    public RazonDeuda getRazon_deuda() {
        return razon_deuda;
    }

    public void setRazon_deuda(RazonDeuda razon_deuda) {
        this.razon_deuda = razon_deuda;
    }

    public Calendar getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Calendar fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Calendar getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Calendar fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public Double getMonto_inicial() {
        return monto_inicial;
    }

    public void setMonto_inicial(Double monto_inicial) {
        this.monto_inicial = monto_inicial;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getNumero_cuenta_otro() {
        return numero_cuenta_otro;
    }

    public void setNumero_cuenta_otro(String numero_cuenta_otro) {
        this.numero_cuenta_otro = numero_cuenta_otro;
    }

    public String getGestor_extrajudicial() {
        return gestor_extrajudicial;
    }

    public void setGestor_extrajudicial(String gestor_extrajudicial) {
        this.gestor_extrajudicial = gestor_extrajudicial;
    }

    public String getGestor_judicial() {
        return gestor_judicial;
    }

    public void setGestor_judicial(String gestor_judicial) {
        this.gestor_judicial = gestor_judicial;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public Long getPdf() {
        return pdf;
    }

    public void setPdf(Long pdf) {
        this.pdf = pdf;
    }

    public Long getInv() {
        return inv;
    }

    public void setInv(Long inv) {
        this.inv = inv;
    }

    public Long getMaycom() {
        return maycom;
    }

    public void setMaycom(Long maycom) {
        this.maycom = maycom;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public Long getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(Long anticipo) {
        this.anticipo = anticipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion_adicional() {
        return descripcion_adicional;
    }

    public void setDescripcion_adicional(String descripcion_adicional) {
        this.descripcion_adicional = descripcion_adicional;
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

    public List<BitacoraGestionCobros> getLst_bitacora_gestion_cobros() {
        return lst_bitacora_gestion_cobros;
    }

    public void setLst_bitacora_gestion_cobros(List<BitacoraGestionCobros> lst_bitacora_gestion_cobros) {
        this.lst_bitacora_gestion_cobros = lst_bitacora_gestion_cobros;
    }

    public List<BitacoraGestionJuridico> getLst_bitacora_gestion_juridico() {
        return lst_bitacora_gestion_juridico;
    }

    public void setLst_bitacora_gestion_juridico(List<BitacoraGestionJuridico> lst_bitacora_gestion_juridico) {
        this.lst_bitacora_gestion_juridico = lst_bitacora_gestion_juridico;
    }

    @Override
    public String toString() {
        return "Expediente{" + "actor=" + actor + ", deudor=" + deudor + ", numero_caso=" + numero_caso + ", estatus_extrajudicial=" + estatus_extrajudicial + ", estatus_judicial=" + estatus_judicial + ", garantia=" + garantia + ", moneda=" + moneda + ", codigo_resultado=" + codigo_resultado + ", cosecha=" + cosecha + ", antiguedad=" + antiguedad + ", intencion_pago=" + intencion_pago + ", razon_deuda=" + razon_deuda + ", fecha_ingreso=" + fecha_ingreso + ", fecha_recepcion=" + fecha_recepcion + ", monto_inicial=" + monto_inicial + ", saldo=" + saldo + ", numero_cuenta=" + numero_cuenta + ", numero_cuenta_otro=" + numero_cuenta_otro + ", gestor_extrajudicial=" + gestor_extrajudicial + ", gestor_judicial=" + gestor_judicial + ", estado=" + estado + ", pdf=" + pdf + ", inv=" + inv + ", maycom=" + maycom + ", nit=" + nit + ", anticipo=" + anticipo + ", descripcion=" + descripcion + ", descripcion_adicional=" + descripcion_adicional + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + ", lst_bitacora_gestion_cobros=" + lst_bitacora_gestion_cobros + ", lst_bitacora_gestion_juridico=" + lst_bitacora_gestion_juridico + '}';
    }
    
}
