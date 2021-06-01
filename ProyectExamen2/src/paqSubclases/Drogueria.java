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
import paqInterfaces.Intoxicable;

/**
 *
 * @author Profesor
 */
public class Drogueria extends Articulo implements Intoxicable{

    public Drogueria(String pais, String nombre, Fecha fechaCaducidad, double precio) throws PaisFabricacionException, PrecioException, FechaCaducidadException {
        super(pais, nombre, fechaCaducidad, precio);
        this.iva=21;
    }

    public Drogueria(Paises pais, String nombre, Fecha fechaCaducidad, double precio) {
        super(pais, nombre, fechaCaducidad, precio);
        this.iva=21;
    }

    @Override
    public String toString() {
        return "Drogueria{" +super.toString()+ '}';
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
        return "Si ha bebido, llame al teléfono a EMERGENCIAS";
    }
    
}
