/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq5;

import paq4.*;
import paq3.*;

/**
 *
 * @author isabel
 */
public class Emp {
    private int id;
    private String nombre;
    private int depart;

    public Emp(int id, String nombre, int depart) {
        this.id = id;
        this.nombre = nombre;
        this.depart=depart;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    @Override
    public String toString() {
        return "Empleado -> Identificador= " + id + "\t Nombre= " + nombre;
    }
    
    
    
}
