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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistemagimnasio.Cliente;
import sistemagimnasio.Engine;
import sistemagimnasio.IPagoDAO;
import sistemagimnasio.Pago;
import sistemagimnasio.PagoDAO;

/**
 * FXMLRegistrarPagoController es la clase que se encarga del control de la interfaz
 * FXMLRegistrarPago. Registra un pago de un cliente en la base de datos.
 */
public class FXMLRegistrarPagoController {

    @FXML
    private Button aceptarButton;
    @FXML
    private Button cancelarButton;
    @FXML
    private Label labelNombre;
    @FXML
    private Label labelMembresia;
    @FXML
    private TextField textPago;
    @FXML
    private TextField textFecha;
    @FXML
    private TextField textMensualidadPagar;
    private IPagoDAO pagoDAO = new PagoDAO();

    @FXML
    void initialize() {
        aceptarButton.setOnAction(registrarPagoHandler());
    }

    /**
     * Inicializa la ventana con un cliente especificado.
     * 
     * @param cliente cliente a utilizar
     */
    public void initData(Cliente cliente) {
        labelNombre.setText("Saarayim González Hernández");
        labelMembresia.setText("Especial");
        textFecha.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/uuuu")));
        textFecha.textProperty().addListener(Engine.onlyDateFormatRegexListener(textFecha));
    }
    
    /**
     * Lleva a cabo el evento del botón de Registrar.
     * 
     * @return el evento del botón
     */
    private EventHandler<ActionEvent> registrarPagoHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFecha.getText().isEmpty()
                    || textPago.getText().isEmpty()
                    || textMensualidadPagar.getText().isEmpty()) {
                    new Alert(Alert.AlertType.WARNING, "Faltan campos por llenar.").show();
                    return;
                }
                LocalDate fechaToInsert = LocalDate.now();
                try {
                    fechaToInsert = LocalDate.parse(
                        textFecha.getText(),
                        DateTimeFormatter.ofPattern("d/M/uuuu")
                    );
                } catch (DateTimeParseException e) {
                    new Alert(
                        Alert.AlertType.WARNING, "Debes ingresar una fecha de nacimiento válida"
                    ).show();
                    return;
                }
                boolean didInsert = pagoDAO.insertPago(
                    // Modificar idCliente e idMembresia
                    new Pago(
                        0, 1, 1, Integer.parseInt(textPago.getText()), fechaToInsert,
                        LocalDate.now().plusMonths(Integer.parseInt(textMensualidadPagar.getText()))
                    )
                );
                if (didInsert) {
                    new Alert(Alert.AlertType.INFORMATION, "Pago registrado exitosamente").show();
                    ((Stage) aceptarButton.getScene().getWindow()).close();
                } else {
                    new Alert(
                        Alert.AlertType.ERROR, "Ocurrió un error al guardar los datos."
                    ).show();
                }
            }
        };
    }

    /**
     * Cierra la ventana
     *
     * @param event
     */
    private void accionCancelar(ActionEvent event) {
        ((Stage) cancelarButton.getScene().getWindow()).close();
    }

}
