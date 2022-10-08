
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
    private String añoRegistro;
    private int idCliente;
    private String nombreCliente;

    public Moto(String placa, String idMotor, String idChasis, String marca, String modelo, String añoRegistro, int idCliente) {
        this.placa = placa;
        this.idMotor = idMotor;
        this.idChasis = idChasis;
        this.marca = marca;
        this.modelo = modelo;
        this.añoRegistro = añoRegistro;
        this.idCliente = idCliente;
    }
   
    public Moto(String placa, String idMotor, String idChasis, String marca, String modelo, String añoRegistro, int idCliente, String nombreCliente) {
        this.placa = placa;
        this.idMotor = idMotor;
        this.idChasis = idChasis;
        this.marca = marca;
        this.modelo = modelo;
        this.añoRegistro = añoRegistro;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        
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

    public String getañoRegistro() {
        return añoRegistro;
    }

    public void setañoRegistro(String añoRegistro) {
        this.añoRegistro = añoRegistro;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    
    @Override
    public String toString() {
        return "Moto{" + 
                "placa=" + placa + 
                ", idMotor=" + idMotor + 
                ", idChasis=" + idChasis + 
                ", marca=" + marca + 
                ", modelo=" + modelo + 
                ", añoRegistro=" + añoRegistro + 
                ", idCliente=" + idCliente + 
                ", nombreCliente=" + nombreCliente + 
                '}';
    }
}
