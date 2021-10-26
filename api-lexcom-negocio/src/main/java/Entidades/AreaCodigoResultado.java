package Entidades;

import java.io.Serializable;

public class AreaCodigoResultado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_area_codigo_resultado;
    private String nombre;
    private String descripcion;

    public AreaCodigoResultado(Long id_area_codigo_resultado, String nombre, String descripcion) {
        this.id_area_codigo_resultado = id_area_codigo_resultado;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public AreaCodigoResultado() {
    }

    public Long getId_area_codigo_resultado() {
        return id_area_codigo_resultado;
    }

    public void setId_area_codigo_resultado(Long id_area_codigo_resultado) {
        this.id_area_codigo_resultado = id_area_codigo_resultado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "AreaCodigoResultado{" + "id_area_codigo_resultado=" + id_area_codigo_resultado + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
