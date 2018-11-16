/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.entidades;

import java.util.Date;

/**
 *
 * @author german
 */
public class Producto {
    private  int id;
    private String codigo;
    private String detalle;
    private int stock;
    private Date FechaExp;
    private double precio;
    private Date fechaIn;
    private tipPro tiproducto;
    private Proveedor provedor;

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFechaExp() {
        return FechaExp;
    }

    public void setFechaExp(Date FechaExp) {
        this.FechaExp = FechaExp;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(Date fechaIn) {
        this.fechaIn = fechaIn;
    }

    public tipPro getTiproducto() {
        return tiproducto;
    }

    public void setTiproducto(tipPro tiproducto) {
        this.tiproducto = tiproducto;
    }

    public Proveedor getProvedor() {
        return provedor;
    }

    public void setProvedor(Proveedor provedor) {
        this.provedor = provedor;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", codigo=" + codigo + ", detalle=" + detalle + ", stock=" + stock + ", FechaExp=" + FechaExp + ", precio=" + precio + ", fechaIn=" + fechaIn + ", tiproducto=" + tiproducto + ", provedor=" + provedor + '}';
    }
    
    
    
}
