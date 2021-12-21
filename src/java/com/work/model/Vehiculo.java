package com.work.model;

/**
 *
 * @author Admin
 */
public class Vehiculo {
    public String idVehiculo;
    public String curp;
    public String codigoHash;
    public String nSerie;
    public String nombre;
    public String apellidos;
    public String direccion;
    public String color;
    public String matricula;

    public Vehiculo() {
    }

    public Vehiculo(String idVehiculo, String curp, String codigoHash, String nSerie, String nombre, String apellidos, String direccion, String color, String matricula) {
        this.idVehiculo = idVehiculo;
        this.curp = curp;
        this.codigoHash = codigoHash;
        this.nSerie = nSerie;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.color = color;
        this.matricula = matricula;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCodigoHash() {
        return codigoHash;
    }

    public void setCodigoHash(String codigoHash) {
        this.codigoHash = codigoHash;
    }

    public String getnSerie() {
        return nSerie;
    }

    public void setnSerie(String nSerie) {
        this.nSerie = nSerie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "idVehiculo=" + idVehiculo + ", curp=" + curp + ", codigoHash=" + codigoHash + ", nSerie=" + nSerie + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", color=" + color + ", matricula=" + matricula + '}';
    }    
    
}
