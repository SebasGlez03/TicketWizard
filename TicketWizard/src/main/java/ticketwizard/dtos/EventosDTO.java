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

    String nombre;
    String descripcion;
    Date fechaHora;
    Integer codigoRecinto;

    /**
     * Constructor que inicializa los atributos de la clase al valor de sus
     * parametros
     *
     * @param nombre Nombre del evento
     * @param descripcion Descripcion del evento
     * @param fechaHora Fecha hora del evento
     * @param codigoRecinto Codigo identificador del recinto
     */
    public EventosDTO(String nombre, String descripcion, Date fechaHora, Integer codigoRecinto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.codigoRecinto = codigoRecinto;
    }

    /**
     * Obtener nombre del evento
     *
     * @return nombre del evento
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establecer nombre del evento
     *
     * @param nombre nombre del evento a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtener descripcion del evento
     *
     * @return valor de la descripcion del evento
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establecer descripcion del evento
     *
     * @param descripcion descripcion del evento a establecer
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtener fecha y hora del evento
     *
     * @return valor de la fecha y hora del evento
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Establecer fecha y hora del evento
     *
     * @param fechaHora fecha y hora del evento a establecer
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtener codigo identificador del recinto
     *
     * @return valor del codigo identificador del recinto
     */
    public Integer getCodigoRecinto() {
        return codigoRecinto;
    }

    /**
     * Establecer codigo identificador del recinto
     *
     * @param codigoRecinto codigo identificador del recinto a establecer
     */
    public void setCodigoRecinto(Integer codigoRecinto) {
        this.codigoRecinto = codigoRecinto;
    }

}
