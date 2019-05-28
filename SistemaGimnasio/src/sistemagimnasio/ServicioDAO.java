/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagimnasio;
import engine.SQL;
import java.util.ArrayList;

/**
 *
 * @author Saarayim
 */
public class ServicioDAO implements IServicioDAO {
  
  public ServicioDAO(){
    
  }
  
  @Override
    public Servicio getServicio(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public boolean insertServicio(Servicio servicio) {
        if (SQL.executeUpdate(
            "INSERT INTO servicio VALUES (NULL, ?, ?, ?)",
            new ArrayList<Object>() {
                {
                    add(servicio.getNombre());
                    add(servicio.getCosto());
                    add(servicio.getInstructor());
                }
            }
        ) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
    }
  
}
