/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagimnasio.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import sistemagimnasio.Cliente;
import sistemagimnasio.ClienteDAO;
import sistemagimnasio.HorarioServicio;
import sistemagimnasio.IClienteDAO;
import sistemagimnasio.IServicioDAO;
import sistemagimnasio.Membresia;
import sistemagimnasio.Servicio;
import sistemagimnasio.ServicioDAO;

/**
 * FXML Controller class
 *
 * @author Saarayim
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
    private void accionCancelar(ActionEvent event) {
        ((Stage) cancelarButton.getScene().getWindow()).close();
    }

    private EventHandler<ActionEvent> registrarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (
                    textNombre.getText().isEmpty() ||
                    textCosto.getText().isEmpty() ||
                    textInstructor.getText().isEmpty()
                ) {
                    new Alert(AlertType.WARNING, "Campos incompletos.").show();
                    return;
                }
                if (
                    textLunes.getText().isEmpty() &&
                    textMartes.getText().isEmpty() &&
                    textMiercoles.getText().isEmpty() &&
                    textJueves.getText().isEmpty() &&
                    textViernes.getText().isEmpty() &&
                    textSabado.getText().isEmpty()
                ) {
                    new Alert(AlertType.WARNING, "Debes asignar al menos un horario.").show();
                    return;
                }
                ArrayList<HorarioServicio> horarios = new ArrayList<>();
                TextField[] horariosTextField = { 
                    textLunes, textMartes, textMiercoles, textJueves, textViernes, textSabado
                };
                String[] horariosDias = {
                    "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"
                };
                for (int i = 0; i < horariosTextField.length; i++) {
                    if (horariosTextField[i].getText().isEmpty()) {
                        continue;
                    }
                    String[] horas = horariosTextField[i].getText().split(" - ");
                    horarios.add(
                        new HorarioServicio(
                            0, 0, horariosDias[i], 
                            LocalTime.parse(horas[0]), LocalTime.parse(horas[1])
                        )
                    );
                }
                boolean didInsert = servicioDAO.insertServicio(
                    new Servicio(
                        0, textNombre.getText(), textCosto.getText(), 
                        textInstructor.getText(), horarios
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

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        aceptarButton.setOnAction(registrarButtonHandler());
    }

}
