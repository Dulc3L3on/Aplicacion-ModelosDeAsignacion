/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulceingenio.metodohungaro.parcial3_io.InterfazManual;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author phily
 */
public class Table {    
    private JPanel contenedorTabla = new JPanel();
    private ArrayList<ArrayList<Cell>> listaDeListasCeldas;//aquí se add las listas de las filas
    private ArrayList<Cell> filaDeHeaders;
    private int identificadorFilas = 1;
    private int identificadorColumnas = 65;
    private int anchuraPanel = 1334, alturaPanel = 842;       
    private List listado;    
    private double elMayorDeLosDatos = 0, elMinimoDeLosDatos=0;//esto último por los números negativos...
    
    public Table(JPanel elContenedorTabla, int numFilasIniciales, int numColumnasIniciales, List laLista){//Aquí como en la lista, se inicializará la tabla; el tipo de dato de fila y columna no es ncesario colocarlo, para evitar un amontonamiento xD
        listado = laLista;
        contenedorTabla = elContenedorTabla;                
        listaDeListasCeldas = new ArrayList<>();
        
        filaDeHeaders = new ArrayList<>();
        filaDeHeaders.add(new Cell("", 3, false, null));//se add la celda donde debería aparecer el tipo de datos que habrán en la tabla xD (pero para evitar redundancia no lo hará xD)        
        
        listaDeListasCeldas.add(filaDeHeaders);//Se crear la fila en la que aparecerán los encabezados de columnas...                   
        
        inicializarTabla(numFilasIniciales, numColumnasIniciales);
        System.out.println("tabla inicializada");
    }
    
    private void inicializarTabla(int numFilasIniciales, int numColumIniciales){        
        addRow(numFilasIniciales);                      
        addColumn(numColumIniciales);        
        
        actualizarTabla();
    }
    
    public void cambiarTamanioTabla(boolean esAumentar, boolean enFilas, int numeroLimite){//el número límite corresponderá al lugar del tipo de cb...
        if(esAumentar){
            if(enFilas){
                addRow(numeroLimite);
            }else{
                addColumn(numeroLimite);
            }
        }else{
            if(enFilas){
                deleteRow(numeroLimite);
            }else{
                deleteColumn(numeroLimite);
            }
        }                       
        
        actualizarTabla();
        System.out.println("Dimensiones tabla -> " + contenedorTabla.getSize());
    }
    
    private void addRow(int indiceLlegada){            
        System.out.println("Fila nueva (#FilasAntiguas) -> "+ listaDeListasCeldas.size());
        
        do{
            ArrayList<Cell> nuevaFila = new ArrayList<>();
            //Se add el header correspondiente de la nueva fila                        
            nuevaFila.add(new Cell(String.valueOf(identificadorFilas), 1, false, new HeaderTableListener(this, listado, "fila")));        
            identificadorFilas++;
            
            for (int celdaActual = 1; celdaActual < filaDeHeaders.size(); celdaActual++) {//< porque el primer ele de la fila es para el header de la misma
                nuevaFila.add(new Cell("", 0, true, null));
            }                        
        
            listaDeListasCeldas.add(nuevaFila);                            
            activarScrollBars(true, true);
        }while(listaDeListasCeldas.size()<= indiceLlegada);//Es <= puesto que realmente se tiene una fila de más por la existencia de los encabezados de columna...
        
        System.out.println("indice llegada -> "+ indiceLlegada+"\n");                
    }//Terminado    
    
    private void addColumn(int indiceLlegada){        
        int numeroColumnasNuevas = indiceLlegada -filaDeHeaders.size()+1;        
        
        do{//se add el header correspondiente de la nueva columna                                    
            filaDeHeaders.add(new Cell(String.valueOf((char)identificadorColumnas), 2, false, new HeaderTableListener(this, listado, "columna")));
            identificadorColumnas++;
            activarScrollBars(true, false);
        }while(filaDeHeaders.size()<= indiceLlegada);//Se add el número de cols nuevas en el encabezado...        
        
        for (int filaActual = 1; filaActual < listaDeListasCeldas.size(); filaActual++) {//< porque la fila de los headers de columnas no cuenta xD
            for (int numeroColumnaACrear = 0; numeroColumnaACrear < numeroColumnasNuevas; numeroColumnaACrear++) {
                listaDeListasCeldas.get(filaActual).add(new Cell("", 0, true, null));
            }                       
        }
    }//Terminado        
    
    private void deleteRow(int indiceLimite){
        while((listaDeListasCeldas.size()-1)> indiceLimite){
            listaDeListasCeldas.remove(listaDeListasCeldas.size()-1);    
        
            identificadorFilas--;
            activarScrollBars(false, true);
        }        
    }//Terminado
    
    private void deleteColumn(int indiceLimite){          
        int numeroColumnasAEliminar = filaDeHeaders.size()-(1+indiceLimite);
        
        for (int filaActual = 0; filaActual < listaDeListasCeldas.size(); filaActual++) {
            for (int numeroColumnaAEliminar = 0; numeroColumnaAEliminar < numeroColumnasAEliminar; numeroColumnaAEliminar++) {
                listaDeListasCeldas.get(filaActual).remove(listaDeListasCeldas.get(filaActual).size()-1);            
                
                if(filaActual==0){
                    activarScrollBars(false, false);
                    identificadorColumnas--;
                }
            }                                    
        }                        
    }//Terminado
    
    public void actualizarTabla(){
        contenedorTabla.removeAll();//solo que aquí tb se remueve el viewport... por eso es que baja 104 espacios en Y... lo que debería hacerse es un contenedorTabla.getViwePort.removeAll()
        int size;
        ArrayList<Cell> listaFilaActual;
        
        for (int filaActual = 0; filaActual < listaDeListasCeldas.size(); filaActual++) {
            listaFilaActual = listaDeListasCeldas.get(filaActual);
            size = listaFilaActual.size();            
            
            for (int celdaActual = 0; celdaActual < size; celdaActual++) {
                Cell celda = listaFilaActual.get(celdaActual);
                contenedorTabla.add(celda);
                celda.setLocation(celda.getWidth()*celdaActual, /*contenedorTabla.getY()+*/(celda.getHeight()*filaActual));//el cambio de posición en Y del contenedor, es porque el viewport se eli al hacer removeALl y no getViewport.removeAll(), y eso último no lo hice porque al final de cuentas el cotenendor baja los 104 y además de eso, solo se muestra la fila más reciente .-.
                celda.setVisible(true);
                
                contenedorTabla.updateUI();
            }
        }                   
    }//Terminado
    
    private void activarScrollBars(boolean esAumento, boolean enFilas){
        if(enFilas){
            if(listaDeListasCeldas.size()>8){
                alturaPanel += (esAumento)?+100:-100;
                contenedorTabla.setPreferredSize(new Dimension(contenedorTabla.getWidth(), alturaPanel));
            }            
        }else{
            if(filaDeHeaders.size()>13){
                anchuraPanel += (esAumento)?+100:-100;
                contenedorTabla.setPreferredSize(new Dimension(anchuraPanel, contenedorTabla.getHeight()));
            }            
        }//solo no se porqué no eliminan los scroll pane cuando llegan al número corresp.. habría que comparar con lo que se hace en List xD, quizá sea por el <, o quizá sea porque ya no se pueden eliminar :o, no creo porque en el list si se pudo xD        
    }        
    
    public double[][] darInfo(){//la dará por lista, desde el primero al último ele de ella, excluyendo los headers... xD
        double matrizDatos[][] = new double[listaDeListasCeldas.size()-1][filaDeHeaders.size()-1];//puesto que lo que corresp a los headers no cuenta...                
        elMinimoDeLosDatos = 0;
        elMayorDeLosDatos = 0;
        
        try{//bien podrías haber utilizado un JFormattedTextField, pero al cb eso, debías hacer algo para que en los encabezados se admitieran strings y en las celdas de los datos solo doubles [para que así admitiera enteros y decimales [Es decir como el primer fragemento de ejemplo de chuils...]            
            ArrayList<Cell> listaFilaActual;
        
            for (int filaActual = 0; filaActual < matrizDatos.length; filaActual++) {//empieza en 1, porque la fila 0 es la de los headers...
                listaFilaActual = listaDeListasCeldas.get(filaActual+1);
            
                for (int columnaActual = 0; columnaActual < matrizDatos[0].length; columnaActual++) {//en la columna 1, porque la 0 de todas las filas de datos, tienen en esa col los headers de las filas...xD
                    matrizDatos[filaActual][columnaActual] = Double.parseDouble(listaFilaActual.get(columnaActual+1).getInfoCelda());//no habrá problema puesto que se verificará que solo puedn ingresarse números..., sino encieroo esto en un try catch y listo xD
                    elMayorDeLosDatos = (matrizDatos[filaActual][columnaActual]>elMayorDeLosDatos)?matrizDatos[filaActual][columnaActual]:elMayorDeLosDatos;//se busca el mayor, que será útil en caso de que la op sea maximiz, [hacer esto aquí ahorra tener que hacer dos for en el método de maxi de la clase MétodoHúngaro]
                    elMinimoDeLosDatos = (matrizDatos[filaActual][columnaActual]<elMinimoDeLosDatos)?matrizDatos[filaActual][columnaActual]:elMinimoDeLosDatos;
                }
            }                    
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Solo se aceptan números positivos"+((elMinimoDeLosDatos<0)?"(+)":"")+"\nenteros y con decimales", "Datos erróneos", JOptionPane.ERROR_MESSAGE);                    
            return null;
        }                
        
        if(elMinimoDeLosDatos<0){
            JOptionPane.showMessageDialog(null, "Solo se aceptan números positivos (+)", "Datos negativos", JOptionPane.ERROR_MESSAGE);
        }
        
        return matrizDatos;//hago esto porque la matriz no sería nula, puesto que ya le envié el número de espacios que debe tener...
    }//Terminado [ya revisé y pienso que sí xD]            
    
    public ArrayList<ArrayList<Cell>> getMatriz(){
        return listaDeListasCeldas;
    }
    
    public ArrayList<Cell> getHeaders(){
        return filaDeHeaders;
    }          
    
    public double getMayorDeLosDatos(){//útil para la maximiz...
        return elMayorDeLosDatos;
    }    
    
    public double getMenorDeLosDatos(){//esto por los datos negativos!!! de no permitirse agregarás un if en el método dar info que si es < 0 este dato envíe null y muestre el JOptionPane informando el hecho xD
        return elMinimoDeLosDatos;
    }
}
