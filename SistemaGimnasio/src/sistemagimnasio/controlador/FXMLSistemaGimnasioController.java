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
import java.util.ResourceBundle;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sistemagimnasio.Empleado;
import sistemagimnasio.EmpleadoDAO;
import sistemagimnasio.Engine;
import sistemagimnasio.IEmpleadoDAO;

/**
 * FXMLSistemaGimnasioController es la clase que lleva el control de la interfaz
 * FXMLSistemaGimnasio y se encarga del inicio de sesion de los empleados.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/05/18
 */
public class FXMLSistemaGimnasioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button iniciarSesionButton;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private TextField usernameTextField;

    private IEmpleadoDAO empleadoDAO = new EmpleadoDAO();

    @FXML
    void initialize() {
        iniciarSesionButton.setOnAction(iniciarSesionButtonHandler());
    }

    /**
     * Lleva a cabo la accion del boton de inicio de sesion, verificando con la base de datos
     * si existe el usuario y realizando el inicio de sesion.
     * 
     * @return el evento del boton
     */
    private EventHandler<ActionEvent> iniciarSesionButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()) {
                    new Alert(AlertType.WARNING, "Debes completar todos los campos.").show();
                    return;
                }
                Empleado empleado = empleadoDAO.getEmpleado(
                    usernameTextField.getText(), passwordTextField.getText()
                );
                if (empleado.isLoaded()) {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                            "/sistemagimnasio/interfaz/FXMLMenuPrincipal.fxml"
                        ));
                        Stage stage = new Stage();
                        stage.setScene(new Scene((AnchorPane) loader.load()));
                        stage.setTitle("Menú principal - Gimnasio");
                        stage.show();
                        Engine.iniciarSesionWindow = iniciarSesionButton.getScene().getWindow();
                        Engine.empleadoSesion = empleado;
                        iniciarSesionButton.getScene().getWindow().hide();
                    } catch (IOException e) {
                        new Alert(
                            AlertType.ERROR, "Ocurrió un error al abrir el menú principal."
                        ).show();
                        System.out.println(e.getMessage());
                    }
                } else {
                    new Alert(AlertType.ERROR, "Este empleado no existe.").show();
                }
            }
        };
    }

}
