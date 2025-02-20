/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ticketwizard;

import java.util.List;
import ticketwizard.entidades.Eventos;
import ticketwizard.entidades.Recintos;
import ticketwizard.persistencia.ConexionBD;
import ticketwizard.persistencia.EventosDAO;
import ticketwizard.persistencia.RecintosDAO;

/**
 *
 * @author PC
 */
public class TicketWizard {

    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();

        EventosDAO eventosDAO = new EventosDAO(conexionBD);
        List<Eventos> listaEventos = eventosDAO.consultarEventos();
        System.out.println(listaEventos);

        System.out.println("a");

        RecintosDAO recintosDAO = new RecintosDAO(conexionBD);
        List<Recintos> listaRecintos = recintosDAO.consultarRecintos();
        System.out.println(listaRecintos);

    }
}
