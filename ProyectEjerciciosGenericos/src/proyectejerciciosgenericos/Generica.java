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
public class Generica <T extends Producto> {
    ArrayList<T> lista;

    public Generica(ArrayList<T> lista) {
        this.lista=lista;
    }
    
    public boolean estaVacia(){
        return this.lista.isEmpty();
    }
    
    public void aniadir(T t){
        this.lista.add(t);
    }
    
    public T primero() throws IllegalArgumentException{
        if (!estaVacia())
            return this.lista.get(0);
        throw new IllegalArgumentException("Error, está vacía");
    }
    
    public T extraer()throws IllegalArgumentException{
        T pr=primero();
        this.lista.remove(0);
        return pr;
    }
    
    public void mostrar(){
        for(T p: this.lista) System.out.println("-"+p);
    }
       
    public static void listarArrayList(ArrayList<? extends Producto>  lista)
    {
        for(Producto p: lista) System.out.println("-"+p);
    }
}
