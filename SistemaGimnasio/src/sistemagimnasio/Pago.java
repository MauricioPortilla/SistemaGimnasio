/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagimnasio;

import java.time.LocalDate;

/**
 *
 * @author Saarayim
 */
public class Pago {
  private int id;
  private String monto;
  private LocalDate fecha;
  private int idCliente;
  private int idMembresia;
  
  
  public Pago (int id, int idCliente, int idMembresia, String monto, LocalDate fecha){
    this.id=id;
    this.monto=monto;
    this.fecha=fecha;
    this.idCliente=idCliente;
    this.idMembresia=idMembresia;
  }

  public int getId() {
    return id;
  }

  public String getMonto() {
    return monto;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setMonto(String monto) {
    this.monto = monto;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public int getIdCliente() {
    return idCliente;
  }

  public int getIdMembresia() {
    return idMembresia;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public void setIdMembresia(int idMembresia) {
    this.idMembresia = idMembresia;
  }
  
  
}
