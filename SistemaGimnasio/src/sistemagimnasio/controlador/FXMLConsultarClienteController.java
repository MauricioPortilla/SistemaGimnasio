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
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sistemagimnasio.Cliente;
import sistemagimnasio.ClienteDAO;
import sistemagimnasio.IClienteDAO;

/**
 * FXMLConsultarClienteController es la clase que lleva el control de la
 * interfaz FXMLConsultarCliente y se encarga de buscar un cliente por
 * nombre en la base de datos para posteriormente mostrar sus datos en
 * un FXMLConsultarClienteDatos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/29
 */
public class FXMLConsultarClienteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button consultarButton;

    @FXML
    private TextField nombreClienteTextField;

    private IClienteDAO clienteDAO = new ClienteDAO();

    private Cliente cliente = null;

    @FXML
    void initialize() {
        consultarButton.setOnAction(consultarButtonHandler());
    }

    private final int NAME_LENGTH_FOR_FULLNAME = 3; // Mauricio Cruz Portilla
    private final int NAME_LENGTH_FOR_PARTIAL_FULLNAME = 2; // Mauricio Cruz
    
    /**
     * Lleva a cabo la acción del botón de Consultar.
     * 
     * @return el evento del botón
     */
    private EventHandler<ActionEvent> consultarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (nombreClienteTextField.getText().isEmpty()) {
                    new Alert(AlertType.WARNING, "Debes ingresar un nombre").show();
                    return;
                }
                String[] nombreClienteSplit = nombreClienteTextField.getText().split(" ");
                if (nombreClienteSplit.length < NAME_LENGTH_FOR_PARTIAL_FULLNAME) {
                    new Alert(AlertType.WARNING, "Debes ingresar un nombre completo").show();
                    return;
                }
                if (nombreClienteSplit.length == NAME_LENGTH_FOR_PARTIAL_FULLNAME) {
                    cliente = clienteDAO.getCliente(
                        nombreClienteSplit[0], nombreClienteSplit[1], null
                    );
                } else if (nombreClienteSplit.length == NAME_LENGTH_FOR_FULLNAME) {
                    cliente = clienteDAO.getCliente(
                        nombreClienteSplit[0], nombreClienteSplit[1], nombreClienteSplit[2]
                    );
                } else if (nombreClienteSplit.length > NAME_LENGTH_FOR_FULLNAME) {
                    String nombre = "";
                    for (int i = 0; i < nombreClienteSplit.length - 2; i++) {
                        nombre += nombreClienteSplit[i];
                        if (i >= 0 && i < nombreClienteSplit.length - 3) {
                            nombre += " ";
                        }
                    }
                    cliente = clienteDAO.getCliente(
                        nombre, 
                        nombreClienteSplit[nombreClienteSplit.length - 2], 
                        nombreClienteSplit[nombreClienteSplit.length - 1]
                    );
                }
                if (cliente.getId() > 0) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                            "/sistemagimnasio/interfaz/FXMLConsultarClienteDatos.fxml"
                        ));
                        Stage stage = new Stage();
                        stage.setScene(new Scene((AnchorPane) loader.load()));
                        stage.setTitle("Consultar cliente - " + cliente.getFullName());
                        FXMLConsultarClienteDatosController controller = loader.
                            <FXMLConsultarClienteDatosController>getController();
                        controller.initData(cliente);
                        stage.show();
                    } catch (IOException e) {
                        new Alert(
                            AlertType.ERROR, "Ocurrió un error al abrir los datos de la consulta."
                        ).show();
                    }
                } else {
                    new Alert(
                        AlertType.ERROR, "No existe un cliente registrado con ese nombre"
                    ).show();
                }
            }
        };
    }

}
