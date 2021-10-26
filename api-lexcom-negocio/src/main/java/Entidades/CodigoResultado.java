package Entidades;

import java.io.Serializable;
import java.util.Calendar;

public class CodigoResultado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private AreaCodigoResultado area_codigo_resultado;
    private RegistroCodigoResultado registro_codigo_resultado;
    private TipoCodigoResultado tipo_codigo_resultado;
    private Long es_contacto;
    private String codigo;
    private String nombre;
    private Long activo;
    private String descripcion;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;

    public CodigoResultado(AreaCodigoResultado area_codigo_resultado, RegistroCodigoResultado registro_codigo_resultado, TipoCodigoResultado tipo_codigo_resultado, Long es_contacto, String codigo, String nombre, Long activo, String descripcion, Calendar fecha_hora_modificacion, String usuario_modificacion) {
        this.area_codigo_resultado = area_codigo_resultado;
        this.registro_codigo_resultado = registro_codigo_resultado;
        this.tipo_codigo_resultado = tipo_codigo_resultado;
        this.es_contacto = es_contacto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
    }

    public CodigoResultado() {
    }

    public AreaCodigoResultado getArea_codigo_resultado() {
        return area_codigo_resultado;
    }

    public void setArea_codigo_resultado(AreaCodigoResultado area_codigo_resultado) {
        this.area_codigo_resultado = area_codigo_resultado;
    }

    public RegistroCodigoResultado getRegistro_codigo_resultado() {
        return registro_codigo_resultado;
    }

    public void setRegistro_codigo_resultado(RegistroCodigoResultado registro_codigo_resultado) {
        this.registro_codigo_resultado = registro_codigo_resultado;
    }

    public TipoCodigoResultado getTipo_codigo_resultado() {
        return tipo_codigo_resultado;
    }

    public void setTipo_codigo_resultado(TipoCodigoResultado tipo_codigo_resultado) {
        this.tipo_codigo_resultado = tipo_codigo_resultado;
    }

    public Long getEs_contacto() {
        return es_contacto;
    }

    public void setEs_contacto(Long es_contacto) {
        this.es_contacto = es_contacto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getActivo() {
        return activo;
    }

    public void setActivo(Long activo) {
        this.activo = activo;
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
        return "CodigoResultado{" + "area_codigo_resultado=" + area_codigo_resultado + ", registro_codigo_resultado=" + registro_codigo_resultado + ", tipo_codigo_resultado=" + tipo_codigo_resultado + ", es_contacto=" + es_contacto + ", codigo=" + codigo + ", nombre=" + nombre + ", activo=" + activo + ", descripcion=" + descripcion + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + '}';
    }
    
}
