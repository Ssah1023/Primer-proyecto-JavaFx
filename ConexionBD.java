
package expedientedelictivo;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
/**
 *
 * @author betin
 */
public class ConexionBD {
    private static final String URL = "jdbc:postgresql://localhost:5432/expedientes_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";
    private static Connection connection;

   
    public static Connection getConnection() {
    try {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
    } catch (SQLException ex) {
        System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
    }
    return connection;
    }
    
    public static void cerrarConexion() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
}

    /**
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException ex) {
                System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
            }
        }
        return connection;
    }
    */