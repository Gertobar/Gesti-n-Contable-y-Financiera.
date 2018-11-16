/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;

import ec.edu.ups.entidades.Cliente;
import ec.edu.ups.entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author german
 */
public class ControladorCliente extends Conectar {
  public void crearCliente (Cliente c) {
        PreparedStatement sta = null;
       Persona p = new Persona();
       
        Connection con = getConnection();
    try { 
        String sql = "INSERT INTO `FACTURA`.`Cliente` (`idCliente`, `TipoCliente`, `Persona_idPersona`) values ('"+c.getCodigo()+ "', '"+c.getTipCli()+"','"+c.getPersona()+"')";
     
             sta = con.prepareStatement(sql);
             System.out.println(sql);
             sta.execute(sql);
            
            
        } catch (Exception ex) {
            System.out.println("ERROR al insertar cargo------" + ex);
        }

    }
    
    public void EliminarCliente(Cliente c) {
        Statement sta = null;
        Connection con = getConnection();
                
        try {
            sta = con.createStatement();
            String sql = "DELETE FROM `FACTURA`.`cliente`," +"WHERE `Cliente`.`idCliente`="+c.getCodigo()+"";
            
            System.out.println(sql);
            sta.execute(sql);

        } catch (SQLException ex1) {
            System.out.println("Error de SQL " + ex1);
            System.out.println();
        }
    }
    
     public void actualizarCliente(Cliente c) {
        Statement sta = null;
         Connection con = getConnection();
         Persona p = new Persona();

        try {
            sta = con.createStatement();
            String sql = "UPDATE `FACTURA`.`cliente`\n" +
"SET\n" +
"`idCliente` = "+c.getCodigo()+",\n" +
"`TipoCliente` = "+c.getTipCli()+",\n" +
"`Persona_idPersona` = "+p.toString()+"\n" +
"WHERE `idCliente` = "+c.getCodigo()+"";  //<{expr}>;";
            System.out.println(sql);
            sta.execute(sql);
            sta.close();

        } catch (SQLException ex) {
            System.out.println("Error en sentencia UPDATE  :" + ex);

        }
        }
    public List<Cliente> listarTodo(String nom) {
        Statement sta = null;
        Connection con = getConnection();
        Persona p = new Persona();
        ResultSet rs = null;
        List<Cliente> lista = new ArrayList<>();
        try {
            sta = con.createStatement();
            String sql1 ="select Cliente.idCliente, Persona.Nombre,Persona.Apellido,Persona.CedulaRucPersona,Persona.Email,Persona.Direccion,Cliente.TipoCliente from FACTURA.Persona, FACTURA.Cliente where Persona.idPersona = Cliente.Persona_idPersona && Persona.Nombre like  '%"+nom+"%'";
            rs = sta.executeQuery(sql1);
            while (rs.next()) {
                Cliente c= new Cliente();
                c.setCodigo(rs.getInt("idCliente"));
                c.setNombre(rs.getString("Nombre"));
                c.setApellido(rs.getString("Apellido"));
                c.setCedula(rs.getString("CedulaRucPersona"));
                c.setEmail(rs.getString("Email"));
                c.setDireccion(rs.getString("Direccion"));
                c.setTipCli(rs.getString("TipoCliente"));
                  
                lista.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Error de SQL" + ex);
        }
        return lista;
  }  
    
    public Cliente buscarPorCodigo(int codigo) {
        Cliente c = new Cliente();
        Statement sta = null;
        Connection con = getConnection();
        ResultSet rs = null;
        try {
            sta = con.createStatement();
            String sql = "SELECT `Cliente`.`idCliente`," +"`Cliente`.`TipoCliente`," +"`Cliente`.`Persona_idPersona`" +"FROM `FACTURA`.`Cliente`"+"where`Cliente`.`idCliente` = " +codigo+"";
                   
            System.out.println(sql);
            sta.execute(sql);
            rs = sta.executeQuery(sql);
            rs.next();
            c.setCodigo(rs.getInt("idCliente"));
            c.setTipCli(rs.getString("TipoCliente"));
            rs.close();
            sta.close();
        } catch (SQLException ex) {
            System.out.println("Error en la findByCodigo" + ex);
        }
        return c;
    }  
}
