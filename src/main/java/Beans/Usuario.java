
package Beans;

/**
 *
 * @author BMO
 */
public abstract class Usuario extends Persona{
    private String estado;
    private String password;
    private String rol;

    public Usuario(String estado, String password, String rol, int id, String nombre, String primerApellido, String segundoApellido, String correo, String numeroContacto) {
        super(id, nombre, primerApellido, segundoApellido, correo, numeroContacto);
        this.estado = estado;
        this.password = password;
        this.rol = rol;
    }

    public String isEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public abstract String toString();
    
    
}
