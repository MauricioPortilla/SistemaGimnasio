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

import java.util.ArrayList;

import engine.SQL;
import engine.SQLRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * MembresiaDAO es la clase que lleva a cabo el control de las membresias en la
 * base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/19
 */
public class MembresiaDAO implements IMembresiaDAO {
    private final ObservableList<Membresia> membresias = FXCollections.observableArrayList();

    /**
     * Crea una instancia MembresiaDAO.
     */
    public MembresiaDAO() {
    }

    @Override
    public Membresia getMembresia(int id) {
        Membresia membresia = new Membresia();
        try {
			SQL.executeQuery(
			    "SELECT * FROM membresia WHERE idMembresia = ? LIMIT 1", 
			    new ArrayList<Object>() {
			        {
			            add(id);
			        }
			    }, (result) -> {
			        for (SQLRow row : result) {
			            membresia.setId((int) row.getColumnData("idMembresia"));
			            membresia.setNombre(row.getColumnData("nombre").toString());
			            membresia.setCosto((int) row.getColumnData("costo"));
			        }
			        return true;
			    }, () -> {
			        return false;
			    }
			);
		} catch (Exception e) {
            new Alert(AlertType.ERROR, "Ocurrió un error al momento de obtener los datos").show();
		}
        return membresia;
    }

    @Override
    public ObservableList<Membresia> getMembresias() {
        loadMembresias();
        return membresias;
    }

    /**
     * Carga las membresias desde la base de datos.
     * 
     * @return <code>true</code> si tuvo exito; <code>false</code> si no
     */
    private boolean loadMembresias() {
        try {
			return SQL.executeQuery("SELECT * FROM membresia;", null, (result) -> {
			    for (SQLRow row : result) {
			        membresias.add(new Membresia(
			            (int) row.getColumnData("idMembresia"),
			            row.getColumnData("nombre").toString(),
                        (int) row.getColumnData("costo"),
                        null
			        ));
			    }
			    return true;
			}, () -> {
			    return false;
			});
		} catch (Exception e) {
			new Alert(AlertType.ERROR, "Ocurrió un error al momento de obtener los datos").show();
            return false;
        }
    }

    @Override
    public boolean insertMembresia(Membresia membresia) {
        String sqlAfterFirst = "INSERT INTO servicioMembresia VALUES";
        ArrayList<Object> parametersAfterFirst = new ArrayList<>();
        for (Servicio servicio : membresia.getServicios()) {
            if (!membresia.getServicios().get(0).equals(servicio)) {
                sqlAfterFirst += ",";
            }
            sqlAfterFirst += "(?, ?)";
            parametersAfterFirst.add(servicio.getId());
            parametersAfterFirst.add("RETURNED_ID");
        }
        if (SQL.executeTransactionUpdate(
            "INSERT INTO membresia VALUES (NULL, ?, ?);",
            new ArrayList<Object>() {
                {
                    add(membresia.getNombre());
                    add(membresia.getCosto());
                }
            },
            sqlAfterFirst, parametersAfterFirst
        ) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
    }

    @Override
    public boolean updateMembresia(Membresia membresia) {
        return false;
    }

    @Override
    public boolean deleteMembresia(Membresia membresia){
        return false;
    }
}
