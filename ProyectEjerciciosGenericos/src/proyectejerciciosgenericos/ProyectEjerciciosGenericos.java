/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectejerciciosgenericos;

import java.util.ArrayList;

/**
 *
 * @author Profesor
 */
public class ProyectEjerciciosGenericos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pelicula p1=new Pelicula("ESPAÑOL", 200, "FICCION","EL SEÑOR DE LOS ANILLOS");
        Pelicula p2=new Pelicula("INGLÉS", 45, "Ficcion","The Hobbit");
        Pelicula p3=new Pelicula("INGLÉS",89,"Ficcion","Star Wars III");
        Pelicula p4=new Pelicula("ESPAÑOL",78,"COMEDIA","El discurso del Rey");
        Pelicula p5=new Pelicula("FRANCÉS", 123,"INFANTIL","Shrek");
        ArrayList<Producto> arrProductos=new ArrayList<Producto>();
        
        Generica<Producto> pelis=new Generica<Producto>(arrProductos);
        pelis.aniadir(p1);
        pelis.aniadir(p2);
        pelis.aniadir(p3);
        
        System.out.println("Listado de Películas---");
        Generica.listarArrayList(arrProductos);        
        
        System.out.println("Extraigo la 1ª peli: "+pelis.extraer());
        
        System.out.println("Listado de Películas de pelis---");
        pelis.mostrar();
        
        System.out.println("Listado del Array Productos---");
        Generica.listarArrayList(arrProductos);        
    }
    
}
