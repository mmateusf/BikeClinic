
package Controller;

/**
 *
 * @author BMO
 */
public interface IServicioController {
    
    public String registrarServicio(String nombreServicio, String detalleServicio, double valorServicio);
    public String obtenerServicios();
    public String actualizarServicio(int idServicio, String nombreServicio, String detalleServicio, double valorServicio);
}
