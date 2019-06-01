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
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import sistemagimnasio.Engine;
import sistemagimnasio.IMembresiaDAO;
import sistemagimnasio.IServicioDAO;
import sistemagimnasio.Membresia;
import sistemagimnasio.MembresiaDAO;
import sistemagimnasio.Servicio;
import sistemagimnasio.ServicioDAO;

public class FXMLRegistrarMembresiaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelarButton;

    @FXML
    private TextField costoTextField;

    @FXML
    private TextField nombreTextField;

    @FXML
    private Button quitarButton;

    @FXML
    private Button registrarButton;

    @FXML
    private Button seleccionarButton;

    @FXML
    private ListView<Servicio> serviciosListView;

    @FXML
    private ListView<Servicio> serviciosSeleccionadosListView;

    private IServicioDAO servicioDAO = new ServicioDAO();
    private IMembresiaDAO membresiaDAO = new MembresiaDAO();

    @FXML
    void initialize() {
        serviciosListView.setItems(servicioDAO.getServicios());
        serviciosListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        serviciosSeleccionadosListView.setItems(FXCollections.observableArrayList());
        serviciosSeleccionadosListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        costoTextField.setText("0");
        costoTextField.setDisable(true);
        seleccionarButton.setOnAction(seleccionarButtonHandler());
        quitarButton.setOnAction(quitarButtonHandler());
        registrarButton.setOnAction(registrarButtonHandler());
        cancelarButton.setOnAction(cancelarButtonHandler());
    }

    private EventHandler<ActionEvent> seleccionarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ObservableList<Servicio> serviciosSelected = 
                    serviciosListView.getSelectionModel().getSelectedItems();
                if (serviciosSelected.isEmpty()) {
                    new Alert(
                        AlertType.WARNING, 
                        "Debes seleccionar al menos un servicio de la lista de los registrados"
                    ).show();
                    return;
                }
                for (Servicio servicio : serviciosSelected) {
                    serviciosSeleccionadosListView.getItems().add(servicio);
                    serviciosListView.getItems().remove(servicio);
                    int nuevoCosto = Integer.parseInt(costoTextField.getText()) + 
                        servicio.getCosto();
                    costoTextField.setText(String.valueOf(nuevoCosto));
                }
            }
        };
    }

    private EventHandler<ActionEvent> quitarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ObservableList<Servicio> serviciosSelected = 
                    serviciosSeleccionadosListView.getSelectionModel().getSelectedItems();
                if (serviciosSelected.isEmpty()) {
                    new Alert(
                        AlertType.WARNING, 
                        "Debes seleccionar al menos un servicio de la lista de los seleccionados"
                    ).show();
                    return;
                }
                for (Servicio servicio : serviciosSelected) {
                    serviciosListView.getItems().add(servicio);
                    serviciosSeleccionadosListView.getItems().remove(servicio);
                    int nuevoCosto = Integer.parseInt(costoTextField.getText()) - 
                        servicio.getCosto();
                    costoTextField.setText(String.valueOf(nuevoCosto));
                }
            }
        };
    }

    private EventHandler<ActionEvent> registrarButtonHandler() {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (nombreTextField.getText().isEmpty() ||
                    costoTextField.getText().isEmpty() ||
                    serviciosSeleccionadosListView.getItems().isEmpty()
                ) {
                    new Alert(AlertType.WARNING, "Faltan campos por completar").show();
                    return;
                }
                ArrayList<Servicio> serviciosSeleccionados = new ArrayList<>();
                for (Servicio servicio : serviciosSeleccionadosListView.getItems()) {
                    serviciosSeleccionados.add(servicio);
                }
                if (membresiaDAO.insertMembresia(
                    new Membresia(
                        0, 
                        nombreTextField.getText(), 
                        Integer.parseInt(costoTextField.getText()),
                        serviciosSeleccionados
                    )
                )) {
                    new Alert(AlertType.INFORMATION, "Membresía Registrada").showAndWait();
                    cancelarButton.fire();
                } else {
                    new Alert(AlertType.ERROR, "Ocurrió un error al registrar la membresía").show();
                }
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
