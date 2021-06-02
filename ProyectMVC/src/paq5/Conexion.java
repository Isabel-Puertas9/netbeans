/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq5;

import paq4.*;
import paq3.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jmompou
 */
public class Conexion {
    private Connection conexion=null;
    
    
    public Conexion() throws Exception {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("Driver cargado.");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
            //System.out.println("Conexión exitosa..");            
        }
        catch(SQLException ex){
            throw new Exception("No se pudo realizar la conexión ");            
        }
        catch(ClassNotFoundException ex){
            throw new Exception("El Driver no se pudo cargar ....");            
        }
    }
    
    
    public void close()throws Exception{
        try{
            this.conexion.close();            
        }
        catch(SQLException ex)
        {
            throw new Exception("No se pudo cerrar la conexión");
        }
    }
      
    //1
    public ArrayList <Emp> listadoCompletoEmple()throws Exception{
        ArrayList <Emp> empleados=new ArrayList();
        String select="SELECT * FROM emp";
        try{
            PreparedStatement sentencia=this.conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            while(consulta.next())
            {
               Emp e=new Emp(consulta.getInt("id"), consulta.getString("nombre"),consulta.getInt("depart")); 
               empleados.add(e);              
            }
            
        }catch(SQLException ex){
            throw new Exception("Select mal formado : "+select);
        }
        return empleados;
    }
    
    //2
    public Emp busquedaClavePrimariaEmple(int vId) throws Exception{
       // System.out.println("BÚSQUEDA POR NÚMERO DE EMPLEADO :"+vId);
        Emp e=null;
       
        String select="SELECT * FROM emp WHERE id="+vId;
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            while(consulta.next())
            {
               e=new Emp(consulta.getInt("id"), consulta.getString("nombre"),consulta.getInt("depart"));                 
            }                    
        }catch(SQLException ex){
            throw new Exception("Select mal formado : "+select);
        }
       return e;
    }
    
    //3
    public ArrayList <Emp> busquedaCadenaNombreContengaenEmple()throws Exception{
        ArrayList <Emp> empleados=new ArrayList();
        String select="SELECT * FROM emp WHERE nombre LIKE '%en%' OR nombre LIKE '%EN%'";
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
           
            while(consulta.next())
            {
               Emp e=new Emp(consulta.getInt("id"), consulta.getString("nombre"),consulta.getInt("depart")); 
               empleados.add(e);            
            }            
        }catch(SQLException ex){
            throw new Exception("Select mal formado : "+select);            
        }
        return empleados;
    }
    
    //4
    public ArrayList <Emp> busquedaCadenaNombreEmple(String vCad) throws Exception{
    ArrayList <Emp> empleados=new ArrayList();
    //System.out.println("BÚSQUEDA POR NOMBRE DE EMPLEADO QUE CONTENGA "+vCad);
    String    select="SELECT * FROM emp WHERE nombre LIKE '%"+vCad+"%'";
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            while(consulta.next())
            {
                Emp e=new Emp(consulta.getInt("id"), consulta.getString("nombre"),consulta.getInt("depart")); 
                empleados.add(e);                
            }          
        }catch(SQLException ex){
             throw new Exception("Select mal formado : "+select);             
        }
        return empleados;
    } 
        
    //5
    public ArrayList <Emp> busquedaNombreCompletoEmple(String vCad) throws Exception{
    ArrayList <Emp> empleados=new ArrayList();
    //System.out.println("BÚSQUEDA POR NOMBRE DE EMPLEADO QUE CONTENGA "+vCad);
     String   select="SELECT * FROM emp WHERE nombre='"+vCad+"'";
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();            
            while(consulta.next())
            {
                Emp e=new Emp(consulta.getInt("id"), consulta.getString("nombre"),consulta.getInt("depart")); 
                empleados.add(e);                
            }          
        }catch(SQLException ex){
             throw new Exception("Select mal formado : "+select);             
        }
    return empleados;                   
    }   
    
    /*
    //6
    public void listadoCompletoAbajoArriba(){
     //System.out.println("LISTADO COMPLETO DE LA TABLA emp desde el final hasta el principio ");
     
      String  select="SELECT * FROM emp";
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            consulta.afterLast();
            
            while(consulta.previous())
            {
                System.out.println(consulta.getInt("id")+"\t"+consulta.getString("nombre"));
            }
           System.out.println("LISTADO COMPLETO DE LA TABLA emp desde el principio hasta el final");
           consulta.beforeFirst();
           while(consulta.next())
            {
                System.out.println(consulta.getInt("id")+"\t"+consulta.getString("nombre"));
            }
            
        }catch(SQLException ex){
            System.out.println("Select mal formado : "+select);
        }
    }
    
    //7
    public void listadoCompletoContandoFilas(){
       String select="SELECT * FROM emp";
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
    }   
    
    
    //8
    public boolean busquedaClavePrimaria2(int vId){
     System.out.println("BÚSQUEDA POR UN ID");
     boolean encontrado=false;
     String select="SELECT * FROM emp WHERE id="+vId;
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            
            consulta.last();
            int numFilas=consulta.getRow();
            if (numFilas==1)
            {    
                System.out.println(consulta.getInt("id")+"\t"+consulta.getString("nombre"));
                encontrado=true;
            }    
            else 
                System.out.println("No existe empleado con ese id");
            
        }catch(SQLException ex){
            System.out.println("Select mal formado : "+select);
        }
        return encontrado;
    } 
    
    
    //9
    public void modificacionNombrePorId(int vId, String vCad) throws Exception{
    //System.out.println("MODIFICACIÓN POR UN ID A UN NOMBRE");
        
        String update="UPDATE emp SET nombre='"+vCad+"' WHERE id="+vId;
        try{
            PreparedStatement sentencia=conexion.prepareStatement(update);
            int filas=sentencia.executeUpdate();
            
            if (filas==0)
                throw new Exception("Ese "+vId+" no existe");       
            
        }catch(SQLException ex){
            throw new Exception("Update mal formado : "+update);
        }
    }
    
    
    //10 
    public void alteracionTablaCampoDepart()throws Exception{
        //System.out.println("ALTERACIÓN DE LA TABLA emp");
        String update="ALTER TABLE emp ADD depart INT NULL";
        try{
            PreparedStatement sentencia=conexion.prepareStatement(update);            
        }catch(SQLException ex){
            throw new Exception("Update mal formado : "+update);
        }          
    } 
    */
    
    //11
    public ArrayList <Depart> listadoCompletoDepart()throws Exception{
        ArrayList <Depart> dptos=new ArrayList();
        String select="SELECT * FROM depart";
        try{
            PreparedStatement sentencia=this.conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            while(consulta.next())
            {
               Depart e=new Depart(consulta.getInt("id"), consulta.getString("nombre")); 
               dptos.add(e);              
            }
            
        }catch(SQLException ex){
            throw new Exception("Select mal formado : "+select);
        }
        return dptos;
    }
    
    //12
    public Depart busquedaClavePrimariaDepart(int vId) throws Exception{
        Depart e=null;
       
        String select="SELECT * FROM depart WHERE id="+vId;
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            while(consulta.next())
            {
               e=new Depart(consulta.getInt("id"), consulta.getString("nombre"));                 
            }                    
        }catch(SQLException ex){
            throw new Exception("Select mal formado : "+select);
        }
       return e;
    }
    
    //13
    public ArrayList <Depart> busquedaCadenaNombreContengaenDepart()throws Exception{
        ArrayList <Depart> dptos=new ArrayList();
        String select="SELECT * FROM depart WHERE nombre LIKE '%en%' OR nombre LIKE '%EN%'";
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
           
            while(consulta.next())
            {
               Depart e=new Depart(consulta.getInt("id"), consulta.getString("nombre")); 
               dptos.add(e);            
            }            
        }catch(SQLException ex){
            throw new Exception("Select mal formado : "+select);            
        }
        return dptos;
    }
    
    //14
    public ArrayList <Depart> busquedaCadenaNombreDepart(String vCad) throws Exception{
    ArrayList <Depart> dptos=new ArrayList();
    //System.out.println("BÚSQUEDA POR NOMBRE DE DEPARTAMENTO QUE CONTENGA "+vCad);
    String    select="SELECT * FROM depart WHERE nombre LIKE '%"+vCad+"%'";
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            while(consulta.next())
            {
                Depart e=new Depart(consulta.getInt("id"), consulta.getString("nombre")); 
                dptos.add(e);                
            }          
        }catch(SQLException ex){
             throw new Exception("Select mal formado : "+select);             
        }
        return dptos;
    } 
        
    //15
    public ArrayList <Depart> busquedaNombreCompletoDepart(String vCad) throws Exception{
    ArrayList <Depart> dptos=new ArrayList();
    //System.out.println("BÚSQUEDA POR NOMBRE DE DEPARTAMENTO QUE CONTENGA "+vCad);
     String   select="SELECT * FROM depart WHERE nombre='"+vCad+"'";
        try{
            PreparedStatement sentencia=conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();            
            while(consulta.next())
            {
                Depart e=new Depart(consulta.getInt("id"), consulta.getString("nombre")); 
                dptos.add(e);                
            }          
        }catch(SQLException ex){
             throw new Exception("Select mal formado : "+select);             
        }
    return dptos;                   
    }   
    
    
    //16
    public ArrayList <DepartEmp> listadoEmpleConNombreDpto()
    {
        ArrayList <DepartEmp> dptos=new ArrayList();
        String select="SELECT emp.id idEmp, emp.nombre nombreEmp, depart.id idDpto, depart.nombre nombreDpto FROM depart,emp WHERE depart.id=emp.id";
        try{
            PreparedStatement sentencia=this.conexion.prepareStatement(select);
            ResultSet consulta=sentencia.executeQuery();
            while(consulta.next())
            {
               DepartEmp e=new DepartEmp(consulta.getInt("idDpto"), consulta.getString("nombreDpto"),consulta.getInt("idEmp"), consulta.getString("nombreEmp")); 
               dptos.add(e);              
            }
            
        }catch(SQLException ex){
          //  throw new Exception("Select mal formado : "+select);
        }
        return dptos; 
    }
    
}
