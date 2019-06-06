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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sistemagimnasio.Cliente;
import sistemagimnasio.Engine;
import sistemagimnasio.IPagoDAO;
import sistemagimnasio.Membresia;
import sistemagimnasio.Pago;
import sistemagimnasio.PagoDAO;

/**
 * FXMLRegistrarPagoController es la clase que se encarga del control de la interfaz
 * FXMLRegistrarPago. Registra un pago de un cliente en la base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @author Maria Saarayim Gonzalez Hernandez
 * @author Maria Jose Hernandez Molinos
 * @version 1.0
 * @since 2019/05/24
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
    private Cliente cliente;
    private Membresia membresia;

    @FXML
    void initialize() {
        aceptarButton.setOnAction(registrarPagoHandler());
        cancelarButton.setOnAction(cancelarButtonHandler());
        textFecha.textProperty().addListener(Engine.onlyDateFormatRegexListener(textFecha));
        textMensualidadPagar.textProperty().addListener(
            Engine.onlyNumbersRegexListener(textMensualidadPagar)
        );
        textMensualidadPagar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(
                ObservableValue<? extends String> observable, String oldValue, String newValue
            ) {
                if (newValue.isEmpty() || newValue.equals("0")) {
                    textPago.setText("0");
                    aceptarButton.setDisable(true);
                } else {
                    textPago.setText(
                        String.valueOf(membresia.getCosto() * Integer.parseInt(newValue))
                    );
                    aceptarButton.setDisable(false);
                }
            }
        });
        textPago.setDisable(true);
    }

    /**
     * Inicializa la ventana con un cliente especificado.
     * 
     * @param cliente cliente a utilizar
     */
    public void initData(Cliente cliente) {
        this.cliente = cliente;
        this.membresia = cliente.getMembresia();
        labelNombre.setText(cliente.getFullName());
        labelMembresia.setText(membresia.getNombre());
        textFecha.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/uuuu")));
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
                if (textFecha.getText().isEmpty() ||
                    textPago.getText().isEmpty() ||
                    textMensualidadPagar.getText().isEmpty()
                ) {
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
                    new Pago(
                        0, cliente.getId(), membresia.getId(), 
                        Integer.parseInt(textPago.getText()), fechaToInsert,
                        LocalDate.now().plusMonths(Integer.parseInt(textMensualidadPagar.getText()))
                    )
                );
                if (didInsert) {
                    new Alert(
                        Alert.AlertType.INFORMATION, "Pago registrado exitosamente"
                    ).showAndWait();
                    cancelarButton.fire();
                } else {
                    new Alert(
                        Alert.AlertType.ERROR, "Ocurrió un error al guardar los datos."
                    ).show();
                }
            }
        };
    }

    /**
     * Cierra la ventana actual.
     *
     * @return el evento del botón
     */
    private EventHandler<ActionEvent> cancelarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                showConsultarClienteDatos();
                ((Stage) cancelarButton.getScene().getWindow()).close();
            }
        };
    }

    /**
     * Muestra una ventana de FXMLConsultarClienteDatos inicializada con
     * los datos del cliente asociado a esta clase.
     */
    private void showConsultarClienteDatos() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/sistemagimnasio/interfaz/FXMLConsultarClienteDatos.fxml"
            ));
            Stage stage = new Stage();
            stage.setScene(new Scene((AnchorPane) loader.load()));
            stage.setTitle("Consultar cliente - Gimnasio");
            FXMLConsultarClienteDatosController controller = loader.
                <FXMLConsultarClienteDatosController>getController();
            controller.initData(cliente);
            stage.show();
        } catch (IOException e) {
            new Alert(
                AlertType.ERROR, "Ocurrió un error al abrir los datos de la consulta."
            ).show();
        }
    }

}
