/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulceingenio.metodohungaro.parcial3_io.Backtend;

import java.awt.Dimension;
import java.util.ArrayList;
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
    
    public Table(JPanel elContenedorTabla, int numFilasIniciales, int numColumnasIniciales){//Aquí como en la lista, se inicializará la tabla; el tipo de dato de fila y columna no es ncesario colocarlo, para evitar un amontonamiento xD
        contenedorTabla = elContenedorTabla;                
        listaDeListasCeldas = new ArrayList<>();
        
        filaDeHeaders = new ArrayList<>();
        filaDeHeaders.add(new Cell("", 3, false));//se add la celda donde debería aparecer el tipo de datos que habrán en la tabla xD (pero para evitar redundancia no lo hará xD)        
        
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
        System.out.println("agregación (tam inicial) -> "+ listaDeListasCeldas.size());
        
        do{
            ArrayList<Cell> nuevaFila = new ArrayList<>();
            //Se add el header correspondiente de la nueva fila
            nuevaFila.add(new Cell(String.valueOf(identificadorFilas), 1, false));        
            identificadorFilas++;
            
            for (int celdaActual = 1; celdaActual < filaDeHeaders.size(); celdaActual++) {//< porque el primer ele de la fila es para el header de la misma
                nuevaFila.add(new Cell("", 0, true));
            }                        
        
            listaDeListasCeldas.add(nuevaFila);                            
            activarScrollBars(true, true);
        }while(listaDeListasCeldas.size()<= indiceLlegada);//Es <= puesto que realmente se tiene una fila de más por la existencia de los encabezados de columna...
        
        System.out.println("indice llegada -> "+ indiceLlegada+"\n");                
    }//Terminado    
    
    private void addColumn(int indiceLlegada){        
        int numeroColumnasNuevas = indiceLlegada -filaDeHeaders.size()+1;
        
        //se add el header correspondiente de la nueva columna
        do{
            filaDeHeaders.add(new Cell(String.valueOf((char)identificadorColumnas), 2, false));
            identificadorColumnas++;
            activarScrollBars(true, false);
        }while(filaDeHeaders.size()<= indiceLlegada);//Se add el número de cols nuevas en el encabezado...        
        
        for (int filaActual = 1; filaActual < listaDeListasCeldas.size(); filaActual++) {//< porque la fila de los headers de columnas no cuenta xD
            for (int numeroColumnaACrear = 0; numeroColumnaACrear < numeroColumnasNuevas; numeroColumnaACrear++) {
                listaDeListasCeldas.get(filaActual).add(new Cell("", 0, true));                 
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
    
    
    public String[][] darInfo(){//la dará por lista, desde el primero al último ele de ella, excluyendo los headers... xD
        String matrizDatos[][] = new String[listaDeListasCeldas.size()-1][filaDeHeaders.size()-1];//puesto que lo que corresp a los headers no cuenta...
        ArrayList<Cell> listaFilaActual;
        
        for (int filaActual = 0; filaActual < matrizDatos.length; filaActual++) {
            listaFilaActual = listaDeListasCeldas.get(filaActual);
            
            for (int columnaActual = 0; columnaActual < matrizDatos[0].length; columnaActual++) {
                matrizDatos[filaActual][columnaActual] = listaFilaActual.get(columnaActual).getDato();
            }
        }        
        
        return matrizDatos;
    }    
    
    //me imagino que aquí habrá que enviar los tipos de listener según el #header que sea...
}
