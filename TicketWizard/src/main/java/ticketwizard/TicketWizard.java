/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ticketwizard;

import java.util.List;
import ticketwizard.control.ControlInicio;
import ticketwizard.entidades.Eventos;
import ticketwizard.entidades.Personas;
import ticketwizard.entidades.Recintos;
import ticketwizard.persistencia.ConexionBD;
import ticketwizard.persistencia.EventosDAO;
import ticketwizard.persistencia.PersonasDAO;
import ticketwizard.persistencia.RecintosDAO;

/**
 *
 * @author PC
 */
public class TicketWizard {

    public static void main(String[] args) {
//        ConexionBD conexionBD = new ConexionBD();
//
//        System.out.println("Eventos");
//        EventosDAO eventosDAO = new EventosDAO(conexionBD);
//        List<Eventos> listaEventos = eventosDAO.consultarEventos();
//        System.out.println(listaEventos);
//
//        System.out.println("Recintos");
//        RecintosDAO recintosDAO = new RecintosDAO(conexionBD);
//        List<Recintos> listaRecintos = recintosDAO.consultarRecintos();
//        System.out.println(listaRecintos);
//
//        System.out.println("Personas");
//        PersonasDAO personasDAO = new PersonasDAO(conexionBD);
//        List<Personas> listaPersonas = personasDAO.consultarPersonas();
//        System.out.println(listaPersonas);
//
//        System.out.println("Persona Inicia Sesion");
//        System.out.println(personasDAO.iniciarSesion("sebas@gmail.com", "sebas123").toString());

        ControlInicio control = new ControlInicio();
        control.iniciarCasoUso();

    }
}
