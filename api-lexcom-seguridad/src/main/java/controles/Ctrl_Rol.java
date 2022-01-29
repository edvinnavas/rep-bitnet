package controles;

import com.google.gson.Gson;
import entidades.Rol;
import java.io.Serializable;
import java.sql.Connection;
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
                    + "r.descripcion, "
                    + "FROM "
                    + "rol r";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cadenasql);
            while (rs.next()) {
                Rol rol = new Rol(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4), new ArrayList<>());
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
                resultado = new Rol(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4), new ArrayList<>());
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            resultado = null;
            System.out.println("1,ERROR: " + this.getClass().getName() + " METODO: obtener_rol MENSAJE: " + ex.getLocalizedMessage());
        }

        return resultado;
    }
    
}
