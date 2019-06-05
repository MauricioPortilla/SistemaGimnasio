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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXMLMenuPrincipalController es la clase que lleva el control de la interfaz
 * FXMLMenuPrincipal y se encarga del menu principal del gimnasio.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/19
 */
public class FXMLMenuPrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button registrarClienteButton;
    
    @FXML private Button registrarPagoButton;
    @FXML private Button registrarServicioButton;
    @FXML private Button consultarClienteButton;
    @FXML private Button registrarMembresiaButton;

    @FXML
    void initialize() {
        registrarClienteButton.setOnAction(registrarClienteButtonHandler());
        registrarPagoButton.setOnAction(registrarPagoButtonHandler());
        registrarServicioButton.setOnAction(registrarServicioButtonHandler());
        consultarClienteButton.setOnAction(consultarClienteButtonHandler());
        registrarMembresiaButton.setOnAction(registrarMembresiaButtonHandler());
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

    /**
     * Lleva a cabo la accion del boton de registrar cliente. Abre la ventana de registro de
     * cliente.
     * 
     * @return el evento del boton
     */
    private EventHandler<ActionEvent> consultarClienteButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(
                        "/sistemagimnasio/interfaz/FXMLConsultarCliente.fxml"
                    ));
                    Stage stage = new Stage();
                    stage.setScene(new Scene((AnchorPane) loader.load()));
                    stage.setTitle("Consultar cliente");
                    stage.show();
                } catch (IOException e) {
                    new Alert(
                        AlertType.ERROR, "Ocurrió un error al abrir la ventana de consultas."
                    ).show();
                }
            }
        };
    }
    
    /**
     * Lleva a cabo la acción del botón Registrar Pago.
     * 
     * @return el evento del botón
     */
    private EventHandler<ActionEvent> registrarPagoButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(
                        "/sistemagimnasio/interfaz/FXMLRegistrarPago.fxml"
                    ));
                    Stage stage = new Stage();
                    stage.setScene(new Scene((AnchorPane) loader.load()));
                    stage.setTitle("Registrar cliente - Gimnasio");
                    stage.show();
                } catch (IOException e) {
                    new Alert(
                        AlertType.ERROR, "Ocurrió un error."
                    ).show();
                    System.out.println(e.getMessage());
                    System.out.println(e.getCause());
                }
            }
        };
    }
    
    /**
     * Lleva a cabo la acción del botón Registrar Servicio.
     * 
     * @return el evento del botón
     */
    private EventHandler<ActionEvent> registrarServicioButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(
                        "/sistemagimnasio/interfaz/FXMLRegistrarServicio.fxml"
                    ));
                    Stage stage = new Stage();
                    stage.setScene(new Scene((AnchorPane) loader.load()));
                    stage.setTitle("Registrar servicio - Gimnasio");
                    stage.show();
                } catch (IOException e) {
                    new Alert(
                        AlertType.ERROR, "Ocurrió un error."
                    ).show();
                    System.out.println(e.getMessage());
                    System.out.println(e.getCause());
                }
            }
        };
    }

    /**
     * Lleva a cabo la acción del botón Registrar Membresía.
     * 
     * @return el evento del botón
     */
    private EventHandler<ActionEvent> registrarMembresiaButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(
                        "/sistemagimnasio/interfaz/FXMLRegistrarMembresia.fxml"
                    ));
                    Stage stage = new Stage();
                    stage.setScene(new Scene((AnchorPane) loader.load()));
                    stage.setTitle("Registrar membresia - Gimnasio");
                    stage.show();
                } catch (IOException e) {
                    new Alert(
                        AlertType.ERROR, "Ocurrió un error al abrir el formulario de registro."
                    ).show();
                }
            }
        };
    }

}
