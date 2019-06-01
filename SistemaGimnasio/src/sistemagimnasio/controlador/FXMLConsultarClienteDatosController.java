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

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sistemagimnasio.Cliente;
import sistemagimnasio.IMembresiaDAO;
import sistemagimnasio.Membresia;
import sistemagimnasio.MembresiaDAO;
import sistemagimnasio.Pago;

public class FXMLConsultarClienteDatosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button actualizarButton;

    @FXML
    private Label fechaNacimientoLabel;

    @FXML
    private Label maternoLabel;

    @FXML
    private Label membresiaLabel;

    @FXML
    private Button modificarButton;

    @FXML
    private Label nombreLabel;

    @FXML
    private Label paternoLabel;

    @FXML
    private Label telefonoLabel;

    @FXML
    private Label fechaVencimientoLabel;

    private Cliente cliente;
    private Membresia membresiaCliente;

    private IMembresiaDAO membresiaDAO = new MembresiaDAO();

    @FXML
    void initialize() {
        modificarButton.setOnAction(modificarButtonHandler());
        actualizarButton.setDisable(true);
    }

    /**
     * Inicia la ventana con los datos de un cliente.
     * 
     * @param cliente cliente a utilizar
     */
    public void initData(Cliente cliente) {
        this.cliente = cliente;
        this.membresiaCliente = membresiaDAO.getMembresia(cliente.getIdMembresia());
        nombreLabel.setText(nombreLabel.getText() + " " + cliente.getNombre());
        paternoLabel.setText(paternoLabel.getText() + " " + cliente.getPaterno());
        maternoLabel.setText(maternoLabel.getText() + " " + cliente.getMaterno());
        telefonoLabel.setText(telefonoLabel.getText() + " " + cliente.getTelefono());
        fechaNacimientoLabel.setText(
            fechaNacimientoLabel.getText() + " " + 
            cliente.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/uuuu"))
        );
        membresiaLabel.setText(membresiaLabel.getText() + " " + membresiaCliente.getNombre());
        Pago ultimoPago = cliente.getUltimoPago();
        if (ultimoPago.isLoaded()) {
            fechaVencimientoLabel.setText(
                fechaVencimientoLabel.getText() + " " +
                ultimoPago.getFechaVencimiento().format(DateTimeFormatter.ofPattern("dd/MM/uuuu"))
            );
        } else {
            fechaVencimientoLabel.setText(fechaVencimientoLabel.getText() + " No hay registros");
        }
    }

    /**
     * Lleva a cabo la accion del boton de modificar cliente. Abre la ventana de modificar datos del
     * cliente.
     * 
     * @return el evento del boton
     */
    private EventHandler<ActionEvent> modificarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(
                        "/sistemagimnasio/interfaz/FXMLActualizarDatos.fxml"
                    ));
                    Stage stage = new Stage();
                    stage.setScene(new Scene((AnchorPane) loader.load()));
                    stage.setTitle("Modificar datos del cliente - Gimnasio");
                    FXMLActualizarDatosController controller = loader.
                        <FXMLActualizarDatosController>getController();
                    controller.initData(cliente);
                    stage.setOnHidden(reloadWindow());
                    stage.show();
                    ((Stage) modificarButton.getScene().getWindow()).close();
                } catch (IOException e) {
                    new Alert(
                        AlertType.ERROR, "Ocurrió un error al abrir el formulario de registro."
                    ).show();
                }
            }
        };
    }

    private EventHandler<WindowEvent> reloadWindow() {
        return new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {

            }
        };
    }

}
