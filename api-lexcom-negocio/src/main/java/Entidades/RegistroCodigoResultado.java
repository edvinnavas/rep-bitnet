package Entidades;

import java.io.Serializable;

public class RegistroCodigoResultado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_registro_codigo_resultado;
    private String nombre;
    private String descripcion;

    public RegistroCodigoResultado(Long id_registro_codigo_resultado, String nombre, String descripcion) {
        this.id_registro_codigo_resultado = id_registro_codigo_resultado;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public RegistroCodigoResultado() {
    }

    public Long getId_registro_codigo_resultado() {
        return id_registro_codigo_resultado;
    }

    public void setId_registro_codigo_resultado(Long id_registro_codigo_resultado) {
        this.id_registro_codigo_resultado = id_registro_codigo_resultado;
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
        return "RegistroCodigoResultado{" + "id_registro_codigo_resultado=" + id_registro_codigo_resultado + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
