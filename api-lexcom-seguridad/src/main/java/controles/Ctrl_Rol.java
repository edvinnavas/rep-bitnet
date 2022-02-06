package controles;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entidades.Control;
import entidades.Rol;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ctrl_Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    public Ctrl_Rol() {
    }

    public List<Rol> obtener_rol_todos(Connection conn) {
        List<Rol> resultado = new ArrayList<>();

        try {
            String cadenasql = "SELECT "
                    + "r.id_rol, "
                    + "r.nombre, "
                    + "r.activo, "
                    + "r.descripcion "
                    + "FROM "
                    + "rol r";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cadenasql);
            while (rs.next()) {
                Rol rol = new Rol(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4), this.obtener_controladores_permitidos(rs.getLong(1), conn));
                resultado.add(rol);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            resultado = null;
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_rol_todos MENSAJE: " + ex.getLocalizedMessage());
        }

        return resultado;
    }

    public Rol obtener_rol(Long id_rol, Connection conn) {
        Rol resultado = new Rol();

        try {
            String cadenasql = "SELECT "
                    + "r.id_rol, "
                    + "r.nombre, "
                    + "r.activo, "
                    + "r.descripcion "
                    + "FROM "
                    + "rol r "
                    + "WHERE r.id_rol=" + id_rol;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cadenasql);
            while (rs.next()) {
                resultado = new Rol(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4), this.obtener_controladores_permitidos(id_rol, conn));
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            resultado = null;
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_rol MENSAJE: " + ex.getLocalizedMessage());
        }

        return resultado;
    }

    public String crear_rol(String jsonString, Connection conn) {
        String resultado = "";

        try {
            Type listType = new TypeToken<ArrayList<Rol>>() {
            }.getType();
            List<Rol> lista_rol = new Gson().fromJson(jsonString, listType);

            conn.setAutoCommit(false);

            for (Integer i = 0; i < lista_rol.size(); i++) {
                String cadenasql = "SELECT IFNULL(MAX(r.id_rol), 0) + 1 MAXIMO FROM rol r";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(cadenasql);
                Long id_rol_max = Long.parseLong("0");
                while (rs.next()) {
                    id_rol_max = rs.getLong(1);
                }
                rs.close();
                stmt.close();

                cadenasql = "INSERT INTO rol (id_rol, nombre, activo, descripcion) VALUES (?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(cadenasql);
                pstmt.setLong(1, id_rol_max);
                pstmt.setString(2, lista_rol.get(i).getNombre());
                pstmt.setLong(3, lista_rol.get(i).getActivo());
                pstmt.setString(4, lista_rol.get(i).getDescripcion());
                pstmt.executeUpdate();
                pstmt.close();
                
                for (Integer j = 0; j < lista_rol.get(i).getLst_control().size(); j++) {
                    cadenasql = "INSERT INTO rol_aplicacion_control (id_rol, id_control, id_aplicacion) VALUES (?,?,?)";
                    pstmt = conn.prepareStatement(cadenasql);
                    pstmt.setLong(1, id_rol_max);
                    pstmt.setLong(2, lista_rol.get(i).getLst_control().get(j).getId_control());
                    pstmt.setLong(3, lista_rol.get(i).getLst_control().get(j).getAplicacion().getId_aplicacion());
                    pstmt.executeUpdate();
                    pstmt.close();
                }
                
            }

            conn.commit();
            conn.setAutoCommit(true);

            resultado = "0,Rol creado correctamente.";
        } catch (Exception ex) {
            try {
                conn.rollback();

                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: crear_rol MENSAJE: " + ex.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: crear_rol MENSAJE: " + ex.getLocalizedMessage());
            } catch (Exception ex1) {
                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: crear_rol_1 MENSAJE: " + ex1.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: crear_rol_1 MENSAJE: " + ex1.getLocalizedMessage());
            }
        }

        return resultado;
    }

    public String modificar_rol(String jsonString, Connection conn) {
        String resultado = "";

        try {
            Type listType = new TypeToken<ArrayList<Rol>>() {
            }.getType();
            List<Rol> lista_rol = new Gson().fromJson(jsonString, listType);

            conn.setAutoCommit(false);

            for (Integer i = 0; i < lista_rol.size(); i++) {
                String cadenasql = "UPDATE rol SET nombre=?, activo=?, descripcion=? WHERE id_rol=?";
                PreparedStatement pstmt = conn.prepareStatement(cadenasql);
                pstmt.setString(1, lista_rol.get(i).getNombre());
                pstmt.setLong(2, lista_rol.get(i).getActivo());
                pstmt.setString(3, lista_rol.get(i).getDescripcion());
                pstmt.setLong(4, lista_rol.get(i).getId_rol());
                pstmt.executeUpdate();
                pstmt.close();
            }

            conn.commit();
            conn.setAutoCommit(true);

            resultado = "0,Rol modificado correctamente.";
        } catch (Exception ex) {
            try {
                conn.rollback();

                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: modificar_aplicacion MENSAJE: " + ex.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: modificar_aplicacion MENSAJE: " + ex.getLocalizedMessage());
            } catch (Exception ex1) {
                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: modificar_aplicacion_1 MENSAJE: " + ex1.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: modificar_aplicacion_1 MENSAJE: " + ex1.getLocalizedMessage());
            }
        }

        return resultado;
    }
    
    private List<Control> obtener_controladores_permitidos(Long id_rol, Connection conn) {
        List<Control> resultado = new ArrayList<>();
        
        try {
            String cadenasql = "SELECT rac.id_control FROM rol_aplicacion_control rac WHERE rac.id_rol=?";
            PreparedStatement stmt = conn.prepareStatement(cadenasql);
            stmt.setLong(1, id_rol);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ctrl_Control ctrl_control = new Ctrl_Control();
                Control control = ctrl_control.obtener_control(rs.getLong(1), conn);
                resultado.add(control);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_controladores_permitidos MENSAJE: " + ex.getLocalizedMessage());
        }
        
        return resultado;
    }
    
    public boolean obtener_actividad_rol(Long id_rol, Connection conn) {
        boolean resultado = false;
        
        try {
            String cadenasql = "SELECT r.activo FROM rol r WHERE r.id_rol=?";
            PreparedStatement stmt = conn.prepareStatement(cadenasql);
            stmt.setLong(1, id_rol);
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
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_actividad_rol MENSAJE: " + ex.getLocalizedMessage());
        }
        
        return resultado;
    }
}
