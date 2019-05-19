package sistemagimnasio.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class RegistrarClienteController {

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
    private TextField membresiaTextField;

    @FXML
    private TextField nombreTextField;

    @FXML
    private Button registrarButton;

    @FXML
    private TextField telefonoTextField;


    @FXML
    void initialize() {
        assert apellidoMaternoTextField != null : "fx:id=\"apellidoMaternoTextField\" was not injected: check your FXML file 'registrarCliente.interfaz.fxml'.";
        assert apellidoPaternoTextField != null : "fx:id=\"apellidoPaternoTextField\" was not injected: check your FXML file 'registrarCliente.interfaz.fxml'.";
        assert cancelarButton != null : "fx:id=\"cancelarButton\" was not injected: check your FXML file 'registrarCliente.interfaz.fxml'.";
        assert domicilioTextField != null : "fx:id=\"domicilioTextField\" was not injected: check your FXML file 'registrarCliente.interfaz.fxml'.";
        assert fechaNacimientoTextField != null : "fx:id=\"fechaNacimientoTextField\" was not injected: check your FXML file 'registrarCliente.interfaz.fxml'.";
        assert membresiaTextField != null : "fx:id=\"membresiaTextField\" was not injected: check your FXML file 'registrarCliente.interfaz.fxml'.";
        assert nombreTextField != null : "fx:id=\"nombreTextField\" was not injected: check your FXML file 'registrarCliente.interfaz.fxml'.";
        assert registrarButton != null : "fx:id=\"registrarButton\" was not injected: check your FXML file 'registrarCliente.interfaz.fxml'.";
        assert telefonoTextField != null : "fx:id=\"telefonoTextField\" was not injected: check your FXML file 'registrarCliente.interfaz.fxml'.";


    }

}
