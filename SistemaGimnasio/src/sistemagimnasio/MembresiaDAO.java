/**
 * MembresiaDAO es la clase que lleva a cabo el control de las membresias en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/19
 */

package sistemagimnasio;

import java.util.ArrayList;

import engine.SQL;
import engine.SQLRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class MembresiaDAO implements IMembresiaDAO {
    private final ObservableList<Membresia> membresias = FXCollections.observableArrayList();

    /**
     * Crea una instancia MembresiaDAO.
     */
    public MembresiaDAO() {
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
        return SQL.executeQuery("SELECT * FROM membresia;", null, (result) -> {
            for (SQLRow row : result) {
                membresias.add(new Membresia(
                    (int) row.getColumnData("idMembresia"),
                    row.getColumnData("nombre").toString(),
                    (int) row.getColumnData("costo")
                ));
            }
            return true;
        }, () -> {
            return false;
        });
    }

    @Override
    public boolean insertMembresia(Membresia membresia) {
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
