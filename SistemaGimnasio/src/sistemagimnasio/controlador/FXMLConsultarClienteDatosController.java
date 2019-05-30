package sistemagimnasio.controlador;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sistemagimnasio.Cliente;
import sistemagimnasio.IMembresiaDAO;
import sistemagimnasio.Membresia;
import sistemagimnasio.MembresiaDAO;

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
        /*fechaNacimientoLabel.setText(
            fechaNacimientoLabel.getText() + " " + 
            cliente.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/uuuu"))
        );*/
        membresiaLabel.setText(membresiaLabel.getText() + " " + membresiaCliente.getNombre());
        fechaVencimientoLabel.setText(cliente.getUltimoPago().getFechaVencimiento().format(
            DateTimeFormatter.ofPattern("dd/MM/uuuu")
        ));
    }

}
