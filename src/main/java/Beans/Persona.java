
package Beans;

/**
 *Clase abstracta para personas.
 * @author BMO
 */
public abstract class Persona {
    private int id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String correo;
    private String numeroContacto;

    public Persona(int id, String nombre, String primerApellido, String segundoApellido, String correo, String numeroContacto) {
        
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.numeroContacto = numeroContacto;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public String obtenerNombreCompleto(){
        return nombre + " " + primerApellido + " " + segundoApellido + ".";
    }
    
    
    //pa tenerlo como string
    @Override
    public abstract String toString();
    
       
    
}
