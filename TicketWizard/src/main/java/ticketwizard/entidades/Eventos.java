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
    Integer codigoRecinto;

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
     * @param codigoRecinto Codigo identificador del recinto (llave foranea)
     */
    public Eventos(String nombre, String descripcion, Date fechaHora, Integer codigoRecinto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.codigoRecinto = codigoRecinto;
    }

    /**
     * Metodo que inicializa todos los atributos de la clase al valor de sus
     * parametros.
     *
     * @param codigoEvento Codigo identificador del evento
     * @param nombre Nombre del evento
     * @param descripcion Descripcion del evento
     * @param fechaHora Fceha hora de el evento
     * @param codigoRecinto Codigo identificador del recinto (llave foranea)
     */
    public Eventos(Integer codigoEvento, String nombre, String descripcion, Date fechaHora, Integer codigoRecinto) {
        this.codigoEvento = codigoEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.codigoRecinto = codigoRecinto;
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
     * Establecer el codigo identificador del evento
     *
     * @param codigoEvento codigo identificador del evento a establecer
     */
    public void setCodigoEvento(Integer codigoEvento) {
        this.codigoEvento = codigoEvento;
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
     * Establecer el nombre del evento
     *
     * @param nombre nombre del evento a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * Establecer la descripcion del evento
     *
     * @param descripcion descripcion del evento a establecer
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
     * Establecer la fecha y hora de el evento
     *
     * @param fechaHora fecha y hora del evento a establecer
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtener codigo identificador del recinto en donde se realizara el evento
     *
     * @return valor del codigo identificador del recinto
     */
    public Integer getCodigoRecinto() {
        return codigoRecinto;
    }

    /**
     * Establecer codigo identificaidor del recinto en donde se realizara el
     * evento
     *
     * @param codigoRecinto codigo identificador del recinto a establecer
     */
    public void setCodigoRecinto(Integer codigoRecinto) {
        this.codigoRecinto = codigoRecinto;
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
        return "Eventos{" + "codigoEvento=" + codigoEvento + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaHora=" + fechaHora + ", codigoRecinto=" + codigoRecinto + '}';
    }

}
