/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqRepasoWildCard;

import proyectejerciciosgenericos.Pelicula;

/**
 *
 * @author Profesor
 */
public class Corto extends Pelicula{

    public Corto(String idioma, int duracion, String genero, String nombre) throws IllegalArgumentException {
        super(idioma, duracion, genero, nombre);
    }

    @Override
    public String toString() {
        return "Corto{" +super.toString()+ '}';
    }
    
    
}
