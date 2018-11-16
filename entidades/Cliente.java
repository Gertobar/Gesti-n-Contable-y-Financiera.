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
public class Cliente extends Persona{
 private int codigo;
 private String tipCli;
 private int persona;
 

    public Cliente() {
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipCli() {
        return tipCli;
    }

    public void setTipCli(String tipCli) {
        this.tipCli = tipCli;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", tipCli=" + tipCli + ", persona=" + persona + '}';
    }

    
 
}
