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
public class MetodoHungaro {    
    
    public MetodoHungaro(){}
        
    public void setListadosTipoDatos(String[] listadoNombresAsignaciones, String[] listadoNombreCandidatos){
    
    }
    
    public ArrayList<Resultado> hallarValorOptimo(boolean esMaximizacion, double[][] laMatriz, double elMayorDeLosDatos){               
        if(esMaximizacion){
            laMatriz = maximizar(laMatriz, elMayorDeLosDatos);//para no tener 
        }                                
        //Se va a retornar el listado que devolverá el método formarListaDeResultados y minimizar se colocará en el espacio donde se debe colocar el parám de los resultados numéricos [costos]
        return minimizar(revisarCondicionPrevia(laMatriz));                
    }
    
    private double[][] revisarCondicionPrevia(double[][] matrizOriginal){                
        if(matrizOriginal.length != matrizOriginal[0].length){
            double[][] matrizEquilibrada = new double[(matrizOriginal[0].length > matrizOriginal.length)?matrizOriginal.length+1:matrizOriginal.length]//columnas > filas [tareas > candidatos] -> se add fila ficticia
                    [(matrizOriginal.length > matrizOriginal[0].length)?matrizOriginal[0].length+1:matrizOriginal[0].length];//filas > columnas [candidatos > tareas] -> se add columna ficticia
                                    
            for (int filaActual = 0; filaActual < matrizOriginal.length; filaActual++) {
                for (int columnaActual = 0; columnaActual < matrizOriginal[0].length; columnaActual++) {//puesto que la fila/col fincticia se add al final, entonces puede pasar los datos de la matriz original sin problelma, es decir solo tomando los índices de la matriz otrig xD
                    matrizEquilibrada[filaActual][columnaActual] = matrizOriginal[filaActual][columnaActual];
                }
            }                            
            return matrizEquilibrada;
        }
        
        return matrizOriginal;
    }
    
    private double[][] maximizar(double[][] laMatriz ,double elMayorDato){
        for (int filaActual = 0; filaActual < laMatriz.length; filaActual++) {
            for (int columnaActual = 0; columnaActual < laMatriz[0].length; columnaActual++) {
                laMatriz[filaActual][columnaActual] = elMayorDato - laMatriz[filaActual][columnaActual];
            }
        }                
        
        return laMatriz;//devolvería la misma instancia [por así llamarla] de la matriz origicnal pero con los datos arreglados para app la minimiz...
    }
    
    private ArrayList<Resultado> minimizar(double[][] matrizDeDatos){                               
        return hallarCeros(restarMinimosResultado(matrizDeDatos, hallarMinimosDatos(matrizDeDatos)));
        
    }    
    
    private double [][] hallarMinimosDatos(double[][] matrizDeDatos){
        //Se pudo formar un solo arr con la misma cdad de cols, puesto que aquí fijo fijo la matriz está eqq (#filas==#cols)
        double[][] minimosDatos = new double[2][matrizDeDatos.length];//fila 0 -> minsFilas, fila 1 -> mins cols                
        
        for (int filaActual = 0; filaActual < matrizDeDatos.length; filaActual++) {
            for (int columnaActual = 0; columnaActual < matrizDeDatos[0].length; columnaActual++) {
                //se setea el minimo dato de cada fila [cada segundo índice[][*], rep una fila
                minimosDatos[0][filaActual] = (matrizDeDatos[filaActual][columnaActual] < minimosDatos[0][filaActual])?matrizDeDatos[filaActual][columnaActual]:minimosDatos[0][filaActual];//Creo que aplica lo mismo aunque sean negativos... creo :v xD
                //se setea el mínimo dato de cada columna [cada segundo índice[][*] re una col
                minimosDatos[1][columnaActual] = (matrizDeDatos[filaActual][columnaActual] < minimosDatos[1][columnaActual])?matrizDeDatos[filaActual][columnaActual]:minimosDatos[1][columnaActual];
            }            
        }        
        return minimosDatos;        
    }
    
    //paso 1 y 2 después del previo
    private double[][] restarMinimosResultado(double[][] matrizDeDatos, double[][] minimosDatos){
        for (int filaActual = 0; filaActual < matrizDeDatos.length; filaActual++) {
            for (int columnaActual = 0; columnaActual < matrizDeDatos[0].length; columnaActual++) {
                matrizDeDatos[filaActual][columnaActual] = matrizDeDatos[filaActual][columnaActual] - minimosDatos[0][filaActual] - minimosDatos[1][columnaActual];
                System.out.println("resta forma 1: "+ (matrizDeDatos[filaActual][columnaActual] = matrizDeDatos[filaActual][columnaActual] - minimosDatos[0][filaActual] - minimosDatos[1][columnaActual]));
                System.out.println("resta forma 2: "+ (matrizDeDatos[filaActual][columnaActual] -= (minimosDatos[0][filaActual] + minimosDatos[1][columnaActual])));    
            }            
        }
        
        return matrizDeDatos;
    }
    
    private ArrayList<Resultado> hallarCeros(double [][] matrizDeDatos){        
        //Si en la iteración actual sobrepasa esto, ahí será donde devolverás NULL y por ello el msje de imposible calcular que mostrará la instancia del manejador de Reportes
        //[el proceso completo ya lo tienes en el JPanel_paso 1, solo debes implementar este método y listo uwu, podrás pasar al reporte :v xD
        int filaCoincidencia[] = new int[matrizDeDatos.length];//Aquí se almacenan los números de las filas en las que se encontró 0, por col [que corresponde a cada índice... para así verificar si ya existe o no un 0 en esa fila...
                                                               //la revisión se hace por columna, para así buscar con mayor facilidad la existencia de un 0 que evite la aglomeración...
        for (int columnaActual = 0; columnaActual < matrizDeDatos[0].length; columnaActual++) {
            for (int filaActual = 0; filaActual < matrizDeDatos.length; filaActual++) {
                if((matrizDeDatos[filaActual][columnaActual]==0 && columnaActual==0) || (matrizDeDatos[filaActual][columnaActual]==0 && buscarCoincidencia(columnaActual, filaActual, filaCoincidencia))){//lo primero es para cuando se esté en la col 0, puseto que tienen como datos predefinicidos 0, si la fila de existencia en esa col fuera 0, diría que ya existía esa fila cuando en realidad no es así...
                    filaCoincidencia[columnaActual] = filaActual;
                    break;//para parar este for interno y seguir a la siguiente columna...
                }
                if(filaActual == (matrizDeDatos.length-1)){
                    //Se manda a llamar al método para tachar los ceros... puesto que el llegar aquí indica que en ningún momneto se halló cero alguno o un cero en una fila que no estuviera regitrada 
                    //se exe tb el método que hace la resta y sumas respectivas
                    
                    columnaActual = 0;//para reiniciar el ciclo
                }                
            }            
        }
        
        //quiere decir que se llenó todo el arreglo de filas, porque no había aglomeración...
        //se llama a método para formar el resultado
        return null;//Se retonra el resultado...
    }//Está bien, pero te hace falta add el método para tachar, que retornará NULL y parará el método de hallarCeros, si las líneas sobrepasasn "n"
    
    
    
    private boolean buscarCoincidencia(int numeroColumnaActual, int filaCoincidenciaActual, int [] filaCoincidencia){        
        for (int columnaActual = 0; columnaActual <= numeroColumnaActual; columnaActual++) {            
            if(filaCoincidenciaActual== filaCoincidencia[columnaActual]){
                return false;
            }
        }        
        return true;
    }
    
    private void tacharCeros(double[][] matrizDatos){
        boolean[][] listadoTchones = new boolean[2][matrizDatos.length];//esto último puesto que #filas = #columnas
        
    }
    
    private ArrayList<Resultado> formarListaDeResultados(String[] listadoNombresAsignaciones, String[] listadoNombreCandidatos){
        ArrayList<Resultado> listadoResultados;
        
        
        return null;
    }
}
