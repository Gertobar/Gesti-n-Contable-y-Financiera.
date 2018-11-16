/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;
import ec.edu.ups.entidades.Proveedor;
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
public class ControladorProveedor extends Conectar {
public void crearProveedor (Proveedor pro) {
        PreparedStatement sta = null;
        Connection con = getConnection();
    try { 
        String sql = "INSERT INTO `FACTURA`.`Proveedor` (`idProveedor`, `nombre`) values ('"+pro.getCodigo()+ "', '"+pro.getDescripcion()+"')";
          
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
            String sql = "SELECT `Proveedor`.`idProveedor`,"+"`Proveedor`.`nombre`"+"FROM `FACTURA`.`Proveedor`;";
            sta = con.prepareStatement(sql);
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                Proveedor prov = new Proveedor();
                lista.put(rs.getInt(1), rs.getString(2));

            }
            sta.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("ERROR lista" + ex);
        }
        return lista;
    }
    
    
    public Proveedor buscarPorCodigo(int id) {
        Proveedor tm = new Proveedor();
        Statement sta = null;
        Connection con = getConnection();
        ResultSet rs = null;
        try {
            sta = con.createStatement();
            String sql = "SELECT `Proveedor`.`idProveedor`," +"`Proveedor`.`nombre`" +"FROM `FACTURA`.`Proveedor`"+"where`Proveedor`.`idProveedor` = " +id+"";

            sta.execute(sql);
            rs = sta.executeQuery(sql);
            rs.next();
            tm.setCodigo(rs.getInt("idProveedor"));
            tm.setDescripcion(rs.getString("nombre"));
            

            rs.close();
            sta.close();
        } catch (SQLException ex) {
            System.out.println("Error en la findByCodigo" + ex);
        }
        return tm;
    }
    
    public void EliminarProveedor(Proveedor prov) {
        Statement sta = null;
        Connection con = getConnection();
                
        try {
            sta = con.createStatement();
            String sql = "DELETE FROM `FACTURA`.`proveedor`," +"WHERE `proveedor`.`idProveedor`="+prov.getCodigo()+"";
            
            System.out.println(sql);
            sta.execute(sql);

        } catch (SQLException ex1) {
            System.out.println("Error de SQL " + ex1);
            System.out.println();
        }
        }

public void actualizarProveedor(Proveedor prov) {
        Statement sta = null;
         Connection con = getConnection();

        try {
            sta = con.createStatement();
            String sql = "UPDATE `FACTURA`.`proveedor`\n" +
"SET\n" +
"`idCliente` = "+prov.getCodigo()+",\n" +
"`Stock` = "+prov.getDescripcion()+"\n" +
"WHERE `idProveedor` = "+prov.getCodigo()+"";  //<{expr}>;";
            sta.execute(sql);
            sta.close();

        } catch (SQLException ex) {
            System.out.println("Error en sentencia UPDATE  :" + ex);
        }
        }

 public List<Proveedor> listarTodo(String num) {
        Statement sta = null;
        ResultSet rs = null;
        Connection con = getConnection();
        List<Proveedor> lista = new ArrayList<>();
        try {
            sta = con.createStatement();
               String  sql="select idProveedor,nombre from Proveedor where nombre like  '%"+num+"%'";
            
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                Proveedor p = new Proveedor();
                //p.setId(rs.getInt("idProducto"));
                p.setCodigo(rs.getInt("idProveedor"));
                p.setDescripcion(rs.getString("nombre"));
                //p.setStock(rs.getInt("Stock"));
                //p.setFechaExp(rs.getDate("FechaCaducidad"));
                //p.setPrecio(rs.getDouble("Precio"));
                //p.setFechaIn(rs.getDate("FechaIngreso"));
                lista.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Error de SQL" + ex);
        }
        return lista;
    }
}
