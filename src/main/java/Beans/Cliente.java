
package Beans;

/**
 *
 * @author BMO
 */
public  class Cliente extends Persona{
    private String tipoID;

    public Cliente(String tipoID, int id, String nombre, String primerApellido, String segundoApellido, String correo, String numeroContacto) {
        super(id, nombre, primerApellido, segundoApellido, correo, numeroContacto);
        this.tipoID = tipoID;
    }

    

    public String getTipoID() {
        return tipoID;
    }

    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }

    @Override
    public String toString() {
        return "Cliente{" + 
                "tipoID=" + tipoID + 
                ", idCliente=" + super.getId() + 
                ", nombre=" + super.getNombre() + 
                ", primerApellido=" + super.getPrimerApellido() + 
                ", segundoApellido=" + super.getSegundoApellido() + 
                ", correo=" + super.getCorreo() + ", numeroContacto=" + 
                super.getNumeroContacto() + '}';
    }
    
    
}
