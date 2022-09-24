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
    static String db = "BikeClinic";
    static String port = "3306";
    static String login = "root";
    static String pasword = "admin";

    public DBConnection() {
        //no tiene parametros porque se logea con usuario y contraseña, por lo cual no se realiza. 
        try {
            //registra el driven para la conexión en MySql.
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:" + this.port + "/" + this.db;
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
