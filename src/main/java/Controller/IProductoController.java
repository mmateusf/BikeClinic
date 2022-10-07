
package Controller;

/**
 *
 * @author BMO
 */
public interface IProductoController {
    
    public String registrarProducto(String nombre, double valorProducto);
    public String obtenerProductos();
    public String actualizarProducto();
    
}
