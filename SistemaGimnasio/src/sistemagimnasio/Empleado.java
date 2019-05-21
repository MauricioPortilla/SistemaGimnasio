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
 * Empleado es la clase que lleva la informacion de un empleado del gimnasio.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/19
 */
public class Empleado {
    private int id;
    private String nombre;
    private String paterno;
    private String materno = null;
    private String usuario;
    private String contrasenia;

    /**
     * Crea una instancia de Empleado vacia.
     */
    public Empleado(){
    }

    /**
     * Crea una instancia de Empleado sin recurrir a la base de datos.
     * 
     * @param id identificador del empleado
     * @param nombre nombre del empleado
     * @param paterno apellido paterno del empleado
     * @param materno apellido materno del empleado
     * @param usuario nombre de usuario del empleado
     * @param contrasenia contraseña del empleado
     */
    public Empleado(
        int id, String nombre, String paterno, String materno, String usuario, String contrasenia
    ) {
        this.id = id;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    /**
     * Verifica si el empleado tiene informacion cargada.
     * 
     * @return <code>true</code> si fue cargado; <code>false</code> si no
     */
    public boolean isLoaded() {
        return (id != 0);
    }

    /**
     * Establece un identificador
     * 
     * @param id nuevo identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece un nombre
     * 
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece un paterno
     * 
     * @param paterno nuevo paterno
     */
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    /**
     * Establece un materno
     * 
     * @param materno nuevo materno
     */
    public void setMaterno(String materno) {
        this.materno = materno;
    }

    /**
     * Establece un usuario
     * 
     * @param usuario nuevo usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Establece una contrasenia
     * 
     * @param contrasenia nueva contrasenia
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Regresa el identificador del empleado.
     * 
     * @return el identificador del empleado
     */
    public int getId() {
        return id;
    }

    /**
     * Regresa el nombre del empleado.
     * 
     * @return el nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Regresa el apellido paterno del empleado.
     * 
     * @return el apellido paterno del empleado
     */
    public String getPaterno() {
        return paterno;
    }

    /**
     * Regresa el apellido materno del empleado.
     * 
     * @return el apellido materno del empleado
     */
    public String getMaterno() {
        return materno;
    }

    /**
     * Regresa el usuario del empleado.
     * 
     * @return el usuario del empleado
     */
    public String getUsuario() {
        return usuario;
    }
}
