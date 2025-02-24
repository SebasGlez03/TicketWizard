/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.persistencia;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import ticketwizard.dtos.PersonasDTO;
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
     * Metodo que se encarga de obtener todos los registros de las personas de
     * la base de datos
     *
     * @return Lista con todos las personas de la base de datos
     */
    public List<Personas> consultarPersonas() {
        String codigoSQL = """
                           SELECT codigoPersona, nombre, apellidoMaterno, apellidoPaterno, correoElectronico, contrasenia, saldo, fechaNacimiento, calle, colonia, numero
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
                String calle = resultadosConsulta.getString("calle");
                String colonia = resultadosConsulta.getString("colonia");
                String numero = resultadosConsulta.getString("numero");
                Personas persona = new Personas(codigoPersona, nombre,
                        apellidoPaterno, apellidoMaterno, correoElectronico,
                        contrasenia, saldo, fechaNacimiento, calle, colonia,
                        numero);
                listaPersonas.add(persona);
            }

        } catch (SQLException ex) {
            System.err.println("Error al consultar personas" + ex);
        }
        return listaPersonas;
    }

    /**
     * Obtiene una persona de la base de datos por medio de su codigo
     * identificador
     *
     * @param codigoPersonaRecibido Codigo identificador de la persona a buscar
     * en la base de datos
     * @return Persona con el codigo identificador buscado
     */
    public Personas consultarPersonaPorID(Integer codigoPersonaRecibido) {
        String codigoSQL = """
                           SELECT codigoPersona, nombre, apellidoMaterno, apellidoPaterno, correoElectronico, contrasenia, saldo, fechaNacimiento, calle, colonia, numero
                           FROM personas
                           WHERE codigoPersona = ?;
                           """;

        Connection conexion = null;
        PreparedStatement comando = null;
        ResultSet resultadosConsulta = null;

        try {
            // Crear la conexión con la base de datos
            conexion = conexionBD.crearConexion();

            comando = conexion.prepareStatement(codigoSQL);
            comando.setInt(1, codigoPersonaRecibido); // Se pasa el codigoPersona al PreparedStatement

            resultadosConsulta = comando.executeQuery();

            while (resultadosConsulta.next()) {

                Integer codigoPersona = resultadosConsulta.getInt("codigoPersona");
                String nombre = resultadosConsulta.getString("nombre");
                String apellidoMaterno = resultadosConsulta.getString("apellidoMaterno");
                String apellidoPaterno = resultadosConsulta.getString("apellidoPaterno");
                String correoElectronico = resultadosConsulta.getString("correoElectronico");
                String contrasenia = resultadosConsulta.getString("contrasenia");
                double saldo = resultadosConsulta.getDouble("saldo");
                Date fechaNacimiento = resultadosConsulta.getDate("fechaNacimiento");
                String calle = resultadosConsulta.getString("calle");
                String colonia = resultadosConsulta.getString("colonia");
                String numero = resultadosConsulta.getString("numero");

                Personas persona = new Personas(codigoPersona, nombre,
                        apellidoPaterno, apellidoMaterno, correoElectronico,
                        contrasenia, saldo, fechaNacimiento, calle, colonia, numero);

                return persona;
            }

            conexion.close();
            comando.close();
            resultadosConsulta.close();

        } catch (SQLException ex) {
            System.err.println("Error al consultar personas por id: " + ex);
        } finally {
            // Crerrar los recursos siempre incluso aunque haya una excepcion
            try {
                if (resultadosConsulta != null) {
                    resultadosConsulta.close();
                }
                if (comando != null) {
                    comando.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Ocurrio un error al cerrar las conexiones con personas: " + ex);
            }
        }

        return null;
    }

    /**
     * Metodo que agrega una nueva persona a la base de datos
     *
     * @param personaDTO Objeto personaDTO con la persona a agregar a la base de
     * datos
     */
    public void agregarPersona(PersonasDTO personaDTO) {
        String codigoSQL = """
                           INSERT INTO personas(nombre, apellidoMaterno, apellidoPaterno, correoElectronico, contrasenia, fechaNacimiento, calle, colonia, numero)
                           VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);
                           """;

        try {
            Connection conexion = conexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);

            // Se encripta la contrasenia antes de almacenarla
            String contraseniaEncriptada = encriptarContrasenia(personaDTO.getContrasenia());

            // Se cambia el tipo de dato de la fecha a uno valido
            java.sql.Date sqlFechaNacimiento = new java.sql.Date(personaDTO.getFechaNacimiento().getTime());

            comando.setString(1, personaDTO.getNombre());
            comando.setString(2, personaDTO.getApellidoPaterno());
            comando.setString(3, personaDTO.getApellidoMaterno());
            comando.setString(4, personaDTO.getCorreoElectronico());
            comando.setString(5, contraseniaEncriptada);
            comando.setDate(6, sqlFechaNacimiento);
            comando.setString(7, personaDTO.getCalle());
            comando.setString(8, personaDTO.getColonia());
            comando.setString(9, personaDTO.getNumeroCasa());

            int filasAfectadas = comando.executeUpdate();
            System.out.println("Se registro a la persona");
            System.out.println("Filas afectadas: " + filasAfectadas);
        } catch (SQLException | NoSuchAlgorithmException ex) {
            System.err.println("Error al agregar usuario: " + ex);
        }
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
                       SELECT codigoPersona, nombre, apellidoMaterno, apellidoPaterno, correoElectronico, contrasenia, saldo, fechaNacimiento, calle, colonia, numero
                       FROM personas
                       WHERE correoElectronico = ?;
                       """;

        try {
            // Crear la conexión con la base de datos
            Connection conexion = conexionBD.crearConexion();

            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            comando.setString(1, correo); // Se pasa el el correo al PreparedStatement

            ResultSet resultadosConsulta = comando.executeQuery();

            if (resultadosConsulta.next()) { // Si existe el usuario con ese correo
                String contraseniaBD = resultadosConsulta.getString("contrasenia");

                // Se encripta la contrasenia ingresada y se compara con la almacenada
                String contraseniaEncriptadaIngresada = encriptarContrasenia(contrasenia);

                // Se compara la contraseña recibida con la almacenada en la base de datos
                if (contraseniaBD.equals(contraseniaEncriptadaIngresada)) {
                    Integer codigoPersona = resultadosConsulta.getInt("codigoPersona");
                    String nombre = resultadosConsulta.getString("nombre");
                    String apellidoMaterno = resultadosConsulta.getString("apellidoMaterno");
                    String apellidoPaterno = resultadosConsulta.getString("apellidoPaterno");
                    String correoElectronico = resultadosConsulta.getString("correoElectronico");
                    double saldo = resultadosConsulta.getDouble("saldo");
                    Date fechaNacimiento = resultadosConsulta.getDate("fechaNacimiento");
                    String calle = resultadosConsulta.getString("calle");
                    String colonia = resultadosConsulta.getString("colonia");
                    String numero = resultadosConsulta.getString("numero");

                    return new Personas(codigoPersona, nombre, apellidoPaterno,
                            apellidoMaterno, correoElectronico, contraseniaBD,
                            saldo, fechaNacimiento, calle, colonia, numero);
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Contraseña incorrecta.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Contrasenia incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Correo no registrado.");
            }

        } catch (SQLException | NoSuchAlgorithmException ex) {
            System.err.println("Error al iniciar sesión: " + ex);
        }

        return null; // Devuelve null si no se encontró el usuario o la contraseña es incorrecta
    }

    /**
     * Metodo para encriptar la contrasenia utilizando SHA-256
     *
     * @param contrasenia Contrasenia a encriptar
     * @return Regresa la contrasenia encriptada (o hasheada)
     * @throws NoSuchAlgorithmException
     */
    private static String encriptarContrasenia(String contrasenia) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256"); // Se usa el algorimto SHA-256
        byte[] hashBytes = digest.digest(contrasenia.getBytes(StandardCharsets.UTF_8)); // Realiza el hash
        return bytesAHex(hashBytes);
    }

    /**
     * Metodo que convierte un arreglo de bytes a una cadena hexadecimal
     *
     * @param bytes Arreglo de bytes a convertir
     * @return Cadena de Hexadecimal
     */
    private static String bytesAHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
