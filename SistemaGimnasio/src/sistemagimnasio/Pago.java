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
 *Pago es la clase que lleva la información del pago
 * 
 * @author Maria Saarayim Gonzalez Hernandez
 * @author Mauricio Cruz Portilla
 * @author Maria Jose Hernandez Molinos
 */
public class Pago {

    private int id;
    private int monto;
    private LocalDate fecha;
    private int idCliente;
    private int idMembresia;
    private LocalDate fechaVencimiento;
    
    /**
     * Crea una instancia Pago vacia.
     */

    public Pago() {
    }
    /**
     * Crea una instancia Pago sin recurrir a la base de datos
     * 
     * @param id identificador del pago
     * @param idCliente identificador del cliente
     * @param idMembresia identificador de la membresía
     * @param monto monto a pagar
     * @param fecha fecha en la que se realiza el pago
     * @param fechaVencimiento fecha en la que vence el pago
     */
    

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
    
    /**
     * Regresa el identificador de pago
     * 
     * @return el identificador de pago
     */

    public int getId() {
        return id;
    }
    
    /**
     * Regresa el monto a pagar
     * 
     * @return el monto a pagar
     */

    public int getMonto() {
        return monto;
    }
    
    /**
     * Retorna la fecha en la que se realiza el pago
     * 
     * @return la fecha en la que se realiza el pago
     */

    public LocalDate getFecha() {
        return fecha;
    }
    
    /**
     * Establece un nuevo identificador al pago
     * 
     * @param id nuevo identificador
     */

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Establece un nuevo monto al pago
     * 
     * @param monto nuevo monto
     */

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    /**
     * Establece una nueva fecha al pago
     * 
     * @param fecha nueva fecha
     */

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    /** 
     * Retorna el identificador de cliente 
     * 
     * @return el identificador del cliente 
     */

    public int getIdCliente() {
        return idCliente;
    }
    
    /**
     * Retorna el identificador de la membresia
     * 
     * @return el identificador de la membresía
     */

    public int getIdMembresia() {
        return idMembresia;
    }
    
    /**
     * Establece un nuevo identificador de cliente al pago
     * 
     * @param idCliente nuevo identificador de cliente
     */

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    /**
     * Establece un nuevo identicador de membresía al pago
     * 
     * @param idMembresia nuevo idenificador de membresía
     */

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }
    
    /**
     * Retorna la fecha en la que vence el pago
     * 
     * @return la fecha en la que vence el pago
     */

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
    
    /**
     * Establece una nueva fecha de vencimiento al pago
     * 
     * @param fechaVencimiento nueva fecha de vencimiento
     */

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}
