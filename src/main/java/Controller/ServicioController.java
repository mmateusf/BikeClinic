package Controller;

import Beans.Servicio;
import Connection.DBConnection;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author BMO
 */
public class ServicioController implements IServicioController {

    @Override
    public String obtenerServicios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String listarServicios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String actualizarServicio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String registrarServicio(String nombreServicio, String detalleServicio, double valorServicio) {
        
        //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        
        //Consulta para setear.INSERT. ID no se pasa porque es autoincremental
        String sql = "INSERT INTO servicios(nombreProceso, detalleProceso, valorProceso) values('" + nombreServicio + "', '" + detalleServicio + "', " + valorServicio  + ")";

        try {
            Statement st = conn.conectar().createStatement();
//          Se ejecuta un update porque se está ejecutando.
            st.executeUpdate(sql);

//          Se crea objeto y se vuelve json.
            Servicio servicio = new Servicio(nombreServicio, detalleServicio, valorServicio);
            st.close();
            System.out.println("Se realizó la consulta de actualización en: " + servicio);
            //Regregar el objeto de Json
            return gson.toJson(servicio);

        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en el register() " + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return "false";
    }

}
