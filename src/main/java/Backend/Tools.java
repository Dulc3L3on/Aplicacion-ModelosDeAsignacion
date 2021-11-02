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
public class Tools{
    
    public double[][] clonarMatriz(double[][]matrizAClonar){
        double[][] matriz = new double[matrizAClonar.length][];
    
        for (int filaActual = 0; filaActual < matrizAClonar.length; filaActual++) {
            matriz[filaActual] = matrizAClonar[filaActual].clone();
        }
        return matriz;
    }
    
    public int getIndiceCoincidencia(int[] listadoFilasCoincidencia, int dato){
        for (int indiceActual = 0; indiceActual < listadoFilasCoincidencia.length; indiceActual++) {
            if(listadoFilasCoincidencia[indiceActual] == dato){
                return indiceActual;            
            }
        }
        return -1;//pero como yo soy quine manda los datos, siempre devovlerá el indice en el que se encuentra el elemento...
    }
    
}
