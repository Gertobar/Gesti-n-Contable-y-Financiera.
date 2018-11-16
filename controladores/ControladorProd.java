/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;

import ec.edu.ups.entidades.Persona;
import ec.edu.ups.entidades.Producto;
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
public class ControladorProd extends Conectar{
    
    public void crearProduc (Producto p) {
        PreparedStatement sta = null;
        DateFormat formatofch;
        formatofch = new SimpleDateFormat("yyyy-MM-dd");
        Connection con = getConnection();
    try { 
        String sql = "INSERT INTO `FACTURA`.`Producto` (`idProducto`, `Codigo`, `Detalle`, `Stock`, `FechaCaducidad`, `Precio`, `FechaIngreso`, `TipoProducto_idTipoProducto`, `Proveedor_idProveedor`) values ('"+p.getId()+ "', '"+p.getCodigo()+"', '"+p.getDetalle()+"', '"+p.getStock()+"', '"+formatofch.format(p.getFechaExp())+"', '"+p.getPrecio()+"', '"+formatofch.format(p.getFechaIn())+"', '"+p.getTiproducto().getCodigo()+"', '"+p.getProvedor().getCodigo()+"')";
     
             sta = con.prepareStatement(sql);
             System.out.println(sql);
             sta.execute(sql);
            
            
        } catch (Exception e) {
            System.out.println("ERROR al insertar cargo------" + e);
        }
    }
    
    public void actualizarProducto(Producto p) {
        Statement sta = null;
         Connection con = getConnection();
         Persona pers = new Persona();

        try {
            sta = con.createStatement();
            String sql = "UPDATE `FACTURA`.`cliente`\n" +
"SET\n" +
//"`idCliente` = "+p.getCodigo()+",\n" +
"`Stock` = "+p.getStock()+"\n" +
"WHERE `idProducto` = "+p.getCodigo()+"";  //<{expr}>;";
            System.out.println(sql);
            sta.execute(sql);
            sta.close();

        } catch (SQLException ex) {
            System.out.println("Error en sentencia UPDATE  :" + ex);

        }
        }
    public List<Producto> listarTodo(String num) {
        Statement sta = null;
        ResultSet rs = null;
        Connection con = getConnection();
        List<Producto> lista = new ArrayList<>();
        try {
            sta = con.createStatement();
               String  sql="select Codigo,Detalle,Precio from Producto where Detalle like  '%"+num+"%'";
            
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                Producto p = new Producto();
                //p.setId(rs.getInt("idProducto"));
                p.setCodigo(rs.getString("Codigo"));
                p.setDetalle(rs.getString("Detalle"));
                //p.setStock(rs.getInt("Stock"));
                //p.setFechaExp(rs.getDate("FechaCaducidad"));
                p.setPrecio(rs.getDouble("Precio"));
                //p.setFechaIn(rs.getDate("FechaIngreso"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Error de SQL" + ex);
        }
        return lista;
    }
}
