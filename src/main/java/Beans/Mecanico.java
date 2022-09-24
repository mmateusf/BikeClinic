
package Beans;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author BMO
 */
public class Mecanico extends Usuario{
    
    ArrayList<Mecanico> listaMecanicos;
        
    
    public Mecanico(String estado, String password, String rol, int id, String nombre, String primerApellido, String segundoApellido, String correo, String numeroContacto) {
        super(estado, password, rol, id, nombre, primerApellido, segundoApellido, correo, numeroContacto);
    }
    
    //esto es pal controller.
//    public ArrayList agregarMecanico(){
//        listaMecanicos = new ArrayList<>();
//        listaMecanicos.add(this);
//        return listaMecanicos;
//    }
//    
//    public ArrayList listaMecanicos(ArrayList<Mecanico> listaMecanicos){
//        listaMecanicos = new ArrayList<>();
//        for (Mecanico mecanico : listaMecanicos) {
//            System.out.println(mecanico);
//        }
//        return listaMecanicos;
//    }
    

    @Override
    public String toString() {
        return "Mecánico{" + 
                ", estado=" + super.isEstado() + 
                ", password=" + super.getPassword() + 
                ", rol=" + super.getRol() + 
                ", nombre=" + super.getNombre() + 
                ", primerApellido=" + super.getPrimerApellido() + 
                ", segundoApellido=" + super.getSegundoApellido() + 
                ", correo=" + super.getCorreo() + 
                ", numeroContacto=" + super.getNumeroContacto()+ 
                '}';
    }

}
