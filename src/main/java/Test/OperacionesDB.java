
package Test;


import Beans.*;
import Connection.DBConnection;
import Controller.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;


/**
 *
 * @author BMO
 */
public class OperacionesDB {
    
    public static void main(String[] args) {
        
        //Correcta con el tema del servidor al inicio.
//        conectarse();s
        //seteo de datos con Upcasting
        /*
        pruebaBeans();
        actualizarAdminstrador(1116547319, "Activo");
        listarEstado(4);
        ordenes();
        UsuarioController usuario = new UsuarioController();
        System.out.println(usuario.listarMecanicos());
        */
//        HVMotoController hvController = new HVMotoController();
//        MotoController moto = new MotoController();
//        System.out.println(moto.listarMotos());
//          OrdenController ordenC = new OrdenController();
//          System.out.println(ordenC.listarOrdenes());
        EstadoController estadoC = new EstadoController();
        System.out.println(estadoC.listarEstado());
    }
      
    
    
    
    public static void verHV(){
         System.out.println("----------------------------------------");
        DBConnection conn = new DBConnection();
        String sql = "SELECT * FROM orden_servicios_idestado";
        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                int idOrden = rs.getInt("Orden");
                String placaMoto = rs.getString("placa");
                String idCliente = rs.getString("cliente");
                String idMecanico = rs.getString("Mecánico");
                String motivo = rs.getString("motivo");
                String documentos = rs.getString("documentos");
                String anticipo = rs.getString("anticipo");
                double valorAnticipo = rs.getDouble("valorAnticipo");
                String autorizacionRuta = rs.getString("autorizacionRuta");
                Date date = rs.getDate("fecha");
                int idEstado = rs.getInt("idEstado");
                String descripcionDiagnostico = rs.getString("descripcionDiagnostico");
                String productoServicio = rs.getString("Productos para servicio");
                String servicios = rs.getString("servicios");
                String aprobadoCliente = rs.getString("Aprobado por cliente");
                
               
                System.out.println("Seteado hv");
                HVmoto orden = new HVmoto(idOrden, placaMoto, idCliente, idMecanico, motivo, documentos, anticipo, valorAnticipo, autorizacionRuta, date, idEstado, descripcionDiagnostico, productoServicio, servicios, aprobadoCliente);      
                
                System.out.println(orden);
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la conexión de ver orden" + ex.getMessage());
        }finally{
            conn.desconectar();
        }
    }
    
    /**
     * Prueba de objetos 
     */
    
    public static void pruebaBeans() {
        System.out.println("----------------------------------------");
        Persona duro = new Administrador("Activo", "12345", "Administrador", 1116547319, "Diego", "Gallo", "García", "diegofelipe.gallo@gmail.com", "3108796935");
        Persona durito = new Administrador("Activo", "6573432", "Administrador", 1116345346, "Dario", "Gasr", "Maloq", "diegofeli@gmail.com", "4326656935");
        Persona donMecanico = new Mecanico("Activo", "2345", "Mecánico", 1322344634, "Don", "Mecánico", null, "arreglar@gmail.com", "321234334");
        Persona clientecito = new Cliente("CC", 111324354, "Pata", "Brava", null, "noduranmotos@chaterrero.com", "55555555");
        
        
        System.out.println(duro);
        System.out.println(durito);
        System.out.println(donMecanico);
        System.out.println(clientecito);
        
    }
   
    public static void actualizarAdminstrador(int idUsuario, String estado) {
        System.out.println("----------------------------------------");
        DBConnection conn = new DBConnection();
        String sql ="UPDATE usuarios SET estado = '"+ estado + "' WHERE idUsuario = " + idUsuario;
        try {
            Statement st = conn.conectar().createStatement();
            
            st.execute(sql);
            System.out.println("Se realizó la actualización de manera adecuada");
        } catch (Exception ex) {
            System.out.println( ex.getMessage() + " actualizar");
        }finally{
            conn.desconectar();
        }
    }
    /**
     * Prueba para poder conectase, mediante metodo en sección de pruebas. 
     */
    
    /*
    public static void listarEstado(int idEstado){
        System.out.println("----------------------------------------");
        DBConnection conn = new DBConnection();
//        String sql ="SELECT * FROM estado WHERE idEstado=" + idEstado;
          String sql ="SELECT * FROM estado";
        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            System.out.println("Se realizó la consulta en ListarEstado");
            
            while(rs.next()){
                int id = rs.getInt("idEstado");
                String indicadores = rs.getString("Indicadores");
                String desIndicadores = rs.getString("desIndicadores");
                String aceite = rs.getString("Aceite");
                String nivelAceite = rs.getString("nivelAceite");
                String liquidoFrenos = rs.getString("liquidoFrenos");
                String liquidoEmbrague = rs.getString("liquidoEmbrague");
                String liquidoRefrigerante = rs.getString("liquidoRefrigerante");
                String lucesAptas = rs.getString("lucesAptas");
                String espejos = rs.getString("espejos");
                String claxon = rs.getString("claxon");
                String tanque = rs.getString("tanque");
                String llantaDelantera = rs.getString("llantaDelantera");
                String llantaTrasera = rs.getString("llantaTrasera");
                String motor = rs.getString("motor");
                String chasis = rs.getString("Chasis");
                String acelerador = rs.getString("Acelerador");
                String escape = rs.getString("Escape");
                String trasmision = rs.getString("Trasmision");
                String embrague = rs.getString("Embrague");
                String frenos = rs.getString("frenos");
                String cadena = rs.getString("Cadena");
                String apoyaPies = rs.getString("apoyaPies");
                String kilometraje = rs.getString("Kilometraje");
                String combustible = rs.getString("combustible");
                System.out.println("Se setearon datos estado");
                //objeto que guarda datos de cada estado
                Estado estado = new Estado(id, indicadores, desIndicadores, aceite, nivelAceite, liquidoFrenos, liquidoEmbrague, liquidoRefrigerante, lucesAptas, espejos, claxon, tanque, llantaDelantera, llantaTrasera, motor, chasis, acelerador, escape, trasmision, embrague, frenos, cadena, apoyaPies, kilometraje, combustible);
                //para imprimir
                System.out.println(estado);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "No se pudo listar el estado");
        } finally {
            conn.desconectar();
        }
    }*/
    
    
    public static void conectarse() {
       DBConnection conn = new DBConnection();
        conn.conectar();
    }
    
    
    public static void ordenes(){
        System.out.println("----------------------------------------");
        DBConnection conn = new DBConnection();
        String sql = "SELECT * FROM orden_servicios";
        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                int idOrden = rs.getInt("idOrden");
                Date date = rs.getDate("fecha");
                String idCliente = rs.getString("cliente");
                String idMecanico = rs.getString("mecanico");
                String placaMoto = rs.getString("moto");
                String motivo = rs.getString("motivo");
                String documentos = rs.getString("documentos");
                double valorAnticipo = rs.getDouble("valorAnticipo");
                String descripcionDiagnostico = rs.getString("descripcionDiagnostico");
                String idEstado = rs.getString("estado");
                String autorizacionRuta = rs.getString("autorizacionRuta");
                String anticipo = rs.getString("anticipo");
                
                
//                System.out.println("Seteado orden");
//                OrdenDeServicio orden = new OrdenDeServicio(idOrden, date, nombreCliente, nombreMecanico, placaMoto, motivo, descripcionDiagnostico, documentos, anticipo, valorAnticipo, autorizacionRuta, idEstado);
//                System.out.println(orden);                       
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la conexión de ver orden" + ex.getMessage());
        }finally{
            conn.desconectar();
        }
        
    }
}

