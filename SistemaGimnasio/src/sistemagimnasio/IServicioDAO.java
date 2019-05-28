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
public interface IServicioDAO {
  public Servicio getServicio (int id);
  public boolean insertServicio(Servicio servicio);
  
  
}
