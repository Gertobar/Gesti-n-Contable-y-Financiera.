/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;

import ec.edu.ups.entidades.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author german
 */
public class ControladorCargo extends Conectar {
    
    public void crearCargo (Cargo car) {
        PreparedStatement sta = null;
        Connection con = getConnection();
    try { 
        String sql = "INSERT INTO `FACTURA`.`Cargo` (`idCargo`, `descripcion`) values ('"+car.getCodigo()+ "', '"+car.getDescripcion()+"')";
          
             sta = con.prepareStatement(sql);
             System.out.println(sql);
             sta.execute(sql);
            
            
        } catch (Exception e) {
            System.out.println("ERROR al insertar cargo------" + e);
        }

    }
   
     public Map<Integer, String> listaProveedor() {
        PreparedStatement sta = null;
        Connection con = getConnection();
        ResultSet rs = null;
        Map<Integer, String> lista = new HashMap<Integer, String>();

        try {
            String sql = "SELECT `Cargo`.`idCargo`,"+"`Cargo`.`descripcion`"+"FROM `FACTURA`.`Cargo`;";
            sta = con.prepareStatement(sql);
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                Cargo prov = new Cargo();
                lista.put(rs.getInt(1), rs.getString(2));

            }
            sta.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("ERROR lista" + ex);
        }
        return lista;
    }
    
    
    public Cargo buscarPorCodigo(int id) {
        Cargo tm = new Cargo();
        Statement sta = null;
        Connection con = getConnection();
        ResultSet rs = null;
        try {
            sta = con.createStatement();
            String sql = "SELECT `Cargo`.`idCargo`," +"`Cargo`.`descripcion`" +"FROM `FACTURA`.`Cargo`"+"where`Cargo`.`idCargo` = " +id+"";

            sta.execute(sql);
            rs = sta.executeQuery(sql);
            rs.next();
            tm.setCodigo(rs.getInt("idCargo"));
            tm.setDescripcion(rs.getString("descripcion"));
            

            rs.close();
            sta.close();
        } catch (SQLException ex) {
            System.out.println("Error en la findByCodigo" + ex.getStackTrace());
        }
        return tm;
    }
}
