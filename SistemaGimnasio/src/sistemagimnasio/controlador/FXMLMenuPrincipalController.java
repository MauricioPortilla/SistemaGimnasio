/**
 * FXMLMenuPrincipalController es la clase que lleva el control de la interfaz FXMLMenuPrincipal
 * y se encarga del menu principal del gimnasio.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/19
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLMenuPrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button modificarClienteButton;

    @FXML
    private Button registrarClienteButton;

    @FXML
    void initialize() {
        registrarClienteButton.setOnAction(registrarClienteButtonHandler());
    }

    /**
     * Lleva a cabo la accion del boton de registrar cliente. Abre la ventana de registro de
     * cliente.
     * 
     * @return el evento del boton
     */
    private EventHandler<ActionEvent> registrarClienteButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(
                        "/sistemagimnasio/interfaz/FXMLRegistrarCliente.fxml"
                    ));
                    Stage stage = new Stage();
                    stage.setScene(new Scene((AnchorPane) loader.load()));
                    stage.setTitle("Registrar cliente - Gimnasio");
                    stage.show();
                } catch (IOException e) {
                    new Alert(
                        AlertType.ERROR, "Ocurrió un error al abrir el formulario de registro."
                    ).show();
                    System.out.println(e.getMessage());
                    System.out.println(e.getCause());
                }
            }
        };
    }

}