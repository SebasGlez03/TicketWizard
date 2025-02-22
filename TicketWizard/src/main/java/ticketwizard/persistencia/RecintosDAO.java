/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import ticketwizard.entidades.Recintos;

/**
 * Clase Data Acces Object para la clase de recintos
 *
 * @author PC
 */
public class RecintosDAO {

    private final ConexionBD conexionBD;

    /**
     * Constructor que inicializa la conexion a la base de datos
     *
     * @param conexionBD conexion con los datos de la base de datos
     */
    public RecintosDAO(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Metodo que se encarga de obtener todos los registros de los recintos de
     * la base de datos
     *
     * @return Lista con todos los recintos de la base de datos
     */
    public List<Recintos> consultarRecintos() {
        String codigoSQL = """
                           SELECT codigoRecinto, nombre, estado, ciudad, cantidadAsientos
                           FROM recintos;
                           """;

        List<Recintos> listaRecintos = new LinkedList<>();
        try {

            // Crear la conexion con la base de datos
            Connection conexion = conexionBD.crearConexion();

            PreparedStatement comando = conexion.prepareStatement(codigoSQL);

            ResultSet resultadosConsulta = comando.executeQuery();

            // nos movemos a cada una de las filas de vueltas.
            while (resultadosConsulta.next()) {
                // Estamos dentro de una fila
                Integer codigoRecinto = resultadosConsulta.getInt("codigoRecinto");
                String nombre = resultadosConsulta.getString("nombre");
                String estado = resultadosConsulta.getString("estado");
                String ciudad = resultadosConsulta.getString("ciudad");
                Integer cantidadAsientos = resultadosConsulta.getInt("cantidadAsientos");
                Recintos recinto = new Recintos(
                        codigoRecinto, nombre, estado, ciudad, cantidadAsientos);
                listaRecintos.add(recinto);
            }

        } catch (SQLException ex) {
            System.err.println("Error al consultar recintos" + ex);
        }
        return listaRecintos;
    }

}
