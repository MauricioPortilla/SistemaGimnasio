/**
 * IEmpleadoDAO es la interfaz que lleva a cabo el control de los empleados en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/19
 */

package sistemagimnasio;

public interface IEmpleadoDAO {
    /**
     * Retorna un empleado de la base de datos.
     * 
     * @param usuario Nombre de usuario del empleado
     * @param contrasenia Contraseña del empleado
     * @return el empleado
     */
    public Empleado getEmpleado(String usuario, String contrasenia);

    /**
     * Inserta un empleado en la base de datos.
     * 
     * @param empleado empleado a insertar
     * @return <code>true</code> si fue insertado con exito; <code>false</code> si no
     */
    public boolean insertEmpleado(Empleado empleado);

    /**
     * Actualiza un empleado de la base de datos.
     * 
     * @param empleado empleado a actualizar
     * @return <code>true</code> si fue actualizado con exito; <code>false</code> si no
     */
    public boolean updateEmpleado(Empleado empleado);

    /**
     * Elimina un empleado de la base de datos.
     * 
     * @param empleado empleado a insertar
     * @return <code>true</code> si fue eliminado con exito; <code>false</code> si no
     */
    public boolean deleteEmpleado(Empleado empleado);
}
