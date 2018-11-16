/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;

import ec.edu.ups.entidades.Cargo;
import ec.edu.ups.entidades.Empleado;
import ec.edu.ups.entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author german
 */
public class ControladorEmpleados extends Conectar{
    
    public void crearEmpleado (Empleado e) {
        PreparedStatement sta = null;
        DateFormat formatofch;
        formatofch = new SimpleDateFormat("yyyy-MM-dd");
        Connection con = getConnection();
    try { 
        String sql = "INSERT INTO `FACTURA`.`Empleado` (`idEmpleado`, `Usuario`, `Contrasenha`, `FechaInicio`, `FechaFin`, `Persona_idPersona`, `Cargo_idCargo`) values ('"+e.getCodigo()+ "', '"+e.getUsuario()+"', '"+e.getContrasenha()+"', '"+formatofch.format(e.getFechain())+"', '"+formatofch.format(e.getFechafin())+"', '"+e.getPersona()+"', '"+e.getCargo().getCodigo()+"')";
     
             sta = con.prepareStatement(sql);
             System.out.println(sql);
             sta.execute(sql);
            
            
        } catch (SQLException ex) {
            System.out.println("ERROR AL INSERTAR EMPLEADO------" + ex);
        }

    }
    
        public List<Empleado> listarTodo(String nom) {
        Statement sta = null;
        Connection con = getConnection();
        Persona p = new Persona();
        ResultSet rs = null;
        List<Empleado> lista = new ArrayList<>();
        try {
            sta = con.createStatement();
            String sql1 ="Select Empleado.idEmpleado, Persona.Nombre, Persona.Apellido,Persona.CedulaRucPersona,Persona.Email,Persona.Direccion,Empleado.Usuario,Empleado.FechaInicio,Empleado.FechaFin,Cargo.descripcion from FACTURA.Persona, FACTURA.Empleado,FACTURA.Cargo where Persona.idPersona = Empleado.Persona_idPersona && Cargo.idCargo = Empleado.Cargo_idCargo && Persona.Nombre like  '%"+nom+"%'"; 
            rs = sta.executeQuery(sql1);
            while (rs.next()) {
                Empleado e= new Empleado();
                //Cargo c = new Cargo();
                e.setCodigo(rs.getInt("idEmpleado"));
                e.setNombre(rs.getString("Nombre"));
                e.setApellido(rs.getString("Apellido"));
                e.setCedula(rs.getString("CedulaRucPersona"));
                e.setEmail(rs.getString("Email"));
                e.setDireccion(rs.getString("Direccion"));
                e.setUsuario(rs.getString("Usuario"));
                e.setFechain(rs.getDate("FechaInicio"));
                e.setFechain(rs.getDate("FechaInicio"));
                e.setFechafin(rs.getDate("FechaFin"));
                e.setDescripcion(rs.getString("descripcion"));
                lista.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("Error de SQL" + ex);
        }
        return lista;
  }
}
