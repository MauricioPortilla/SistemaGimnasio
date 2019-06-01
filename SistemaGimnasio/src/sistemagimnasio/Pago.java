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

import java.time.LocalDate;

/**
 *
 * @author Maria Saarayim Gonzalez Hernandez
 * @author Mauricio Cruz Portilla
 */
public class Pago {

    private int id;
    private int monto;
    private LocalDate fecha;
    private int idCliente;
    private int idMembresia;
    private LocalDate fechaVencimiento;

    public Pago() {
    }

    public Pago(
        int id, int idCliente, int idMembresia, int monto, LocalDate fecha, 
        LocalDate fechaVencimiento
    ) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idMembresia = idMembresia;
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Verifica si el objeto tiene datos cargados.
     * 
     * @return <code>true</code> si el identificador es mayor a cero; de lo
     *         contrario, retornará <code>false</code>
     */
    public boolean isLoaded() {
        return (id > 0);
    }

    public int getId() {
        return id;
    }

    public int getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdMembresia() {
        return idMembresia;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}
