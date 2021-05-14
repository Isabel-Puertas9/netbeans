/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqWildCard;

import java.util.ArrayList;

/**
 *
 * @author Profesor
 */
public class DemoWildCard {
   
    public static void main(String[] args) {
       SerVivo s1=new SerVivo("Ser Vivo1");
       SerVivo s2=new SerVivo("Ser Vivo2");
       SerVivo s3=new SerVivo("Ser Vivo3");
       
       Animal a1=new Animal("Animal1");
       Animal a2=new Animal("Animal2");
       
       Gato g1=new Gato("Gato1");
       Gato g2=new Gato("Gato2");
       
       ArrayList<SerVivo> seres=new ArrayList<SerVivo>();
       ArrayList<Animal> animales=new ArrayList<Animal>();
       ArrayList<Gato> gatos=new ArrayList<Gato>();
       
       seres.add(s1);
       seres.add(a1);
       seres.add(g1);
       
       animales.add(a2);
       animales.add(g2);
        
       gatos.add(g1);
       
       System.out.println("Listado de Seres vivos---");
       /*for(SerVivo v: seres)
            System.out.println("-"+v);
       */
       DemoWildCard.listarLoQueSea(seres);
       //--------------------Con WildCard Limitado por extends
       System.out.println("Listado de Animales---");
       DemoWildCard.listaDownSerVivo(animales);
       
       System.out.println("Listado de Seres vivos---");
       DemoWildCard.listaDownSerVivo(seres);
       
        //--------------------Con WildCard Limitado por extends Animal
        System.out.println("Listado de Animales---");
        DemoWildCard.listaDownAnimal(animales);
       
        //System.out.println("Listado de Seres vivos---");
        //DemoWildCard.listaDownAnimal(seres);
        
        //--------------------Con WildCard Limitado por super
        anaidirSerVivo(seres);
        System.out.println("Lista completa de Seres Vivos");
        listaDownSerVivo(seres);
     
        System.out.println("<? super SerVivo> para aniadirUpSerVivo para seres");
        anaidirUpSerVivo(seres);
        
        System.out.println("<? super SerVivo> para aniadirUpAnimal con Object");
        ArrayList<Object> objetos=new ArrayList<Object>();
        anaidirUpSerVivo(objetos);
        listarLoQueSea(objetos);
        
       // anaidirUpSerVivo(animales);
        
       // anaidirUpSerVivo(gatos);
    }
    
    //public static <T> void listarLoQueSea(ArrayList<T> lista)
    public static void listarLoQueSea(ArrayList<?> lista)
    {
        for(Object t: lista )
            System.out.println("-"+t);
    }  
    
    public static <T extends SerVivo> void listaDownSerVivo1(ArrayList<T> lista){
        for(T v: lista)
            System.out.println("-"+v);
    }
    public static void listaDownSerVivo(ArrayList<? extends SerVivo> lista){
        for(SerVivo v: lista)
            System.out.println("-"+v);
    }        
     
    public static void listaDownAnimal(ArrayList<? extends Animal> lista){
        for(Animal v: lista)
            System.out.println("-"+v);
    }
    
    public static void anaidirSerVivo(ArrayList<SerVivo> lista){
        lista.add(new Gato("Gato3"));
        lista.add(new Animal("Animal3"));
        lista.add(new SerVivo("SerVivo4"));
    }
    
    public static void anaidirUpSerVivo(ArrayList<? super SerVivo> lista)
    {
        //solo se pueden añadir a lista Animal y Gato
        lista.add(new Gato("Gato4"));
        lista.add(new Animal("Animal4"));
        //lista.add(new SerVivo("SerVivo5"));
    }
}
