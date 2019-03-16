/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.io.Serializable;

/**
 *
 * @author Gherni
 */
public class usuarios implements Serializable{
    
    private String usuario;
    private String password;
    private int security;
    private String nombre,apellido,posicion;
    public usuarios(String usuario,String password,int security,String nombre,String apellido,String posicion){
        this.usuario = usuario;
        this.password = password;
        this.security = security;
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
               
    }

    @Override
    public String toString() {
        return "usuarios{" + "usuario=" + usuario + ", password=" + password + ", security=" + security + ", nombre=" + nombre + ", apellido=" + apellido + ", posicion=" + posicion + '}';
    }

    public void setSecurity(int security) {
        this.security = security;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getSecurity() {
        return security;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }
    
}
