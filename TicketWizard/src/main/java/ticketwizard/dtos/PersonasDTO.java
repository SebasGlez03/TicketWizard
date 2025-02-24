/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.dtos;

import java.util.Date;

/**
 * Clase Data Transfer Object de la clase Personas
 *
 * @author PC
 */
public class PersonasDTO {

    private Integer codigoPersona;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correoElectronico;
    private String contrasenia;
    private double saldo;
    private Date fechaNacimiento;
    private String calle;
    private String colonia;
    private String numeroCasa;

    /**
     * Constructor que inicializa todos los atributos de la clase con el valor
     * de sus parametros
     *
     * @param codigoPersona Codigo identificador de la persona
     * @param nombre Nombre de la persona
     * @param apellidoPaterno Apellido paterno de la persona
     * @param apellidoMaterno Apellido materno de la persona
     * @param correoElectronico Correo electronico de la persona
     * @param contrasenia Contrasenia de la persona
     * @param saldo Saldo de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona
     * @param calle Calle de la direccion de la persona
     * @param colonia Colonia de la direccion de la persona
     * @param numeroCasa Numero de casa de la direccion de la persona
     */
    public PersonasDTO(Integer codigoPersona, String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico, String contrasenia, double saldo, Date fechaNacimiento, String calle, String colonia, String numeroCasa) {
        this.codigoPersona = codigoPersona;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
        this.saldo = saldo;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroCasa = numeroCasa;
    }

    /**
     * Constructor que inicializa todos los atributos de la clase con el valor
     * de sus parametros a excepcion del codigo identificador
     *
     * @param nombre Nombre de la persona
     * @param apellidoPaterno Apellido paterno de la persona
     * @param apellidoMaterno Aellido materno de la persona
     * @param correoElectronico Correo electronico de la persona
     * @param contrasenia Contrasenia de la persona
     * @param saldo Saldo de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona
     * @param calle Calle de la direccion de la persona
     * @param colonia Colonia de la direccion de la persona
     * @param numeroCasa Numero de casa de la direccion de la persona
     */
    public PersonasDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico, String contrasenia, double saldo, Date fechaNacimiento, String calle, String colonia, String numeroCasa) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
        this.saldo = saldo;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroCasa = numeroCasa;
    }

    /**
     * Constructor que inicializa todos los atributos de la clase con el valor
     * de sus parametros a excepcion del saldo
     *
     * @param nombre Nombre de la persona
     * @param apellidoPaterno Apellido paterno de la persona
     * @param apellidoMaterno Apellido materno de la persona
     * @param correoElectronico Correo electronico de la persona
     * @param contrasenia Contrasenia de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona
     * @param calle Calle de la direccion de la persona
     * @param colonia Colonia de la direccion de la persona
     * @param numeroCasa Numero de casa de la direccion de la persona
     */
    public PersonasDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico, String contrasenia, Date fechaNacimiento, String calle, String colonia, String numeroCasa) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroCasa = numeroCasa;
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
     * Obtiene el nombre de la persona
     *
     * @return Nombre de la persona
     */
    public String getNombre() {
        return nombre;
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
     * Obtiene el apellido materno de la persona
     *
     * @return Apellido materno de la persona
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Obtiene el correo electronico de la persona
     *
     * @return Correo electronico de la persona
     */
    public String getCorreoElectronico() {
        return correoElectronico;
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
     * Obtiene el saldo de la persona
     *
     * @return Saldo de la persona
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona
     *
     * @return Fecha de nacimiento de la parsona
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Obtiene la calle de la direccion de la persona
     *
     * @return Calle de la direccion de la persona
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Obtiene la colonia de la direccion de la persona
     *
     * @return Colonia de la direccion de la persona
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Numero de casa de la direccion de la persona
     *
     * @return Numero de casa de la direccion de la persona
     */
    public String getNumeroCasa() {
        return numeroCasa;
    }

}
