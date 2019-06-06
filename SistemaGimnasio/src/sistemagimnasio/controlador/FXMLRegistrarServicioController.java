/**
 * Sistema de Gimnasio
 * Elaborado por (en orden alfabetico):
 *  Cruz Portilla Mauricio
 *  Gonzalez Hernandez Maria Saarayim
 *  Hernandez Molinos Maria Jose
 *
 * Mayo, 2019
 */

package sistemagimnasio.controlador;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import sistemagimnasio.Engine;
import sistemagimnasio.HorarioServicio;
import sistemagimnasio.IServicioDAO;
import sistemagimnasio.Servicio;
import sistemagimnasio.ServicioDAO;

/**
 * FXMLRegistrarServicioController es la clase que lleva el control de la interfaz
 * FXMLRegistrarServicio y registra un nuevo servicio en la base de datos.
 * 
 * @author Maria Saarayim Gonzalez Hernandez
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/27
 */
public class FXMLRegistrarServicioController implements Initializable {

    @FXML
    private Button cancelarButton;
    @FXML
    private Button aceptarButton;
    @FXML
    private TextField textNombre;
    @FXML
    private TextField textCosto;
    @FXML
    private TextField textInstructor;
    @FXML
    private TextField textLunes;
    @FXML
    private TextField textMartes;
    @FXML
    private TextField textMiercoles;
    @FXML
    private TextField textJueves;
    @FXML
    private TextField textViernes;
    @FXML
    private TextField textSabado;
    @FXML
    private RadioButton radioLunes;
    @FXML
    private RadioButton radioMartes;
    @FXML
    private RadioButton radioMiercoles;
    @FXML
    private RadioButton radioJueves;
    @FXML
    private RadioButton radioViernes;
    @FXML
    private RadioButton radioSabado;
    private IServicioDAO servicioDAO = new ServicioDAO();

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        aceptarButton.setOnAction(registrarButtonHandler());
        cancelarButton.setOnAction(cancelarButtonHandler());
        textLunes.setDisable(true);
        textLunes.textProperty().addListener(Engine.onlyHourFormatRegexListener(textLunes, true));
        textMartes.setDisable(true);
        textMartes.textProperty().addListener(Engine.onlyHourFormatRegexListener(textMartes, true));
        textMiercoles.setDisable(true);
        textMiercoles.textProperty().addListener(
            Engine.onlyHourFormatRegexListener(textMiercoles, true)
        );
        textJueves.setDisable(true);
        textJueves.textProperty().addListener(Engine.onlyHourFormatRegexListener(textJueves, true));
        textViernes.setDisable(true);
        textViernes.textProperty().addListener(
            Engine.onlyHourFormatRegexListener(textViernes, true)
        );
        textSabado.setDisable(true);
        textSabado.textProperty().addListener(Engine.onlyHourFormatRegexListener(textSabado, true));
        radioLunes.selectedProperty().addListener(didSelectRadio(textLunes));
        radioMartes.selectedProperty().addListener(didSelectRadio(textMartes));
        radioMiercoles.selectedProperty().addListener(didSelectRadio(textMiercoles));
        radioJueves.selectedProperty().addListener(didSelectRadio(textJueves));
        radioViernes.selectedProperty().addListener(didSelectRadio(textViernes));
        radioSabado.selectedProperty().addListener(didSelectRadio(textSabado));
        textCosto.textProperty().addListener(Engine.onlyNumbersRegexListener(textCosto));
    }

    /**
     * Lleva a cabo el evento de pulsación del botón de Cancelar. Cierra la ventana.
     * 
     * @return el evento del botón
     */
    private EventHandler<ActionEvent> cancelarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((Stage) cancelarButton.getScene().getWindow()).close();
            }
        };
    }

    /**
     * Listener que permite habilitar o deshabilitar un TextField al seleccionar o deseleccionar
     * un RadioButton asociado con este Listener.
     * 
     * @param textFieldToEnable TextField a interactuar
     * @return Listener restrictivo
     */
    private ChangeListener<Boolean> didSelectRadio(TextField textFieldToEnable) {
        return new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                if (isNowSelected) {
                    textFieldToEnable.setDisable(false);
                } else {
                    textFieldToEnable.setDisable(true);
                }
            }
        };
    }

    /**
     * Lleva a cabo el evento de pulsación del botón de Registrar. Registra el servicio en la
     * base de datos.
     * 
     * @return el evento del botón
     */
    private EventHandler<ActionEvent> registrarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textNombre.getText().isEmpty() ||
                    textCosto.getText().isEmpty() ||
                    textInstructor.getText().isEmpty()
                ) {
                    new Alert(AlertType.WARNING, "Campos incompletos.").show();
                    return;
                }
                if (textLunes.getText().isEmpty() &&
                    textMartes.getText().isEmpty() &&
                    textMiercoles.getText().isEmpty() &&
                    textJueves.getText().isEmpty() &&
                    textViernes.getText().isEmpty() &&
                    textSabado.getText().isEmpty()
                ) {
                    new Alert(AlertType.WARNING, "Debes asignar al menos un horario.").show();
                    return;
                }
                TextField[] horariosTextField = { 
                    textLunes, textMartes, textMiercoles, textJueves, textViernes, textSabado
                };
                for (TextField textFieldDay : horariosTextField) {
                    if (textFieldDay.getText().isEmpty()) {
                        continue;
                    }
                    if (!textFieldDay.getText().matches(Engine.REGEX_HOUR_FORMAT_PERIOD)) {
                        new Alert(
                            AlertType.WARNING, 
                            "Debes ingresar un horario en el formato 00:00 - 00:00"
                        ).show();
                        return;
                    }
                }
                String[] horariosDias = {
                    "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"
                };
                ArrayList<HorarioServicio> horarios = new ArrayList<>();
                for (int i = 0; i < horariosTextField.length; i++) {
                    if (horariosTextField[i].getText().isEmpty()) {
                        continue;
                    }
                    // Separar las horas y almacenarlas en un arreglo
                    String[] horas = horariosTextField[i].getText().split(" - ");
                    try {
                        horarios.add(
                            new HorarioServicio(
                                0, 0, horariosDias[i], 
                                LocalTime.parse(horas[0]), LocalTime.parse(horas[1])
                            )
                        );
                    } catch (DateTimeParseException ex) {
                        new Alert(
                            AlertType.WARNING, 
                            "Debes ingresar un horario en el formato 00:00 - 00:00"
                        ).show();
                        return;
                    }
                }
                boolean didInsert = servicioDAO.insertServicio(
                    new Servicio(
                        0, 
                        textNombre.getText(), 
                        Integer.parseInt(textCosto.getText()), 
                        textInstructor.getText(), 
                        horarios
                    )
                );
                if (didInsert) {
                    new Alert(AlertType.INFORMATION, "Servicio registrado exitosamente").show();
                    ((Stage) aceptarButton.getScene().getWindow()).close();
                } else {
                    new Alert(AlertType.ERROR, "Ocurrió un error al guardar los datos").show();
                }
            }
        };
    }

}
