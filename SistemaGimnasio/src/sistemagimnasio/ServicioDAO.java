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
import engine.SQLRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;

/**
 *
 * @author Maria Saarayim Gonzalez Hernandez
 * @author Mauricio Cruz Portilla
 */
public class ServicioDAO implements IServicioDAO {

    public ServicioDAO() {
    }

    @Override
    public ObservableList<Servicio> getServicios() {
        return loadServicios();
    }

    private ObservableList<Servicio> loadServicios() {
        ObservableList<Servicio> servicios = FXCollections.observableArrayList();
        try {
            SQL.executeQuery("SELECT * FROM servicio;", null, (result) -> {
                for (SQLRow row : result) {
                    servicios.add(new Servicio(
                        (int) row.getColumnData("idServicio"),
                        row.getColumnData("nombre").toString(),
                        (int) row.getColumnData("costo"),
                        row.getColumnData("instructor").toString(),
                        null
                    ));
                }
                return true;
            }, () -> {
                return false;
            });
        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Ocurrió un error al cargar los servicios").show();
        }
        return servicios;
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
            parameters2.add(horario.getHoraInicio());
            parameters2.add(horario.getHoraFin());
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
