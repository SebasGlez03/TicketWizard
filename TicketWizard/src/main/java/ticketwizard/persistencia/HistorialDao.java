/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.persistencia;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import ticketwizard.dtos.PersonasDTO;
import ticketwizard.entidades.Boletos;
import ticketwizard.entidades.Eventos;
import ticketwizard.entidades.Personas;
import ticketwizard.entidades.Ventas;

/**
 *
 * @author santi
 */
public class HistorialDao {
    
    
    private final ConexionBD conexionBD;

    public HistorialDao(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    public List<Ventas> ventasUsuario(int Usuario){
         String codigoSQL = """
                           select codigoHistorial, fechaHora, accion, codigoBoleto from historial where
                            codigoUsuario = ?;
                           """;

        List<Ventas> Historial = new LinkedList<>();

        Connection conexion = null;
        PreparedStatement comando = null;
        ResultSet resultadosConsulta = null;
        
        try{

            conexion = conexionBD.crearConexion();
            
            comando = conexion.prepareStatement(codigoSQL);
            
            comando.setInt(1, Usuario);

            resultadosConsulta = comando.executeQuery();

            while (resultadosConsulta.next()){
                
                Integer codigoAccion = resultadosConsulta.getInt("codigoHistorial");
                Date fechaHora = resultadosConsulta.getDate("fechaHora");
                String accion = resultadosConsulta.getString("accion");
                Integer codigoBoleto = resultadosConsulta.getInt("codigoBoleto");
                
                BoletosDAO boletosDAO = new BoletosDAO(conexionBD);
                
                Ventas acciones = new Ventas(codigoAccion, fechaHora, accion, boletosDAO.consultarBoleto(codigoBoleto));
                
                
            }
            conexion.close();
            comando.close();
            resultadosConsulta.close();
        }
        catch (SQLException ex) {
             System.err.println("Ha ocurrido un error al cerrar la conexion con boletos: " + ex);
        }
        
        return Historial;
    }
        
    
}
