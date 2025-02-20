/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.dtos;

/**
 * Clase de solo lectura de recintos
 *
 * @author PC
 */
public class RecintosDTO {

    String nombre;
    String estado;
    String ciudad;
    Integer cantidadAsientos;

    /**
     * Constructor que inicializa los atributos de la clase al valor de sus
     * parametros
     *
     * @param nombre Nombre del recinto
     * @param estado Estado en el que se encuentra el recinto
     * @param ciudad Ciudad en la que se encuentra el recinto
     * @param cantidadAsientos Cantidad de asientos con los que cuenta el
     * recinto
     */
    public RecintosDTO(String nombre, String estado, String ciudad, Integer cantidadAsientos) {
        this.nombre = nombre;
        this.estado = estado;
        this.ciudad = ciudad;
        this.cantidadAsientos = cantidadAsientos;
    }

    /**
     * Obtener el nombre del recinto
     *
     * @return nombre del recinto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establecer el nombre del recinto
     *
     * @param nombre nombre del recinto a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtener estado en el que se encuentra el recinto
     *
     * @return estado en el que se encuentra el recinto
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establecer el estado en el que se encuentra el recinto
     *
     * @param estado estado en el que se encuentra el recinto a establecer
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtener ciudad en la que se encuentra el recinto
     *
     * @return ciudad en la que se encuentra el recinto
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establecer ciudad en la que se encuentra el recinto
     *
     * @param ciudad ciudad en la que se encuentra el recinto a establecer
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtener cantidad de asientos con los que cuenta el recinto
     *
     * @return cantidad de asientos con los que cuenta el recinto
     */
    public Integer getCantidadAsientos() {
        return cantidadAsientos;
    }

    /**
     * Establecer cantidad de asientos con los que quenta el recinto
     *
     * @param cantidadAsientos cantidad de asientos con los que cuenta el
     * recinto a establecer
     */
    public void setCantidadAsientos(Integer cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

}
