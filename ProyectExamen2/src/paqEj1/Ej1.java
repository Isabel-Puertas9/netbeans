/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqEj1;

import java.util.Scanner;

/**
 *
 * @author Profesor
 */
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String meses[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Septiembre"};
        int v[]=new int[7];
        Scanner teclado=new Scanner(System.in);
        String cadena;
        
        //a) Introdución de los goles por meses
        System.out.println("INTRODUCCIÓN DE GOLES");
        for (int i = 0; i < v.length; i++) {
            System.out.print("Dime el número de goles en el mes de "+meses[i]+" =");
            cadena=teclado.nextLine();
            v[i]=Integer.parseInt(cadena);
        }
        
        //b
        int maximo=v[0];
        for (int i = 0; i < v.length; i++) {
            if (maximo < v[i]){
                maximo=v[i];
            }
        }
        
        System.out.println("Máximo número de goles ="+maximo);
        for (int i = 0; i < v.length; i++) {
            if (v[i]==maximo){
                System.out.println("En el mes "+meses[i]);
            }
        }
    }
    
}
