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
import ticketwizard.entidades.Boletos;
import ticketwizard.entidades.Eventos;
import ticketwizard.entidades.Personas;

/**
 * Clase Data Acces Object para la entidad de Boletos
 *
 * @author PC
 */
public class BoletosDAO {

    private final ConexionBD conexionBD;

    /**
     * Constructor que inicializa la conexion con la base de datos
     *
     * @param conexionBD Conexion con los datos de la base de datos
     */
    public BoletosDAO(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    public List<Boletos> consultarBoletos() {
        String codigoSQL = """
                           SELECT codigoBoleto, fila, asiento, numeroInterno, codigoUsuario, codigoEvento, numeroSerie, costoOriginal, costo, estado
                           FROM boletos;
                           """;

        List<Boletos> listaBoletos = new LinkedList<>();

        Connection conexion = null;
        PreparedStatement comando = null;
        ResultSet resultadosConsulta = null;
        try {
            // Crear la conexion con la base de datos
            conexion = conexionBD.crearConexion();

            comando = conexion.prepareStatement(codigoSQL);

            resultadosConsulta = comando.executeQuery();

            while (resultadosConsulta.next()) {
                Integer codigoBoleto = resultadosConsulta.getInt("codigoBoleto");
                String fila = resultadosConsulta.getString("fila");
                String asiento = resultadosConsulta.getString("asiento");
                String numeroInterno = resultadosConsulta.getString("numeroInterno");
                Integer codigoUsuario = resultadosConsulta.getInt("codigoUsuario");
                Integer codigoEvento = resultadosConsulta.getInt("codigoEvento");
                String numeroSerie = resultadosConsulta.getString("numeroSerie");
                double costoOriginal = resultadosConsulta.getDouble("costoOriginal");
                double costo = resultadosConsulta.getDouble("costo");
                String estado = resultadosConsulta.getString("estado");

                PersonasDAO personaBuscar = new PersonasDAO(conexionBD);
                Personas persona = new Personas();

                persona.setCodigoPersona(personaBuscar.consultarPersonaPorID(codigoUsuario).getCodigoPersona());
                persona.setNombre(personaBuscar.consultarPersonaPorID(codigoUsuario).getNombre());
                persona.setApellidoPaterno(personaBuscar.consultarPersonaPorID(codigoUsuario).getApellidoPaterno());
                persona.setApellidoMaterno(personaBuscar.consultarPersonaPorID(codigoUsuario).getApellidoMaterno());
                persona.setCorreoElectronico(personaBuscar.consultarPersonaPorID(codigoUsuario).getCorreoElectronico());
                persona.setContrasenia(personaBuscar.consultarPersonaPorID(codigoUsuario).getContrasenia());
                persona.setSaldo(personaBuscar.consultarPersonaPorID(codigoUsuario).getSaldo());
                persona.setFechaNacimiento(personaBuscar.consultarPersonaPorID(codigoUsuario).getFechaNacimiento());
                persona.setCalle(personaBuscar.consultarPersonaPorID(codigoUsuario).getCalle());
                persona.setColonia(personaBuscar.consultarPersonaPorID(codigoUsuario).getColonia());
                persona.setNumeroCasa(personaBuscar.consultarPersonaPorID(codigoUsuario).getNumeroCasa());

                EventosDAO eventoBuscar = new EventosDAO(conexionBD);
                Eventos evento = new Eventos();

                evento.setCodigoEvento(eventoBuscar.consultarEventoPorID(codigoEvento).getCodigoEvento());
                evento.setNombre(eventoBuscar.consultarEventoPorID(codigoEvento).getNombre());
                evento.setDescripcion(eventoBuscar.consultarEventoPorID(codigoEvento).getDescripcion());
                evento.setFechaHora(eventoBuscar.consultarEventoPorID(codigoEvento).getFechaHora());
                evento.setEstado(eventoBuscar.consultarEventoPorID(codigoEvento).getEstado());
                evento.setCiudad(eventoBuscar.consultarEventoPorID(codigoEvento).getCiudad());
                evento.setCantidadAsientos(eventoBuscar.consultarEventoPorID(codigoEvento).getCantidadAsientos());

                Boletos boleto = new Boletos(codigoBoleto, fila, asiento,
                        persona, evento, numeroSerie, costoOriginal,
                        costo, estado);

                listaBoletos.add(boleto);
            }

            conexion.close();
            comando.close();
            resultadosConsulta.close();
        } catch (SQLException ex) {
            System.err.println("Ha ocurrido un error al obtener la lista de boletos: " + ex);
        } finally {
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
                System.err.println("Ha ocurrido un error al cerrar la conexion con boletos: " + ex);
            }
        }

        return null;
    }

}
