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

import java.util.ArrayList;

/**
 *
 * @author Maria Saarayim Gonzalez Hernandez
 * @author Mauricio Cruz Portilla
 * @author Maria Jose Hernandez Molinos
 */
public class Servicio {

    private int id;
    private String nombre;
    private int costo;
    private String instructor;
    private ArrayList<HorarioServicio> horarios;
    
    /**
     * 
     * @param id identificador del servicio
     * @param nombre nombre del servicio
     * @param costo costo del servicio
     * @param instructor nombre del instructor
     * @param horarios horarios en que se dará el servicio
     */

    public Servicio(
        int id, String nombre, int costo, String instructor, ArrayList<HorarioServicio> horarios
    ) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.instructor = instructor;
        this.horarios = horarios;
    }
    
    /**
     * Regresa el identificador del servicio
     * 
     * @return el identificador del servicio
     */

    public int getId() {
        return id;
    }
    
    /**
     * Regresa el nombre del servicio
     * 
     * @return el nombre del servicio
     */

    public String getNombre() {
        return nombre;
    }
    
    /**
     * Regresa el costo del servicio
     * 
     * @return el costo del servicio
     */

    public int getCosto() {
        return costo;
    }
    
    /**
     * Regresa el nombre del instructor
     * 
     * @return el nombre del instructor
     */

    public String getInstructor() {
        return instructor;
    }
    
    /**
     * Regresa los horarios del servicio
     * 
     * @return los horarios del servicio
     */

    public ArrayList<HorarioServicio> getHorariosServicios() {
        return horarios;
    }
    
    /**
     * Establece un nuevo identificador al servicio
     * 
     * @param id 
     */

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Establece un nuevo nombre al servicio
     * 
     * @param nombre nuevo nombre
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Establece un nuevo costo al servicio
     * 
     * @param costo nuevo costo
     */

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
    /**
     * Establece un nuevo instructor al servicio
     * 
     * @param instructor nuevo instructor
     */

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return nombre + " ($" + costo + ".00)";
    }

}
