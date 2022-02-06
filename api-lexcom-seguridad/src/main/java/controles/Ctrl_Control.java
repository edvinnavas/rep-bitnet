package controles;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entidades.Control;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ctrl_Control implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public Ctrl_Control() {
    }
    
    public Control obtener_control(Long id_control, Connection conn) {
        Control resultado = new Control();
        
        try {
            String cadenasql = "SELECT c.id_control, c.id_aplicacion, c.nombre, c.activo, c.descripcion FROM control c WHERE c.id_control=?";
            PreparedStatement stmt = conn.prepareStatement(cadenasql);
            stmt.setLong(1, id_control);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ctrl_Aplicacion ctrl_aplicacion = new Ctrl_Aplicacion();
                resultado = new Control(rs.getLong(1), ctrl_aplicacion.obtener_aplicacion(rs.getLong(2), conn), rs.getString(3), rs.getLong(4), rs.getString(5));
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            resultado = null;
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_control MENSAJE: " + ex.getLocalizedMessage());
        }
        
        return resultado;
    }
    
    public List<Control> obtener_control_todos(Connection conn) {
        List<Control> resultado = new ArrayList<>();
        
        try {
            String cadenasql = "SELECT c.id_control, c.id_aplicacion, c.nombre, c.activo, c.descripcion FROM control c";
            PreparedStatement stmt = conn.prepareStatement(cadenasql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ctrl_Aplicacion ctrl_aplicacion = new Ctrl_Aplicacion();
                Control control = new Control(rs.getLong(1), ctrl_aplicacion.obtener_aplicacion(rs.getLong(2), conn), rs.getString(3), rs.getLong(4), rs.getString(5));
                resultado.add(control);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_control_todos MENSAJE: " + ex.getLocalizedMessage());
        }
        
        return resultado;
    }
    
    public String crear_control(String jsonString, Connection conn) {
        String resultado = "";
        
        try {
            Type listType = new TypeToken<ArrayList<Control>>() {
            }.getType();
            List<Control> lista_control = new Gson().fromJson(jsonString, listType);
            
            conn.setAutoCommit(false);
            
            for (Integer i = 0; i < lista_control.size(); i++) {
                String cadenasql = "SELECT IFNULL(MAX(c.id_control), 0) + 1 MAXIMO FROM control c";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(cadenasql);
                Long id_usuario_max = Long.parseLong("0");
                while (rs.next()) {
                    id_usuario_max = rs.getLong(1);
                }
                rs.close();
                stmt.close();
                
                cadenasql = "INSERT INTO control (id_control, id_aplicacion, nombre, activo, descrpicon) VALUES (?,?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(cadenasql);
                pstmt.setLong(1, lista_control.get(i).getId_control());
                pstmt.setLong(2, lista_control.get(i).getAplicacion().getId_aplicacion());
                pstmt.setString(3, lista_control.get(i).getNombre());
                pstmt.setLong(4, lista_control.get(i).getActivo());
                pstmt.setString(5, lista_control.get(i).getDescripcion());
                pstmt.executeUpdate();
                pstmt.close();
            }
            
            conn.commit();
            conn.setAutoCommit(true);
            
            resultado = "0,Control creado correctamente.";
        } catch (Exception ex) {
           try {
                conn.rollback();

                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: crear_control MENSAJE: " + ex.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: crear_control MENSAJE: " + ex.getLocalizedMessage());
            } catch (Exception ex1) {
                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: crear_control_1 MENSAJE: " + ex1.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: crear_control_1 MENSAJE: " + ex1.getLocalizedMessage());
            }
        }
        
        return resultado;
    }
    
    public String modificar_control(String jsonString, Connection conn) {
        String resultado = "";
        
        try {
            Type listType = new TypeToken<ArrayList<Control>>() {
            }.getType();
            List<Control> lista_control = new Gson().fromJson(jsonString, listType);
            
            conn.setAutoCommit(false);
            
            for (Integer i = 0; i < lista_control.size(); i++) {
                String cadenasql = "UPDATE control SET id_aplicacion=?, nombre=?, activo=?, descripcion=? FROM control WHERE id_control=?";
                PreparedStatement stmt = conn.prepareStatement(cadenasql);
                stmt.setLong(1, lista_control.get(i).getAplicacion().getId_aplicacion());
                stmt.setString(2, lista_control.get(i).getNombre());
                stmt.setLong(3, lista_control.get(i).getActivo());
                stmt.setString(4, lista_control.get(i).getDescripcion());
                stmt.setLong(5, lista_control.get(i).getId_control());
                stmt.executeUpdate();
                stmt.close();
            }
            
            conn.commit();
            conn.setAutoCommit(true);
            
            resultado = "0,Control modificado correctamente.";
        } catch (Exception ex) {
            try {
                conn.rollback();

                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: modificar_control MENSAJE: " + ex.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: modificar_control MENSAJE: " + ex.getLocalizedMessage());
            } catch (Exception ex1) {
                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: modificar_control_1 MENSAJE: " + ex1.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: modificar_control_1 MENSAJE: " + ex1.getLocalizedMessage());
            }
        }
        
        return resultado;
    }
    
    public boolean obtener_actividad_control(Long id_control, Connection conn) {
        boolean resultado = false;
        
        try {
            String cadenasql = "SELECT c.activo FROM control c WHERE c.id_control=?";
            PreparedStatement stmt = conn.prepareStatement(cadenasql);
            stmt.setLong(1, id_control);
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
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_actividad_control MENSAJE: " + ex.getLocalizedMessage());
        }
        
        return resultado;
    }
}
