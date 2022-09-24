
package Beans;

/**
 *
 * @author BMO
 */
public class Servicio {
    private int idServicio;
    private String nombreServicio;
    private String detalleServicio;
    private double valorServicio;

    public Servicio(int idServicio, String nombreServicio, String detalleServicio, double valorServicio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.detalleServicio = detalleServicio;
        this.valorServicio = valorServicio;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
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

    @Override
    public String toString() {
        return "Servicio{" + "idServicio=" + idServicio + ", nombreServicio=" + nombreServicio + ", detalleServicio=" + detalleServicio + ", valorServicio=" + valorServicio + '}';
    }
    
    
}
