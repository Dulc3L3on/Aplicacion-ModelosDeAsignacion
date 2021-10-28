/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulceingenio.metodohungaro.parcial3_io.Backtend;

import java.util.ArrayList;
import javax.swing.JScrollPane;

/**
 *
 * @author phily
 */
public class Table {
    private final JScrollPane contenedorTabla;
    private ArrayList<ArrayList<Cell>> listaDeListasCeldas;//aquí se add las listas de las filas
    private ArrayList<Cell> filaDeHeaders;
    private int identificadorFilas = 1;
    private int identificadorColumnas = 65;
    
    public Table(JScrollPane elContenedorTabla, int numFilasIniciales, int numColumnasIniciales){//Aquí como en la lista, se inicializará la tabla; el tipo de dato de fila y columna no es ncesario colocarlo, para evitar un amontonamiento xD
        contenedorTabla = elContenedorTabla;
        listaDeListasCeldas = new ArrayList<>();
        
        filaDeHeaders = new ArrayList<>();
        filaDeHeaders.add(new Cell("", 3, false));//se add la celda donde debería aparecer el tipo de datos que habrán en la tabla xD (pero para evitar redundancia no lo hará xD)
        filaDeHeaders.get(0).desabilitarEdicion();
        
        listaDeListasCeldas.add(filaDeHeaders);//Se crear la fila en la que aparecerán los encabezados de columnas...                   
        
        inicializarTabla(numFilasIniciales, numColumnasIniciales);
        System.out.println("tabla inicializada");
    }
    
    private void inicializarTabla(int numFilasIniciales, int numColumIniciales){
        for (int filaActual = 0; filaActual < numFilasIniciales; filaActual++) {//para add las filas
            addRow();
        }
        
        for (int columnaActual = 0; columnaActual < numColumIniciales; columnaActual++) {
            addColumn();
        }
        
        actualizarTabla();
    }
    
    public void cambiarTamanioTabla(boolean esAumentar, boolean enFilas){
        if(esAumentar){
            if(enFilas){
                addRow();
            }else{
                addColumn();
            }
        }else{
            if(enFilas){
                deleteRow();
            }else{
                deleteColumn();
            }
        }               
        
        actualizarTabla();
    }
    
    private void addRow(){   
        /*Esto solo establece como "el limite" inicial de elementos, no add eleemntos a la lista [dicha add podría hacerla el método, pero no es su objetivo...]
        ArrayList<Cell> nuevaFila = new ArrayList<>(filaDeHeaders.size());//creo que sale mejor, puesto que al hacer esto se evita usar más de una vez el método get de la lista ;v xD
        listaDeListasCeldas.add(nuevaFila);        
        */
        
        ArrayList<Cell> nuevaFila = new ArrayList<>();
        //Se add el header correspondiente de la nueva fila
        nuevaFila.add(new Cell(String.valueOf(identificadorFilas), 1, false));        
        identificadorFilas++;
        
        for (int celdaActual = 1; celdaActual < filaDeHeaders.size(); celdaActual++) {//< porque el primer ele de la fila es para el header de la misma
            nuevaFila.add(new Cell("", 0, true));
        }                        
        
        listaDeListasCeldas.add(nuevaFila);        
    }    
    
    private void addColumn(){
        //se add el header correspondiente de la nueva columna
        filaDeHeaders.add(new Cell(String.valueOf((char)identificadorColumnas), 2, false));
        identificadorColumnas++;
        
        for (int filaActual = 1; filaActual < listaDeListasCeldas.size(); filaActual++) {//< porque la fila de los headers de columnas no cuenta xD
            listaDeListasCeldas.get(filaActual).add(new Cell("", 0, true));                        
        }
    }        
    
    private void deleteRow(){
        listaDeListasCeldas.remove(listaDeListasCeldas.size()-1);    
        
        identificadorFilas--;
    }
    
    private void deleteColumn(){                               
        for (int filaActual = 0; filaActual < listaDeListasCeldas.size(); filaActual++) {
            listaDeListasCeldas.get(filaActual).remove(listaDeListasCeldas.get(filaActual).size()-1);            
        }
        
        identificadorColumnas--;
    }
    
    public void actualizarTabla(){
        contenedorTabla.removeAll();
        int size;
        ArrayList<Cell> listaFilaActual;
        
        for (int filaActual = 0; filaActual < listaDeListasCeldas.size(); filaActual++) {
            listaFilaActual = listaDeListasCeldas.get(filaActual);
            size = listaFilaActual.size();            
            
            for (int celdaActual = 0; celdaActual < size; celdaActual++) {
                Cell celda = listaFilaActual.get(celdaActual);
                contenedorTabla.add(celda);
                celda.setLocation(celda.getWidth()*celdaActual, contenedorTabla.getY()+ (celda.getHeight()*filaActual));
                celda.setVisible(true);
            }
        }
        
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
