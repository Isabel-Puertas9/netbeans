/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqEj3;

/**
 *
 * @author Profesor
 */
public interface Operable <E extends Number>  {
    public E suma(E n1, E n2);
    public E resta(E n1, E n2);
    public E producto(E n1, E n2);
    public E division(E n1, E n2);
}
