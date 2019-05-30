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

import java.sql.Date;
import java.util.ArrayList;

import engine.SQL;
import engine.SQLRow;

/**
 * ClienteDAO es la clase que lleva a cabo el control de los clientes en la base
 * de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/19
 */
public class ClienteDAO implements IClienteDAO {
    /**
     * Crea una instancia ClienteDAO.
     */
    public ClienteDAO(){
    }

    @Override
    public Cliente getCliente(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cliente getCliente(String nombre, String paterno, String materno) {
        Cliente cliente = new Cliente();
        SQL.executeQuery(
            "SELECT * FROM cliente WHERE nombre = ? AND paterno = ? AND materno = ? LIMIT 1", 
            new ArrayList<Object>() {
                {
                    add(nombre);
                    add(paterno);
                    add(materno);
                }
            }, (result) -> {
                for (SQLRow row : result) {
                    cliente.setId((int) row.getColumnData("idCliente"));
                    cliente.setIdMembresia((int) row.getColumnData("idMembresia"));
                    cliente.setNombre(row.getColumnData("nombre").toString());
                    cliente.setPaterno(row.getColumnData("paterno").toString());
                    cliente.setMaterno(row.getColumnData("materno").toString());
                    cliente.setTelefono(row.getColumnData("telefono").toString());
                    cliente.setFechaNacimiento(
                        ((Date) row.getColumnData("fechaNacimiento")).toLocalDate()
                    );
                    cliente.setDomicilio(row.getColumnData("domicilio").toString());
                }
                return true;
            }, () -> {
                return false;
            }
        );
        return cliente;
    }

    @Override
    public boolean insertCliente(Cliente cliente) {
        if (SQL.executeUpdate(
            "INSERT INTO cliente VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)",
            new ArrayList<Object>() {
                {
                    add(cliente.getIdMembresia());
                    add(cliente.getNombre());
                    add(cliente.getPaterno());
                    add(cliente.getMaterno());
                    add(cliente.getTelefono());
                    add(cliente.getFechaNacimiento());
                    add(cliente.getDomicilio());
                }
            }
        ) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCliente(Cliente cliente) {
        if (SQL.executeUpdate(
            "UPDATE cliente SET nombre = ?, paterno = ?, materno = ?, telefono = ?, " + 
            "fechaNacimiento = ?, domicilio = ? WHERE idCliente = ?",
            new ArrayList<Object>() {
                {
                    add(cliente.getNombre());
                    add(cliente.getPaterno());
                    add(cliente.getMaterno());
                    add(cliente.getTelefono());
                    add(cliente.getFechaNacimiento());
                    add(cliente.getDomicilio());
                    add(cliente.getId());
                }
            }
        ) == 1) { // 1 indica que hay 1 fila afectada
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
