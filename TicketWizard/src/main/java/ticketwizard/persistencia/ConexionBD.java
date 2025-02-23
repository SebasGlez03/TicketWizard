/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class ConexionBD {

    // Informacion para conectarte a la bd
    private final String cadenaConexion = "jdbc:mysql://localhost/ticketwizard";
    private final String usuario = "root";
    private final String contrasenia = "SanSanty03";

    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(
                cadenaConexion,
                usuario,
                contrasenia);

        return conexion;
    }
}
