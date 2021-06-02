/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq4;

import java.util.ArrayList;
import paq3.*;

/**
 *
 * @author isabel
 */
public class Vista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      Conexion con=null;
      try{  
          con=new Conexion();
      }catch(Exception e){
          System.out.println("Error "+e.getMessage());
      }  
      
      
      if (con!=null){         
          try{
              System.out.println("LISTADO COMPLETO DE EMPLEADOS");
              ArrayList <Emp> empleados =con.listadoCompleto();
              if (empleados.isEmpty()) System.out.println("Tabla vacía");
              else{
                  for(Emp e: empleados) System.out.println(e);
              }
              
              System.out.println("EMPLEADOS CUYO NOMBRE CONTENGA 'CO'");
              empleados =con.busquedaCadenaNombre("co");
              if (empleados.isEmpty()) System.out.println("Tabla vacía");
              else{
                  for(Emp e: empleados) System.out.println(e);
              }
          
              con.close();
          }
          catch(Exception e){
              System.out.println("Error");
          }
      }
    }
    
}
