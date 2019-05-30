/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagimnasio;

import engine.SQL;
import engine.SQLRow;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Saarayim
 */
public class PagoDAO implements IPagoDAO {

    public PagoDAO() {
    }

    @Override
    public Pago getPago(int id) {
        Pago pago = new Pago();
        SQL.executeQuery(
                "SELECT * FROM pago WHERE idPago = ? LIMIT 1",
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
                }
        );
        return pago;
    }

    @Override
    public Pago getUltimoPago(int idCliente) {
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
                }
        );
        return pago;
    }

    @Override
    public boolean insertPago(Pago pago) {
        if (SQL.executeUpdate(
                "INSERT INTO pago VALUES (NULL, ?, ?, ?, ?)",
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
