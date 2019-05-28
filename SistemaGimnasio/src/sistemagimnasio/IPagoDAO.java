/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagimnasio;

/**
 *
 * @author Saarayim
 */
public interface IPagoDAO {
  public Pago getPago(int id);
  public boolean insertPago(Pago pago);
}
