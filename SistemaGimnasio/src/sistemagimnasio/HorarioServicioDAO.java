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
import engine.SQL;
import java.util.ArrayList;

/**
 *
 * @author Saarayim
 */
public class HorarioServicioDAO implements IHorarioServicioDAO {
  
  public HorarioServicioDAO(){
  }
  
  @Override
    public HorarioServicio getHorarioServicio(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public boolean insertHorarioServicio(HorarioServicio horarioServicio) {
        if (SQL.executeUpdate(
            "INSERT INTO horarioservicio VALUES (NULL, ?, ?, ?, ?)",
            new ArrayList<Object>() {
                {
                  add(horarioServicio.getIdServicio());
                  add(horarioServicio.getDia());
                  add(horarioServicio.getHoraInicio());
                  add(horarioServicio.getHoraFin());
                }
            }
        ) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
    }
  
}
