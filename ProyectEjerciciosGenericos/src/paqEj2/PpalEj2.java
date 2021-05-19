/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqEj2;

/**
 *
 * @author Profesor
 */
public class PpalEj2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer numeros[]={10,11,12,13,14,15};
        
        Vector<Integer> v=new Vector<Integer>(numeros);
        
        v.set(0,20);
        v.set(1,200);
        
        Integer numeros2[]={100,110,120,130,140,150};
        Vector<Integer> v2=new Vector<Integer>(numeros2);
        
        Double numerosD1[]={100.23,110.23,120.23,130.2,140.4,150.3};
        Vector<Double> v3=new Vector<Double>(numerosD1);
        
        System.out.println("Media del array numerosD1 "+v3.media());
        System.out.println("Media del array numeros "+v.media());
        
        if (v3.comparaMedia(v)) System.out.println("Son iguales");
        System.out.println("Son distintas");
        
        
    }
    
}
