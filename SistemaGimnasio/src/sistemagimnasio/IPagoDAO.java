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
public interface IPagoDAO {

    public Pago getPago(int id);

    public Pago getUltimoPago(int idCliente);

    public boolean insertPago(Pago pago);
}
