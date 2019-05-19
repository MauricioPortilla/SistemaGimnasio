/**
 * FXMLRegistrarClienteController es la clase que lleva el control de la interfaz 
 * FXMLRegistrarCliente y se encarga del registro de clientes nuevos del gimnasio.
 * 
 * @author Mauricio Cruz Portilla
 * @author Maria Jose Hernandez Molinos
 * @version 1.0
 * @since 2019/05/19
 */

package sistemagimnasio.controlador;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

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
import sistemagimnasio.IClienteDAO;
import sistemagimnasio.IMembresiaDAO;
import sistemagimnasio.Membresia;
import sistemagimnasio.MembresiaDAO;


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
    private ComboBox membresiaComboBox;

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
                    new Alert(AlertType.WARNING, "Debes completar los campos faltantes.").show();
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
                        LocalDate.parse(
                            fechaNacimientoTextField.getText(), 
                            DateTimeFormatter.ofPattern("dd/MM/uuuu")
                        ), 
                        domicilioTextField.getText()
                    )
                );
                if (didInsert) {
                    new Alert(AlertType.INFORMATION, "Cliente registrado").show();
                    ((Stage) registrarButton.getScene().getWindow()).close();
                } else {
                    new Alert(AlertType.ERROR, "Ocurrió un error al registrar el cliente.").show();
                }
            }
        };
    }

}
