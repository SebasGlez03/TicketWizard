/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketwizard.entidades;

import java.util.Date;
import java.util.Objects;

/**
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

    public Personas() {
    }

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

    public Integer getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(Integer codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigoPersona);
        return hash;
    }

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

    @Override
    public String toString() {
        return "Personas{" + "codigoPersona=" + codigoPersona + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", correoElectronico=" + correoElectronico + ", saldo=" + saldo + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + '}';
    }

}
