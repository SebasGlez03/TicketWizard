/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.entidades;

import java.util.Objects;

/**
 * Esta clase es encargada de crear los atributos de la tabla Recintos
 *
 * @author PC
 */
public class Recintos {

    Integer codigoRecinto;
    String nombre;
    String estado;
    String ciudad;
    Integer cantidadAsientos;

    /**
     * Constructor por omision
     */
    public Recintos() {
    }

    /**
     * Constructor que inicializa los atributos de la clase al valor de sus
     * parametros. A excepcion del id de la tabla
     *
     * @param nombre Nombre del recinto
     * @param estado Estado en el que se encuentra el recinto
     * @param ciudad Ciudad en la que se encuentra el recinto
     * @param cantidadAsientos Cantidad de asientos con la que cuenta el recinto
     */
    public Recintos(String nombre, String estado, String ciudad, Integer cantidadAsientos) {
        this.nombre = nombre;
        this.estado = estado;
        this.ciudad = ciudad;
        this.cantidadAsientos = cantidadAsientos;
    }

    /**
     * Constructor que inicializa los atributos de la clase al valor de sus
     * parametros
     *
     * @param codigoRecinto codigo identificador de la tabla recintos
     * @param nombre Nombre del recinto
     * @param estado Estado en el que se encuentra el recinto
     * @param ciudad Ciudad en la que se encuentra el recinto
     * @param cantidadAsientos Cantidad de asientos con la que cuenta el recinto
     */
    public Recintos(Integer codigoRecinto, String nombre, String estado, String ciudad, Integer cantidadAsientos) {
        this.codigoRecinto = codigoRecinto;
        this.nombre = nombre;
        this.estado = estado;
        this.ciudad = ciudad;
        this.cantidadAsientos = cantidadAsientos;
    }

    /**
     * Obtener el codigo identificador del recinto
     *
     * @return valor del codigo identificador del recinto
     */
    public Integer getCodigoRecinto() {
        return codigoRecinto;
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
     * Obtener estado en el que se encuentra el recinto
     *
     * @return estado en el que se encuentra el recinto
     */
    public String getEstado() {
        return estado;
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
     * Obtener cantidad de asientos con los que cuenta el recinto
     *
     * @return cantidad de asientos con los que cuenta el recinto
     */
    public Integer getCantidadAsientos() {
        return cantidadAsientos;
    }

    /**
     * Metodo que obtiene el hascode en base al codigo identificador del recinto
     *
     * @return hascode en base al identificador del recinto obtenido
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.codigoRecinto);
        return hash;
    }

    /**
     * Metodo que diferencia un objeto recinto de otro
     *
     * @param obj evento que recive
     * @return true si es el mismo objeto, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recintos other = (Recintos) obj;
        return Objects.equals(this.codigoRecinto, other.codigoRecinto);
    }

    /**
     * Metodo que convierte todos los atributos de la clase a un valor de tipo
     * String
     *
     * @return Cadena tipo String con todos los atributos de la clase
     */
    @Override
    public String toString() {
        return "Recintos{" + "codigoRecinto=" + codigoRecinto + ", nombre=" + nombre + ", estado=" + estado + ", ciudad=" + ciudad + ", cantidadAsientos=" + cantidadAsientos + '}';
    }

}
