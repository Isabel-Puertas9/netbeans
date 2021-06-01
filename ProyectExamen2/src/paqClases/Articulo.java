/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqClases;

import paqExcepciones.FechaCaducidadException;
import paqExcepciones.PaisFabricacionException;
import paqExcepciones.PrecioException;
import paqInterfaces.Caducable;
import paqInterfaces.Vendible;

/**
 *
 * @author Profesor
 */
public abstract class Articulo implements Vendible, Caducable{
  protected static int numArticulos;
  protected Paises pais;
  protected String codigo;
  protected String nombre;
  protected Fecha fechaCaducidad;
  protected boolean caducado;
  protected double precio;
  protected double iva;

  //c)
    public Articulo(String pais, String nombre, Fecha fechaCaducidad, double precio) throws PaisFabricacionException, PrecioException, FechaCaducidadException {
        try{       
            this.pais = Paises.valueOf(pais);
        }catch(IllegalArgumentException e){
            throw new PaisFabricacionException("País erroneo");
        }
        if (precio <=0 )
            throw new PrecioException("arg");
        
        if (!fechaCaducidad.fechaMayor(new Fecha(29,5,2021)))
            throw new FechaCaducidadException("Error, producto caducado");
        
        
        this.nombre = nombre.toUpperCase().trim();
        this.fechaCaducidad = fechaCaducidad;
        this.precio = precio;
        this.caducado=false;
        Articulo.numArticulos++;
        
        String semiNombre=nombre.substring(0,3);
        semiNombre+=pais.toString();
        semiNombre=semiNombre + this.fechaCaducidad.getAnio();
        
        int x = this.fechaCaducidad.getAnio() + this.fechaCaducidad.getMes() + Articulo.numArticulos;
        x%=20;
        
        String control;
        if (x<10) control="0"+x;
        else control=String.valueOf(x);
        
        this.codigo=semiNombre+control;
    }

    public Articulo(Paises pais, String nombre, Fecha fechaCaducidad, double precio) {
        //Incompleto
        this.pais = pais;
        this.nombre = nombre;
        this.fechaCaducidad = fechaCaducidad;
        this.precio = precio;
    }

    public static int getNumArticulos() {
        return numArticulos;
    }

    public Paises getPais() {
        return pais;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFechaCaducidad() {
        return fechaCaducidad;
    }

    public boolean isCaducado() {
        return caducado;
    }

    public double getPrecio() {
        return precio;
    }

    public double getIva() {
        return iva;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaCaducidad(Fecha fechaCaducidad) {
        //Posible excepcion
        this.fechaCaducidad = fechaCaducidad;
    }

    public void setCaducado(boolean caducado) {
        this.caducado = caducado;
    }

    public void setPrecio(double precio) {
        //posible excepcion
        this.precio = precio;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "Articulo{" + "pais=" + pais + ", codigo=" + codigo + ", nombre=" + nombre + ", fechaCaducidad=" + fechaCaducidad + ", caducado=" + caducado + ", precio=" + precio + ", iva=" + iva + '}';
    }

    //implementar el método de la interface Caducable
  @Override
    public void comprobarCaducidad(Fecha hoy){
        if (!this.fechaCaducidad.fechaMayor(hoy))
            this.caducado=false;
    }
    
    //No se implementa el método getPrecioIva
  
}
