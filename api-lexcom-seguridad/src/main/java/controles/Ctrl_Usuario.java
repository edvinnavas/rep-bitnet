package controles;

import com.google.gson.Gson;
import entidades.Usuario;
import java.io.Serializable;
import java.sql.Connection;
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

}
