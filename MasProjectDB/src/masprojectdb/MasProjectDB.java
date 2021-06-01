/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masprojectdb;

import java.sql.*;
        
/**
 *
 * @author Profesor
 */
public class MasProjectDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connection conexion=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(".... Driver cargado....");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa","root","");
            System.out.println("conexión con éxito");    
           }
           catch(SQLException ex){
               System.out.println("No se ha podido realizar la conexión");
           }
           catch(ClassNotFoundException ex){
               System.out.println("El driver no ha podido ser cargado");
           }
        
        //Realizar un listado completo de la tabla de clientes
        // SELECT * FROM clientes
        String sql="SELECT * FROM clientes";
        try{            
            PreparedStatement sentencia=conexion.prepareStatement(sql);
            ResultSet cursor=sentencia.executeQuery();
            System.out.println("LISTADO DE CLIENTES----");
            while (cursor.next()){
                System.out.println(cursor.getInt(1)+" "+cursor.getString("nombre"));
            }
        }catch(SQLException ex){
            System.out.println("Error en la creación del select  "+sql);
        }
        
        //Diseña un método, tal que dado un cli_no
        //nos muestra el cliente con ese número
        // busquedaPrimayKey
        busquedaPrimaryKey(conexion, 108);
        
        
    }
    
    public static void busquedaPrimaryKey(Connection conexion, int numero){       
            String sql="SELECT * FROM clientes WHERE cli_no="+numero;
            try{            
                PreparedStatement sentencia=conexion.prepareStatement(sql);
                ResultSet cursor=sentencia.executeQuery();
                System.out.println("CLIENTE cuyo número de Id es : "+numero);            
                while (cursor.next()){
                    System.out.println(cursor.getInt("cli_no")+" "+cursor.getString("nombre"));
                }            
            }catch(SQLException ex){
            System.out.println("Error en la creación del select  "+sql);
            }
    }
    
    //Método estático busquedaNombre tq dada la conexion y el nombre
    // muestra todos los clientes cuyo nombre comience por lnombre
    
    
}
