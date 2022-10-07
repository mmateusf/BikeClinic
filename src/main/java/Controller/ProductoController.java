package Controller;

import Beans.Producto;
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
public class ProductoController implements IProductoController {

    @Override
    public String registrarProducto(String nombre, double valorProducto) {

        //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();

        //Consulta para setear.INSERT. ID no se pasa porque es autoincremental
        String sql = "INSERT INTO productos(nombre, valorProducto) values('" + nombre + "', " + valorProducto + ")";

        try {
            Statement st = conn.conectar().createStatement();
//          Se ejecuta un update porque se está ejecutando.
            st.executeUpdate(sql);

//          Se crea objeto y se vuelve json.
            Producto producto = new Producto(nombre, valorProducto);
            st.close();
            System.out.println("Se realizó la consulta de actualización en: " + producto);
            //Regregar el objeto de Json
            return gson.toJson(producto);

        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en el producto " + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return "false";
    }

    @Override
    public String obtenerProductos() {
        
        //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT * FROM productos";

        List<String> listaProductos = new ArrayList<>();
        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            //List para guardar objeticos :D

            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String nombre = rs.getString("nombre");
                double valorProducto = rs.getDouble("valorProducto");
//                Se crea objeto y se vuelve json.
                Producto productoC = new Producto( idProducto, nombre, valorProducto);

                //Para agregarle
                listaProductos.add(gson.toJson(productoC));

            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en obtener productos " + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return gson.toJson(listaProductos);
    }

    @Override
    public String actualizarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
