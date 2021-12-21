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
import javax.annotation.PostConstruct;
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
    private Vehiculo vehiculo;
        
    private String valorBusqueda;
    
    private String tipoBusqueda;
    
    private final String SQL_INSERT = "INSERT INTO VEHICULOPRUEBA v ( v.id_vehiculo, v.curp, v.hash_curp, v.matricula, v.hash_matricula, v.nserie, v.hash_nserie, v.nombre, v.apellidos, v.direccion, v.color)" +
                                      "VALUES ('?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?');";

    @PostConstruct
    public void init(){
        vehiculo = new Vehiculo();
    }   
    
    public void conectar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String idVehiculo = "";
        String curp = "";
        String matricula = "";
        String nSerie = "";
        String nombre = "";
        String apellidos = "";
        String direccion = "";
        String color = "";
       
        try {
            conn = getDataSource("jdbc/OracleVM").getConnection();            
            stmt = conn.prepareCall("SELECT * FROM VEHICULOPRUEBA");            
            rs = stmt.executeQuery();
     
            while (rs.next()) {
                idVehiculo = rs.getString("ID_VEHICULO");
                curp = rs.getString("CURP");
                matricula = rs.getString("MATRICULA");
                nSerie = rs.getString("NSERIE");
                nombre = rs.getString("NOMBRE");
                apellidos = rs.getString("APELLIDOS");
                direccion = rs.getString("DIRECCION");
                color = rs.getString("COLOR");
                
                vehiculo = new Vehiculo();
                vehiculo.setIdVehiculo(idVehiculo);
                vehiculo.setCurp(curp);
                vehiculo.setMatricula(matricula);
                vehiculo.setnSerie(nSerie);
                vehiculo.setNombre(nombre);
                vehiculo.setApellidos(apellidos);
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
    
    public int insert() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            conn = getDataSource("jdbc/OracleVM").getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vehiculo.getCurp());
            stmt.setInt(2, vehiculo.getCurp().hashCode());
            stmt.setString(3, vehiculo.getMatricula());
            stmt.setInt(4, vehiculo.getMatricula().hashCode());
            stmt.setString(5, vehiculo.getnSerie());
            stmt.setInt(6, vehiculo.getnSerie().hashCode());
            stmt.setString(7, vehiculo.getNombre());
            stmt.setString(8, vehiculo.getApellidos());
            stmt.setString(9, vehiculo.getDireccion());
            stmt.setString(10, vehiculo.getColor());
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch(Exception ex){
            System.out.println("Error insertando: " + ex);
        }

        return rows;
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

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
}
