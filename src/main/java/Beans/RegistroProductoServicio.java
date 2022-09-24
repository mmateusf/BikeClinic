
package Beans;

/**
 *
 * @author BMO
 */
public class RegistroProductoServicio {
    private int idRegistro;
    private Producto producto;
    private Servicio servicio;
    private boolean aprobado;
    private String orden;

    public RegistroProductoServicio(int idRegistro, Producto producto, Servicio servicio, boolean aprobado, String orden) {
        this.idRegistro = idRegistro;
        this.producto = producto;
        this.servicio = servicio;
        this.aprobado = aprobado;
        this.orden = orden;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    @Override
    public String toString() {
        return "RegistroProductoServicio{" + 
                "idRegistro=" + idRegistro + 
                ", producto=" + producto + 
                ", servicio=" + servicio + 
                ", aprobado=" + aprobado + 
                ", orden=" + orden + 
                '}';
    }

    
    
    
}
