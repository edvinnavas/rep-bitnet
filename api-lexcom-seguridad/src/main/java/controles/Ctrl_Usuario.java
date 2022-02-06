package controles;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entidades.Usuario;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ctrl_Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    public Ctrl_Usuario() {
    }

    public List<Usuario> obtener_usuario_todos(Connection conn) {
        List<Usuario> resultado = new ArrayList<>();

        try {
            String cadenasql = "SELECT "
                    + "u.id_usuario, "
                    + "u.nombre_completo, "
                    + "u.nombre_usuario, "
                    + "'-' contrasena, "
                    + "u.correo_electronico, "
                    + "u.activo, "
                    + "u.descripcion, "
                    + "u.id_rol "
                    + "FROM "
                    + "usuario u";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cadenasql);
            while (rs.next()) {
                Ctrl_Rol ctrl_rol = new Ctrl_Rol();
                Usuario usuario = new Usuario(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getLong(6), rs.getString(7), ctrl_rol.obtener_rol(rs.getLong(8), conn));
                resultado.add(usuario);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_usuario_todos MENSAJE: " + ex.getLocalizedMessage());
        }

        return resultado;
    }

    public Usuario obtener_usuario(Long id_usuario, Connection conn) {
        Usuario resultado = new Usuario();

        try {
            String cadenasql = "SELECT "
                    + "u.id_usuario, "
                    + "u.nombre_completo, "
                    + "u.nombre_usuario, "
                    + "'-' contrasena, "
                    + "u.correo_electronico, "
                    + "u.activo, "
                    + "u.descripcion, "
                    + "u.id_rol "
                    + "FROM "
                    + "usuario u "
                    + "WHERE u.id_usuario=" + id_usuario;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cadenasql);
            while (rs.next()) {
                Ctrl_Rol ctrl_rol = new Ctrl_Rol();
                resultado = new Usuario(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getLong(6), rs.getString(7), ctrl_rol.obtener_rol(rs.getLong(8), conn));
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            resultado = null;
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_usuario MENSAJE: " + ex.getLocalizedMessage());
        }

        return resultado;
    }

    public String crear_usuario(String jsonString, Connection conn) {
        String resultado = "";

        try {
            Type listType = new TypeToken<ArrayList<Usuario>>() {
            }.getType();
            List<Usuario> lista_usuario = new Gson().fromJson(jsonString, listType);
            
            System.out.println(new Gson().toJson(lista_usuario));
            
            conn.setAutoCommit(false);
            
            for (Integer i = 0; i < lista_usuario.size(); i++) {
                String cadenasql = "SELECT IFNULL(MAX(u.id_usuario), 0) + 1 MAXIMO FROM usuario u";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(cadenasql);
                Long id_usuario_max = Long.parseLong("0");
                while (rs.next()) {
                    id_usuario_max = rs.getLong(1);
                }
                rs.close();
                stmt.close();

                cadenasql = "INSERT INTO usuario (id_usuario, nombre_completo, nombre_usuario, contrasena, correo_electronico, activo, descripcion, id_rol) VALUES (?,?,?,SHA2(?, 512),?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(cadenasql);
                pstmt.setLong(1, id_usuario_max);
                pstmt.setString(2, lista_usuario.get(i).getNombre_completo());
                pstmt.setString(3, lista_usuario.get(i).getNombre_usuario());
                pstmt.setString(4, lista_usuario.get(i).getContrasena());
                
                pstmt.setString(5, lista_usuario.get(i).getCorreo_electronico());
                pstmt.setLong(6, lista_usuario.get(i).getActivo());
                pstmt.setString(7, lista_usuario.get(i).getDescripcion());
                pstmt.setLong(8, lista_usuario.get(i).getRol().getId_rol());
                
                pstmt.executeUpdate();
                pstmt.close();
            }
            
            conn.commit();
            conn.setAutoCommit(true);
            
            resultado = "0,Usuario creado correctamente.";
        } catch (Exception ex) {
            try {
                conn.rollback();

                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: crear_usuario MENSAJE: " + ex.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: crear_usuario MENSAJE: " + ex.getLocalizedMessage());
            } catch (Exception ex1) {
                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: crear_usuario_1 MENSAJE: " + ex1.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: crear_usuario_1 MENSAJE: " + ex1.getLocalizedMessage());
            }
        }

        return resultado;
    }
    
    public String modificar_usuario(String jsonString, Connection conn) {
        String resultado = "";
        
        try {
            Type listType = new TypeToken<ArrayList<Usuario>>() {
            }.getType();
            List<Usuario> lista_usuario = new Gson().fromJson(jsonString, listType);
            
            conn.setAutoCommit(false);
            
            for (Integer i = 0; i < lista_usuario.size(); i++) {
                String cadenasql = "UPDATE usuario SET nombre_completo=?, nombre_usuario=?, contrasena=?, correo_electronico=?, activo=?, descripcion=?, id_rol=? WHERE id_usuario=?";
                PreparedStatement stmt = conn.prepareStatement(cadenasql);
                stmt.setString(1, lista_usuario.get(i).getNombre_completo());
                stmt.setString(2, lista_usuario.get(i).getNombre_usuario());
                stmt.setString(3, lista_usuario.get(i).getContrasena());
                stmt.setString(4, lista_usuario.get(i).getCorreo_electronico());
                stmt.setLong(5, lista_usuario.get(i).getActivo());
                stmt.setString(6, lista_usuario.get(i).getDescripcion());
                stmt.setLong(7, lista_usuario.get(i).getRol().getId_rol());
                stmt.setLong(8, lista_usuario.get(i).getId_usuario());
                stmt.executeUpdate();
                stmt.close();
            }
            
            conn.commit();
            conn.setAutoCommit(true);
            
            resultado = "0,Usuario modificado correctamente.";
        } catch (Exception ex) {
            try {
                conn.rollback();

                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: modificar_usuario MENSAJE: " + ex.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: modificar_usuario MENSAJE: " + ex.getLocalizedMessage());
            } catch (Exception ex1) {
                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: modificar_usuario_1 MENSAJE: " + ex1.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: modificar_usuario_1 MENSAJE: " + ex1.getLocalizedMessage());
            }
        }
        
        return resultado;
    }
    
    public boolean obtener_actividad_usuario(Long id_usuario, Connection conn) {
        boolean resultado = false;
        
        try {
            String cadenasql = "SELECT u.activo FROM usuario u WHERE u.id_usuario=?";
            PreparedStatement stmt = conn.prepareStatement(cadenasql);
            stmt.setLong(1, id_usuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Long activo = rs.getLong(1);
                switch (activo.intValue()) {
                    case 1:
                        resultado = true;
                        break;
                    case 0:
                    default:
                        break;
                }
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_actividad_usuario MENSAJE: " + ex.getLocalizedMessage());
        }
        
        return resultado;
    }
}
