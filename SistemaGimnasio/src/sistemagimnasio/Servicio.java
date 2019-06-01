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
 */
public class Servicio {

    private int id;
    private String nombre;
    private int costo;
    private String instructor;
    private ArrayList<HorarioServicio> horarios;

    public Servicio(
        int id, String nombre, int costo, String instructor, ArrayList<HorarioServicio> horarios
    ) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.instructor = instructor;
        this.horarios = horarios;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCosto() {
        return costo;
    }

    public String getInstructor() {
        return instructor;
    }

    public ArrayList<HorarioServicio> getHorariosServicios() {
        return horarios;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return nombre + " ($" + costo + ".00)";
    }

}
