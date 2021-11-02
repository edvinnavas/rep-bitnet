package Entidades;

import java.io.Serializable;
import java.util.Calendar;

public class BitacoraGestionJuridico implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_bitacora_gestion_juridico;
    private Long id_expediente;
    private CodigoResultado codigo_resultado;
    private Calendar fecha_hora;
    private String usuario_gestion;
    private String descripcion_gestion;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;

    public BitacoraGestionJuridico(Long id_bitacora_gestion_juridico, Long id_expediente, CodigoResultado codigo_resultado, Calendar fecha_hora, String usuario_gestion, String descripcion_gestion, Calendar fecha_hora_modificacion, String usuario_modificacion) {
        this.id_bitacora_gestion_juridico = id_bitacora_gestion_juridico;
        this.id_expediente = id_expediente;
        this.codigo_resultado = codigo_resultado;
        this.fecha_hora = fecha_hora;
        this.usuario_gestion = usuario_gestion;
        this.descripcion_gestion = descripcion_gestion;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
    }

    public BitacoraGestionJuridico() {
    }

    public Long getId_bitacora_gestion_juridico() {
        return id_bitacora_gestion_juridico;
    }

    public void setId_bitacora_gestion_juridico(Long id_bitacora_gestion_juridico) {
        this.id_bitacora_gestion_juridico = id_bitacora_gestion_juridico;
    }

    public Long getId_expediente() {
        return id_expediente;
    }

    public void setId_expediente(Long id_expediente) {
        this.id_expediente = id_expediente;
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
        return "BitacoraGestionJuridico{" + "id_bitacora_gestion_juridico=" + id_bitacora_gestion_juridico + ", id_expediente=" + id_expediente + ", codigo_resultado=" + codigo_resultado + ", fecha_hora=" + fecha_hora + ", usuario_gestion=" + usuario_gestion + ", descripcion_gestion=" + descripcion_gestion + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + '}';
    }
    
}
