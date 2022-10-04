
package Beans;

/**
 *
 * @author BMO
 */
public class RegistroProductoServicio {
    private int idOrden;
    private int idRegistro;
    private String nombreProducto;
    private double valorProducto;
    private String nombreServicio;
    private String detalleServicio;
    private double valorServicio;
    private String aprobado;

    public RegistroProductoServicio(int idOrden, int idRegistro, String nombreProducto, double valorProducto, String nombreServicio, String detalleServicio, double valorServicio, String aprobado) {
        this.idOrden = idOrden;
        this.idRegistro = idRegistro;
        this.nombreProducto = nombreProducto;
        this.valorProducto = valorProducto;
        this.nombreServicio = nombreServicio;
        this.detalleServicio = detalleServicio;
        this.valorServicio = valorServicio;
        this.aprobado = aprobado;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(double valorProducto) {
        this.valorProducto = valorProducto;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDetalleServicio() {
        return detalleServicio;
    }

    public void setDetalleServicio(String detalleServicio) {
        this.detalleServicio = detalleServicio;
    }

    public double getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(double valorServicio) {
        this.valorServicio = valorServicio;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    @Override
    public String toString() {
        return "RegistroProductoServicio{" + 
                "idOrden=" + idOrden + 
                ", idRegistro=" + idRegistro + 
                ", nombreProducto=" + nombreProducto + 
                ", valorProducto=" + valorProducto + 
                ", nombreServicio=" + nombreServicio + 
                ", detalleServicio=" + detalleServicio + 
                ", valorServicio=" + valorServicio + 
                ", aprobado=" + aprobado + 
                '}';
    }
}
