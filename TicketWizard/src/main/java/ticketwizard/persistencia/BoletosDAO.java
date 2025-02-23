/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.persistencia;

import java.util.List;
import ticketwizard.entidades.Boletos;

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
        String codigoSQL = 
    }

}
