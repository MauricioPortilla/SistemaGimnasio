/**
 * Cliente es la clase que lleva la informacion de un cliente del gimnasio.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/19
 */
package sistemagimnasio;

import java.time.LocalDate;

public class Cliente {
    private int id;
    private int idmembresia;
    private String nombre;
    private String paterno;
    private String materno = null;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String domicilio = null;

    /**
     * Crea una instancia Cliente sin recurrir a la base de datos.
     * 
     * @param id identificador del cliente
     * @param idmembresia identificador de su membresia
     * @param nombre nombre del cliente
     * @param paterno apellido paterno del cliente
     * @param materno apellido materno del cliente
     * @param telefono telefono del cliente
     * @param fechaNacimiento fecha de nacimiento del cliente
     * @param domicilio domicilio del cliente
     */
    public Cliente(
        int id, int idmembresia, String nombre, String paterno, String materno, String telefono, 
        LocalDate fechaNacimiento, String domicilio
    ) {
        this.id = id;
        this.idmembresia = idmembresia;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
    }

    /**
     * Regresa el identificador del cliente.
     * 
     * @return el identificador del cliente
     */
    public int getId() {
        return id;
    }

    /**
     * Regresa el identificador de la membresia del cliente.
     * 
     * @return el identificador de la membresia del cliente
     */
    public int getIdMembresia() {
        return idmembresia;
    }

    /**
     * Regresa el nombre del cliente.
     * 
     * @return el nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Regresa el apellido paterno del cliente.
     * 
     * @return el apellido paterno del cliente
     */
    public String getPaterno() {
        return paterno;
    }

    /**
     * Regresa el apellido materno del cliente.
     * 
     * @return el apellido materno del cliente
     */
    public String getMaterno() {
        return materno;
    }

    /**
     * Regresa el telefono del cliente.
     * 
     * @return el telefono del cliente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Regresa la fecha de nacimiento del cliente.
     * @return la fecha de nacimiento del cliente
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Regresa el domicilio del cliente.
     * @return el domicilio del cliente
     */
    public String getDomicilio() {
        return domicilio;
    }
}
