/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqExcepciones;

/**
 *
 * @author Profesor
 */
public class PesoException extends AlimentacionException{
  //b)
    public PesoException() {
        super("El peso nunca puede ser inferior a 0");
    }

    public PesoException(String s) {
        super(s);
    }
    
}
