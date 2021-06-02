/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq5;

//import paq4.*;
import java.util.ArrayList;
//import paq3.*;

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
              ArrayList <Emp> empleados =con.listadoCompletoEmple();
              if (empleados.isEmpty()) System.out.println("Tabla vacía");
              else{
                  for(Emp e: empleados) System.out.println(e);
              }
              
              
              System.out.println("EMPLEADOS CUYO NOMBRE CONTENGA 'CO'");
              empleados =con.busquedaCadenaNombreEmple("co");
              if (empleados.isEmpty()) System.out.println("Tabla vacía");
              else{
                  for(Emp e: empleados) System.out.println(e);
              }
          
              // Otra forma:
              System.out.println("EMPLEADOS CUYO NOMBRE CONTENGA 'CO'");
              empleados =con.listadoCompletoEmple();
              if (empleados.isEmpty()) System.out.println("Tabla vacía");
              else{
                  for(Emp e: empleados) 
                    if (e.getNombre().indexOf("co") !=-1)  
                        System.out.println(e);
              }
              
              
              
              
              
              System.out.println("LISTADO EMPLEADOS CON NOMBRE DE DEPARTAMENTO");
              ArrayList <DepartEmp> dempleados =con.listadoEmpleConNombreDpto();
              if (empleados.isEmpty()) System.out.println("Tabla vacía");
              else{
                  for(DepartEmp e: dempleados)
                      System.out.println(e.getIdEmp()+" "+e.getNombreEmp()+" "+e.getNombreDepart());
              }

              con.close();
          }
          catch(Exception e){
              System.out.println("Error");
          }
      }
    }
    
}
