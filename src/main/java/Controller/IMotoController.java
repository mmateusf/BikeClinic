
package Controller;

/**
 *
 * @author BMO
 */
public interface IMotoController {
    public String listarMotos();
    
    public String registrarMoto(String placa, String idMotor, String idChasis, String marca, String modelo, String anioRegistro, int idCliente);
    
    public String buscarMoto(String placaMoto);
}
