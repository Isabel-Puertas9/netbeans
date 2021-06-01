/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqSubclases;

import paqClases.Articulo;
import paqClases.Fecha;
import paqClases.Paises;
import paqExcepciones.FechaCaducidadException;
import paqExcepciones.PaisFabricacionException;
import paqExcepciones.PrecioException;
import paqInterfaces.Calorica;
import paqInterfaces.Intoxicable;

/**
 *
 * @author Profesor
 */
public class Bebida extends Articulo implements Calorica, Intoxicable{
    private int calorias, grados;
 
    //d)
    public Bebida(int calorias, int grados, String pais, String nombre, Fecha fechaCaducidad, double precio) throws PaisFabricacionException, PrecioException, FechaCaducidadException, IllegalArgumentException {
        super(pais, nombre, fechaCaducidad, precio);
        if (calorias <0)
            throw new IllegalArgumentException("Calorias negativas");
        if (grados <0)
            throw new IllegalArgumentException("Grados negativo");
        
        this.calorias = calorias;
        this.grados = grados;
        if (this.grados>7) this.iva=30;
        else this.iva=21;
    }

    public Bebida(int calorias, int grados, Paises pais, String nombre, Fecha fechaCaducidad, double precio) {
        super(pais, nombre, fechaCaducidad, precio);
        if (calorias <0)
            throw new IllegalArgumentException("Calorias negativas");
        if (grados <0)
            throw new IllegalArgumentException("Grados negativo");
        
        this.calorias = calorias;
        this.grados = grados;
        if (this.grados>7) this.iva=30;
        else this.iva=21;
    }

    public int getGrados() {
        return grados;
    }

    public void setGrados(int grados) {
        this.grados = grados;
    }

    @Override
    public String toString() {
        return "Bebida{" +super.toString()+ "calorias=" + calorias + ", grados=" + grados + '}';
    }
    
    //d)
    //Método getCalorias de Calorica
    @Override
    public int getCalorias(){
        return this.calorias;
    }
    
    //Método getPrecioIva de la interface Vendible
    @Override
    public double getPrecioIva(){
        return this.precio+ this.precio*this.iva;
    }
    
    //Método getAdvertencia de Intoxicable
    @Override
    public String getAdvertencia()
    {
        String cadena;
        if (this.grados==0) 
            cadena="Permitido para niños, debes esperar..";
        else if (this.grados<7)
            cadena="No permitido para menores de 18 años";
        else cadena="Atención!! La bebida con alcohol es dañina";
        
        return cadena;
    }
    
}
