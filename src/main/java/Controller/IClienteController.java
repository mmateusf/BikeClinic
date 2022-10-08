
package Controller;

/**
 *
 * @author BMO
 */
public interface IClienteController {
    
    String registrarCliente(String tipoID, int id, String nombre, String primerApellido, String segundoApellido, String correo, String numeroContacto);
    
    String actualizarCliente(String tipoID, int id, String nombre, String primerApellido, String segundoApellido, String correo, String numeroContacto);
    
    String buscarCliente(int id);
}
