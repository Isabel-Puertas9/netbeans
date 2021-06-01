/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqSubclases;

import paqClases.Fecha;
import paqClases.Paises;
import paqExcepciones.FechaCaducidadException;
import paqExcepciones.PaisFabricacionException;
import paqExcepciones.PrecioException;

/**
 *
 * @author Profesor
 */
public class Fruta extends Alimentacion{
    protected int peso;

    public Fruta(int peso, int calorias, String pais, String nombre, Fecha fechaCaducidad, double precio) throws PaisFabricacionException, PrecioException, FechaCaducidadException {
        super(calorias, pais, nombre, fechaCaducidad, precio);
        //posible exception
        this.peso = peso;
        this.iva=4;
    }

    public Fruta(int peso, int calorias, Paises pais, String nombre, Fecha fechaCaducidad, double precio) {
        super(calorias, pais, nombre, fechaCaducidad, precio);
        //posible exception para el peso
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        //posible excepcion
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Fruta{" +super.toString()+ "peso=" + peso + '}';
    }
    
    
    //Método getPrecioIva de la interface Vendible
    @Override
    public double getPrecioIva(){
        return this.precio+ this.precio*this.iva;
    }
    
    //Método getCalorias de Calorica
    @Override
    public int getCalorias(){
        return this.calorias;
    }
}
