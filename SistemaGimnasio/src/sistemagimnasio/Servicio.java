/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagimnasio;

import java.util.ArrayList;

/**
 *
 * @author Saarayim
 */
public class Servicio {

    private int id;
    private String nombre;
    private String costo;
    private String instructor;
    private ArrayList<HorarioServicio> horarios;

    public Servicio(
        int id, String nombre, String costo, String instructor, ArrayList<HorarioServicio> horarios
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

    public String getCosto() {
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

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

}
