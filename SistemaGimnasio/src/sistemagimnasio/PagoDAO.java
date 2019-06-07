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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Maria Saarayim Gonzalez Hernandez
 * @author Mauricio Cruz Portilla
 */
public class PagoDAO implements IPagoDAO {

    /**
     * Crea una instancia de tipo PagoDAO.
     */
    public PagoDAO() {
    }

    @Override
    public Pago getPago(int id) {
        Pago pago = new Pago();
        try {
			SQL.executeQuery(
                "SELECT * FROM pago WHERE idPago = ?",
                new ArrayList<Object>() {
                    {
                        add(id);
                    }
			}, (result) -> {
                for (SQLRow row : result) {
                    pago.setId((int) row.getColumnData("idPago"));
                    pago.setMonto((int) row.getColumnData("monto"));
                    pago.setFecha(((Date) row.getColumnData("fecha")).toLocalDate());
                    pago.setIdCliente((int) row.getColumnData("idCliente"));
                    pago.setIdMembresia((int) row.getColumnData("idMembresia"));
                    pago.setFechaVencimiento(
                        ((Date) row.getColumnData("fechaVencimiento")).toLocalDate()
                    );
                }
                return true;
            }, () -> {
                return false;
            });
		} catch (Exception e) {
			new Alert(AlertType.ERROR, "Ocurrió un error al momento de obtener los datos").show();
		}
        return pago;
    }

    @Override
    public Pago getUltimoPago(int idCliente) {
        try {
            Pago pago = new Pago();
			SQL.executeQuery(
			    "SELECT * FROM pago WHERE idCliente = ? ORDER BY idPago DESC LIMIT 1",
			    new ArrayList<Object>() {
                    {
                        add(idCliente);
                    }
			}, (result) -> {
			    for (SQLRow row : result) {
			        pago.setId((int) row.getColumnData("idPago"));
			        pago.setMonto((int) row.getColumnData("monto"));
			        pago.setFecha(((Date) row.getColumnData("fecha")).toLocalDate());
			        pago.setIdCliente((int) row.getColumnData("idCliente"));
			        pago.setIdMembresia((int) row.getColumnData("idMembresia"));
			        pago.setFechaVencimiento(
                        ((Date) row.getColumnData("fechaVencimiento")).toLocalDate()
			        );
			    }
			    return true;
			}, () -> {
			    return false;
			});
            return pago;
		} catch (Exception e) {
            new Alert(AlertType.ERROR, "Ocurrió un error al momento de obtener los datos").show();
            return null;
		}
    }

    @Override
    public boolean insertPago(Pago pago) {
        if (SQL.executeUpdate(
            "INSERT INTO pago VALUES (NULL, ?, ?, ?, ?, ?)",
            new ArrayList<Object>() {
                {
                    add(pago.getIdCliente());
                    add(pago.getIdMembresia());
                    add(pago.getMonto());
                    add(pago.getFecha());
                    add(pago.getFechaVencimiento());
                }
            }
        ) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
    }

}
