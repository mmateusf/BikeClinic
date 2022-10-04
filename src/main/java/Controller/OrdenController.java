
package Controller;

import Beans.OrdenDeServicio;
import Connection.DBConnection;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author BMO
 */
public class OrdenController implements IOrdenController{

    @Override
    public String listarOrdenes() {
        //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "Select o.idOrden, o.fecha, CONCAT(c.nombre, ' ', c.primerApellido) AS Cliente, CONCAT(u.nombre, ' ', u.primerApellido) AS Mecánico, o.moto, o.motivo, o.descripcionDiagnostico, o.documentos, o.anticipo, o.valorAnticipo, o.autorizacionRuta, o.estado from orden_servicios o JOIN clientes c ON c.idCliente = o.cliente JOIN usuarios u ON u.idUsuario = o.mecanico";

        List<String> listaOrdenes = new ArrayList<>();
        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            //List para guardar objeticos :D
            while (rs.next()) {
                int idOrden = rs.getInt("idOrden");
                Date date = rs.getDate("fecha");
                String nombreCliente = rs.getString("Cliente");
                String nombreMecanico = rs.getString("Mecánico");
                String placaMoto = rs.getString("moto");
                String motivo = rs.getString("motivo");
                String descripcionDiagnostico = rs.getString("descripcionDiagnostico");
                String documentos = rs.getString("documentos");
                String anticipo = rs.getString("anticipo");
                double valorAnticipo = rs.getDouble("valorAnticipo");
                String autorizacionRuta = rs.getString("autorizacionRuta");
                int idEstado = rs.getInt("estado");
                

//                Se crea objeto y se vuelve json.
                OrdenDeServicio orden = new OrdenDeServicio(idOrden, date, nombreCliente, nombreMecanico, placaMoto, motivo, descripcionDiagnostico, documentos, anticipo, valorAnticipo, autorizacionRuta, idEstado);

                //Para agregarle
                listaOrdenes.add(gson.toJson(orden));

            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en listar motos " + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return gson.toJson(listaOrdenes);
    }
    
}
