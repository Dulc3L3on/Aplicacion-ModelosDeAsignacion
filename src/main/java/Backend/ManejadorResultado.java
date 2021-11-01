/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.ArrayList;

/**
 *
 * @author phily
 */
public class ManejadorResultado {   
    
    public ArrayList<Resultado> formarListaDeResultados(String[] listadoNombresAsignaciones, 
        String[] listadoNombreCandidatos, double [][] matrizDeDatosFinales, int[] ubicacionCerosOptimos){
            
        ArrayList<Resultado> listadoResultados = null;
        
        if(matrizDeDatosFinales!= null){
            listadoResultados = new ArrayList<>();
            
            //Aquí la lógica para incorporar los datos a la lista de resultados...
        }                                        
        return listadoResultados;
    }
    
}
