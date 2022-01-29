package entidades;

import java.io.Serializable;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_usuario; 
    private String nombre_completo;
    private String nombre_usuario;
    private String contrasena;
    private String correo_electronico;
    private Long activo;
    private String descripcion;
    private Rol rol;

    public Usuario(Long id_usuario, String nombre_completo, String nombre_usuario, String contrasena, String correo_electronico, Long activo, String descripcion, Rol rol) {
        this.id_usuario = id_usuario;
        this.nombre_completo = nombre_completo;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.correo_electronico = correo_electronico;
        this.activo = activo;
        this.descripcion = descripcion;
        this.rol = rol;
    }

    public Usuario() {
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre_completo=" + nombre_completo + ", nombre_usuario=" + nombre_usuario + ", contrasena=" + contrasena + ", correo_electronico=" + correo_electronico + ", activo=" + activo + ", descripcion=" + descripcion + ", rol=" + rol + '}';
    }
    
}
