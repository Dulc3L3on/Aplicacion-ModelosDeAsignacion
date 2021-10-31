/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulceingenio.metodohungaro.parcial3_io.InterfazManual;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;


/**
 *
 * @author phily
 */
public class AccionesPopupMenu extends AbstractAction{
    private Table tabla;
    private List lista;
    private String tipoEncabezado;
    private String tipoAccion;
    
    public AccionesPopupMenu(Table laTabla, List laLista, String elTipoEncabezado, String tipoAccion){
        tabla = laTabla;
        lista = laLista;
        tipoEncabezado = elTipoEncabezado;
        this.putValue(Action.NAME, tipoAccion);
    }
       

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(tipoEncabezado){
            case "fila":
                if(tipoAccion.equals("Eliminar")){
                
                }else if(tipoAccion.equals("Cambiar nombre")){
                
                }else if(tipoAccion.contains("derecha")){
                
                }else{
                
                }
            break;
            default:
            break;
        }
        
    }       
    
}
