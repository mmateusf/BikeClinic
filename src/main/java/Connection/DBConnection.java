package Connection;

/**
 *
 * @author BMO Clase para conectar con la base de datos, mantiene el registro de
 * la base y solo se debe instanciar el objeto, preferiblemente conn.
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    //Declaración objeto conector.
    Connection connection;
    //Datos base de datos para url en el driven.
    static String db = "BikeClinic";   // Cambiar "BikeClinic" por "railway"
    static String port = "3306";       // Cambiar "3306" por "7846"
    static String login = "root";
    static String pasword = "admin";   // Cambiar "admin" por "rHaCxK5cvaE8ZSvI17L0"
    //static String ip = "containers-us-west-92.railway.app";

    public DBConnection() {
        //no tiene parametros porque se logea con usuario y contraseña, por lo cual no se realiza. 
        try {
            //registra el driven para la conexión en MySql.
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:" + this.port + "/" + this.db;     // Cambiar localhost por "+this.ip+"
            connection = DriverManager.getConnection(url, this.login, this.pasword);
            System.out.println("Conexión con la base de datos exitosa.");
        } catch (Exception ex) {
            System.out.println("Error en la conexión. " + ex.getMessage());
        }
    }
    //pa llamar la conexión

    public Connection conectar() {
        return connection;
    }

    //pa desconectar
    public void desconectar() {
        connection = null;
    }
}
