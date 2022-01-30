package servicios;

import com.google.gson.Gson;
import controles.Ctrl_Aplicacion;
import controles.Ctrl_Driver;
import controles.Ctrl_Rol;
import controles.Ctrl_Usuario;
import entidades.Aplicacion;
import entidades.Rol;
import entidades.Usuario;
import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("servicios")
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final String JNDI_NAME = "jndi-lexcom";
    
    private Connection conn;
    
    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
    
    @GET
    @Path("obtener_aplicacion_todos")
    @Produces({"application/json", "text/plain"})
    public String obtener_aplicacion_todos() {
        String resultado = "";
        Ctrl_Driver ctrl_driver = new Ctrl_Driver(JNDI_NAME);
        
        try {
            this.conn = ctrl_driver.Abrir_Conexion();
            Ctrl_Aplicacion ctrl_aplicacion = new Ctrl_Aplicacion();
            List<Aplicacion> lst_aplicacion = ctrl_aplicacion.obtener_aplicacion_todos(this.conn);
            resultado = new Gson().toJson(lst_aplicacion);
        } catch (Exception ex) {
            resultado = "1,ERROR: " + this.getClass().getName() + " METODO: obtener_aplicacion_todos MENSAJE: " + ex.getLocalizedMessage();
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_aplicacion_todos MENSAJE: " + ex.getLocalizedMessage());
        } finally {
            this.conn = ctrl_driver.Cerrar_Conexion(this.conn);
        }
        
        return resultado;
    }
    
    @GET
    @Path("obtener_aplicacion/{id_aplicacion}")
    @Produces({"application/json", "text/plain"})
    public String obtener_aplicacion(@PathParam("id_aplicacion") Long id_aplicacion) {
        String resultado = "";
        Ctrl_Driver ctrl_driver = new Ctrl_Driver(JNDI_NAME);
        
        try {
            this.conn = ctrl_driver.Abrir_Conexion();
            Ctrl_Aplicacion ctrl_aplicacion = new Ctrl_Aplicacion();
            Aplicacion aplicacion = ctrl_aplicacion.obtener_aplicacion(id_aplicacion, this.conn);
            resultado = new Gson().toJson(aplicacion);
        } catch (Exception ex) {
            resultado = "1,ERROR: " + this.getClass().getName() + " METODO: obtener_aplicacion MENSAJE: " + ex.getLocalizedMessage();
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_aplicacion MENSAJE: " + ex.getLocalizedMessage());
        } finally {
            this.conn = ctrl_driver.Cerrar_Conexion(this.conn);
        }
        
        return resultado;
    }
    
    @POST
    @Path("crear_aplicacion")
    @Produces({"text/plain"})
    public String crear_aplicacion(String jsonString) {
        String resultado = "";
        Ctrl_Driver ctrl_driver = new Ctrl_Driver(JNDI_NAME);
        
        try {
            this.conn = ctrl_driver.Abrir_Conexion();
            Ctrl_Aplicacion ctrl_aplicacion = new Ctrl_Aplicacion();
            resultado = ctrl_aplicacion.crear_aplicacion(jsonString, this.conn);
        } catch (Exception ex) {
            resultado = "1,ERROR: " + this.getClass().getName() + " METODO: crear_aplicacion MENSAJE: " + ex.getLocalizedMessage();
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: crear_aplicacion MENSAJE: " + ex.getLocalizedMessage());
        } finally {
            this.conn = ctrl_driver.Cerrar_Conexion(this.conn);
        }
        
        return resultado;
    }
    
    @PUT
    @Path("modificar_aplicacion")
    @Produces({"text/plain"})
    public String modificar_aplicacion(String jsonString) {
        String resultado = "";
        Ctrl_Driver ctrl_driver = new Ctrl_Driver(JNDI_NAME);
        
        try {
            this.conn = ctrl_driver.Abrir_Conexion();
            Ctrl_Aplicacion ctrl_aplicacion = new Ctrl_Aplicacion();
            resultado = ctrl_aplicacion.modificar_aplicacion(jsonString, this.conn);
        } catch (Exception ex) {
            resultado = "1,ERROR: " + this.getClass().getName() + " METODO: modificar_aplicacion MENSAJE: " + ex.getLocalizedMessage();
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: modificar_aplicacion MENSAJE: " + ex.getLocalizedMessage());
        } finally {
            this.conn = ctrl_driver.Cerrar_Conexion(this.conn);
        }
        return resultado;
    }
    
    @DELETE
    @Path("eliminar_aplicacion/{id_aplicacion}")
    @Produces({"text/plain"})
    public String eliminar_aplicacion(@PathParam("id_aplicacion") Long id_aplicacion) {
        String resultado = "";
        Ctrl_Driver ctrl_driver = new Ctrl_Driver(JNDI_NAME);
        
        try {
            this.conn = ctrl_driver.Abrir_Conexion();
            Ctrl_Aplicacion ctrl_aplicacion = new Ctrl_Aplicacion();
            resultado = ctrl_aplicacion.eliminar_aplicacion(id_aplicacion, this.conn);
        } catch (Exception ex) {
            resultado = "1,ERROR: " + this.getClass().getName() + " METODO: eliminar_aplicacion MENSAJE: " + ex.getLocalizedMessage();
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: eliminar_aplicacion MENSAJE: " + ex.getLocalizedMessage());
        } finally {
            this.conn = ctrl_driver.Cerrar_Conexion(this.conn);
        }
        
        return resultado;
    }
    
    @GET
    @Path("obtener_usuario_todos")
    @Produces({"application/json", "text/plain"})
    public String obtener_usuario_todos() {
        String resultado = "";
        Ctrl_Driver ctrl_driver = new Ctrl_Driver(JNDI_NAME);
        
        try {
            this.conn = ctrl_driver.Abrir_Conexion();
            Ctrl_Usuario ctrl_usuario = new Ctrl_Usuario();
            List<Usuario> lst_usuario = ctrl_usuario.obtener_usuario_todos(conn);
            resultado = new Gson().toJson(lst_usuario);
        } catch (Exception ex) {
            resultado = "1,ERROR: " + this.getClass().getName() + " METODO: obtener_usuario_todos MENSAJE: " + ex.getLocalizedMessage();
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_usuario_todos MENSAJE: " + ex.getLocalizedMessage());
        } finally {
            this.conn = ctrl_driver.Cerrar_Conexion(this.conn);
        }
        
        return resultado;
    }
    
    @GET
    @Path("obtener_usuario/{id_usuario}")
    @Produces({"application/json", "text/plain"})
    public String obtener_usuario(@PathParam("id_usuario") Long id_usuario) {
        String resultado = "";
        Ctrl_Driver ctrl_driver = new Ctrl_Driver(JNDI_NAME);
        
        try {
            this.conn = ctrl_driver.Abrir_Conexion();
            Ctrl_Usuario ctrl_usuario = new Ctrl_Usuario();
            Usuario usuario = ctrl_usuario.obtener_usuario(id_usuario, this.conn);
            resultado = new Gson().toJson(usuario);
        } catch (Exception ex) {
            resultado = "1,ERROR: " + this.getClass().getName() + " METODO: obtener_usuario MENSAJE: " + ex.getLocalizedMessage();
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_usuario MENSAJE: " + ex.getLocalizedMessage());
        } finally {
            this.conn = ctrl_driver.Cerrar_Conexion(this.conn);
        }
        
        return resultado;
    }
    
    @POST
    @Path("crear_usuario/{id_rol}")
    @Produces({"text/plain"})
    public String crear_usuario(String jsonString, @PathParam("id_rol") Long id_rol) {
        String resultado = "";
        Ctrl_Driver ctrl_driver = new Ctrl_Driver(JNDI_NAME);
        
        try {
            this.conn = ctrl_driver.Abrir_Conexion();
            Ctrl_Usuario ctrl_usuario = new Ctrl_Usuario();
            Ctrl_Rol ctrl_rol = new Ctrl_Rol();
            Rol rol = ctrl_rol.obtener_rol(id_rol, conn);
            if (rol != null) {
                resultado = ctrl_usuario.crear_usuario(jsonString, id_rol, conn);
            } else {
                resultado = "1,El rol no existe! por favor verifique el id de rol.";
            }
        } catch (Exception ex) {
            resultado = "1,ERROR: " + this.getClass().getName() + " METODO: crear_usuario MENSAJE: " + ex.getLocalizedMessage();
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: crear_usuario MENSAJE: " + ex.getLocalizedMessage());
        } finally {
            this.conn = ctrl_driver.Cerrar_Conexion(this.conn);
        }
        
        return resultado;
    }
    
    @PUT
    @Path("modificar_usuario/{id_rol}")
    @Produces({"text/plain"})
    public String modificar_usuario(String jsonString, @PathParam("id_rol") Long id_rol) {
        String resultado = "";
        Ctrl_Driver ctrl_driver = new Ctrl_Driver(JNDI_NAME);
        
        try {
            this.conn = ctrl_driver.Abrir_Conexion();
            Ctrl_Usuario ctrl_usuario = new Ctrl_Usuario();
            Ctrl_Rol ctrl_rol = new Ctrl_Rol();
            Rol rol = ctrl_rol.obtener_rol(id_rol, conn);
            if (rol != null) {
                resultado = ctrl_usuario.modificar_usuario(jsonString, id_rol, conn);
            } else {
                resultado = "1,El rol no existe! por favor verifique el id de rol.";
            }
        } catch (Exception ex) {
            resultado = "1,ERROR: " + this.getClass().getName() + " METODO: modificar_usuario MENSAJE: " + ex.getLocalizedMessage();
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: modificar_usuario MENSAJE: " + ex.getLocalizedMessage());
        } finally {
            this.conn = ctrl_driver.Cerrar_Conexion(this.conn);
        }
        
        return resultado;
    }
    
    @POST
    @Path("crear_rol")
    @Produces({"text/plain"})
    public String crear_rol(String jsonString) {
        String resultado = "";
        Ctrl_Driver ctrl_driver = new Ctrl_Driver(JNDI_NAME);
        
        try {
            this.conn = ctrl_driver.Abrir_Conexion();
            Ctrl_Rol ctrl_rol = new Ctrl_Rol();
            resultado = ctrl_rol.crear_rol(jsonString, this.conn);
        } catch (Exception ex) {
            resultado = "1,ERROR: " + this.getClass().getName() + " METODO: crear_rol MENSAJE: " + ex.getLocalizedMessage();
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: crear_rol MENSAJE: " + ex.getLocalizedMessage());
        } finally {
            this.conn = ctrl_driver.Cerrar_Conexion(this.conn);
        }
        
        return resultado;
    }
    
    @GET
    @Path("obtener_rol_todos")
    @Produces({"application/json", "text/plain"})
    public String obtener_rol_todos() {
        String resultado = "";
        Ctrl_Driver ctrl_driver = new Ctrl_Driver(JNDI_NAME);
        
        try {
            this.conn = ctrl_driver.Abrir_Conexion();
            Ctrl_Rol ctrl_rol = new Ctrl_Rol();
            List<Rol> lst_rol = ctrl_rol.obtener_rol_todos(this.conn);
            resultado = new Gson().toJson(lst_rol);
        } catch (Exception ex) {
            resultado = "1,ERROR: " + this.getClass().getName() + " METODO: obtener_rol_todos MENSAJE: " + ex.getLocalizedMessage();
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_rol_todos MENSAJE: " + ex.getLocalizedMessage());
        } finally {
            this.conn = ctrl_driver.Cerrar_Conexion(this.conn);
        }
        
        return resultado;
    }
    
    @GET
    @Path("obtener_rol/{id_rol}")
    @Produces({"application/json", "text/plain"})
    public String obtener_rol(@PathParam("id_rol") Long id_rol) {
        String resultado = "";
        Ctrl_Driver ctrl_driver = new Ctrl_Driver(JNDI_NAME);
        
        try {
            this.conn = ctrl_driver.Abrir_Conexion();
            Ctrl_Rol ctrl_rol = new Ctrl_Rol();
            Rol rol = ctrl_rol.obtener_rol(id_rol, this.conn);
            resultado = new Gson().toJson(rol);
        } catch (Exception ex) {
            resultado = "1,ERROR: " + this.getClass().getName() + " METODO: obtener_rol MENSAJE: " + ex.getLocalizedMessage();
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_rol MENSAJE: " + ex.getLocalizedMessage());
        } finally {
            this.conn = ctrl_driver.Cerrar_Conexion(this.conn);
        }
        
        return resultado;
    }
    
    @PUT
    @Path("modificar_rol")
    @Produces({"text/plain"})
    public String modificar_rol(String jsonString) {
        String resultado = "";
        Ctrl_Driver ctrl_driver = new Ctrl_Driver(JNDI_NAME);
        
        try {
            this.conn = ctrl_driver.Abrir_Conexion();
            Ctrl_Rol ctrl_rol = new Ctrl_Rol();
            resultado = ctrl_rol.modificar_rol(jsonString, this.conn);
        } catch (Exception ex) {
            resultado = "1,ERROR: " + this.getClass().getName() + " METODO: modificar_rol MENSAJE: " + ex.getLocalizedMessage();
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: modificar_rol MENSAJE: " + ex.getLocalizedMessage());
        } finally {
            this.conn = ctrl_driver.Cerrar_Conexion(this.conn);
        }
        return resultado;
    }
    
}
