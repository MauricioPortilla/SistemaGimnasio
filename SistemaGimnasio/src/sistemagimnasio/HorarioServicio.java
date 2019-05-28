/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagimnasio;

import java.sql.Time;

/**
 *
 * @author Saarayim
 */
public class HorarioServicio {
  private int id;
  private int idServicio;
  private String dia;
  private String horaInicio;
  private String horaFin;
  
  public HorarioServicio(int id, int idServicio, String dia, String horaInicio, String horaFin){
    this.id=id;
    this.idServicio=idServicio;
    this.dia=dia;
    this.horaInicio=horaInicio;
    this.horaFin=horaFin;
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

  public String getHoraInicio() {
    return horaInicio;
  }

  public String getHoraFin() {
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

  public void setHoraInicio(String horaInicio) {
    this.horaInicio = horaInicio;
  }

  public void setHoraFin(String horaFin) {
    this.horaFin = horaFin;
  }
  
  
  
}
