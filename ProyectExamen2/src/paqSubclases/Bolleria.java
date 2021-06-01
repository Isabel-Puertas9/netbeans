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
public class Bolleria extends Alimentacion {

    public Bolleria(int calorias, String pais, String nombre, Fecha fechaCaducidad, double precio) throws PaisFabricacionException, PrecioException, FechaCaducidadException {
        super(calorias, pais, nombre, fechaCaducidad, precio);
        this.iva=12;
    }

    public Bolleria(int calorias, Paises pais, String nombre, Fecha fechaCaducidad, double precio) {
        super(calorias, pais, nombre, fechaCaducidad, precio);
        this.iva=12;
    }

    @Override
    public String toString() {
        return "Bolleria{" +super.toString()+ '}';
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
