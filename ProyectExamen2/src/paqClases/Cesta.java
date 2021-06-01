/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqClases;

import java.util.ArrayList;
import paqSubclases.Alimentacion;
import paqSubclases.Bebida;
import paqSubclases.Bolleria;
import paqSubclases.Fruta;

/**
 *
 * @author Profesor
 */
public class Cesta {
    private ArrayList<Articulo> listaArticulos;

    public Cesta() {
        this.listaArticulos = new ArrayList<>();
    }
    
    public void addArticulo(Articulo ar){
        if (!this.listaArticulos.contains(ar))
            this.listaArticulos.add(ar);
    }
    
    //e)
    public double calculoPrecioBebidasAlcoholicas(){
        double suma=0.0;
        for(Articulo t: this.listaArticulos){
            if(t instanceof Bebida && ((Bebida)t).getGrados()>0){
                suma+=t.getPrecioIva();
            }
        }
        return suma;
    }
    
    public double calculoPrecioMedioFrutas(){
        double suma=0.0;
        int contFrutas=0;
        for(Articulo t: this.listaArticulos){
            if(t instanceof Fruta){
                suma+=t.getPrecioIva();
                contFrutas++;
            }
        }
        return suma/contFrutas;        
    }
    
    public String nombreArticuloMasCalorico(){
        Articulo arMasCalorico=null;
        int maximasCalorias=0;
        for(Articulo t: this.listaArticulos){
            if(t instanceof Bolleria){
                if (maximasCalorias < ((Bolleria) t).getCalorias()){
                    maximasCalorias=((Bolleria) t).getCalorias();
                    arMasCalorico=t;
                }
            }
        }
        
        for(Articulo t: this.listaArticulos){
            if(t instanceof Bebida){
                if (maximasCalorias < ((Bebida) t).getCalorias()){
                    maximasCalorias=((Bebida) t).getCalorias();
                    arMasCalorico=t;
                }
            }
        }

        for(Articulo t: this.listaArticulos){
            if(t instanceof Fruta){
                if (maximasCalorias < ((Fruta) t).getCalorias()){
                    maximasCalorias=((Fruta) t).getCalorias();
                    arMasCalorico=t;
                }
            }
        }
        
        return arMasCalorico.getNombre();
    }
}
