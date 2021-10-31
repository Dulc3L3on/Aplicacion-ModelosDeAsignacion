/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulceingenio.metodohungaro.parcial3_io.InterfazManual;

import java.awt.Dimension;
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
    private int alturaContenedorAsignaciones = 550, alturaContenedorCandidatos = 550;
    
    
    public List(JPanel elContenedorListaCandidatos, JPanel elContenedorListaAsignaciones, int numColumnasIniciales, int numFilasIniciales){
        contenedorListaCandidatos = elContenedorListaCandidatos;
        contenedorListaAsignaciones = elContenedorListaAsignaciones;
        
        inicializarListas(numFilasIniciales, numColumnasIniciales);        
        inicializarContenedores();
    }
    
    private void inicializarListas(int elementosIncialesFilas, int elementosInicialesColumnas){                
            addElemento(false, elementosIncialesFilas);                        
            addElemento(true, elementosInicialesColumnas);        
    }
    
    private void inicializarContenedores(){
        actualizarElementosContenedor(true);
        actualizarElementosContenedor(false);
    }
    
    public void cambiarTamanioLista(boolean esAumento, boolean esAsignacion, int cantidadReferencia){//si es de aumento, sería el # hasta el cual debería seguirse add, y si es de elo, correspondería al númeo a partir del cual se empezaría a eli...
        if(esAumento){
           addElemento(esAsignacion, cantidadReferencia);           
        }else{
            eliminarElemento(esAsignacion, cantidadReferencia);
        }               
        
        //ajustarScrollBars(esAsignacion, esAumento);
        actualizarElementosContenedor(esAsignacion);        
        System.out.println(contenedorListaAsignaciones.getSize());
    }
    
    
    private void addElemento(boolean esAsignacion, int indiceLlegada){               
        ArrayList<ElementList> listadoAuxiliar = (esAsignacion)?listadoAsignaciones:listadoCandidatos;
        int indicePartida = 1+ ((esAsignacion)?listadoAsignaciones.size():listadoCandidatos.size());
        System.out.println(indicePartida);
        
        for (int elementoActual = indicePartida; elementoActual <= indiceLlegada; elementoActual++) {
            listadoAuxiliar.add(new ElementList((esAsignacion)?String.valueOf((char)identificadorColumnas):String.valueOf(identificadorFilas), ((esAsignacion)?"Asignación":"Candidato") + " #"+((esAsignacion)?listadoAsignaciones.size()+1:identificadorFilas)));
            
            if(esAsignacion){
                identificadorColumnas++;
            }else{
                identificadorFilas++;
            }
            
            ajustarScrollBars(esAsignacion, true);
        }
        
        System.out.println("agregación -> "+ ((esAsignacion)?listadoAsignaciones.size():listadoCandidatos.size())+"\n");
        
        
      /*UTIL pero solo para hacerlo de 1 en 1
        if(esAsignacion){                                        
            listadoAsignaciones.add(new ElementList(String.valueOf((char)identificadorColumnas), contenidoCampo));
            identificadorColumnas++;                                            
        }else{
            listadoCandidatos.add(new ElementList(String.valueOf(identificadorFilas), contenidoCampo));
            identificadorFilas++;
        }               */
    }//Terminado
    
    private void eliminarElemento(boolean esDeAsignacion, int indiceLimite){//si te da tiempo, add el parám índice, para eliminar el que corresp...
        ArrayList<ElementList> listadoAuxiliar = (esDeAsignacion)?listadoAsignaciones:listadoCandidatos;        
        int indicePartida = (esDeAsignacion)?listadoAsignaciones.size():listadoCandidatos.size();
        System.out.println(indiceLimite);
        
        while((--indicePartida)>= indiceLimite){
            listadoAuxiliar.remove(indicePartida);
            
            if(esDeAsignacion){
                identificadorColumnas--;
            }else{
                identificadorFilas--;
            }
            
            ajustarScrollBars(esDeAsignacion, false);
        }
        
        System.out.println("eliminación -> "+ ((esDeAsignacion)?listadoAsignaciones.size():listadoCandidatos.size())+"\n");
        
        /*UTIL pero solo para hacerlo de 1 en 1
        if(esDeAsignacion){
            listadoAsignaciones.remove(listadoAsignaciones.size()-1);
            
            //tendría que hacerse otro método para actualizar los elementos en el caso de la eliminación en cualquier parte, 
            //puesto que en ese método se tendría que hacer la respectiva resta del identificador de la col o fila, según corresp...            
            identificadorColumnas--;
        }else{
            listadoCandidatos.remove(listadoCandidatos.size()-1);                       
            identificadorFilas--;
        } */               
    }//Terminado
    
    private void actualizarElementosContenedor(boolean actualizarAsignaciones){
        if(actualizarAsignaciones){
            contenedorListaAsignaciones.removeAll();
            
            for (int elementoActual = 0; elementoActual < listadoAsignaciones.size(); elementoActual++) {
                ElementList elemento = listadoAsignaciones.get(elementoActual);
                contenedorListaAsignaciones.add(elemento);
                elemento.setLocation(0, contenedorListaAsignaciones.getY()+ (elemento.getHeight()*elementoActual));
                elemento.setVisible(true);
            }                                   
            
            contenedorListaAsignaciones.updateUI();
        }else{
            contenedorListaCandidatos.removeAll();
            
            for (int elementoActual = 0; elementoActual < listadoCandidatos.size(); elementoActual++) {
                ElementList elemento = listadoCandidatos.get(elementoActual);                
                contenedorListaCandidatos.add(elemento);
                elemento.setLocation(0, contenedorListaCandidatos.getY()+ (elemento.getHeight()*elementoActual));
                elemento.setVisible(true);
            }                             
            
            contenedorListaCandidatos.updateUI();
        }               
    }       
    
    private void ajustarScrollBars(boolean esAsignacion, boolean esAumento){
        if(esAsignacion){            
            if(listadoAsignaciones.size()>6){
                alturaContenedorAsignaciones += (esAumento)?+65:-65;
                contenedorListaAsignaciones.setPreferredSize(new Dimension(contenedorListaAsignaciones.getWidth(), alturaContenedorAsignaciones));
            }                      
        }else{
            if(listadoCandidatos.size()>6){
                alturaContenedorCandidatos += (esAumento)?+65:-65;
                contenedorListaCandidatos.setPreferredSize(new Dimension(contenedorListaCandidatos.getWidth(), alturaContenedorCandidatos));
            }//hay un pequeño bug con los tamaños, pero es de java :v o netbeans xD, porque tu tienes todo bien xD
        }       
    }
    
    public String[] getListadoAsignaciones(){
        String listadoNombresAsignaciones[] = new String[listadoAsignaciones.size()];
        
        for (int nombreActual = 0; nombreActual < listadoNombresAsignaciones.length; nombreActual++) {
            listadoNombresAsignaciones[nombreActual] = listadoAsignaciones.get(nombreActual).getCampoNombre();
        }
        
        return listadoNombresAsignaciones;
    }
    
    public String[] getListadoCandidatos(){
        String listadoNombresCandidatos[] = new String[listadoCandidatos.size()];
        
        for (int nombreActual = 0; nombreActual < listadoNombresCandidatos.length; nombreActual++) {
            listadoNombresCandidatos[nombreActual] = listadoCandidatos.get(nombreActual).getCampoNombre();
        }
        
        return listadoNombresCandidatos;
    }
    
}
