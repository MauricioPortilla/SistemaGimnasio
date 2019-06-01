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

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.stage.Window;

/**
 * Engine es la clase que almacena el empleado en sesion y la ventana de inicio
 * de sesion.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/19
 */
public class Engine {
    public static Empleado empleadoSesion;
    public static Window iniciarSesionWindow;

    public static ChangeListener<String> onlyNumbersRegexListener(TextField textField) {
        return new ChangeListener<String>() {
            @Override
            public void changed(
                ObservableValue<? extends String> observable, String oldValue, String newValue
            ) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        };
    }

    public static ChangeListener<String> onlyDateFormatRegexListener(TextField textField) {
        return new ChangeListener<String>() {
            @Override
            public void changed(
                ObservableValue<? extends String> observable, String oldValue, String newValue
            ) {
                if (!newValue.matches("(\\d*\\/\\d*)")) {
                    textField.setText(newValue.replaceAll("[^(\\d*\\/\\d*)]", ""));
                }
            }
        };
    }
}
