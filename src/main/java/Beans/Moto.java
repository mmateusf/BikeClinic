
package Beans;

/**
 *
 * @author BMO
 */
public class Moto {
    private String placa;
    private String idMotor;
    private String idChasis;
    private String marca;
    private String modelo;
    private String annoRegistro;
    private String idCliente;

    public Moto(String placa, String idMotor, String idChasis, String marca, String modelo, String annoRegistro, String idCliente) {
        this.placa = placa;
        this.idMotor = idMotor;
        this.idChasis = idChasis;
        this.marca = marca;
        this.modelo = modelo;
        this.annoRegistro = annoRegistro;
        this.idCliente = idCliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getIdMotor() {
        return idMotor;
    }

    public void setIdMotor(String idMotor) {
        this.idMotor = idMotor;
    }

    public String getIdChasis() {
        return idChasis;
    }

    public void setIdChasis(String idChasis) {
        this.idChasis = idChasis;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnnoRegistro() {
        return annoRegistro;
    }

    public void setAnnoRegistro(String annoRegistro) {
        this.annoRegistro = annoRegistro;
    }

    public String getCliente() {
        return idCliente;
    }

    public void setCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    
    

    @Override
    public String toString() {
        return "Moto{" + 
                "placa=" + placa + 
                ", idMotor=" + idMotor + 
                ", idChasis=" + idChasis + 
                ", marca=" + marca + 
                ", modelo=" + modelo + 
                ", annoRegistro=" + annoRegistro + 
                ", idCliente=" + idCliente + '}';
    }
    
    
}
