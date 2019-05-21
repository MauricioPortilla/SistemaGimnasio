/**
 * Sistema de Gimnasio
 * Elaborado por (en orden alfabetico):
 *  Cruz Portilla Mauricio
 *  Gonzalez Hernandez Maria Saarayim
 *  Hernandez Molinos Maria Jose
 * 
 * Mayo, 2019
 */

package engine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database es la clase que lleva a cabo la conexion a la
 * base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 1.0
 * @since 2019/02/22
 */
public class Database {
    private Connection connection;

    /**
     * Crea la conexion a la base de datos
     */
    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Connecting...");
            String url = "jdbc:mysql://localhost:3306/gimnasiodb";
            connection = DriverManager.getConnection(url, "gimnasiouser", "tm3");
            System.out.println("Connected.");
        } catch(SQLException sqlException){
            System.out.println("Connection error -> " + sqlException.getMessage());
        } catch(ClassNotFoundException classException){
            classException.printStackTrace();
        } catch(Exception e){
            System.out.println("Se produjo un error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * Retorna la conexion a la base de datos
     * @return la conexion
     */
    public Connection getConnection() {
        return connection;
    }
    
    /**
     * Cierra la conexion a la base de datos
     */
    public void close() {
        try {
            connection.close();
        } catch (SQLException sqlException) {
            System.err.println("Error: " + sqlException.getMessage () + "\n" + sqlException.getErrorCode ());
        }
    }
}
