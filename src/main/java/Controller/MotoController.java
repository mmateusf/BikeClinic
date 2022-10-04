package Controller;

import Beans.Moto;
import Connection.DBConnection;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BMO
 */
public class MotoController implements IMotoController {

    @Override
    public String listarMotos() {
        //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT m.*, CONCAT(c.nombre, ' ', c.primerApellido) AS Cliente FROM motos m JOIN clientes c ON c.idCliente = m.Clientes_idCliente";

        List<String> listaMotos = new ArrayList<>();
        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            //List para guardar objeticos :D
            while (rs.next()) {
                String placa = rs.getString("placaMoto");
                String idMotor = rs.getString("idMotor");
                String idChasis = rs.getString("idChasis");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String annoRegistro = rs.getString("annoRegistro");
                int idCliente = rs.getInt("Clientes_idCliente");
                String nombreCliente = rs.getString("Cliente");

//                Se crea objeto y se vuelve json.
                Moto moto = new Moto(placa, idMotor, idChasis, marca, modelo, annoRegistro, idCliente, nombreCliente);

                //Para agregarle
                listaMotos.add(gson.toJson(moto));

            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en listar motos " + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return gson.toJson(listaMotos);

    }
}
