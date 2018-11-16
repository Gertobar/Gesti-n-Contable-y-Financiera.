/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;

import ec.edu.ups.entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author german
 */
public class ControladorPersona  extends Conectar{
    
    public void crearPersona (Persona per) {
        PreparedStatement sta = null;
        Connection con = getConnection();
    try { 
        String sql = "INSERT INTO `FACTURA`.`Persona` (`idPersona`, `CedulaRucPersona`, `Nombre`, `Apellido`, `Direccion`, `Email`) values ('"+per.getCodigo()+ "', '"+per.getCedula()+"','"+per.getNombre()+"', '"+per.getApellido()+"', '"+per.getDireccion()+"', '"+per.getEmail()+"')";
          
             sta = con.prepareStatement(sql);
             System.out.println(sql);
             sta.execute(sql);
            
            
        } catch (Exception e) {
            System.out.println("ERROR al insertar cargo------" + e);
        }

    }
}
