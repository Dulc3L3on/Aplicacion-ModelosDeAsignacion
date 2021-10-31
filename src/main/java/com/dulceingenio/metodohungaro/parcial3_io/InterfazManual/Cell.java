/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulceingenio.metodohungaro.parcial3_io.InterfazManual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author phily
 */
public class Cell extends JPanel{    
    private JTextField campoTexto;
    private final int tipoCelda;//0 -> celda normal, 1 -> encabezado fila, 2-> encabezado columna, 3-> esquinaNoroeste (la que especifica el tipo de datos que se encontrará en la tabla...)    
    
    public Cell(String contenido, int elTipoCelda, boolean edicionHabilitada, HeaderTableListener elListener){
        tipoCelda = elTipoCelda;          
        
        inicializarCelda(contenido, edicionHabilitada, elListener);
    }
    
    private void inicializarCelda(String contenido, boolean edicionHabilitada, HeaderTableListener elListener){    
        this.setSize(100, 100);   
        
        
        campoTexto = new JTextField(contenido);        
        campoTexto.setBackground(new Color(229,230,232));            
        campoTexto.setPreferredSize(new Dimension(95, 95));
        campoTexto.setFont(new Font("Ubuntu", Font.PLAIN, 18));                   
        
        if(!edicionHabilitada){
            campoTexto.setEditable(false);         
            
            /*if(tipoCelda<3){//Es decir es un encabezad [con respecto al 0, no hay problema porque se hace el enío del listener cuando se están asignando dichos headers y no en el caso de las celdas normales...
                campoTexto.addMouseListener(elListener);
            }*///lo comenté mejor, porque con las axn con el spinner basta xD...
        }
        
        this.add(campoTexto);    
    }    

    public void desabilitarEdicion(){}//creo que solo sería útil si se hubiera creado el popMenu para las op de edición[add, eli, change name] de la tabla xD
        
    public String getInfoCelda(){
        return campoTexto.getText();
    }
    
    public int getTipoCelda(){
        return tipoCelda;
    }        
}
