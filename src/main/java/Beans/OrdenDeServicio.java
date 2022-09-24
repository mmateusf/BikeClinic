
package Beans;

import java.sql.Date;

/**
 *
 * @author BMO
 */
public class OrdenDeServicio {
     private int idOrden;
    //formato: YYYY-MM-DD, new SimpleDateFormat("dd-MM-yyyy").format(objeto creado con Date))
    private Date date;
    private String idCliente;
    private String idMecanico;
    private String placaMoto;
    private String motivo;
    private String documentos;
    private String anticipo;
    private double valorAnticipo;
    private String idEstado;
    private String descripcionDiagnostico;
    private String autorizacionRuta;
    

    public OrdenDeServicio(int idOrden, Date date, String idCliente, String idMecanico, String placaMoto, String motivo, String documentos, String anticipo, double valorAnticipo, String idEstado, String descripcionDiagnostico, String autorizacionRuta) {
        this.idOrden = idOrden;
        this.date = date;
        this.idCliente = idCliente;
        this.idMecanico = idMecanico;
        this.placaMoto = placaMoto;
        this.motivo = motivo;
        this.documentos = documentos;
        this.anticipo = anticipo;
        this.valorAnticipo = valorAnticipo;
        this.idEstado = idEstado;
        this.descripcionDiagnostico = descripcionDiagnostico;
        this.autorizacionRuta = autorizacionRuta;
       
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getidCliente() {
        return idCliente;
    }

    public void setidCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getMecanico() {
        return idMecanico;
    }

    public void setMecanico(String idMecanico) {
        this.idMecanico = idMecanico;
    }

    public String getPlacaMoto() {
        return placaMoto;
    }

    public void setPlacaMoto(String placaMoto) {
        this.placaMoto = placaMoto;
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

    public String getAncipo() {
        return anticipo;
    }

    public void setAncipo(String ancipo) {
        this.anticipo = anticipo;
    }

    public double getValorAnticipo() {
        return valorAnticipo;
    }

    public void setValorAnticipo(double valorAnticipo) {
        this.valorAnticipo = valorAnticipo;
    }

    public String getEstado() {
        return idEstado;
    }

    public void setEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescripcionDiagnostico() {
        return descripcionDiagnostico;
    }

    public void setDescripcionDiagnostico(String descripcionDiagnostico) {
        this.descripcionDiagnostico = descripcionDiagnostico;
    }

    public String getAutorizacionRuta() {
        return autorizacionRuta;
    }

    public void setAutorizacionRuta(String autorizacionRuta) {
        this.autorizacionRuta = autorizacionRuta;
    }

    

    @Override
    public String toString() {
        return "OrdenDeServicio{" + 
                "idOrden=" + idOrden + 
                ", date=" + date + 
                ", cliente=" + idCliente + 
                ", mecanico=" + idMecanico + 
                ", moto=" + placaMoto + 
                ", motivo=" + motivo + 
                ", documentos=" + documentos + 
                ", anticipo=" + anticipo + 
                ", idEstado=" + idEstado + 
                ", descripcionDiagnostico=" + descripcionDiagnostico + 
                ", autorizacionRuta=" + autorizacionRuta + 
                '}';
    }
    
    
}

