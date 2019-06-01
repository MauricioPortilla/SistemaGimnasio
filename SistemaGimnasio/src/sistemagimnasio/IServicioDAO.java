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
 *
 * @author Saarayim
 */
public interface IServicioDAO {

    public ObservableList<Servicio> getServicios();

    public Servicio getServicio(int id);

    public boolean insertServicio(Servicio servicio);

}
