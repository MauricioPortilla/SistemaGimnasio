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
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * SQL es la clase que permite llevar a cabo las consultas en la
 * base de datos.
 * 
 * @author Mauricio Cruz Portilla
 * @version 2.0
 * @since 2019/02/22
 */
public class SQL {
    public static Statement statement;

    /**
     * Realiza una consulta a la base de datos y retorna una lista con cada resultado encontrado.
     * 
     * @param sql consulta SQL
     * @param result funcion con parametro que posee
     * los resultados de la consulta
     * @return lista de resultados encontrados
     */
    public static ArrayList<SQLRow> executeQuery(String sql, Predicate<ArrayList<SQLRow>> result) {
        try {
            Connection conn = new Database().getConnection();
            statement = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
            );
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<SQLRow> list = retrieveSQLData(rs);
            if (result != null) {
                if (!list.isEmpty()) {
                    result.test(list);
                }
            }
            statement.close();
            conn.close();
            return list;
        } catch (SQLException ex) {
            System.out.println("executeQuery Error -> " + ex.getMessage());
        }
        return null;
    }

    /**
     * Realiza una consulta a la base de datos y retorna una lista con cada resultado encontrado.
     * 
     * @param sql consulta SQL
     * @param parameters lista de valores que va a tomar la consulta
     * @param result funcion con parametro que posee los resultados de la consulta y se ejecuta si
     * existe algun resultado
     * @param failure funcion que se ejecuta si no existe algun resultado de la consulta
     * @return lista de resultados encontrados
     */
    public static boolean executeQuery(
        String sql, ArrayList<Object> parameters, Predicate<ArrayList<SQLRow>> result, 
        BooleanSupplier failure
    ) throws Exception {
        try {
            Connection conn = new Database().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.size(); i++) {
                    if (parameters.get(i) == null) {
                        ps.setNull(i + 1, Types.VARCHAR);
                        continue;
                    }
                    ps.setObject(i + 1, parameters.get(i));
				}
			}
            ResultSet rs = ps.executeQuery();
            ArrayList<SQLRow> list = retrieveSQLData(rs);
            boolean queryStatus;
            if (result != null) {
                if (!list.isEmpty()) {
                    queryStatus = result.test(list);
                } else {
                    queryStatus = failure.getAsBoolean();
                }
            } else {
                queryStatus = failure.getAsBoolean();
            }
            ps.close();
            conn.close();
            return queryStatus;
        } catch (SQLException sqlException) {
            System.out.println("executeQuery Error -> " + sqlException.getMessage());
            throw new SQLException("executeQuery Error -> " + sqlException.getMessage());
        } catch (Exception exception) {
            System.out.println("Exception -> " + exception.getMessage());
            throw new Exception("Exception -> " + exception.getMessage());
        }
    }

    /**
     * Realiza una actualizacion en la base de datos y retorna el numero de filas
     * afectadas si no se indica que se retorne el id de la fila afectada.
     * 
     * @param sql consulta SQL
     * @param returnId si deberia retornar el id de la fila afectada
     * @return el numero de filas afectadas, o el id de la fila afectada
     */
    public static int executeUpdate(String sql, boolean returnId) {
        int status = -1;
        try {
            Connection conn = new Database().getConnection();
            statement = conn.createStatement();
            if (returnId) {
                statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next())
                    status = rs.getInt(1);
            } else
                status = statement.executeUpdate(sql);
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("executeUpdate Error -> " + ex.getMessage());
            System.out.println("Query -> " + sql);
        }
        return status;
    }

    /**
     * Realiza una actualizacion en la base de datos de acuerdo a los parametros
     * ingresados.
     * 
     * @param sql consulta SQL
     * @param parameters valores a usar en la consulta
     * @return el numero de filas afectadas
     */
    public static int executeUpdate(String sql, ArrayList<Object> parameters) {
        int status = -1;
        try {
            Connection conn = new Database().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < parameters.size(); i++) {
                if (parameters.get(i) == null) {
                    ps.setNull(i + 1, Types.VARCHAR);
                    continue;
                }
                ps.setObject(i + 1, parameters.get(i));
            }
            status = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException sqlException) {
            System.out.println("executeUpdate Error -> " + sqlException.getMessage());
        }
        return status;
    }

    /**
     * Realiza una actualizacion en la base de datos en forma de transaccion, ejecutando primero
     * <i>sql</i> con sus <i>parameters</i>; si tuvo exito, va a ejecutar <i>sqlAfterFirst</i> con
     * sus <i>parametersAfterFirst</i> y concluye la transaccion; si no, deshará los cambios hechos.
     * 
     * @param sql primer sentencia a ejecutar
     * @param parameters parametros de la primera sentencia
     * @param sqlAfterFirst segunda sentencia a ejecutar
     * @param parametersAfterFirst parametros de la segunda sentencia (puede incluir como valor
     * <code>"RETURNED_ID"</code> para referirse al ID de la fila afectada en la sentencia SQL 
     * anterior)
     * @return el numero de filas afectadas, o -1 si no tuvo exito
     */
    public static int executeTransactionUpdate(
        String sql, ArrayList<Object> parameters, 
        String sqlAfterFirst, ArrayList<Object> parametersAfterFirst
    ) {
        int status = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try {
            conn = new Database().getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < parameters.size(); i++) {
                if (parameters.get(i) == null) {
                    ps.setNull(i + 1, Types.VARCHAR);
                    continue;
                }
                ps.setObject(i + 1, parameters.get(i));
            }
            status = ps.executeUpdate();
            int idReturned = 0;
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idReturned = rs.getInt(1);
            }
            if (status == 1) {
                ps2 = conn.prepareStatement(sqlAfterFirst, Statement.RETURN_GENERATED_KEYS);
                for (int i = 0; i < parametersAfterFirst.size(); i++) {
                    if (parametersAfterFirst.get(i).toString().equals("RETURNED_ID")) {
                        ps2.setObject(i + 1, idReturned);
                    } else {
                        ps2.setObject(i + 1, parametersAfterFirst.get(i));
                    }
                }
                ps2.executeUpdate();
                conn.commit();
            } else {
                System.out.println("Rolling back because of error on first query.");
                status = -1;
                conn.rollback();
            }
        } catch (SQLException e) {
            System.out.println("SQLException 1 -> " + e.getMessage());
            if (conn != null) {
                try {
                    status = -1;
                    conn.rollback();
                } catch (SQLException e1) {
                    System.out.println("Error transaction rollback -> " + e1.getMessage());
                }
            }
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQLException on finally -> " + e.getMessage());
            }
        }
        return status;
    }

    /**
     * Convierte un ResultSet en una lista con los datos de cada fila.
     * 
     * @param rs resultado de la consulta
     * @return la lista con cada fila
     */
    private static ArrayList<SQLRow> retrieveSQLData(ResultSet rs) {
        ArrayList<SQLRow> list = new ArrayList<>();
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs != null && rs.next()) {
                SQLRow row = new SQLRow();
                for(int i = 1; i <= metaData.getColumnCount(); i++){
                    row.setColumnData(metaData.getColumnName(i), rs.getObject(i));
                }
                list.add(row);
            }
        } catch (SQLException ex) {
            System.out.println("retrieveSQLData Error -> " + ex.getMessage());
        }
        return list;
    }
}
