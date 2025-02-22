/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import ticketwizard.entidades.Personas;

/**
 * Clase Data Acces Object de la clase Personas
 *
 * @author PC
 */
public class PersonasDAO {

    private final ConexionBD conexionBD;

    /**
     * Constructor que inicializa la conexion con la base de datos
     *
     * @param conexionBD Conexion con los datos de la base de datos
     */
    public PersonasDAO(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Clase que se encarga de obtener todos los registros de las personas de la
     * base de datos
     *
     * @return Lista con todos las personas de la base de datos
     */
    public List<Personas> consultarPersonas() {
        String codigoSQL = """
                           SELECT codigoPersona, nombre, apellidoMaterno, apellidoPaterno, correoElectronico, contrasenia, saldo, fechaNacimiento, direccion
                           FROM personas;
                           """;

        List<Personas> listaPersonas = new LinkedList<>();
        try {

            // Crear la conexion con la base de datos
            Connection conexion = conexionBD.crearConexion();

            PreparedStatement comando = conexion.prepareStatement(codigoSQL);

            ResultSet resultadosConsulta = comando.executeQuery();

            // nos movemos a cada una de las filas de vueltas.
            while (resultadosConsulta.next()) {
                // Estamos dentro de una fila
                Integer codigoPersona = resultadosConsulta.getInt("codigoPersona");
                String nombre = resultadosConsulta.getString("nombre");
                String apellidoMaterno = resultadosConsulta.getString("apellidoMaterno");
                String apellidoPaterno = resultadosConsulta.getString("apellidoPaterno");
                String correoElectronico = resultadosConsulta.getString("correoElectronico");
                String contrasenia = resultadosConsulta.getString("contrasenia");
                double saldo = resultadosConsulta.getDouble("saldo");
                Date fechaNacimiento = resultadosConsulta.getDate("fechaNacimiento");
                String direccion = resultadosConsulta.getString("direccion");
                Personas persona = new Personas(
                        codigoPersona, nombre, apellidoPaterno, apellidoMaterno, correoElectronico, contrasenia, saldo, fechaNacimiento, direccion);
                listaPersonas.add(persona);
            }

        } catch (SQLException ex) {
            System.err.println("Error al consultar recintos" + ex);
        }
        return listaPersonas;
    }

    /**
     * Metodo que se encarga de obtener una persona que exista en la base de
     * datos para verificar su existencia en el sistema
     *
     * @param correo Correo electronico de la persona
     * @param contrasenia Contrasenia de la persona
     * @return Objeto de tipo personas con los datos de una persona encontrada
     * en el sistema
     */
    public Personas iniciarSesion(String correo, String contrasenia) {
        String codigoSQL = """
                       SELECT codigoPersona, nombre, apellidoMaterno, apellidoPaterno, correoElectronico, contrasenia, saldo, fechaNacimiento, direccion
                       FROM personas
                       WHERE correoElectronico = ?;
                       """;

        try {
            // Crear la conexión con la base de datos
            Connection conexion = conexionBD.crearConexion();

            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            comando.setString(1, correo); // Pasamos el correo al PreparedStatement

            ResultSet resultadosConsulta = comando.executeQuery();

            if (resultadosConsulta.next()) { // Si existe el usuario con ese correo
                String contraseniaBD = resultadosConsulta.getString("contrasenia");

                // Comparamos la contraseña recibida con la almacenada en la base de datos
                if (contraseniaBD.equals(contrasenia)) {
                    Integer codigoPersona = resultadosConsulta.getInt("codigoPersona");
                    String nombre = resultadosConsulta.getString("nombre");
                    String apellidoMaterno = resultadosConsulta.getString("apellidoMaterno");
                    String apellidoPaterno = resultadosConsulta.getString("apellidoPaterno");
                    String correoElectronico = resultadosConsulta.getString("correoElectronico");
                    double saldo = resultadosConsulta.getDouble("saldo");
                    Date fechaNacimiento = resultadosConsulta.getDate("fechaNacimiento");
                    String direccion = resultadosConsulta.getString("direccion");

                    return new Personas(codigoPersona, nombre, apellidoPaterno, apellidoMaterno, correoElectronico, contraseniaBD, saldo, fechaNacimiento, direccion);
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Contraseña incorrecta.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Contrasenia incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Correo no registrado.");
            }

        } catch (SQLException ex) {
            System.err.println("Error al iniciar sesión: " + ex);
        }

        return null; // Devuelve null si no se encontró el usuario o la contraseña es incorrecta
    }

}
