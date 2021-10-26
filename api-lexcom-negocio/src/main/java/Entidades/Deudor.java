package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class Deudor implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id_deudor;
    private String nombre_completo;
    private String primer_nombre;
    private String segundo_nombre;
    private String tercer_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private Long dpi;
    private Long nit;
    private Genero genero;
    private Calendar fecha_nacimiento;
    private EstadoCivil estado_civil;
    private Profesion prefesion;
    private Nacionalidad nacionalidad;
    private String descripcion;
    private Calendar fecha_hora_modificacion;
    private String usuario_modificacion;
    private List<DirectorioTelefonicoDeudor> lst_directorio_telefonico_deudor;
    private List<LibretaCorreoElectronicoDeudor> lst_libreta_correo_electronico_deudor;
    private List<LibretaDireccionesDeudor> lst_libreta_direcciones_deudor;

    public Deudor(Long id_deudor, String nombre_completo, String primer_nombre, String segundo_nombre, String tercer_nombre, String primer_apellido, String segundo_apellido, Long dpi, Long nit, Genero genero, Calendar fecha_nacimiento, EstadoCivil estado_civil, Profesion prefesion, Nacionalidad nacionalidad, String descripcion, Calendar fecha_hora_modificacion, String usuario_modificacion, List<DirectorioTelefonicoDeudor> lst_directorio_telefonico_deudor, List<LibretaCorreoElectronicoDeudor> lst_libreta_correo_electronico_deudor, List<LibretaDireccionesDeudor> lst_libreta_direcciones_deudor) {
        this.id_deudor = id_deudor;
        this.nombre_completo = nombre_completo;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.tercer_nombre = tercer_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.dpi = dpi;
        this.nit = nit;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado_civil = estado_civil;
        this.prefesion = prefesion;
        this.nacionalidad = nacionalidad;
        this.descripcion = descripcion;
        this.fecha_hora_modificacion = fecha_hora_modificacion;
        this.usuario_modificacion = usuario_modificacion;
        this.lst_directorio_telefonico_deudor = lst_directorio_telefonico_deudor;
        this.lst_libreta_correo_electronico_deudor = lst_libreta_correo_electronico_deudor;
        this.lst_libreta_direcciones_deudor = lst_libreta_direcciones_deudor;
    }

    public Deudor() {
    }

    public Long getId_deudor() {
        return id_deudor;
    }

    public void setId_deudor(Long id_deudor) {
        this.id_deudor = id_deudor;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getTercer_nombre() {
        return tercer_nombre;
    }

    public void setTercer_nombre(String tercer_nombre) {
        this.tercer_nombre = tercer_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public Long getDpi() {
        return dpi;
    }

    public void setDpi(Long dpi) {
        this.dpi = dpi;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Calendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Calendar fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public EstadoCivil getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(EstadoCivil estado_civil) {
        this.estado_civil = estado_civil;
    }

    public Profesion getPrefesion() {
        return prefesion;
    }

    public void setPrefesion(Profesion prefesion) {
        this.prefesion = prefesion;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
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

    public List<DirectorioTelefonicoDeudor> getLst_directorio_telefonico_deudor() {
        return lst_directorio_telefonico_deudor;
    }

    public void setLst_directorio_telefonico_deudor(List<DirectorioTelefonicoDeudor> lst_directorio_telefonico_deudor) {
        this.lst_directorio_telefonico_deudor = lst_directorio_telefonico_deudor;
    }

    public List<LibretaCorreoElectronicoDeudor> getLst_libreta_correo_electronico_deudor() {
        return lst_libreta_correo_electronico_deudor;
    }

    public void setLst_libreta_correo_electronico_deudor(List<LibretaCorreoElectronicoDeudor> lst_libreta_correo_electronico_deudor) {
        this.lst_libreta_correo_electronico_deudor = lst_libreta_correo_electronico_deudor;
    }

    public List<LibretaDireccionesDeudor> getLst_libreta_direcciones_deudor() {
        return lst_libreta_direcciones_deudor;
    }

    public void setLst_libreta_direcciones_deudor(List<LibretaDireccionesDeudor> lst_libreta_direcciones_deudor) {
        this.lst_libreta_direcciones_deudor = lst_libreta_direcciones_deudor;
    }

    @Override
    public String toString() {
        return "Deudor{" + "id_deudor=" + id_deudor + ", nombre_completo=" + nombre_completo + ", primer_nombre=" + primer_nombre + ", segundo_nombre=" + segundo_nombre + ", tercer_nombre=" + tercer_nombre + ", primer_apellido=" + primer_apellido + ", segundo_apellido=" + segundo_apellido + ", dpi=" + dpi + ", nit=" + nit + ", genero=" + genero + ", fecha_nacimiento=" + fecha_nacimiento + ", estado_civil=" + estado_civil + ", prefesion=" + prefesion + ", nacionalidad=" + nacionalidad + ", descripcion=" + descripcion + ", fecha_hora_modificacion=" + fecha_hora_modificacion + ", usuario_modificacion=" + usuario_modificacion + ", lst_directorio_telefonico_deudor=" + lst_directorio_telefonico_deudor + ", lst_libreta_correo_electronico_deudor=" + lst_libreta_correo_electronico_deudor + ", lst_libreta_direcciones_deudor=" + lst_libreta_direcciones_deudor + '}';
    }
    
}
