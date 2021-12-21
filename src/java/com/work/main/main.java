/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.work.main;

import com.work.model.Vehiculo;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Admin
 */
@Named
@ViewScoped
public class main implements Serializable{
    
    private List<Vehiculo> vehiculos = new ArrayList<>();
        
    private String valorBusqueda;
    
    private String tipoBusqueda;
      
    public void conectar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vehiculo vehiculo = null;
        String idVehiculo = "";
        String curp = "";
        String codigoHash = "";
        String nSerie = "";
        String nombre = "";
        String apellidos = "";
        String matricula = "";
        String direccion = "";
        String color = "";
       
        try {
            conn = getDataSource("jdbc/OracleVM").getConnection();            
            stmt = conn.prepareCall("SELECT * FROM VEHICULOPRUEBA");            
            rs = stmt.executeQuery();
     
            while (rs.next()) {
                idVehiculo = rs.getString("ID_VEHICULO");
                curp = rs.getString("CURP");
                codigoHash = rs.getString("CODIGOHASH");
                nSerie = rs.getString("NSERIE");
                nombre = rs.getString("NOMBRE");
                apellidos = rs.getString("APELLIDOS");
                matricula = rs.getString("MATRICULA");
                direccion = rs.getString("DIRECCION");
                color = rs.getString("COLOR");
                
                vehiculo = new Vehiculo();
                vehiculo.setIdVehiculo(idVehiculo);
                vehiculo.setCurp(curp);
                vehiculo.setCodigoHash(codigoHash);
                vehiculo.setnSerie(nSerie);
                vehiculo.setNombre(nombre);
                vehiculo.setApellidos(apellidos);
                vehiculo.setMatricula(matricula);
                vehiculo.setDireccion(direccion);
                vehiculo.setColor(color);
                vehiculos.add(vehiculo);
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void limpiar(){
        tipoBusqueda =""; 
        valorBusqueda =""; 
    }
    
    public DataSource getDataSource(String jdni) {
        
        InitialContext ctx;
        DataSource ds = null;

        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup(jdni);

        } catch (NamingException ex) {
            System.out.println("Error: " + ex);
        }
        return ds;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public String getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(String tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

    public String getValorBusqueda() {
        return valorBusqueda;
    }

    public void setValorBusqueda(String valorBusqueda) {
        this.valorBusqueda = valorBusqueda;
    }

    
    
}
