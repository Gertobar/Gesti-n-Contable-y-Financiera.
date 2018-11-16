/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.entidades;

/**
 *
 * @author german
 */
public class Proveedor {
        private int codigo;
    private String descripcion;

    public Proveedor() {
    }

  

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ControladorProveedor{" + "codigo=" + codigo + ", descripcion=" + descripcion + '}';
    }
      
}
