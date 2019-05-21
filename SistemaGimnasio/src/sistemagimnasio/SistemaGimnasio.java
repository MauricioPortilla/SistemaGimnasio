/**
 * Sistema de Gimnasio
 * Elaborado por (en orden alfabetico):
 *  Cruz Portilla Mauricio
 *  Gonzalez Hernandez Maria Saarayim
 *  Hernandez Molinos Maria Jose
 * 
 * Mayo, 2019
 */
package sistemagimnasio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * SistemaGimnasio es la clase principal que inicializa el programa.
 * 
 * @author Mauricio Cruz Portilla
 * @author Maria Saarayim Gonzalez Hernandez
 * @author Maria Jose Hernandez Molinos
 * @version 1.0
 * @since 2019/05/18
 */
public class SistemaGimnasio extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("interfaz/FXMLSistemaGimnasio.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
