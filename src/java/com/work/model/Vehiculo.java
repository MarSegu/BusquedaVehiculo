package com.work.model;

/**
 *
 * @author Admin
 */
public class Vehiculo {
    
    private String idVehiculo;    
    private String curp;
    private int hashCurp;
    private String matricula;
    private int hashMatricula;
    private String nSerie;
    private int hashSerie;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String color;

    public Vehiculo() {
    }

    public Vehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculo(String idVehiculo, String curp, int hashCurp, String matricula, int hashMatricula, String nSerie, int hashSerie, String nombre, String apellidos, String direccion, String color) {
        this.idVehiculo = idVehiculo;
        this.curp = curp;
        this.hashCurp = hashCurp;
        this.matricula = matricula;
        this.hashMatricula = hashMatricula;
        this.nSerie = nSerie;
        this.hashSerie = hashSerie;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.color = color;
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

    public int getHashCurp() {
        return hashCurp;
    }

    public void setHashCurp(int hashCurp) {
        this.hashCurp = hashCurp;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getHashMatricula() {
        return hashMatricula;
    }

    public void setHashMatricula(int hashMatricula) {
        this.hashMatricula = hashMatricula;
    }



    public int getHashSerie() {
        return hashSerie;
    }

    public void setHashSerie(int hashSerie) {
        this.hashSerie = hashSerie;
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

    public String getnSerie() {
        return nSerie;
    }

    public void setnSerie(String nSerie) {
        this.nSerie = nSerie;
    }
    
    
}
