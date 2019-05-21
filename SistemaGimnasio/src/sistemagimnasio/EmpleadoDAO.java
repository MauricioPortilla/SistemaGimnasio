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

import engine.SQL;
import java.util.ArrayList;

/**
 * EmpleadoDAO es la clase que lleva a cabo el control de los empleados en la
 * base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/19
 */
public class EmpleadoDAO implements IEmpleadoDAO {
    
    /**
     * Crea una instancia EmpleadoDAO.
     */
    public EmpleadoDAO(){
    }

    @Override
    public Empleado getEmpleado(String usuario, String contrasenia) {
        final Empleado empleado = new Empleado();
        SQL.executeQuery(
            "SELECT * FROM empleado WHERE usuario = ? AND contrasenia = ?", 
            new ArrayList<Object>(){
                {
                    add(usuario);
                    add(contrasenia);
                }
            }, (result) -> {
                empleado.setId((int) result.get(0).getColumnData("idEmpleado"));
                empleado.setNombre(result.get(0).getColumnData("nombre").toString());
                empleado.setPaterno(result.get(0).getColumnData("paterno").toString());
                empleado.setMaterno(result.get(0).getColumnData("materno").toString());
                empleado.setUsuario(result.get(0).getColumnData("usuario").toString());
                empleado.setContrasenia(result.get(0).getColumnData("contrasenia").toString());
                return true;
            }, () -> {
                return false;
            }
        );
        return empleado;
    }

    @Override
    public boolean insertEmpleado(Empleado empleado) {
        return false;
    }

    @Override
    public boolean updateEmpleado(Empleado empleado) {
        return false;
    }

    @Override
    public boolean deleteEmpleado(Empleado empleado) {
        return false;
    }
}
