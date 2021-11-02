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
        String[] listadoNombreCandidatos, int[] ubicacionCerosOptimos, double [][] matrizDeDatosOriginales){//recuerda que el dato almacenado en el arr ubiCerosOpt es la fila y el índice la col
            
        ArrayList<Resultado> listadoResultados = null;
        
        if(ubicacionCerosOptimos!= null){
            listadoResultados = new ArrayList<>();
            
            for (int columnaActual = 0; columnaActual < ubicacionCerosOptimos.length; columnaActual++) {
                listadoResultados.add(new Resultado((ubicacionCerosOptimos[columnaActual]<listadoNombreCandidatos.length)?listadoNombreCandidatos[ubicacionCerosOptimos[columnaActual]]:"Candidato Ficticio",
                    (columnaActual<listadoNombresAsignaciones.length)?listadoNombresAsignaciones[columnaActual]:"Tarea Ficticia",
                    (ubicacionCerosOptimos[columnaActual]<matrizDeDatosOriginales.length && columnaActual<matrizDeDatosOriginales[0].length)
                            ?matrizDeDatosOriginales[ubicacionCerosOptimos[columnaActual]][columnaActual]:0));                                
            }                        
        }                                        
        return listadoResultados;
    }
    
}
