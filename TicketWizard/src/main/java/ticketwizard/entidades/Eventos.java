/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.entidades;

import java.util.Date;
import java.util.Objects;

/**
 * Esta clase es encargada de crear los atributos de la tabla Eventos
 *
 * @author PC
 */
public class Eventos {

    Integer codigoEvento;
    String nombre;
    String descripcion;
    Date fechaHora;
    String Estado;
    String Ciudad;
    Integer cantidadAsientos;

    /**
     * Constructor por omision
     */
    public Eventos() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase al valor de
     * sus parametros. A excepcion de el id de la tabla
     *
     * @param nombre Nombre del evento
     * @param descripcion Descripcion del evento
     * @param fechaHora Fecha Hora de el evento
     * @param Estado Estado donde ocurre el evento
     * @param Ciudad Ciudad donde ocurre el evento
     * @param cantidadAsientos cantidad de asientos del evento
     */
    public Eventos(String nombre, String descripcion, Date fechaHora, String Estado, String Ciudad, Integer cantidadAsientos) {    
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.Estado = Estado;
        this.Ciudad = Ciudad;
        this.cantidadAsientos = cantidadAsientos;
    }

    /**
     * Metodo que inicializa todos los atributos de la clase al valor de sus
     * parametros.
     *
     * @param codigoEvento Codigo identificador del evento
     * @param nombre Nombre del evento
     * @param descripcion Descripcion del evento
     * @param fechaHora Fceha hora de el evento
     * @param Estado Estado donde ocurre el evento
     * @param Ciudad Ciudad donde ocurre el evento
     * @param cantidadAsientos cantidad de asientos del evento
     */
    public Eventos(Integer codigoEvento, String nombre, String descripcion, Date fechaHora, String Estado, String Ciudad, Integer cantidadAsientos) {
        this.codigoEvento = codigoEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.Estado = Estado;
        this.Ciudad = Ciudad;
        this.cantidadAsientos = cantidadAsientos;
    }

    /**
     * Obtener codigo identificador del evento
     *
     * @return valor del codigo identificador del evento
     */
    public Integer getCodigoEvento() {
        return codigoEvento;
    }

    /**
     * Obtener el nombre del evento
     *
     * @return valor del nombre del evento
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Obtener el estado del evento
     *
     * @return El estado donde ocurre el evento
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * Obtener La ciudad del evento
     *
     * @return La ciudad donde ocurre el Evento 
     */
    public String getCiudad() {
        return Ciudad;
    }

    /**
     * Obtener el nombre del evento
     *
     * @return valor de la cantidad de asientos en el evento
     */
    public Integer getCantidadAsientos() {
        return cantidadAsientos;
    }

    /**
     * Obtener la descripcion del evento
     *
     * @return valor de la descripcion del evento
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtener fecha y hora de el evento
     *
     * @return valor de la fecha y hora de el evento
     */
    public Date getFechaHora() {
        return fechaHora;
    }

    /**
     * Metodo que obtiene el hascode en base al codigo identificador del evento
     *
     * @return hascode en base al identificador del evento obtenido
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.codigoEvento);
        return hash;
    }

    /**
     * Metodo que diferencia un objeto evento de otro
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
        final Eventos other = (Eventos) obj;
        return Objects.equals(this.codigoEvento, other.codigoEvento);
    }

     /**
     * Metodo que convierte todos los atributos de la clase a un valor de tipo
     * String
     *
     * @return Cadena tipo String con todos los atributos de la clase
     */
    @Override
    public String toString() {
        return "Eventos{" + "codigoEvento=" + codigoEvento + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaHora=" + fechaHora + ", Estado=" + Estado + ", Ciudad=" + Ciudad + ", cantidadAsientos=" + cantidadAsientos + '}';
    }

  
    
}
