/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqRepasoWildCard;

/**
 *
 * @author Profesor
 */
public class Video extends Corto{

    public Video(String idioma, int duracion, String genero, String nombre) throws IllegalArgumentException {
        super(idioma, duracion, genero, nombre);
    }

    @Override
    public String toString() {
        return "Video{" +super.toString()+ '}';
    }
    
}
