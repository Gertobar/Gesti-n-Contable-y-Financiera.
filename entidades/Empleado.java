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
public class Empleado extends Persona  {
    private int codigo;
    private String Usuario;
    private String Contrasenha;
    private Date fechain;
    private Date fechafin;
    private int persona;
    Cargo Cargo;

    public Empleado() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasenha() {
        return Contrasenha;
    }

    public void setContrasenha(String Contrasenha) {
        this.Contrasenha = Contrasenha;
    }

    public Date getFechain() {
        return fechain;
    }

    public void setFechain(Date fechain) {
        this.fechain = fechain;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    public Cargo getCargo() {
        return Cargo;
    }

    public void setCargo(Cargo Cargo) {
        this.Cargo = Cargo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "codigo=" + codigo + ", Usuario=" + Usuario + ", Contrasenha=" + Contrasenha + ", fechain=" + fechain + ", fechafin=" + fechafin + ", persona=" + persona + ", Cargo=" + Cargo + '}';
    }
   

     
}
