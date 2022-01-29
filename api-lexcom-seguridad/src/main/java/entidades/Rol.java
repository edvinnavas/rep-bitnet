package entidades;

import java.io.Serializable;
import java.util.List;

public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_rol;
    private String nombre;
    private Long activo;
    private String descripcion;
    private List<Control> lst_control;

    public Rol(Long id_rol, String nombre, Long activo, String descripcion, List<Control> lst_control) {
        this.id_rol = id_rol;
        this.nombre = nombre;
        this.activo = activo;
        this.descripcion = descripcion;
        this.lst_control = lst_control;
    }

    public Rol() {
    }
    
    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
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

    public List<Control> getLst_control() {
        return lst_control;
    }

    public void setLst_control(List<Control> lst_control) {
        this.lst_control = lst_control;
    }

    @Override
    public String toString() {
        return "Rol{" + "id_rol=" + id_rol + ", nombre=" + nombre + ", activo=" + activo + ", descripcion=" + descripcion + ", lst_control=" + lst_control + '}';
    }

}
