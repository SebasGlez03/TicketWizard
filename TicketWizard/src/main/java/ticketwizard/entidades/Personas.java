/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.entidades;

import java.util.Date;
import java.util.Objects;

/**
 * Clase que representa una persona usuario del sistema
 *
 * @author PC
 */
public class Personas {

    Integer codigoPersona;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String correoElectronico;
    String contrasenia;
    double saldo;
    Date fechaNacimiento;
    String direccion;

    /**
     * Constructor por omision
     */
    public Personas() {
    }

    /**
     * Clase que inicializa los atributos de la clase con el valor de sus
     * parametros a excepcion del codigo de identificacion
     *
     * @param nombre Nombre de la persona
     * @param apellidoPaterno Apellido paterno de la persona
     * @param apellidoMaterno Apellido materno de la persona
     * @param correoElectronico Correo electronico de la persona
     * @param contrasenia Contrasenia de la persona
     * @param saldo Saldo de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona
     * @param direccion Direccion de la persona
     */
    public Personas(String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico, String contrasenia, double saldo, Date fechaNacimiento, String direccion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
        this.saldo = saldo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    /**
     * Clase que inicializa todos los atributos de la clase con el valor de sus
     * parametros
     *
     * @param codigoPersona Codigo identificador de la persona
     * @param nombre Nombre de la persona
     * @param apellidoPaterno Apellido paterno de la persona
     * @param apellidoMaterno Apellido materno de la persona
     * @param correoElectronico Correo electronico de la persona
     * @param contrasenia Contrasenia de la persona
     * @param saldo Saldo de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona
     * @param direccion Direccion de la persona
     */
    public Personas(Integer codigoPersona, String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico, String contrasenia, double saldo, Date fechaNacimiento, String direccion) {
        this.codigoPersona = codigoPersona;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
        this.saldo = saldo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    /**
     * Obtiene el codigo identificador de la persona
     *
     * @return Codigo identificador de la persona
     */
    public Integer getCodigoPersona() {
        return codigoPersona;
    }

    /**
     * Establece el codigo identificador de la persona
     *
     * @param codigoPersona Codigo identificador de la persona a establecer
     */
    public void setCodigoPersona(Integer codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    /**
     * Obtiene el nombre de la persona
     *
     * @return Nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona
     *
     * @param nombre Nombre de la persona a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno de la persona
     *
     * @return Apellido paterno de la persona
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno de la persona
     *
     * @param apellidoPaterno Apellido paterno de la persona a establecer
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno de la persona
     *
     * @return Apellido materno de la persona
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno de la persona
     *
     * @param apellidoMaterno Apellido materno de la persona a establecer
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el correo electronico de la persona
     *
     * @return Correo eletronico de la persona
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece el correo electonico de la persona
     *
     * @param correoElectronico Correo electronico de la persona a establecer
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene la contrasenia de la persona
     *
     * @return Contrasenia de la persona
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contrasenia de la persona
     *
     * @param contrasenia Contrasenia de la persona a establecer
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el saldo de la persona
     *
     * @return Saldo de la persona
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo de la persona
     *
     * @param saldo Saldo de la persona a establecer
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona
     *
     * @return Fecha de nacimiento de la persona
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona
     *
     * @param fechaNacimiento Fecha de nacimiento de la persona a establecer
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la direccion de la persona
     *
     * @return Direccion de la persona
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la direccion de la persona
     *
     * @param direccion Direccion de la persona a establecer
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo que obtiene el hascode en base al codigo identificador de la
     * persona
     *
     * @return hascode en base al identificador de la persona obtenida
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigoPersona);
        return hash;
    }

    /**
     * Metodo que diferencia un objeto persona de otro
     *
     * @param obj persona que recive
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
        final Personas other = (Personas) obj;
        return Objects.equals(this.codigoPersona, other.codigoPersona);
    }

    /**
     * Metodo que convierte todos los atributos de la clase a un valor de tipo
     * String
     *
     * @return Cadena tipo String con todos los atributos de la clase
     */
    @Override
    public String toString() {
        return "Personas{" + "codigoPersona=" + codigoPersona + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", correoElectronico=" + correoElectronico + ", saldo=" + saldo + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + '}';
    }

}
