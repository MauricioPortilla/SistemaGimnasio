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

import java.time.LocalTime;

/**
 *HorarioServicio es la clase que lleva la información sobre los horarios de los servicios.
 * 
 * @author Maria Saarayim Gonzalez Hernandez
 * @author Mauricio Cruz Portilla
 * @author Maria Jose Hernandez Molinos
 */
public class HorarioServicio {

    private int id;
    private int idServicio;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    
    /**
     * 
     * @param id identificador del horario del servicio.
     * @param idServicio identificador del servicio.
     * @param dia dia en el que dará el servicio.
     * @param horaInicio hora de inicio del servicio.
     * @param horaFin hora de fin del servicio. 
     */

    public HorarioServicio(
        int id, int idServicio, String dia, LocalTime horaInicio, LocalTime horaFin
    ) {
        this.id = id;
        this.idServicio = idServicio;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    /**
     * Regresa el identificador del horario del servicio.
     * 
     * @return el identificador del horario del servicio.
     */

    public int getId() {
        return id;
    }
    
    /**
     * Regresa el identificador del servicio.
     * 
     * @return el identificador del servicio.
     */

    public int getIdServicio() {
        return idServicio;
    }
    
    /**
     * Regresa el día en que se dará el servicio.
     * 
     * @return día en que se dará el servicio.
     */

    public String getDia() {
        return dia;
    }
    
    /**
     * Regresa la hora de inicio del servicio.
     * 
     * @return hora de inicio del servicio.
     */

    public LocalTime getHoraInicio() {
        return horaInicio;
    }
    
    /**
     * Regresa la hora fin del servicio.
     * 
     * @return hora fin del servicio. 
     */

    public LocalTime getHoraFin() {
        return horaFin;
    }
    
    /**
     * Establece un nuevo identificador al horario del servicio.
     * 
     * @param id nuevo identificador.
     */

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Establece un nuevo identificador de servicio a horario servicio.
     * 
     * @param idServicio nuevo identificador.
     */

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
    
    /**
     * Establece un nuevo dia a horario servicio.
     * 
     * @param dia nuevo dia.
     */

    public void setDia(String dia) {
        this.dia = dia;
    }
    
    /**
     * Establece una nueva hora inicio a horario servicio.
     * 
     * @param horaInicio nueva hora inicio.
     */

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    /**
     *Establece una nueva hora fin a horario servicio. 
     *
     * @param horaFin nueva hora fin.
     */

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

}
