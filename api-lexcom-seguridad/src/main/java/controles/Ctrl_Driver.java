package controles;

import java.io.Serializable;
import java.sql.Connection;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Ctrl_Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    private String jndi_nombre;
    private Connection conn;

    public Ctrl_Driver() {
    }

    public Ctrl_Driver(String jndi_nombre) {
        try {
            this.jndi_nombre = jndi_nombre;
        } catch (Exception ex) {
            System.out.println("1,ERROR (" + this.getClass().getName() + " - Ctrl_Driver):" + ex.toString());
        }
    }

    public Connection Abrir_Conexion() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup(this.jndi_nombre);
            this.conn = ds.getConnection();
        } catch (Exception ex) {
            this.conn = null;
            System.out.println("1,ERROR (" + this.getClass().getName() + " - Abrir_Conexion):" + ex.toString());
        }

        return this.conn;
    }

    public Connection Cerrar_Conexion(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (Exception ex) {
            conn = null;
            System.out.println("1,ERROR (" + this.getClass().getName() + " - Cerrar_Conexion):" + ex.toString());
        }
        
        return conn;
    }
}
