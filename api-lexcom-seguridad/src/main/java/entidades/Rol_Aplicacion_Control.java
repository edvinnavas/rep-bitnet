package entidades;

import java.io.Serializable;

public class Rol_Aplicacion_Control implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_rol_aplicacion_control;
    private Rol rol;
    private Control control;
    private Aplicacion aplicacion;

    public Rol_Aplicacion_Control(Long id_rol_aplicacion_control, Rol rol, Control control, Aplicacion aplicacion) {
        this.id_rol_aplicacion_control = id_rol_aplicacion_control;
        this.rol = rol;
        this.control = control;
        this.aplicacion = aplicacion;
    }

    public Rol_Aplicacion_Control() {
    }

    public Long getId_rol_aplicacion_control() {
        return id_rol_aplicacion_control;
    }

    public void setId_rol_aplicacion_control(Long id_rol_aplicacion_control) {
        this.id_rol_aplicacion_control = id_rol_aplicacion_control;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }

    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Override
    public String toString() {
        return "Rol_Aplicacion_Control{" + "id_rol_aplicacion_control=" + id_rol_aplicacion_control + ", rol=" + rol + ", control=" + control + ", aplicacion=" + aplicacion + '}';
    }
    
}
