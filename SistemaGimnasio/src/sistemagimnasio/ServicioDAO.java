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
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(servicio.getNombre());
        parameters.add(servicio.getCosto());
        parameters.add(servicio.getInstructor());
        ArrayList<Object> parameters2 = new ArrayList<>();
        String sqlSentence2 = "INSERT INTO horarioServicio VALUES ";
        for (HorarioServicio horario : servicio.getHorariosServicios()) {
            if (!servicio.getHorariosServicios().get(0).equals(horario)) {
                sqlSentence2 += ",";
            }
            sqlSentence2 += "(NULL, ?, ?, ?, ?)";
            parameters2.add("RETURNED_ID");
            parameters2.add(horario.getDia());
            System.out.println(horario.getDia());
            parameters2.add(horario.getHoraInicio());
            System.out.println(horario.getHoraInicio());
            parameters2.add(horario.getHoraFin());
            System.out.println(horario.getHoraFin());
        }
        if (SQL.executeTransactionUpdate(
            "INSERT INTO servicio VALUES (NULL, ?, ?, ?);", parameters, 
            sqlSentence2, parameters2
        ) == 1) {
            return true;
        }
        return false;
    }
  
}
