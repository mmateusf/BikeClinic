
package Beans;

/**
 *
 * @author BMO
 */
public class Administrador extends Usuario{
    
    public Administrador(String estado, String password, String rol, int id, String nombre, String primerApellido, String segundoApellido, String correo, String numeroContacto) {
        super(estado, password, rol, id, nombre, primerApellido, segundoApellido, correo, numeroContacto);
    }

    @Override
    public String toString() {
        return "Administrador{" + 
                " estado=" + super.isEstado() + 
                ", password=" + super.getPassword() + 
                ", rol=" + super.getRol() + 
                ", nombre=" + super.getNombre() + 
                ", primerApellido=" + super.getPrimerApellido() + 
                ", segundoApellido=" + super.getSegundoApellido() + 
                ", correo=" + super.getCorreo() + 
                ", numeroContacto=" + super.getNumeroContacto()+ 
                '}' ;
    }
    
}
