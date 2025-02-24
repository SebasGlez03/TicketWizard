/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.dtos;

import java.util.Date;

/**
 * Clase de solo lectura de los eventos
 *
 * @author PC
 */
public class EventosDTO {

    private String nombre;
    private String descripcion;
    private Date fechaHora;
    private String estado;
    private String ciudad;
    private Integer cantidadAsientos;

    /**
     * Constructor que inicializa todos los atributos de la clase al valor de
     * sus parametros
     *
     * @param nombre Nombre del evento
     * @param descripcion Descripcion del evento
     * @param fechaHora Fecha y hora del evento
     * @param estado Estado de realizacion evento
     * @param ciudad Ciudad de realizacion evento
     * @param cantidadAsientos Cantidad de asientos del evento
     */
    public EventosDTO(String nombre, String descripcion, Date fechaHora, String estado, String ciudad, Integer cantidadAsientos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.ciudad = ciudad;
        this.cantidadAsientos = cantidadAsientos;
    }

    /**
     * Obtiene el nombre del evento
     *
     * @return Nombre del evento
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la descripcion del evento
     *
     * @return Descripcion del evento
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene la fecha y hora de la realizacion del evento
     *
     * @return Fecha y hora de la realizacion del evento
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Obtiene el estado en donde se realiza el evento
     *
     * @return Estado donde se realiza el evento
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Obtiene la ciudad en donde se realiza el evento
     *
     * @return Ciudad en donde se realiza el evento
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Obtiene la calitdad de asientos de donde se realiza el evento
     *
     * @return Cantidad de asientos de donde se realiza el evento
     */
    public Integer getCantidadAsientos() {
        return cantidadAsientos;
    }

}
