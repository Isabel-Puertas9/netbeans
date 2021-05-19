/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqRepasoWildCard;

import java.util.ArrayList;
import proyectejerciciosgenericos.Pelicula;
import proyectejerciciosgenericos.Producto;

/**
 *
 * @author Profesor
 */
public class PpalRepaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pelicula p1=new Pelicula("ESPAÑOL", 200, "FICCION","EL SEÑOR DE LOS ANILLOS");
        Pelicula p2=new Pelicula("INGLÉS", 45, "Ficcion","The Hobbit");
        Pelicula p3=new Pelicula("INGLÉS",89,"Ficcion","Star Wars III");
        Pelicula p4=new Pelicula("ESPAÑOL",78,"COMEDIA","El discurso del Rey");
        Pelicula p5=new Pelicula("FRANCÉS", 123,"INFANTIL","Shrek");
   
        ArrayList<Pelicula> arrPelis=new ArrayList<Pelicula>();
        arrPelis.add(p5);arrPelis.add(p1);arrPelis.add(p2);
        arrPelis.add(p3); arrPelis.add(p4);
        
        Corto c=new Corto("ESPAÑOL", 20, "COMEDIA", "El corto");
        arrPelis.add(c);
        
        ArrayList<Corto> arrCortos=new ArrayList<Corto>();
        arrCortos.add(c);
        
        ArrayList<Video> arrVideo=new ArrayList<Video>();
        arrVideo.add(new Video("ESPAÑOL",3,"Documental","IES José Planes"));
        
        ArrayList<Producto> arrProductos=new ArrayList<Producto>();
        arrProductos.add(c); arrProductos.add(p1); arrProductos.add(p2);
        
        //Uso del método: listarLoQueSea
        //1. arrProductos
        System.out.println("---LISTADO DE PRODUCTOS---");
        PpalRepaso.listarLoQueSea(arrProductos);

        //2. arrPelis
        System.out.println("---LISTADO DE PELÍCULAS---");
        PpalRepaso.listarLoQueSea(arrPelis);

        //3. arrCorto
        System.out.println("---LISTADO DE CORTOS---");
        PpalRepaso.listarLoQueSea(arrCortos);
        
        //4. arrVideo
        System.out.println("---LISTADO DE VIDEOS---");
        PpalRepaso.listarLoQueSea(arrVideo);
        //5. arrObjetos
        System.out.println("---LISTADO DE OBJETOS---");
        //PpalRepaso.listarLoQueSea(arrObjetos);
        
        //Uso del método: listarJerarquia
        //1. arrProductos
        System.out.println("---LISTADO DE PRODUCTOS---");
        PpalRepaso.listarLoQueSea(arrProductos);

        //2. arrPelis
        System.out.println("---LISTADO DE PELÍCULAS---");
        PpalRepaso.listarLoQueSea(arrPelis);

        //3. arrCorto
        System.out.println("---LISTADO DE CORTOS---");
        PpalRepaso.listarLoQueSea(arrCortos);
        
        //4. arrVideo
        System.out.println("---LISTADO DE VIDEOS---");
        PpalRepaso.listarLoQueSea(arrVideo);
        
        //5. arrObjetos
        System.out.println("---LISTADO DE OBJETOS---");
        //PpalRepaso.listarLoQueSea(arrObjetos);
        
        
        PpalRepaso.aniadir(arrPelis);
        PpalRepaso.aniadir(arrProductos);
     //PpalRepaso.aniadir(arrVideo); ERROR, es un Array que está debajo de Corto
        PpalRepaso.aniadir(arrCortos);
        
    }
    
    public static void listarLoQueSea(ArrayList<?> lista){
        for(Object objeto: lista)
        {
            System.out.println("- "+objeto);
        }
    }
    
    public static void ListarJerarquia(ArrayList <? extends Producto> lista){
        for(Producto objeto: lista)
        {
            System.out.println("- "+objeto);
        }
    }
    
    public static void aniadir(ArrayList <? super Corto> lista){
        lista.add(new Video("ESPAÑOL",5,"DOCUMENTAL","IES Cervantes"));
        lista.add(new Corto("ESPAÑOL",25,"DOCUMENTAL","TURISMO EN POTES"));
        //lista.add(new Pelicula("ESPAÑOL",120,"FICCION","TODO ES MENTIRA"));
    }
}
