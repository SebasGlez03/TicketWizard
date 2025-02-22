/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.control;

import java.util.List;
import ticketwizard.entidades.Eventos;
import ticketwizard.persistencia.ConexionBD;
import ticketwizard.persistencia.EventosDAO;
import ticketwizard.presentacion.CatalogoEventos;

/**
 * Clase control que establece los metodos para mostrar los Frms
 *
 * @author PC
 */
public class ControlEventos {

    private ConexionBD conexionBD = new ConexionBD();
    private EventosDAO eventosDAO = new EventosDAO(conexionBD);
    private CatalogoEventos frmCatalogoEventos;

    /**
     * Metodo que inicia el caso de uso para mostrar el catalogo de eventos
     */
    public void iniciarCasoUso() {
        this.frmCatalogoEventos = new CatalogoEventos(this);
        this.frmCatalogoEventos.setVisible(true);
    }

    /**
     * Metodo que consulta la lista de todos los eventos
     *
     * @return Lista con el contenido de todos los eventos
     */
    public List<Eventos> consultarListaEventos() {
        return this.eventosDAO.consultarEventos();
    }

}
