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
    private int filaCoincidencia[];  
    private double[][] matrizDatosOriginal;
    private final Tools tools = new Tools();
    
    public MetodoHungaro(){}    
    
    public int[] hallarValorOptimo(boolean esMaximizacion, double[][] laMatriz, double elMayorDeLosDatos){               
        matrizDatosOriginal = tools.clonarMatriz(laMatriz);//lo que quiero es que tenga los mismos datos, no que apunte a la misma instancia...sino daría la matriz que ya tiene los ceros y eso no me sirve xD :v
        
        if(esMaximizacion){
            laMatriz = maximizar(laMatriz, elMayorDeLosDatos);//para no tener 
        }                                        
        return minimizar(revisarCondicionPrevia(laMatriz));//Se retorna el arr que contiene las ubicaciones de los 0's óptimos...
    }
    
    private double[][] maximizar(double[][] laMatriz ,double elMayorDato){
        for (int filaActual = 0; filaActual < laMatriz.length; filaActual++) {
            for (int columnaActual = 0; columnaActual < laMatriz[0].length; columnaActual++) {
                laMatriz[filaActual][columnaActual] = elMayorDato - laMatriz[filaActual][columnaActual];
            }
        }                        
        return laMatriz;//devolvería la misma instancia [por así llamarla] de la matriz origicnal pero con los datos arreglados para app la minimiz...
    }//Terminado
    
    private double[][] revisarCondicionPrevia(double[][] matrizOriginal){                
        if(matrizOriginal.length != matrizOriginal[0].length){//Es decir está desequilibrada..
            double[][] matrizEquilibrada = new double[(matrizOriginal[0].length > matrizOriginal.length)?matrizOriginal[0].length:matrizOriginal.length]//columnas > filas [tareas > candidatos] -> se add fila ficticia
                    [(matrizOriginal.length > matrizOriginal[0].length)?matrizOriginal.length:matrizOriginal[0].length];//filas > columnas [candidatos > tareas] -> se add columna ficticia
                                    
            for (int filaActual = 0; filaActual < matrizOriginal.length; filaActual++) {
                for (int columnaActual = 0; columnaActual < matrizOriginal[0].length; columnaActual++) {//puesto que la fila/col fincticia se add al final, entonces puede pasar los datos de la matriz original sin problelma, es decir solo tomando los índices de la matriz otrig xD
                    matrizEquilibrada[filaActual][columnaActual] = matrizOriginal[filaActual][columnaActual];
                }
            }                            
            return matrizEquilibrada;//en dado caso quieras tener la matriz como var globla, en este método tendrías que hacer la asig, puesto que al entrar aquí, existe la posibilidad de que las dimensiones de esta puedan cb...
        }        
        return matrizOriginal;
    }//Terminado, solo hace falta revisar si la teoría permite add más de una fila/col ficticia, para así add lo que corresponda en la interfaz apra llevar a cabo esto... sin importar se pueda o no, este código está bien--- xD       
    
    private int[] minimizar(double[][] matrizDeDatos){                               
        //Se pudo formar un solo arr con la misma cdad de cols, puesto que aquí fijo fijo la matriz está eqq (#filas==#cols)
        double[][] minimosDatos = new double[2][matrizDeDatos.length];//fila 0 -> minsFilas, fila 1 -> mins cols                
        
        for (int ubicacionActual = 0; ubicacionActual < 2; ubicacionActual++) {
            minimosDatos = hallarMinimosDatos(minimosDatos, ubicacionActual, matrizDeDatos);
            matrizDeDatos = reducir(matrizDeDatos, minimosDatos, ubicacionActual);
        }
        
        return hallarCeros(matrizDeDatos);//se devulve la matriz con los datos finales [es decir la que contiene los 0's óptimos y los demás datos no óptimos xD]     
    }//arreglado, más que todo por la reducción de las fils y cols...
    
    private double [][] hallarMinimosDatos(double[][] minimosDatos, int ubicacionDato, double[][] matrizDeDatos){//ubicadionDato es decir, fila[0] o col[1]                
        for (int filaActual = 0; filaActual < matrizDeDatos.length; filaActual++) {//esta ubicación se referirá a la fila o col actual de revisión, según corresponda al tipo de ubicacionDato que se esté revisacndo (fila/col)
            for (int columnaActual = 0; columnaActual < matrizDeDatos.length; columnaActual++) {//puesto que la matriz es cuadrada, puesde usarse de igual manera matrizDatos.lenght...                              
                minimosDatos[ubicacionDato][(ubicacionDato==0)?filaActual:columnaActual] = 
                     (((ubicacionDato==0)?columnaActual:filaActual)==0 || matrizDeDatos[filaActual][columnaActual] < minimosDatos[ubicacionDato][(ubicacionDato==0)?filaActual:columnaActual])?
                        matrizDeDatos[filaActual][columnaActual]:minimosDatos[ubicacionDato][(ubicacionDato==0)?filaActual:columnaActual];//Creo que aplica lo mismo aunque sean negativos... creo :v xD            }            
            }
        }        
        return minimosDatos;                         
    }//Terminado y arreglado, no se puede hallar los míns datos a la vez, debe ser 1ro fils y luego el de las cols...
    
    //paso 1 y 2 después del previo
    private double[][] reducir(double[][] matrizDeDatos, double[][] minimosDatos, int ubicacionDato){
        for (int filaActual = 0; filaActual < matrizDeDatos.length; filaActual++) {
            for (int columnaActual = 0; columnaActual < matrizDeDatos[0].length; columnaActual++) {
                matrizDeDatos[filaActual][columnaActual] -= minimosDatos[ubicacionDato][(ubicacionDato==0)?filaActual:columnaActual];                                
            }            
        }        
        return matrizDeDatos;
    }//Terminado y arreglado [no se puede hacer las restas de ambos tipos de minimos a la vez...
    
   /* private ArrayList<ArrayList<Integer>> getUbicacionesCeros(double[][] matrizDeDatos){
        ArrayList<ArrayList<Integer>> ubicacionDeCeros = new ArrayList<>();
        
        for (int columnaActual = 0; columnaActual < matrizDeDatos[0].length; columnaActual++) {
            ubicacionDeCeros.add(new ArrayList<>());//se add una columna...
            for (int filaActual = 0; filaActual < matrizDeDatos.length; filaActual++) {
                if(matrizDeDatos[filaActual][columnaActual]==0){
                    ubicacionDeCeros.get(columnaActual).add(filaActual);//se agrega la fila en donde se hallo el 0
                }                
            }            
        }
        return ubicacionDeCeros;
    }
    
    private void ubicarCeros(double[][] matrizDeDatos){
        filaCoincidencia = new int[matrizDeDatos.length];//cada índice es una col y el valor de cada celda la fila de coincidencia...
        
        ArrayList<ArrayList<Integer>> listadoUbicaciones = getUbicacionesCeros(matrizDeDatos);
        ArrayList<Integer> listadoAuxiliarColumna;
        
        for (int columnaActual = 0; columnaActual < listadoUbicaciones.size(); columnaActual++) {
            listadoAuxiliarColumna = listadoUbicaciones.get(columnaActual);
            
            for (int indiceCeroActual = 0; indiceCeroActual < listadoAuxiliarColumna.size(); indiceCeroActual++) {
                if(buscarCoincidencia(columnaActual, listadoAuxiliarColumna.get(indiceCeroActual), filaCoincidencia)==false){
                        filaCoincidencia[columnaActual] = listadoAuxiliarColumna.get(indiceCeroActual);
                        break;//para parar este for interno y seguir a la siguiente columna... si no funciona solo establece el valor de filaActual = al número de cols totales, para evitar entrar en el else y seguir con la sig colum xD
                }
                
            }
        }
    
    }
    
    private boolean buscarCeroAlternativo(ArrayList<ArrayList<Integer>> listadoColumnas, ArrayList<Integer> listadoFilasOptimasDeLaColumna, int columnaConProblema){        
        int columnaRevision;
        
        for (int elementoRevisionActual = 0; elementoRevisionActual < listadoFilasOptimasDeLaColumna.size(); elementoRevisionActual++) {
            columnaRevision = tools.getIndiceCoincidencia(filaCoincidencia, listadoFilasOptimasDeLaColumna.get(elementoRevisionActual));
            
            ArrayList<Integer> columnaChocante = listadoColumnas.get(columnaRevision);
            
            for (int filaCeroActual = 0; filaCeroActual < columnaChocante.size(); filaCeroActual++) {
                if(!buscarCoincidencia(columnaRevision, listadoFilasOptimasDeLaColumna.get(elementoRevisionActual), filaCoincidencia)){
                    filaCoincidencia[columnaRevision] = 
                }
                
            }
        }
        
        return false;
    }*/
    
    
    
    //paso #4
    private int[] hallarCeros(double [][] matrizDeDatos){                        
        filaCoincidencia = new int[matrizDeDatos.length];//Aquí se almacenan los números de las filas en las que se encontró 0 en cada col [las col corresp a cada índice... de esa forma se verifica si ya existe o no un 0 en esa fila, lo cual indica si existe o no algomeración...]
                                                         //la revisión se hace por columna, para así buscar con mayor facilidad la existencia de un 0 que evite la aglomeración...        
                                                               
        for (int columnaActual = 0; columnaActual < matrizDeDatos[0].length; columnaActual++) {
            for (int filaActual = 0; filaActual < matrizDeDatos.length; filaActual++) {
                if(matrizDeDatos[filaActual][columnaActual]==0 ){                                       
                   if(buscarCoincidencia(columnaActual, filaActual, filaCoincidencia)==false){
                        filaCoincidencia[columnaActual] = filaActual;
                        break;//para parar este for interno y seguir a la siguiente columna... si no funciona solo establece el valor de filaActual = al número de cols totales, para evitar entrar en el else y seguir con la sig colum xD
                    }
                }
                if(filaActual == (matrizDeDatos.length-1)){//llegar aquí indica que en ningún momneto se halló cero alguno o un cero en una fila que no estuviera regitrada                     
                    matrizDeDatos = recalcularCeros(matrizDeDatos, tacharCeros(matrizDeDatos, encontrarNumeroCerosTotales(matrizDeDatos)));//se tacha los ceros y se procede a hacer las restas y sumas con los datos no tachados y los que están en una intersección...
                    
                    if(matrizDeDatos == null){
                       return null;//puesto que el número de líneas es > "n"
                    }
                    
                    columnaActual = 0;//para reiniciar el ciclo
                }                
            }            
        }        
        //quiere decir que se llenó todo el arreglo de filas, porque no había aglomeración...        
        return filaCoincidencia;//se devuelve la matriz que contiene los ceros no aglomerados xD
    }//Terminado y arreglado, no debía ser else if, sino if, sino cuando se encoentrara cero en la última fila, auqnue existiera coincidencia [Aglomeración/repitencia] no se haría el recálculo de la matriz...
    
    private double [][] encontrarNumeroCerosTotales(double [][] matrizDeDatos){
        double cerosTotales[][] = new double[2][matrizDeDatos.length];            
        
        for (int columnaActual = 0; columnaActual < matrizDeDatos.length; columnaActual++) {//bine hubieran podido ser el for para filaActual y el for de abajo para las cols xD, pues al final se obtiene lo que se requiere y sin necesidad de cb el if y lo que contiene xD
            for (int filaActual = 0; filaActual < matrizDeDatos[0].length; filaActual++) {
                if(matrizDeDatos[filaActual][columnaActual]==0 ){
                    cerosTotales[0][filaActual]++;//se incrementaa el número en la fila corresp...
                    cerosTotales[1][columnaActual]++;//se incrementaa el número en la colum corresp...
                }   
            }            
        }
        return cerosTotales;
    }//Terminado    
    
    private boolean buscarCoincidencia(int numeroColumnaActual, int filaCoincidenciaActual, int[] filaCoincidencia){        
        for (int columnaActual = 0; columnaActual < numeroColumnaActual; columnaActual++) {//debe ser < porque cuando se estuviera revisando la col 0 [o cualquier col que no tenga asginada una fila con 0 sin aglomeración], diría que hay coincidencia cuando en realidad lo que sucede es que ese 0 se tiene porque ese valor es el dato de inicialización de los tipos de dato numérico...
            if(filaCoincidenciaActual== filaCoincidencia[columnaActual]){
                return true;
            }
        }        
        return false;
    }//Terminado y arreglado, solo se deben revisar las cols que ya tienen un val asignado, es decir las < colActual...
    
    private boolean [][] tacharCeros(double[][] matrizDatos, double [][] numeroDeCerosTotales){
        boolean[][] listadoTachones = new boolean[2][matrizDatos.length];//esto último puesto que #filas = #columnas        
        int tipoUbicacionTachon, indiceTachon;
        int numeroTachones=0;
        
        for (int filaActual = 0; filaActual < matrizDatos.length; filaActual++) {
            for (int columnaActual = 0; columnaActual < matrizDatos[0].length; columnaActual++) {
                if(matrizDatos[filaActual][columnaActual]==0){//puesto que solo se debe exe cuando el dato es 0!
                    tipoUbicacionTachon = (numeroDeCerosTotales[0][filaActual] >= numeroDeCerosTotales[1][columnaActual])?0:1;//se ubica en el tipo de lugar (fil/col) donde se hará el tachón
                    indiceTachon = (numeroDeCerosTotales[0][filaActual] >= numeroDeCerosTotales[1][columnaActual])?filaActual:columnaActual;                                
                
                    numeroTachones += (listadoTachones[tipoUbicacionTachon][indiceTachon]==false)?1:0;                
                    listadoTachones[tipoUbicacionTachon][indiceTachon] = true;                                                   
                }                
            }
        }
        return (numeroTachones<matrizDatos.length)?listadoTachones:null;
    }//Terminado
    
    private double [][] recalcularCeros(double[][] matrizDatos, boolean[][] listadoDeTachones){
        if(listadoDeTachones!= null){
            double menorDato =  hallarMenorDeNoTachados(matrizDatos, listadoDeTachones);
            
            for (int filaActual = 0; filaActual < matrizDatos.length; filaActual++) {
                for (int columnaActual = 0; columnaActual < matrizDatos[0].length; columnaActual++) {
                    if(listadoDeTachones[0][filaActual] && listadoDeTachones[1][columnaActual]){//es decir es una intersección de fila y col tachada [es decir indice de fila y columna son ambos true, dobi! xD], por lo tanto se debe sumar...
                        matrizDatos[filaActual][columnaActual]+= menorDato;
                    }
                    if(!listadoDeTachones[0][filaActual] && !listadoDeTachones[1][columnaActual]){//es decir es un dato no tachado, por lo tanto se debe restar...
                        matrizDatos[filaActual][columnaActual]-= menorDato;
                    }
                }
            }                       
        }    
        return (listadoDeTachones!=null)?matrizDatos:null;    
    }//Terminado! uwu xD
    
    private double hallarMenorDeNoTachados(double[][] matrizDatos, boolean[][] listadoDeTachones){
        double menorDato = 0, numeroElementoNoTachado =0;
        
        for (int filaActual = 0; filaActual < matrizDatos.length; filaActual++) {
            if(!listadoDeTachones[0][filaActual]){//0 porque quieres revisar los datos referentes a las filas, en el indice = al valor de la filaActual...
                for (int columnaActual = 0; columnaActual < matrizDatos[0].length; columnaActual++) {
                    if(!listadoDeTachones[1][columnaActual]){
                        numeroElementoNoTachado++;
                        
                        menorDato = ((numeroElementoNoTachado==1) || matrizDatos[filaActual][columnaActual]<menorDato)?matrizDatos[filaActual][columnaActual]:menorDato;                            
                    }                        
                }                    
            }
        }
        return menorDato;        
    }//Terminado y arreglado, la var de menor dato debe setearse con el primer valor de los datos no tachados, para proceder a comparar correctamente xD
    
    public double [][] getMatrizDatosOriginal(){
        return matrizDatosOriginal;
    }
}