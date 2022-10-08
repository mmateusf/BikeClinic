
package Controller;

/**
 *
 * @author BMO
 */
interface IEstadoController {
    
    public String listarEstado();
    
    public String registrarEstado(String indicadores, String desIndicadores, String aceite, String nivelAceite, String liquidoFrenos, String liquidoEmbrague, String liquidoRefrigerante, String lucesAptas, String espejos, String claxon, String tanque, String llantaDelantera, String llantaTrasera, String motor, String chasis, String acelerador, String escape, String trasmision, String embrague, String frenos, String cadena, String apoyaPies, String kilometraje, String combustible);
    
    public String buscarEstado(String kilometraje);
}
