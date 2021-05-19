/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqMetodoGenerico;

import proyectejerciciosgenericos.Pelicula;
import proyectejerciciosgenericos.Producto;

/**
 *
 * @author Profesor
 */
public class NoGenerica {

    public static <T, V extends Producto> boolean estaEn(T t, V[] v){
        boolean encontrado=false;
        for(V v1: v){
            if (t.equals(v1))
            {encontrado=true; break;}
        }
        return encontrado;
    }
    
    public static void main(String[] args) {
        Pelicula p1=new Pelicula("ESPAÑOL", 200, "FICCION","EL SEÑOR DE LOS ANILLOS");
        Pelicula p2=new Pelicula("INGLÉS", 45, "Ficcion","The Hobbit");
        Pelicula p3=new Pelicula("INGLÉS",89,"Ficcion","Star Wars III");
        Pelicula p4=new Pelicula("ESPAÑOL",78,"COMEDIA","El discurso del Rey");
        Pelicula p5=new Pelicula("FRANCÉS", 123,"INFANTIL","Shrek");
   
        Producto productos[]={p1,p2,p3,p4};
        if (estaEn(p5,productos))
            System.out.println("Correcto");
        else
            System.out.println("Esa peli NO está");
        
        //Al poner el límite extends, solo permite Producto para abajo
 /*       Integer numeros[]={23,45,67,89};
        if (estaEn(2,numeros))
            System.out.println("Correcto");
        else
            System.out.println(2+" no está");
*/
    }
    
}
