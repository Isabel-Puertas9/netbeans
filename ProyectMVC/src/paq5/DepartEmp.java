/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq5;

/**
 *
 * @author isabel
 */
public class DepartEmp {
    private int idDepart;
    private String nombreDepart;
    private int idEmp;
    private String nombreEmp;

    public DepartEmp(int idDepart, String nombreDepart, int idEmp, String nombreEmp) {
        this.idDepart = idDepart;
        this.nombreDepart = nombreDepart;
        this.idEmp = idEmp;
        this.nombreEmp = nombreEmp;
    }

    public int getIdDepart() {
        return idDepart;
    }

    public String getNombreDepart() {
        return nombreDepart;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    
    
}
