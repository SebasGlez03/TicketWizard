/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.dtos;

import java.util.Date;

/**
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

    public PersonasDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronico, double saldo, Date fechaNacimiento, String direccion) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronico = correoElectronico;
        this.saldo = saldo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public double getSaldo() {
        return saldo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    
    
    
    
}
