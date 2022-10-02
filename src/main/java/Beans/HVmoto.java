
package Beans;

import java.sql.Date;

/**
 *
 * @author BMO
 */
public class HVmoto {
    private int idOrden;
    private String placaMoto;
    private String nombreCliente;
    private String nombreMecanico;
    private String motivo;
    private String documentos;
    private String anticipo;
    private double valorAnticipo;
    private String autorizacionRuta;
    private Date date;
    private int idEstado;
    private String descripcionDiagnostico;
    private String productoServicio;
    private String servicios;
    private String aprobadoCliente;

    public HVmoto(int idOrden, String placaMoto, String nombreCliente, String nombreMecanico, String motivo, String documentos, String anticipo, double valorAnticipo, String autorizacionRuta, Date date, int idEstado, String descripcionDiagnostico, String productoServicio, String servicios, String aprobadoCliente) {
        this.idOrden = idOrden;
        this.placaMoto = placaMoto;
        this.nombreCliente = nombreCliente;
        this.nombreMecanico = nombreMecanico;
        this.motivo = motivo;
        this.documentos = documentos;
        this.anticipo = anticipo;
        this.valorAnticipo = valorAnticipo;
        this.autorizacionRuta = autorizacionRuta;
        this.date = date;
        this.idEstado = idEstado;
        this.descripcionDiagnostico = descripcionDiagnostico;
        this.productoServicio = productoServicio;
        this.servicios = servicios;
        this.aprobadoCliente = aprobadoCliente;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getPlacaMoto() {
        return placaMoto;
    }

    public void setPlacaMoto(String placaMoto) {
        this.placaMoto = placaMoto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreMecanico() {
        return nombreMecanico;
    }

    public void setNombreMecanico(String nombreMecanico) {
        this.nombreMecanico = nombreMecanico;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    public String getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(String anticipo) {
        this.anticipo = anticipo;
    }

    public double getValorAnticipo() {
        return valorAnticipo;
    }

    public void setValorAnticipo(double valorAnticipo) {
        this.valorAnticipo = valorAnticipo;
    }

    public String getAutorizacionRuta() {
        return autorizacionRuta;
    }

    public void setAutorizacionRuta(String autorizacionRuta) {
        this.autorizacionRuta = autorizacionRuta;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescripcionDiagnostico() {
        return descripcionDiagnostico;
    }

    public void setDescripcionDiagnostico(String descripcionDiagnostico) {
        this.descripcionDiagnostico = descripcionDiagnostico;
    }

    public String getProductoServicio() {
        return productoServicio;
    }

    public void setProductoServicio(String productoServicio) {
        this.productoServicio = productoServicio;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getAprobadoCliente() {
        return aprobadoCliente;
    }

    public void setAprobadoCliente(String aprobadoCliente) {
        this.aprobadoCliente = aprobadoCliente;
    }

    @Override
    public String toString() {
        return "HVmoto{" + 
                "idOrden=" + idOrden + 
                ", placaMoto=" + placaMoto + 
                ", nombreCliente=" + nombreCliente + 
                ", nombreMecanico=" + nombreMecanico + 
                ", motivo=" + motivo + 
                ", documentos=" + documentos + 
                ", anticipo=" + anticipo + 
                ", valorAnticipo=" + valorAnticipo + 
                ", autorizacionRuta=" + autorizacionRuta + 
                ", date=" + date + 
                ", idEstado=" + idEstado + 
                ", descripcionDiagnostico=" + descripcionDiagnostico + 
                ", productoServicio=" + productoServicio + 
                ", servicios=" + servicios + 
                ", aprobadoCliente=" + aprobadoCliente + 
                '}';
    }

    
}
