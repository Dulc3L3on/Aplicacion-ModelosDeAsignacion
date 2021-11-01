/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author phily
 */
public class Resultado {
    private String nombreDelCandidato;
    private String nombreDeLaAsignacion;
    private double costo;
    
    public void setNombreDelCandidato(String nombreDelCandidato) {
        this.nombreDelCandidato = nombreDelCandidato;
    }   

    public void setNombreDeLaAsignacion(String nombreDeLaAsignacion) {
        this.nombreDeLaAsignacion = nombreDeLaAsignacion;
    }
    
    public void setCosto(double costo) {
        this.costo = costo;
    }           

    public String getNombreDeLaAsignacion() {
        return nombreDeLaAsignacion;
    }
    
    public String getNombreDelCandidato() {
        return nombreDelCandidato;
    }
    
    public double getCosto() {
        return costo;
    }    
}
