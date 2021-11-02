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
    private final String nombreDelCandidato;
    private final String nombreDeLaAsignacion;
    private final double tipoDeDato;
    
    public Resultado(String elNombreDelCandidato, String elNombreDeAsignacion, double elTipo){
        nombreDelCandidato = elNombreDelCandidato;
        nombreDeLaAsignacion = elNombreDeAsignacion;
        tipoDeDato = elTipo;
    }   

    public String getNombreDeLaAsignacion() {
        return nombreDeLaAsignacion;
    }
    
    public String getNombreDelCandidato() {
        return nombreDelCandidato;
    }
    
    public double getTipoDeDato() {
        return tipoDeDato;
    }    
}
