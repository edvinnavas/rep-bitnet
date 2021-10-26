package Entidades;

import java.io.Serializable;
import java.util.Calendar;

public class DirectorioTelefonicoDeudor implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_directorio_telefonico_deudor;
    private Long id_deudor;
    private TipoTelefono tipo_telefono;
    private Long codigo_area;
    private Long numero_telefonico;
    private Long principal;
    private String descripcion;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;

    public DirectorioTelefonicoDeudor(Long id_directorio_telefonico_deudor, Long id_deudor, TipoTelefono tipo_telefono, Long codigo_area, Long numero_telefonico, Long principal, String descripcion, Calendar fecha_hora_modificacion, String usuario_modificacion) {
        this.id_directorio_telefonico_deudor = id_directorio_telefonico_deudor;
        this.id_deudor = id_deudor;
        this.tipo_telefono = tipo_telefono;
        this.codigo_area = codigo_area;
        this.numero_telefonico = numero_telefonico;
        this.principal = principal;
        this.descripcion = descripcion;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
    }

    public DirectorioTelefonicoDeudor() {
    }

    public Long getId_directorio_telefonico_deudor() {
        return id_directorio_telefonico_deudor;
    }

    public void setId_directorio_telefonico_deudor(Long id_directorio_telefonico_deudor) {
        this.id_directorio_telefonico_deudor = id_directorio_telefonico_deudor;
    }

    public Long getId_deudor() {
        return id_deudor;
    }

    public void setId_deudor(Long id_deudor) {
        this.id_deudor = id_deudor;
    }

    public TipoTelefono getTipo_telefono() {
        return tipo_telefono;
    }

    public void setTipo_telefono(TipoTelefono tipo_telefono) {
        this.tipo_telefono = tipo_telefono;
    }

    public Long getCodigo_area() {
        return codigo_area;
    }

    public void setCodigo_area(Long codigo_area) {
        this.codigo_area = codigo_area;
    }

    public Long getNumero_telefonico() {
        return numero_telefonico;
    }

    public void setNumero_telefonico(Long numero_telefonico) {
        this.numero_telefonico = numero_telefonico;
    }

    public Long getPrincipal() {
        return principal;
    }

    public void setPrincipal(Long principal) {
        this.principal = principal;
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
        return "DirectorioTelefonicoDeudor{" + "id_directorio_telefonico_deudor=" + id_directorio_telefonico_deudor + ", id_deudor=" + id_deudor + ", tipo_telefono=" + tipo_telefono + ", codigo_area=" + codigo_area + ", numero_telefonico=" + numero_telefonico + ", principal=" + principal + ", descripcion=" + descripcion + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + '}';
    }
    
}
