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
    
    public MetodoHungaro(){}    
    
    public double [][] hallarValorOptimo(boolean esMaximizacion, double[][] laMatriz, double elMayorDeLosDatos){               
        if(esMaximizacion){
            laMatriz = maximizar(laMatriz, elMayorDeLosDatos);//para no tener 
        }                                        
        return minimizar(revisarCondicionPrevia(laMatriz));//Se retorna la matriz que contiene además de los otros datos, los 0's óptimos...
    }
    
    private double[][] maximizar(double[][] laMatriz ,double elMayorDato){
        for (int filaActual = 0; filaActual < laMatriz.length; filaActual++) {
            for (int columnaActual = 0; columnaActual < laMatriz[0].length; columnaActual++) {
                laMatriz[filaActual][columnaActual] = elMayorDato - laMatriz[filaActual][columnaActual];
            }
        }                        
        return laMatriz;//devolvería la misma instancia [por así llamarla] de la matriz origicnal pero con los datos arreglados para app la minimiz...
    }
    
    private double[][] revisarCondicionPrevia(double[][] matrizOriginal){                
        if(matrizOriginal.length != matrizOriginal[0].length){//Es decir está desequilibrada..
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
    
    private double[][] minimizar(double[][] matrizDeDatos){                               
        return hallarCeros(restarMinimosResultado(matrizDeDatos, hallarMinimosDatos(matrizDeDatos)));//se devulve la matriz con los datos finales [es decir la que contiene los 0's óptimos y los demás datos no óptimos xD]     
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
    
    private double [][] hallarCeros(double [][] matrizDeDatos){                
        //[el proceso completo ya lo tienes en el JPanel_paso 1, solo debes implementar este método y listo uwu, podrás pasar al reporte :v xD
        filaCoincidencia = new int[matrizDeDatos.length];//Aquí se almacenan los números de las filas en las que se encontró 0, por col [que corresponde a cada índice... para así verificar si ya existe o no un 0 en esa fila...
                                                         //la revisión se hace por columna, para así buscar con mayor facilidad la existencia de un 0 que evite la aglomeración...        
                                                               
        for (int columnaActual = 0; columnaActual < matrizDeDatos[0].length; columnaActual++) {
            for (int filaActual = 0; filaActual < matrizDeDatos.length; filaActual++) {
                if(matrizDeDatos[filaActual][columnaActual]==0 ){                                       
                   if(columnaActual==0 || buscarCoincidencia(columnaActual, filaActual, filaCoincidencia)){//lo primero es para cuando se esté en la col 0, puseto que tienen como datos predefinicidos 0, si la fila de existencia en esa col fuera 0, diría que ya existía esa fila cuando en realidad no es así...
                        filaCoincidencia[columnaActual] = filaActual;
                        break;//para parar este for interno y seguir a la siguiente columna...
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
        return matrizDeDatos;//se devuelve la matriz que contiene los ceros no aglomerados xD
    }//Está bien, pero te hace falta add el método para tachar, que retornará NULL y parará el método de hallarCeros, si las líneas sobrepasasn "n"
    
    private double [][] encontrarNumeroCerosTotales(double [][] matrizDeDatos){
        double cerosTotales[][] = new double[2][matrizDeDatos.length];            
        
        for (int columnaActual = 0; columnaActual < matrizDeDatos.length; columnaActual++) {
            for (int filaActual = 0; filaActual < matrizDeDatos[0].length; filaActual++) {
                if(matrizDeDatos[filaActual][columnaActual]==0 ){
                    cerosTotales[0][filaActual]++;//se incrementaa el número en la fila corresp...
                    cerosTotales[1][columnaActual]++;//se incrementaa el número en la colum corresp...
                }   
            }            
        }
        return cerosTotales;
    }
    
    
    private boolean buscarCoincidencia(int numeroColumnaActual, int filaCoincidenciaActual, int [] filaCoincidencia){        
        for (int columnaActual = 0; columnaActual <= numeroColumnaActual; columnaActual++) {            
            if(filaCoincidenciaActual== filaCoincidencia[columnaActual]){
                return false;
            }
        }        
        return true;
    }
    
    private boolean [][] tacharCeros(double[][] matrizDatos, double [][] numeroDeCerosTotales){
        boolean[][] listadoTachones = new boolean[2][matrizDatos.length];//esto último puesto que #filas = #columnas        
        int tipoUbicacionTachon, indiceTachon;
        int numeroTachones=0;
        
        for (int filaActual = 0; filaActual < matrizDatos.length; filaActual++) {
            for (int columnaActual = 0; columnaActual < matrizDatos[0].length; columnaActual++) {
                if(matrizDatos[filaActual][columnaActual]==0){
                    tipoUbicacionTachon = (numeroDeCerosTotales[0][filaActual] >= numeroDeCerosTotales[1][columnaActual])?0:1;//se ubica en el tipo de lugar (fil/col) donde se hará el tachón
                    indiceTachon = (numeroDeCerosTotales[0][filaActual] >= numeroDeCerosTotales[1][columnaActual])?filaActual:columnaActual;                                
                
                    numeroTachones += (listadoTachones[tipoUbicacionTachon][indiceTachon]==false)?1:0;                
                    listadoTachones[tipoUbicacionTachon][indiceTachon] = true;                                                   
                }                
            }
        }
        return (numeroTachones<matrizDatos.length)?listadoTachones:null;
    }
    
    private double [][] recalcularCeros(double[][] matrizDatos, boolean[][] listadoDeTachones){
        if(listadoDeTachones!= null){
            double menorDato =  hallarMenorDato(matrizDatos, listadoDeTachones);
            
            for (int filaActual = 0; filaActual < matrizDatos.length; filaActual++) {
                for (int columnaActual = 0; columnaActual < matrizDatos[0].length; columnaActual++) {
                    if(listadoDeTachones[0][filaActual] && listadoDeTachones[1][columnaActual]){//es decir es una intersección, por lo tanto se debe sumar...
                        matrizDatos[filaActual][columnaActual]+= menorDato;
                    }
                    if(!listadoDeTachones[0][filaActual] && !listadoDeTachones[1][columnaActual]){//es decir es un dato no tachado, por lo tanto se debe restar...
                        matrizDatos[filaActual][columnaActual]-= menorDato;
                    }
                }
            }                       
        }    
        return (listadoDeTachones!=null)?matrizDatos:null;    
    }//revisar [y todos los involucrados con este método xD] pero hasta donde sé está bien xD xD
    
    private double hallarMenorDato(double[][] matrizDatos, boolean[][] listadoDeTachones){
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
    }
    
    public int[] getUbicacionCerosOptimos(){
        return filaCoincidencia;
    }
    
    
}
