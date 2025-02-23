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
                        codigoEvento, nombre, descripcion, fechaHora, estado, ciudad, cantidadAsientos);
                listaEventos.add(evento);
            }

        } catch (SQLException ex) {
            System.err.println("Error al consultar eventos");
        }
        return listaEventos;
    }

    /**
     * Obtiene un evento segun el codigo identificador proporcionado
     *
     * @param codigoEventoRecibido Codigo identificador del evento a buscar
     * @return Objeto Evento con los datos del evento con el codigo
     * identificador proporcionado
     */
    public Eventos consultarEventoPorID(Integer codigoEventoRecibido) {
        String codigoSQL = """
                           SELECT codigoEvento, nombre, descripcion, fechaHora, estado, ciudad, cantidadAsientos
                           FROM eventos
                           WHERE codigoEvento = ?;
                           """;

        Connection conexion = null;
        PreparedStatement comando = null;
        ResultSet resultadosConsulta = null;

        try {
            // Crear la conexión con la base de datos
            conexion = conexionBD.crearConexion();

            comando = conexion.prepareStatement(codigoSQL);
            comando.setInt(1, codigoEventoRecibido); // Se pasa el codigoPersona al PreparedStatement

            resultadosConsulta = comando.executeQuery();

            while (resultadosConsulta.next()) {
                Integer codigoEvento = resultadosConsulta.getInt("codigoEvento");
                String nombre = resultadosConsulta.getString("nombre");
                String descripcion = resultadosConsulta.getString("descripcion");
                Date fechaHora = resultadosConsulta.getTimestamp("fechaHora");
                String estado = resultadosConsulta.getString("estado");
                String ciudad = resultadosConsulta.getString("ciudad");
                Integer cantidadAsientos = resultadosConsulta.getInt("cantidadAsientos");

                Eventos evento = new Eventos(codigoEvento, nombre, descripcion, fechaHora, estado, ciudad, cantidadAsientos);

                return evento;
            }
        } catch (SQLException ex) {
            System.err.println("Ha ocurrido un error al consultar el evento por id: " + ex);
        } finally {
            // Cerrar los recursos siempre, incluso si hay una excepcion
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
                System.err.println("Ocurrio un error al cerrar las conexiones de eventos: " + ex);
            }
        }

        return null;
    }
    
    public List<Eventos> consultarEventosUsuario(int usuario) {
        String codigoSQL = """
                           select ev.codigoEvento, ev.nombre, ev.descripcion, ev.fechaHora, ev.estado, ev.ciudad, count(bl.codigoEvento) as cantidadBoletos
                           from boletos as bl inner join eventos as ev 
                           on ev.codigoEvento = bl.codigoEvento
                           where bl.codigoUsuario = ?
                           group by bl.codigoEvento;;
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
                Integer codigoEvento = resultadosConsulta.getInt("ev.codigoEvento");
                String nombre = resultadosConsulta.getString("ev.nombre");
                String descripcion = resultadosConsulta.getString("ev.descripcion");
                Date fechaHora = resultadosConsulta.getDate("ev.fechaHora");
                String estado = resultadosConsulta.getString("ev.estado");
                String ciudad = resultadosConsulta.getString("ev.ciudad");
                Integer cantidadAsientos = resultadosConsulta.getInt("Ev.cantidadBoletos");
                Eventos evento = new Eventos(
                        codigoEvento, nombre, descripcion, fechaHora, estado, ciudad, cantidadAsientos);
                listaEventos.add(evento);
            }

        } catch (SQLException ex) {
            System.err.println("Error al consultar eventos");
        }
        return listaEventos;
    }

}
