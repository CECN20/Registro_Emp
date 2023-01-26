/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mariopatriciogonzalezgallegos
 */
public class ConexionDAO {
    private static Connection conn;
    String url = "jdbc:oracle:thin:@localhost:1521/XE";
    String usuario = "MercadoSuper";
    String password = "MercadoSuper123";

    private ConexionDAO() throws SQLException {
        DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
        conn = DriverManager.getConnection(url, usuario, password);
    }

    public static Connection getConnection() throws SQLException {
        if (conn == null) {
            new ConexionDAO();
        }
        return conn;
    }
    
}
