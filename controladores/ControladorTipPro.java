/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;

import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.tipPro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author german
 */
public class ControladorTipPro extends Conectar{
    
    public void crearTipPro (tipPro tip) {
        PreparedStatement sta = null;
        Connection con = getConnection();
    try { 
        String sql = "INSERT INTO `FACTURA`.`TipoProducto` (`idTipoProducto`, `Nombre`, `Descripcion`) values ('"+tip.getCodigo()+ "', '"+tip.getNombre()+"', '"+tip.getDescripcion()+"')";
     
             sta = con.prepareStatement(sql);
             System.out.println(sql);
             sta.execute(sql);
            
            
        } catch (Exception e) {
            System.out.println("ERROR al insertar cargo------" + e);
        }

    }
    
    public Map<Integer, String> listaTipPro() {
        PreparedStatement sta = null;
        Connection con = getConnection();
        ResultSet rs = null;
        Map<Integer, String> lista = new HashMap<Integer, String>();

        try {
            String sql = "SELECT `TipoProducto`.`idTipoProducto`," +"`TipoProducto`.`nombre`" +"FROM `FACTURA`.`TipoProducto`;";
            sta = con.prepareStatement(sql);
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                tipPro pro = new tipPro();
                lista.put(rs.getInt(1), rs.getString(2));

            }
            sta.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("ERROR lista" + ex);
        }
        return lista;
    }
    
    public tipPro buscarPorCodigo(int id) {
        tipPro tm = new tipPro();
        Statement sta = null;
        Connection con = getConnection();
        ResultSet rs = null;
        try {
            sta = con.createStatement();
            String sql = "SELECT `TipoProducto`.`idTipoProducto`," +"`TipoProducto`.`Nombre`," + "`TipoProducto`.`Descripcion`" +"FROM `FACTURA`.`TipoProducto`"+"where`TipoProducto`.`idTipoProducto` = " +id+"";
//            ﻿//SELECT `TipoProducto`.`idTipoProducto`,`TipoProducto`.`Nombre`,`TipoProducto`.`Descripcion`FROM `FACTURA`.`TipoProducto`where`TipoProducto`.`idTipoProducto` =1;
            sta.execute(sql);
            rs = sta.executeQuery(sql);
            rs.next();
            tm.setCodigo(rs.getInt("idTipoProducto"));
            tm.setNombre(rs.getString("Nombre"));
            tm.setDescripcion(rs.getString("Descripcion"));
            

            rs.close();
            sta.close();
        } catch (SQLException ex) {
            System.out.println("Error en la findByCodigo" + ex);
        }
        return tm;
    }
    
    
    public void EliminarTip(tipPro tp) {
        Statement sta = null;
        Connection con = getConnection();
                
        try {
            sta = con.createStatement();
            String sql = "DELETE FROM `FACTURA`.`TipoProducto`," +"WHERE `TipoProducto`.`idTipoProducto`="+tp.getCodigo()+"";
      
            sta.execute(sql);

        } catch (SQLException ex1) {
            System.out.println("Error de SQL " + ex1);
            System.out.println();
        }
        }
     public List<tipPro> listarTodo(String num) {
        Statement sta = null;
        ResultSet rs = null;
        Connection con = getConnection();
        List<tipPro> lista = new ArrayList<>();
        try {
            sta = con.createStatement();
               String  sql="select idTipoProducto,Nombre,Descripcion from TipoProducto where Nombre like  '%"+num+"%'";
            
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                tipPro p = new tipPro();
                //p.setId(rs.getInt("idProducto"));
                p.setCodigo(rs.getInt("idTipoProducto"));
                p.setNombre(rs.getString("Nombre"));
                //p.setStock(rs.getInt("Stock"));
                //p.setFechaExp(rs.getDate("FechaCaducidad"));
                p.setDescripcion(rs.getString("Descripcion"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Error de SQL" + ex);
        }
        return lista;
    }
}
