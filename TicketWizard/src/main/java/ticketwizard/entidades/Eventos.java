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

    private Integer codigoEvento;
    private String nombre;
    private String descripcion;
    private Date fechaHora;
    private String estado;
    private String ciudad;
    private Integer cantidadAsientos;

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
     * @param estado Estado donde ocurre el evento
     * @param ciudad Ciudad donde ocurre el evento
     * @param cantidadAsientos cantidad de asientos del evento
     */
    public Eventos(String nombre, String descripcion, Date fechaHora, String estado, String ciudad, Integer cantidadAsientos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.ciudad = ciudad;
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
     * @param estado Estado donde ocurre el evento
     * @param ciudad Ciudad donde ocurre el evento
     * @param cantidadAsientos cantidad de asientos del evento
     */
    public Eventos(Integer codigoEvento, String nombre, String descripcion, Date fechaHora, String estado, String ciudad, Integer cantidadAsientos) {
        this.codigoEvento = codigoEvento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.ciudad = ciudad;
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
        return estado;
    }

    /**
     * Obtener La ciudad del evento
     *
     * @return La ciudad donde ocurre el Evento
     */
    public String getCiudad() {
        return ciudad;
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
     * Establece el codigo identificador del evento
     *
     * @param codigoEvento Codigo identificador del evento a establecer
     */
    public void setCodigoEvento(Integer codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    /**
     * Establece el nombre del evento
     *
     * @param nombre Nombre del evento a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la descripcion del evento
     *
     * @param descripcion Descripcion del evento a establecer
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece la fecha y la hora de cuando se realiza el evento
     *
     * @param fechaHora Fecha y hora de cuando se realiza el evento a establecer
     */
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Establece el estado en donde se realiza el evento
     *
     * @param estado Estado en donde se realiza el evento a establecer
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Establece la ciudad en donde se realiza el evento
     *
     * @param ciudad Ciudad en donde se realiza el evento a establecer
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Establece la cantidad de asientos en el evento
     *
     * @param cantidadAsientos Cantidad de asientos en el evento a establecer
     */
    public void setCantidadAsientos(Integer cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
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
        return "Eventos{" + "codigoEvento=" + codigoEvento + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaHora=" + fechaHora + ", Estado=" + estado + ", Ciudad=" + ciudad + ", cantidadAsientos=" + cantidadAsientos + '}';
    }

}
