/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemagimnasio.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemagimnasio.Cliente;
import sistemagimnasio.ClienteDAO;
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

  @FXML private Button cancelarButton;
  @FXML private Button aceptarButton;
  @FXML private TextField textNombre;
  @FXML private TextField textCosto;
  @FXML private TextField textInstructor;
  @FXML private TextField textLunes;
  @FXML private TextField textMartes;
  @FXML private TextField textMiercoles;
  @FXML private TextField textJueves;
  @FXML private TextField textViernes;
  @FXML private TextField textSabado;
  @FXML private RadioButton radioLunes;
  @FXML private RadioButton radioMartes;
  @FXML private RadioButton radioMiercoles;
  @FXML private RadioButton radioJueves;
  @FXML private RadioButton radioViernes;
  @FXML private RadioButton radioSabado;
  private IServicioDAO servicioDAO = new ServicioDAO();
  
  @FXML
 private void accionCancelar(ActionEvent event) throws SQLException {
  ((Stage) cancelarButton.getScene().getWindow()).close(); 
 }
 
 private EventHandler<ActionEvent> registrarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (
                    textNombre.getText().isEmpty()||
                    textCosto.getText().isEmpty()||
                    textInstructor.getText().isEmpty()
                ) {
                    new Alert(Alert.AlertType.WARNING, "Campos incompletos.").show();
                    return;
                }
                boolean didInsert = servicioDAO.insertServicio(
                    new Servicio(
                        0, 
                        textNombre.getText(),
                        textCosto.getText(),
                        textInstructor.getText()
                    )
                );
                if (didInsert) {
                    new Alert(Alert.AlertType.INFORMATION, "Servicio registrado exitosamente").show();
                    ((Stage) aceptarButton.getScene().getWindow()).close();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Ocurrió un error al guardar los datos.").show();
                }
            }
        };
    }
 
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    aceptarButton.setOnAction(registrarButtonHandler());
  }  
  
}
