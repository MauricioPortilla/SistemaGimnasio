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
public class PagoDAO implements IPagoDAO{
  
  public PagoDAO(){
    
  }
  @Override
    public Pago getPago(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public boolean insertPago(Pago pago){
      if (SQL.executeUpdate(
            "INSERT INTO pago VALUES (NULL, ?, ?, ?, ?)",
            new ArrayList<Object>() {
                {
                    add(pago.getIdCliente());
                    add(pago.getIdMembresia());
                    add(pago.getMonto());
                    add(pago.getFecha());
                }
            }
        ) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
      
      
    }
  
}
