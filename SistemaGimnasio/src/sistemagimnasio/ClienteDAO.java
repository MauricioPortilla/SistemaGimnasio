/**
 * ClienteDAO es la clase que lleva a cabo el control de los clientes en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/19
 */

package sistemagimnasio;

import java.util.ArrayList;

import engine.SQL;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
