/**
 * Sistema de Gimnasio
 * Elaborado por (en orden alfabetico):
 *  Cruz Portilla Mauricio
 *  Gonzalez Hernandez Maria Saarayim
 *  Hernandez Molinos Maria Jose
 * 
 * Mayo, 2019
 */

package sistemagimnasio;

/**
 * Membresia es la clase que lleva la informacion de una membresia de la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/19
 */
public class Membresia {
    private int id;
    private String nombre;
    private int costo;

    /**
     * Crea una instancia de Membresia vacia.
     */
    public Membresia() {
    }

    /**
     * Crea una instacia de Membresia sin acudir a la base de datos.
     * 
     * @param id identificador de la membresia
     * @param nombre nombre de la membresia
     * @param costo costo de la membresia
     */
    public Membresia(int id, String nombre, int costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
    }

    /**
     * Establece un nuevo identificador a la membresia.
     * 
     * @param id nuevo identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece un nuevo nombre a la membresia.
     * 
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece un nuevo costo a la membresia.
     * 
     * @param costo nuevo costo
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * Retorna el identificador de la membresia.
     * 
     * @return el identificador de la membresia
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna el nombre de la membresia.
     * 
     * @return el nombre de la membresia
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el costo de la membresia.
     * 
     * @return el costo de la membresia
     */
    public int getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
