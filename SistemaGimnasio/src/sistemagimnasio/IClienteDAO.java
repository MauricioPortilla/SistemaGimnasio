/**
 * IClienteDAO es la interfaz que lleva a cabo el control de los clientes en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/19
 */

package sistemagimnasio;

public interface IClienteDAO {
    
    /**
     * Retorna un cliente de la base de datos.
     * 
     * @param id identificador del cliente
     * @return el cliente
     */
    public Cliente getCliente(int id);

    /**
     * Inserta un cliente en la base de datos.
     * 
     * @param cliente cliente a insertar
     * @return <code>true</code> si fue insertado con exito; <code>false</code> si
     *         no
     */
    public boolean insertCliente(Cliente cliente);

    /**
     * Actualiza un cliente de la base de datos.
     * 
     * @param cliente cliente a actualizar
     * @return <code>true</code> si fue actualizado con exito; <code>false</code> si
     *         no
     */
    public boolean updateCliente(Cliente cliente);

    /**
     * Elimina un cliente de la base de datos.
     * 
     * @param cliente cliente a insertar
     * @return <code>true</code> si fue eliminado con exito; <code>false</code> si
     *         no
     */
    public boolean deleteCliente(Cliente cliente);
}
