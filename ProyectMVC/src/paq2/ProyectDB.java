/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jmompou
 */
public class ProyectDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Connection conexion=null;
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           System.out.println("Driver cargado...");
           String url="jdbc:mysql://localhost:3306/java";
           conexion=DriverManager.getConnection(url, "root","");
           System.out.println("Conexión OK...");
       }
      catch(SQLException ex){
           System.out.println("No se ha podido realizar la conexión ");
          // return;
      }
      catch(ClassNotFoundException ex){
           System.out.println("No se pudo cargar el Driver...");
          // return;
      }
       
       
       //1 LISTADO COMPLETO DE LA TABLA emp
        System.out.println("LISTADO COMPLETO DE LA TABLA emp");
        String select="SELECT * FROM emp";
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            while(consulta.next())
            {
                System.out.println(consulta.getInt("id")+"\t"+consulta.getString("nombre"));
            }
            
        }catch(SQLException ex){
            System.out.println("Select mal formado : "+select);
        }
        
        //2 BÚSQUEDA POR CLAVE PRIMARIA
        int vId=1;
        System.out.println("BÚSQUEDA POR NÚMERO DE EMPLEADO :"+vId);
        select="SELECT * FROM emp WHERE id="+vId;
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            while(consulta.next())
            {
                System.out.println(consulta.getInt("id")+"\t"+consulta.getString("nombre"));
            }
            
        }catch(SQLException ex){
            System.out.println("Select mal formado : "+select);
        }
        
        
        //3 BÚSQUEDA POR NOMBRE, LOS QUE CONTENGAN 'AN' o 'CK'
        System.out.println("BÚSQUEDA POR NOMBRE DE EMPLEADO QUE CONTENGA 'CK' o 'AN'");
        select="SELECT * FROM emp WHERE nombre LIKE '%CK%' OR nombre LIKE '%AN%'";
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            while(consulta.next())
            {
                System.out.println(consulta.getInt("id")+"\t"+consulta.getString("nombre"));
            }
            
        }catch(SQLException ex){
            System.out.println("Select mal formado : "+select);
        }
        
        
        //4 BÚSQUEDA POR NOMBRE, LOS QUE CONTENGAN EL VALOR DE UNA CADENA
        String vCad="KO";
        System.out.println("BÚSQUEDA POR NOMBRE DE EMPLEADO QUE CONTENGA "+vCad);
        select="SELECT * FROM emp WHERE nombre LIKE '%"+vCad+"%'"; 
        //System.out.println(select);
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            while(consulta.next())
            {
                System.out.println(consulta.getInt("id")+"\t"+consulta.getString("nombre"));
            }
            
        }catch(SQLException ex){
            System.out.println("Select mal formado : "+select);
        }
        
        
        //5.BÚSQUEDA POR NOMBRE COMPLETO
        vCad="Nickol Nickolita";
        System.out.println("BÚSQUEDA POR NOMBRE DE EMPLEADO QUE SEA "+vCad);
        select="SELECT * FROM emp WHERE nombre='"+vCad+"'";
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();            
            while(consulta.next())
            {
                System.out.println(consulta.getInt("id")+"\t"+consulta.getString("nombre"));
            }
            
        }catch(SQLException ex){
            System.out.println("Select mal formado : "+select);
        }
        
        
        //6 LISTADO COMPLETO DE LA TABLA emp, utilizando previous
        System.out.println("LISTADO COMPLETO DE LA TABLA emp desde el final hasta el principio ");
        select="SELECT * FROM emp";
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
                      
            while(consulta.next())
            {
                System.out.println(consulta.getInt("id")+"\t"+consulta.getString("nombre"));
            }
            
            
           System.out.println("LISTADO COMPLETO DE LA TABLA emp ");
           consulta.beforeFirst();
           while(consulta.next())
            {
                System.out.println(consulta.getInt("id")+"\t"+consulta.getString("nombre"));
            }
            
        }catch(SQLException ex){
            System.out.println("Select mal formado : "+select);
        }
        
        /*
        //7 LISTADO COMPLETO DE LA TABLA emp. OTRA FORMA
        System.out.println("LISTADO COMPLETO DE LA TABLA ");
        select="SELECT * FROM emp";
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            
            consulta.last();
            int numFilas=consulta.getRow();
            System.out.println("Número de Filas ="+numFilas);
            consulta.beforeFirst();
            for(int fila=1;fila<=numFilas;fila++)
            {
                consulta.next();
                System.out.println(consulta.getInt("id")+"\t"+consulta.getString("nombre"));
            }
            
        }catch(SQLException ex){
            System.out.println("Select mal formado : "+select);
        }
        
        //8. BÚSQUEDA POR CLAVE PRIMARIA
        System.out.println("BÚSQUEDA POR UN ID");
        vId=1;
        select="SELECT * FROM emp WHERE id="+vId;
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            
            consulta.last();
            int numFilas=consulta.getRow();
            if (numFilas==1)
                System.out.println(consulta.getInt("id")+"\t"+consulta.getString("nombre"));
            else 
                System.out.println("No existe empleado con ese id");
            
        }catch(SQLException ex){
            System.out.println("Select mal formado : "+select);
        }
        
        */
        //9 MODIFICACIÓN DE UN NOMBRE, con id=3 se cambia a NOMBRE=JORGE GÓMEZ
        System.out.println("MODIFICACIÓN POR UN ID A UN NOMBRE");
        vId=3; 
        vCad="JORGE GÓMEZ";
        
        String update="UPDATE emp SET nombre='"+vCad+"' WHERE id="+vId;
        try{
            PreparedStatement sentencia=conexion.prepareStatement(update);
            int filas=sentencia.executeUpdate();
            
            if (filas==1)
                System.out.println("Modificación realizada con éxito");
            else 
                System.out.println("Error, ese id no existe");           
            
        }catch(SQLException ex){
            System.out.println("Update mal formado : "+update);
        }
        
        //10 Añadir un campo a la tabla emp        
        System.out.println("ALTERACIÓN DE LA TABLA emp");
        update="ALTER TABLE emp ADD domicilio VARCHAR(20) NULL";
        try{
            PreparedStatement sentencia=conexion.prepareStatement(update);  
            int numFilas=sentencia.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Update mal formado : "+update);
        }
        
        
        try{
            conexion.close();
            System.out.println("Conexión cerrada");
        }
        catch(SQLException ex){
            System.out.println("Error al cerrar la conexión");
        }
        
    }
    
}
