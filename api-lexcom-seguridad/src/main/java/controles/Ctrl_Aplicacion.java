package controles;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entidades.Aplicacion;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ctrl_Aplicacion implements Serializable {

    private static final long serialVersionUID = 1L;

    public Ctrl_Aplicacion() {
    }

    public List<Aplicacion> obtener_aplicacion_todos(Connection conn) {
        List<Aplicacion> resultado = new ArrayList<>();

        try {
            String cadenasql = "SELECT a.id_aplicacion, a.nombre, a.activo, a.descripcion FROM aplicacion a";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cadenasql);
            while (rs.next()) {
                Aplicacion aplicacion = new Aplicacion(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4));
                resultado.add(aplicacion);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_aplicacion_todos MENSAJE: " + ex.getLocalizedMessage());
        }

        return resultado;
    }

    public Aplicacion obtener_aplicacion(Long id_aplicacion, Connection conn) {
        Aplicacion resultado = new Aplicacion();

        try {
            String cadenasql = "SELECT a.id_aplicacion, a.nombre, a.activo, a.descripcion FROM aplicacion a WHERE a.id_aplicacion=" + id_aplicacion;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cadenasql);
            while (rs.next()) {
                resultado = new Aplicacion(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4));
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            resultado = null;
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_aplicacion MENSAJE: " + ex.getLocalizedMessage());
        }

        return resultado;
    }

    public String crear_aplicacion(String jsonString, Connection conn) {
        String resultado = "";

        try {
            Type listType = new TypeToken<ArrayList<Aplicacion>>() {
            }.getType();
            List<Aplicacion> lista_aplicacion = new Gson().fromJson(jsonString, listType);

            conn.setAutoCommit(false);

            for (Integer i = 0; i < lista_aplicacion.size(); i++) {
                String cadenasql = "SELECT IFNULL(MAX(a.id_aplicacion), 0) + 1 MAXIMO FROM aplicacion a";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(cadenasql);
                Long id_aplicacion_max = Long.parseLong("0");
                while (rs.next()) {
                    id_aplicacion_max = rs.getLong(1);
                }
                rs.close();
                stmt.close();

                cadenasql = "INSERT INTO aplicacion (id_aplicacion, nombre, activo, descripcion) VALUES (?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(cadenasql);
                pstmt.setLong(1, id_aplicacion_max);
                pstmt.setString(2, lista_aplicacion.get(i).getNombre());
                pstmt.setLong(3, lista_aplicacion.get(i).getActivo());
                pstmt.setString(4, lista_aplicacion.get(i).getDescripcion());
                pstmt.executeUpdate();
                pstmt.close();
            }

            conn.commit();
            conn.setAutoCommit(true);

            resultado = "0,Aplicación creada correctamente.";
        } catch (Exception ex) {
            try {
                conn.rollback();

                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: crear_aplicacion MENSAJE: " + ex.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: crear_aplicacion MENSAJE: " + ex.getLocalizedMessage());
            } catch (Exception ex1) {
                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: crear_aplicacion_1 MENSAJE: " + ex1.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: crear_aplicacion_1 MENSAJE: " + ex1.getLocalizedMessage());
            }
        }

        return resultado;
    }

    public String modificar_aplicacion(String jsonString, Connection conn) {
        String resultado = "";

        try {
            Type listType = new TypeToken<ArrayList<Aplicacion>>() {
            }.getType();
            List<Aplicacion> lista_aplicacion = new Gson().fromJson(jsonString, listType);

            conn.setAutoCommit(false);

            for (Integer i = 0; i < lista_aplicacion.size(); i++) {
                String cadenasql = "UPDATE aplicacion SET nombre=?, activo=?, descripcion=? WHERE id_aplicacion=?";
                PreparedStatement pstmt = conn.prepareStatement(cadenasql);
                pstmt.setString(1, lista_aplicacion.get(i).getNombre());
                pstmt.setLong(2, lista_aplicacion.get(i).getActivo());
                pstmt.setString(3, lista_aplicacion.get(i).getDescripcion());
                pstmt.setLong(4, lista_aplicacion.get(i).getId_aplicacion());
                pstmt.executeUpdate();
                pstmt.close();
            }

            conn.commit();
            conn.setAutoCommit(true);

            resultado = "0,Aplicación modificada correctamente.";
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

    public String eliminar_aplicacion(Long id_aplicacion, Connection conn) {
        String resultado = "";

        try {
            conn.setAutoCommit(false);

            String cadenasql = "DELETE FROM aplicacion WHERE id_aplicacion=?";
            PreparedStatement pstmt = conn.prepareStatement(cadenasql);
            pstmt.setLong(1, id_aplicacion);
            pstmt.executeUpdate();
            pstmt.close();

            conn.commit();
            conn.setAutoCommit(true);

            resultado = "0,Aplicación eliminada correctamente.";
        } catch (Exception ex) {
            try {
                conn.rollback();

                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: eliminar_aplicacion MENSAJE: " + ex.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: eliminar_aplicacion MENSAJE: " + ex.getLocalizedMessage());
            } catch (Exception ex1) {
                resultado = "1,ERROR: " + this.getClass().getName() + " METODO: eliminar_aplicacion_1 MENSAJE: " + ex1.getLocalizedMessage();
                System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: eliminar_aplicacion_1 MENSAJE: " + ex1.getLocalizedMessage());
            }
        }

        return resultado;
    }

}
