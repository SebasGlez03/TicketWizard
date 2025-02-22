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

    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String correoElectronico;
    double saldo;
    Date fechaNacimiento;
    String direccion;

    /**
     * Constructor que inicializa todos los atributos de la clase con el valor
     * de sus parametros
     *
     * @param nombre Nombre de la persona
     * @param apellidoPaterno Apellido paterno de la persona
     * @param apellidoMaterno Apellido materno de la persona
     * @param correoElectronico Correo electronico de la persona
     * @param saldo Saldo de la persona
     * @param fechaNacimiento Fecha de nacimiento de la persona
     * @param direccion Direccion de la persona
     */
    public PersonasDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico, double saldo, Date fechaNacimiento, String direccion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronico = correoElectronico;
        this.saldo = saldo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
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
     * Obtiene la direccion de la persona
     *
     * @return Direccion de la persona
     */
    public String getDireccion() {
        return direccion;
    }

}
