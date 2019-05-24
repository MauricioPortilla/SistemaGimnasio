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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXMLRegistrarPagoController implements Initializable {

 @FXML private Button aceptarButton;
 @FXML private Button cancelarButton;
 @FXML private Label labelNombre ;
 @FXML private Label labelMembresia;
 @FXML private ComboBox fechaComboBox;
 @FXML private ComboBox mensuPagarComboBox;
 @FXML private TextField textPago;
 
 @FXML
 private void datos (){
   labelNombre.setText("Saaraayim González Hernández");
   labelMembresia.setText("Especial");
 }
 
 @FXML
 private void accionAceptar(ActionEvent event) throws SQLException {
  
 }
 
 
 /**
  * Cierra la ventana
  * @param event
  * @throws SQLException 
  */
 
 @FXML
 private void accionCancelar(ActionEvent event) throws SQLException {
  ((Stage) cancelarButton.getScene().getWindow()).close(); 
 }
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    datos();
  }  
  
}
