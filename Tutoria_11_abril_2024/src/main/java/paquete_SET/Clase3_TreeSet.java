/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paquete_SET;


import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author isabel
 */
public class Clase3_TreeSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //--SET NO permite valores repetidos
        
        //TreeSet Ordena por orden natural - Integer, String, Double, Char, Float...
        TreeSet <Integer>numeros=new TreeSet<Integer>();
        numeros.add(23);
        numeros.add(89);
        numeros.add(23);
        numeros.add(45);
        numeros.add(39);
        
        System.out.println("PRIMER LISTADO--");
        for(Integer n: numeros){
            System.out.println(n);
        }
        
     
        System.out.println("SEGUNDO LISTADO ---");
        Iterator <Integer> i= numeros.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        } 
        
      
    }
    
}