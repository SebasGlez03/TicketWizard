/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard;

import ticketwizard.persistencia.*;
import ticketwizard.persistencia.ConexionBD;

/**
 *
 * @author PC
 */
public class Pruebas {

    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();

        BoletosDAO listaBoletos = new BoletosDAO(conexionBD);
        System.out.println(listaBoletos.consultarBoletos());
//        PersonasDAO personasDAO = new PersonasDAO(conexionBD);
//        System.out.println(personasDAO.consultarPersonaPorID(1));

    }

}
