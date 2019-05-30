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

import javafx.collections.ObservableList;

/**
 * IMembresiaDAO es la interfaz que lleva a cabo el control de las membresias en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/19
 */
public interface IMembresiaDAO {

    /**
     * Retorna una membresia de la base de datos con base en su identificador.
     * 
     * @param id identificador de la membresia
     * @return la membresia
     */
    public Membresia getMembresia(int id);

    /**
     * Retorna una lista observable de las membresias de la base de datos.
     * 
     * @return lista observable de membresias
     */
    public ObservableList<Membresia> getMembresias();

    /**
     * Inserta una membresia en la base de datos.
     * 
     * @param membresia membresia a insertar
     * @return <code>true</code> si fue insertado con exito; <code>false</code> si no
     */
    public boolean insertMembresia(Membresia membresia);

    /**
     * Actualiza una membresia de la base de datos.
     * 
     * @param membresia membresia a actualizar
     * @return <code>true</code> si fue actualizado con exito; <code>false</code> si no
     */
    public boolean updateMembresia(Membresia membresia);

    /**
     * Elimina una membresia de la base de datos.
     * 
     * @param membresia membresia a eliminar
     * @return <code>true</code> si fue eliminado con exito; <code>false</code> si no
     */
    public boolean deleteMembresia(Membresia membresia);
}
