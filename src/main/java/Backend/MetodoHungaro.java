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
public class MetodoHungaro {   
    private int filaCoincidencia[];  
    private double[][] matrizDatosOriginal;
    
    public MetodoHungaro(){}    
    
    public int[] hallarValorOptimo(boolean esMaximizacion, double[][] laMatriz, double elMayorDeLosDatos){               
        matrizDatosOriginal = laMatriz;
        
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
        return hallarCeros(reducirRenglonYColumna(matrizDeDatos, hallarMinimosDatos(matrizDeDatos)));//se devulve la matriz con los datos finales [es decir la que contiene los 0's óptimos y los demás datos no óptimos xD]     
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
    }//Terminado
    
    //paso 1 y 2 después del previo
    private double[][] reducirRenglonYColumna(double[][] matrizDeDatos, double[][] minimosDatos){
        for (int filaActual = 0; filaActual < matrizDeDatos.length; filaActual++) {
            for (int columnaActual = 0; columnaActual < matrizDeDatos[0].length; columnaActual++) {
                matrizDeDatos[filaActual][columnaActual] = matrizDeDatos[filaActual][columnaActual] - minimosDatos[0][filaActual] - minimosDatos[1][columnaActual];
                System.out.println("resta forma 1: "+ (matrizDeDatos[filaActual][columnaActual] = matrizDeDatos[filaActual][columnaActual] - minimosDatos[0][filaActual] - minimosDatos[1][columnaActual]));
                System.out.println("resta forma 2: "+ (matrizDeDatos[filaActual][columnaActual] -= (minimosDatos[0][filaActual] + minimosDatos[1][columnaActual])));    
            }            
        }        
        return matrizDeDatos;
    }//Terminado

    //paso #4
    private int[] hallarCeros(double [][] matrizDeDatos){                        
        filaCoincidencia = new int[matrizDeDatos.length];//Aquí se almacenan los números de las filas en las que se encontró 0 en cada col [las col corresp a cada índice... de esa forma se verifica si ya existe o no un 0 en esa fila, lo cual indica si existe o no algomeración...]
                                                         //la revisión se hace por columna, para así buscar con mayor facilidad la existencia de un 0 que evite la aglomeración...        
                                                               
        for (int columnaActual = 0; columnaActual < matrizDeDatos[0].length; columnaActual++) {
            for (int filaActual = 0; filaActual < matrizDeDatos.length; filaActual++) {
                if(matrizDeDatos[filaActual][columnaActual]==0 ){                                       
                   if(columnaActual==0 || buscarCoincidencia(columnaActual, filaActual, filaCoincidencia)){//lo primero es para cuando se esté en la col 0, puseto que tienen como datos predefinicidos 0, si la fila de existencia en esa col fuera 0, diría que ya existía esa fila cuando en realidad no es así...
                        filaCoincidencia[columnaActual] = filaActual;
                        break;//para parar este for interno y seguir a la siguiente columna... si no funciona solo establece el valor de filaActual = al número de cols totales, para evitar entrar en el else y seguir con la sig colum xD
                    }
                }else if(filaActual == (matrizDeDatos.length-1)){//llegar aquí indica que en ningún momneto se halló cero alguno o un cero en una fila que no estuviera regitrada                     
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
    }
    
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
        for (int columnaActual = 0; columnaActual <= numeroColumnaActual; columnaActual++) {            
            if(filaCoincidenciaActual== filaCoincidencia[columnaActual]){
                return false;
            }
        }        
        return true;
    }//Terminado
    
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
        double menorDato=0;
        
        for (int filaActual = 0; filaActual < matrizDatos.length; filaActual++) {
            if(!listadoDeTachones[0][filaActual]){//0 porque quieres revisar los datos referentes a las filas, en el indice = al valor de la filaActual...
                for (int columnaActual = 0; columnaActual < matrizDatos[0].length; columnaActual++) {
                    if(!listadoDeTachones[1][columnaActual]){
                        menorDato = (matrizDatos[filaActual][columnaActual]<menorDato)?matrizDatos[filaActual][columnaActual]:menorDato;                            
                    }                        
                }                    
            }
        }
        return menorDato;        
    }//Terminado    
    
    public double [][] getMatrizDatosOriginal(){
        return matrizDatosOriginal;
    }
}