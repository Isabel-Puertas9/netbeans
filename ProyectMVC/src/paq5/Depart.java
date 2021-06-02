/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq5;

/**
 *
 * @author isabel
 */
public class Depart {
   private int id;
   private String nombre;

    public Depart(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "[" + "Id=" + this.id + " Nombre=" + this.nombre + ']';
    }
   
   
}
