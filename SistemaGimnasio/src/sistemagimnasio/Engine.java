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

    public static String REGEX_HOUR_FORMAT_PERIOD = "(\\d*:\\d* \\- \\d*:\\d*)";
    public static String REGEX_HOUR_FORMAT = "(\\d*:\\d*)";
    public static String REGEX_DATE_FORMAT = "(\\d*\\/\\d*)";
    public static String REGEX_NUMBERS_FORMAT = "\\d*";

    /**
     * Retorna un Listener para TextField que restringe su valor a solo números.
     * 
     * @param textField TextField que poseerá este listener
     * @return listener de restricción
     */
    public static ChangeListener<String> onlyNumbersRegexListener(TextField textField) {
        return new ChangeListener<String>() {
            @Override
            public void changed(
                ObservableValue<? extends String> observable, String oldValue, String newValue
            ) {
                if (!newValue.matches(REGEX_NUMBERS_FORMAT)) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        };
    }

    /**
     * Retorna un Listener para TextField que restringe su valor a solo un formato de fecha.
     * 
     * @param textField TextField que poseerá este listener
     * @return listener de restricción
     */
    public static ChangeListener<String> onlyDateFormatRegexListener(TextField textField) {
        return new ChangeListener<String>() {
            @Override
            public void changed(
                ObservableValue<? extends String> observable, String oldValue, String newValue
            ) {
                if (!newValue.matches(REGEX_DATE_FORMAT)) {
                    textField.setText(newValue.replaceAll("[^(\\d\\/)]", ""));
                }
            }
        };
    }

    /**
     * Retorna un Listener para TextField que restringe su valor a solo un formato de hora.
     * 
     * @param textField TextField que poseerá este listener
     * @param extendedToPeriod Indica si se acepta el siguiente formato <code>00:00 - 01:00</code>
     * @return listener de restricción
     */
    public static ChangeListener<String> onlyHourFormatRegexListener(
        TextField textField, boolean extendedToPeriod
    ) {
        return new ChangeListener<String>() {
            @Override
            public void changed(
                ObservableValue<? extends String> observable, String oldValue, String newValue
            ) {
                if (extendedToPeriod) {
                    if (!newValue.matches(REGEX_HOUR_FORMAT_PERIOD)) {
                        textField.setText(newValue.replaceAll("[^(\\d:\\d \\-)]", ""));
                    }
                } else {
                    if (!newValue.matches(REGEX_HOUR_FORMAT)) {
                        textField.setText(newValue.replaceAll("[^(\\d:)]", ""));
                    }
                }
            }
        };
    }
}
