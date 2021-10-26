package Entidades;

import java.io.Serializable;
import java.util.Calendar;

public class BitacoraGestionCobros implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_corporacion;
    private Long id_actor;
    private Long id_deudor;
    private Long numero_caso;
    private CodigoResultado codigo_resultado;
    private Calendar fecha_hora;
    private String usuario_gestion;
    private String descripcion_gestion;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;

    public BitacoraGestionCobros(Long id_corporacion, Long id_actor, Long id_deudor, Long numero_caso, CodigoResultado codigo_resultado, Calendar fecha_hora, String usuario_gestion, String descripcion_gestion, Calendar fecha_hora_modificacion, String usuario_modificacion) {
        this.id_corporacion = id_corporacion;
        this.id_actor = id_actor;
        this.id_deudor = id_deudor;
        this.numero_caso = numero_caso;
        this.codigo_resultado = codigo_resultado;
        this.fecha_hora = fecha_hora;
        this.usuario_gestion = usuario_gestion;
        this.descripcion_gestion = descripcion_gestion;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
    }

    public BitacoraGestionCobros() {
    }

    public Long getId_corporacion() {
        return id_corporacion;
    }

    public void setId_corporacion(Long id_corporacion) {
        this.id_corporacion = id_corporacion;
    }

    public Long getId_actor() {
        return id_actor;
    }

    public void setId_actor(Long id_actor) {
        this.id_actor = id_actor;
    }

    public Long getId_deudor() {
        return id_deudor;
    }

    public void setId_deudor(Long id_deudor) {
        this.id_deudor = id_deudor;
    }

    public Long getNumero_caso() {
        return numero_caso;
    }

    public void setNumero_caso(Long numero_caso) {
        this.numero_caso = numero_caso;
    }

    public CodigoResultado getCodigo_resultado() {
        return codigo_resultado;
    }

    public void setCodigo_resultado(CodigoResultado codigo_resultado) {
        this.codigo_resultado = codigo_resultado;
    }

    public Calendar getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Calendar fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getUsuario_gestion() {
        return usuario_gestion;
    }

    public void setUsuario_gestion(String usuario_gestion) {
        this.usuario_gestion = usuario_gestion;
    }

    public String getDescripcion_gestion() {
        return descripcion_gestion;
    }

    public void setDescripcion_gestion(String descripcion_gestion) {
        this.descripcion_gestion = descripcion_gestion;
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
        return "BitacoraGestionCobros{" + "id_corporacion=" + id_corporacion + ", id_actor=" + id_actor + ", id_deudor=" + id_deudor + ", numero_caso=" + numero_caso + ", codigo_resultado=" + codigo_resultado + ", fecha_hora=" + fecha_hora + ", usuario_gestion=" + usuario_gestion + ", descripcion_gestion=" + descripcion_gestion + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + '}';
    }
    
}
