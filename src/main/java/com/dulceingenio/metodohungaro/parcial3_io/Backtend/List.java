/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulceingenio.metodohungaro.parcial3_io.Backtend;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author phily
 */
public class List {
    private ArrayList<ElementList> listadoCandidatos = new ArrayList<>();    
    private ArrayList<ElementList> listadoAsignaciones = new ArrayList<>();    
    private final JPanel contenedorListaCandidatos;
    private final JPanel contenedorListaAsignaciones;
    private int identificadorFilas = 1;
    private int identificadorColumnas = 65;
    
    
    public List(JPanel elContenedorListaCandidatos, JPanel elContenedorListaAsignaciones, int numColumnasIniciales, int numFilasIniciales){
        contenedorListaCandidatos = elContenedorListaCandidatos;
        contenedorListaAsignaciones = elContenedorListaAsignaciones;
        
        inicializarListas(numFilasIniciales, numColumnasIniciales);        
        inicializarContenedores();
    }
    
    private void inicializarListas(int elementosIncialesFilas, int elementosInicialesColumnas){
        
        for (int elementoActual = 1; elementoActual <= elementosIncialesFilas; elementoActual++) {
            addElemento("Candidato #" + elementoActual, false);
        }
        
        for (int elementoActual = 1; elementoActual <= elementosInicialesColumnas; elementoActual++) {
            addElemento("Asignación #" + elementoActual, true);
        }                   
    }
    
    private void inicializarContenedores(){
        actualizarElementosContenedor(true);
        actualizarElementosContenedor(false);
    }
    
    public void addElemento(String contenidoCampo, boolean esAsignacion){               
        if(esAsignacion){                                        
            listadoAsignaciones.add(new ElementList(String.valueOf((char)identificadorColumnas), contenidoCampo));
            identificadorColumnas++;                       
        }else{
            listadoCandidatos.add(new ElementList(String.valueOf(identificadorFilas), contenidoCampo));
            identificadorFilas++;
        }
    }
    
    public void actualizarElementosContenedor(boolean actualizarAsignaciones){
        if(actualizarAsignaciones){
            contenedorListaAsignaciones.removeAll();
            
            for (int elementoActual = 0; elementoActual < listadoAsignaciones.size(); elementoActual++) {
                ElementList elemento = listadoAsignaciones.get(elementoActual);
                contenedorListaAsignaciones.add(elemento);
                elemento.setLocation(0, contenedorListaAsignaciones.getY()+ (elemento.getHeight()*elementoActual));
                elemento.setVisible(true);
            }            
        }else{
            contenedorListaCandidatos.removeAll();
            
            for (int elementoActual = 0; elementoActual < listadoCandidatos.size(); elementoActual++) {
                ElementList elemento = listadoCandidatos.get(elementoActual);                
                contenedorListaCandidatos.add(elemento);
                elemento.setLocation(0, contenedorListaCandidatos.getY()+ (elemento.getHeight()*elementoActual));
            }                              
        }               
    }
    
    public void eliminarElemento(boolean esDeAsignacion){//si te da tiempo, add el parám índice, para eliminar el que corresp...
        if(esDeAsignacion){
            listadoAsignaciones.remove(listadoAsignaciones.size()-1);
            
            //tendría que hacerse otro método para actualizar los elementos en el caso de la eliminación en cualquier parte, 
            //puesto que en ese método se tendría que hacer la respectiva resta del identificador de la col o fila, según corresp...
            actualizarElementosContenedor(true);
            identificadorColumnas--;
        }else{
            listadoCandidatos.remove(listadoCandidatos.size()-1);
            
            actualizarElementosContenedor(false);
            identificadorFilas--;
        }                
    }
    
    
    
}
