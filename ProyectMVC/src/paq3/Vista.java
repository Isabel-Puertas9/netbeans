/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq3;

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
            con.listadoCompleto();
            
            System.out.println("Empleados que contengan en el nombre 'co' ");
            con.busquedaCadenaNombre("co");
            
            con.close();
          }
          catch(Exception e){
              System.out.println("Error");
          }
      }
    }
    
}
