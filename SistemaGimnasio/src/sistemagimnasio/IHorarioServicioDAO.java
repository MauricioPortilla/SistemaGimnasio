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

/**
 *
 * @author Saarayim
 */
public interface IHorarioServicioDAO {

    public HorarioServicio getHorarioServicio(int id);

    public boolean insertHorarioServicio(HorarioServicio horarioServicio);
}
