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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import sistemagimnasio.Cliente;
import sistemagimnasio.ClienteDAO;
import sistemagimnasio.Engine;
import sistemagimnasio.IClienteDAO;
import sistemagimnasio.IMembresiaDAO;
import sistemagimnasio.Membresia;
import sistemagimnasio.MembresiaDAO;

/**
 * FXMLRegistrarClienteController es la clase que lleva el control de la
 * interfaz FXMLRegistrarCliente y se encarga del registro de clientes nuevos
 * del gimnasio.
 * 
 * @author Mauricio Cruz Portilla
 * @author Maria Jose Hernandez Molinos
 * @version 1.0
 * @since 2019/05/19
 */
public class FXMLRegistrarClienteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField apellidoMaternoTextField;

    @FXML
    private TextField apellidoPaternoTextField;

    @FXML
    private Button cancelarButton;

    @FXML
    private TextField domicilioTextField;

    @FXML
    private TextField fechaNacimientoTextField;

    @FXML
    private ComboBox<Membresia> membresiaComboBox;

    @FXML
    private TextField nombreTextField;

    @FXML
    private Button registrarButton;

    @FXML
    private TextField telefonoTextField;

    private IClienteDAO clienteDAO = new ClienteDAO();

    private IMembresiaDAO membresiaDAO = new MembresiaDAO();


    @FXML
    void initialize() {
        cargarMembresias();
        registrarButton.setOnAction(registrarButtonHandler());
        cancelarButton.setOnAction(cancelarButtonHandler());
        telefonoTextField.textProperty().addListener(
            Engine.onlyNumbersRegexListener(telefonoTextField)
        );
        fechaNacimientoTextField.textProperty().addListener(
            Engine.onlyDateFormatRegexListener(fechaNacimientoTextField)
        );
    }

    /**
     * Carga todas las membresias de la base de datos en membresiaComboBox.
     */
    private void cargarMembresias() {
        membresiaComboBox.setItems(membresiaDAO.getMembresias());
    }

    private EventHandler<ActionEvent> registrarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (
                    nombreTextField.getText().isEmpty() ||
                    apellidoPaternoTextField.getText().isEmpty() ||
                    fechaNacimientoTextField.getText().isEmpty() ||
                    telefonoTextField.getText().isEmpty() ||
                    membresiaComboBox.getSelectionModel().getSelectedItem() == null
                ) {
                    new Alert(AlertType.WARNING, "Faltan campos por llenar.").show();
                    return;
                }
                LocalDate fechaNacimientoToInsert = LocalDate.now();
                try {
                    fechaNacimientoToInsert = LocalDate.parse(
                        fechaNacimientoTextField.getText(), 
                        DateTimeFormatter.ofPattern("d/M/uuuu")
                    );
                } catch (DateTimeParseException e) {
                    new Alert(
                        AlertType.WARNING, "Debes ingresar una fecha de nacimiento válida"
                    ).show();
                    return;
                }
                boolean didInsert = clienteDAO.insertCliente(
                    new Cliente(
                        0, 
                        ((Membresia) membresiaComboBox.getSelectionModel().getSelectedItem())
                            .getId(), 
                        nombreTextField.getText(), 
                        apellidoPaternoTextField.getText(), 
                        apellidoMaternoTextField.getText(), 
                        telefonoTextField.getText(), 
                        fechaNacimientoToInsert, 
                        domicilioTextField.getText()
                    )
                );
                if (didInsert) {
                    new Alert(AlertType.INFORMATION, "Cliente registrado exitosamente").show();
                    ((Stage) registrarButton.getScene().getWindow()).close();
                } else {
                    new Alert(AlertType.ERROR, "Ocurrió un error al guardar los datos.").show();
                }
            }
        };
    }

    /**
     * Lleva a cabo la accion del boton de cancelar. Cierra la ventana actual.
     * 
     * @return el evento del boton
     */
    private EventHandler<ActionEvent> cancelarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((Stage) cancelarButton.getScene().getWindow()).close();
            }
        };
    }

}
