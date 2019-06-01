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
 *
 * @author Maria Saarayim Gonzalez Hernandez
 * @author Mauricio Cruz Portilla
 */
public class HorarioServicio {

    private int id;
    private int idServicio;
    private String dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public HorarioServicio(
        int id, int idServicio, String dia, LocalTime horaInicio, LocalTime horaFin
    ) {
        this.id = id;
        this.idServicio = idServicio;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getId() {
        return id;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public String getDia() {
        return dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

}
