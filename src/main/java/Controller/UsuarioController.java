package Controller;

import Beans.Usuario;
import Connection.DBConnection;
import com.google.gson.Gson;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String correo, String password) {
        //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT * FROM usuarios WHERE correo='" + correo + "'  and password='" + password + "'";
        try {
            PreparedStatement pstm = conn.conectar().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String primerApellido = rs.getString("primerApellido");
                String segundoApellido = rs.getString("segundooApellido");
                String numeroContacto = rs.getString("numeroContacto");
                String estado = rs.getString("estado");
                String rol = rs.getString("rol");

//                Se crea objeto y se vuelve json.
                Usuario usuario = new Usuario(estado, password, rol, id, nombre, primerApellido, segundoApellido, correo, numeroContacto);
                return gson.toJson(usuario);
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en el login " + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return "false";
    }

    @Override
    public String registerMecanico(int id, String nombre, String primerApellido, String segundoApellido, String estado, String rol, String correo, String password, String numeroContacto) {
        //ASignación de Variables que no se colocan en front pero deben ir en persistencia. NO ES NECESARIO SE SETEAN EN EL JS.
//        estado = "Activo";
//        rol = "Mecánico";
        //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();

        //Consulta para setear.INSERT. Se actualiza.
        String sql = "INSERT INTO usuarios values('" + id + "', '" + nombre + "', '" + primerApellido + "', '" + segundoApellido + "',  '" + correo + "', '" + numeroContacto + "', '" + estado + "', '" + password + "', '" + rol + "')";

        try {
            Statement st = conn.conectar().prepareStatement(sql);
//          Se ejecuta un update porque se está ejecutando.
            st.executeUpdate(sql);

//          Se crea objeto y se vuelve json.
            Usuario usuario = new Usuario(estado, password, rol, id, nombre, primerApellido, segundoApellido, correo, numeroContacto);
            st.close();
            System.out.println("Se realizó la consulta" + usuario);
            //no sé bien pa qué.
            return gson.toJson(usuario);

        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en el register() " + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return "false";
    }
    
}
