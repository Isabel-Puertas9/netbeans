/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author isabel
 */
public class ConexionMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Cargar el Driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(".... Driver cargado....");
           }catch(ClassNotFoundException ex)
           {
            System.out.println("Error, en la carga del driver "+ex.getMessage());

            }
        
        
        Connection conexion=null;
        try{
         String url="jdbc:mysql://localhost:3306/java";
         conexion=DriverManager.getConnection(url,"root","");
         System.out.println("Conexión OK...");
        }catch(SQLException ex)
        {
        System.out.println("Error, en la conexión "+ex.getMessage());
        }
        
       
        //Listado Global de la tabla departamento de la Base de Datos: java
        String select="SELECT * FROM departamento";
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            System.out.println("---- LISTADO DE DEPARTAMENTOS ----");
            while(consulta.next())
                System.out.println("- "+consulta.getInt("id")+"\t"+consulta.getString(2)+"\t"+consulta.getString(3));
            
        }
        catch(SQLException ex){
            System.out.println("Error en la instrucción select = "+select);
        }

        
       
    }
    
}
