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
import ticketwizard.dtos.EventosDTO;
import ticketwizard.entidades.Eventos;

/**
 * Clase Data Acces Object para la tabla de Eventos
 *
 * @author PC
 */
public class EventosDAO {

    private final ConexionBD conexionBD;

    /**
     * Metodo que inicia la conexion a la base de datos
     *
     * @param conexionBD datos de la conexion a la base de datos
     */
    public EventosDAO(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Metodo para obtener la lista de todos los eventos registrados en la base
     * de datos
     *
     * @return Lista con todos los eventos registrados en la base de datos
     */
    public List<Eventos> consultarEventos() {
        String codigoSQL = """
                           SELECT codigoEvento, nombre, descripcion, fechaHora, estado, ciudad, cantidadAsientos 
                           FROM eventos;
                           """;

        List<Eventos> listaEventos = new LinkedList<>();
        try {

            // Crear la conexion con la base de datos
            Connection conexion = conexionBD.crearConexion();

            PreparedStatement comando = conexion.prepareStatement(codigoSQL);

            ResultSet resultadosConsulta = comando.executeQuery();

            // nos movemos a cada una de las filas de vueltas.
            while (resultadosConsulta.next()) {
                // Estamos dentro de una fila
                Integer codigoEvento = resultadosConsulta.getInt("codigoEvento");
                String nombre = resultadosConsulta.getString("nombre");
                String descripcion = resultadosConsulta.getString("descripcion");
                Date fechaHora = resultadosConsulta.getDate("fechaHora");
                String estado = resultadosConsulta.getString("estado");
                String ciudad = resultadosConsulta.getString("ciudad");
                Integer cantidadAsientos = resultadosConsulta.getInt("cantidadAsientos");
                Eventos evento = new Eventos(
                        codigoEvento, nombre, descripcion, fechaHora, estado, ciudad,cantidadAsientos);
                listaEventos.add(evento);
            }

        } catch (SQLException ex) {
            System.err.println("Error al consultar eventos");
        }
        return listaEventos;
    }

}
