/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectejerciciosgenericos;

/**
 *
 * @author Profesor
 */
public abstract class Producto {
    protected int id;
    protected String nombre;
    protected double precio;
    protected static int contProductos=0;
    
    public Producto(String nombre)
    {
      this.nombre=nombre.trim().toUpperCase();
      Producto.contProductos++;
      this.id=Producto.contProductos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double getPrecio();
    
    public static int getContProductos() {
        return contProductos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.trim().toUpperCase();
    }

    @Override
    public String toString() {
        return "Producto{" + "Id=" + id + " Nombre=" + nombre + " Precio=" + precio + '}';
    }
    
    
    
}
