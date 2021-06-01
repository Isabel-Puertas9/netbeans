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
public class Generica <T extends Alimentacion> {
  public T arr[];

  public Generica(T other[]){
      this.arr=other;
  }
  
  public <T extends Fruta> boolean existeFruta(T fruta){
      boolean existe=false;
      for(Alimentacion f: this.arr){
          if (fruta.equals(f)){
              existe=true;
              break;
          }
      }
      return existe;
  }
  
}
