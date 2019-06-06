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
 * Cliente es la clase que lleva la informacion de un cliente del gimnasio.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/19
 */
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
     * Crea una instancia Cliente vacia.
     */
    public Cliente() {
    }

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
     * Retorna el ultimo pago realizado.
     * 
     * @return ultimo pago realizado
     */
    public Pago getUltimoPago() {
        IPagoDAO pagoDAO = new PagoDAO();
        return pagoDAO.getUltimoPago(this.id);
    }

    public Membresia getMembresia() {
        IMembresiaDAO membresiaDAO = new MembresiaDAO();
        return membresiaDAO.getMembresia(idmembresia);
    }

    /**
     * Establece un nuevo identificador al cliente
     * 
     * @param id nuevo identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece un nuevo identificador de membresia al cliente
     * 
     * @param idmembresia nuevo identificador de membresia
     */
    public void setIdMembresia(int idmembresia) {
        this.idmembresia = idmembresia;
    }

    /**
     * Establece un nuevo nombre al cliente
     * 
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece un nuevo paterno al cliente
     * 
     * @param paterno nuevo paterno
     */
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    /**
     * Establece un nuevo materno al cliente
     * 
     * @param materno nuevo materno
     */
    public void setMaterno(String materno) {
        this.materno = materno;
    }

    /**
     * Establece un nuevo telefono al cliente
     * 
     * @param telefono nuevo telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Establece una nueva fecha de nacimiento al cliente
     * 
     * @param fechaNacimiento nueva fecha de nacimiento
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Establece un nuevo domicilio al cliente
     * 
     * @param domicilio nuevo domicilio
     */
    public void setDomicilio(String domicilio) {
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
     * Regresa el apellido materno del cliente. Si es <code>null</code>, retornará <code>N/A</code>.
     * 
     * @return el apellido materno del cliente
     */
    public String getMaterno() {
        if (materno != null) {
            if (!materno.isEmpty()) {
                return materno;
            }
        }
        return "N/A";
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
     * 
     * @return el domicilio del cliente
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Regresa el nombre completo del cliente.
     * 
     * @return el nombre completo del cliente
     */
    public String getFullName() {
        return nombre + " " + paterno + ((materno != null) ? (" " + materno) : "");
    }
}
