/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqEj2;

import java.util.Arrays;

/**
 *
 * @author Profesor
 */
public class Vector <E extends Number>{
    E e[];
    
    public Vector(E e[]){
        this.e=e;
    }

    public void set(int indice, E elemento)throws ArrayIndexOutOfBoundsException {
       if (indice <0 || indice>= e.length)
            throw new ArrayIndexOutOfBoundsException("índice fuera de límites");
        this.e[indice] = elemento;
    }
    
    public E get(int indice)throws ArrayIndexOutOfBoundsException {
       if (indice <0 || indice>= e.length)
            throw new ArrayIndexOutOfBoundsException("índice fuera de límites");
       return e[indice]; 
    }    
    
    public int elementos(){
        return this.e.length;
    }
      
    public void mostrar(){
        System.out.println("---Valores del Array---");
        for(E element: e)
            System.out.println("-"+e);
    }
    
    public E min(){
        E m=this.e[0];
        for (int i = 1; i < e.length; i++) {
            if (e[i].doubleValue() < m.doubleValue())
                m=e[i];
        }
        return m;
    }
    
     public E max(){
        E m=this.e[0];
        for (int i = 1; i < e.length; i++) {
            if (e[i].doubleValue() > m.doubleValue())
                m=e[i];
        }
        return m;
    }
     
    public boolean estaX(E elemento){
        boolean encontrado=false;
        for (int i = 0; i < this.e.length; i++) {
            if (elemento.equals(e[i])) //como se trabaja con números, tb es
                                      // válido elemento==e[i]
            {
                encontrado=true;
                break;
            }
        }
        return encontrado;
    } 
    
    public double media(){
        double suma=0.0;
        for (int i = 0; i < e.length; i++) {
            suma+=e[i].doubleValue();
        }
        return suma/e.length;
    }
    
    public boolean comparaMedia(Vector <? extends Number>  v){
        double mediaActual=media();
        double mediaOtro=v.media();
        
        if (mediaActual==mediaOtro)
            return true;
        else
            return false;
    }
    
    public void ordenarASC(){
        Arrays.sort(e);
    }
}
