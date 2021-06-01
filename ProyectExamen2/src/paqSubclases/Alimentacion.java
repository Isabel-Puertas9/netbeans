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

/**
 *
 * @author Profesor
 */
public abstract class Alimentacion extends Articulo implements Calorica{
   protected int calorias;

    public Alimentacion(int calorias, String pais, String nombre, Fecha fechaCaducidad, double precio) throws PaisFabricacionException, PrecioException, FechaCaducidadException {
        super(pais, nombre, fechaCaducidad, precio);
        this.calorias = calorias;
    }

    public Alimentacion(int calorias, Paises pais, String nombre, Fecha fechaCaducidad, double precio) {
        super(pais, nombre, fechaCaducidad, precio);
        this.calorias = calorias;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        //se puede controlar con excepcion
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "Alimentacion{" +super.toString()+ "calorias=" + calorias + '}';
    }
 
}
