/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagimnasio;

import java.time.LocalTime;

/**
 *
 * @author Saarayim
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
