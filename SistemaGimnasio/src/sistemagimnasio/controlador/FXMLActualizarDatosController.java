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
import java.text.SimpleDateFormat;
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
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.converter.DateTimeStringConverter;
import javafx.util.converter.IntegerStringConverter;
import sistemagimnasio.Cliente;
import sistemagimnasio.ClienteDAO;
import sistemagimnasio.IClienteDAO;

/**
 * FXMLActualizarClienteController es la clase que lleva el control de la
 * interfaz FXMLActualizarCliente y se encarga de la actualización de los datos
 * de los clientes del gimnasio registrados en el sistema.
 * 
 * @author Mauricio Cruz Portilla
 * @author Maria Jose Hernandez Molinos
 * @version 1.0
 * @since 2019/05/20
 */
public class FXMLActualizarDatosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button actualizarButton;

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
    private TextField nombreTextField;

    @FXML
    private TextField telefonoTextField;

    private Cliente cliente;

    private IClienteDAO clienteDAO = new ClienteDAO();


    @FXML
    void initialize() {
        actualizarButton.setOnAction(actualizarButtonHandler());
        cancelarButton.setOnAction(cancelarButtonHandler());
        telefonoTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    telefonoTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    /**
     * Inicializa la ventana con un cliente en especifico.
     * 
     * @param cliente cliente a utilizar para iniciar la ventana
     */
    void initData(Cliente cliente) {
        this.cliente = cliente;
        nombreTextField.setText(cliente.getNombre());
        apellidoPaternoTextField.setText(cliente.getPaterno());
        apellidoMaternoTextField.setText(cliente.getMaterno());
        telefonoTextField.setText(cliente.getTelefono());
        fechaNacimientoTextField.setText(
            cliente.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/uuuu"))
        );
        domicilioTextField.setText(cliente.getDomicilio());
    }

    /**
     * Lleva a cabo la accion del boton de actualizar. Guarda en la base de datos los cambios.
     * 
     * @return el evento del boton
     */
    private EventHandler<ActionEvent> actualizarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (
                    nombreTextField.getText().isEmpty() ||
                    apellidoPaternoTextField.getText().isEmpty() ||
                    telefonoTextField.getText().isEmpty() ||
                    fechaNacimientoTextField.getText().isEmpty()
                ) {
                    new Alert(AlertType.WARNING, "Faltan campos por llenar").show();
                    return;
                }
                LocalDate fechaNacimientoNueva = LocalDate.now();
                try {
                    fechaNacimientoNueva = LocalDate.parse(
                        fechaNacimientoTextField.getText(), 
                        DateTimeFormatter.ofPattern("d/M/uuuu")
                    );
                } catch (DateTimeParseException e) {
                    new Alert(
                        AlertType.WARNING, "Debes ingresar una fecha de nacimiento válida"
                    ).show();
                    return;
                }
                cliente.setNombre(nombreTextField.getText());
                cliente.setPaterno(apellidoPaternoTextField.getText());
                cliente.setMaterno(apellidoMaternoTextField.getText());
                cliente.setTelefono(telefonoTextField.getText());
                cliente.setFechaNacimiento(fechaNacimientoNueva);
                cliente.setDomicilio(domicilioTextField.getText());
                if (clienteDAO.updateCliente(cliente)) {
                    new Alert(AlertType.INFORMATION, "Se ha actualizado correctamente").show();
                    cancelarButton.fire();
                    return;
                }
                new Alert(
                    AlertType.ERROR, "Ocurrió un error al momento de guardar los datos"
                ).show();
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
