/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulceingenio.metodohungaro.parcial3_io.Backtend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author phily
 */
public class Cell extends JPanel{    
    private JTextField campoTexto;
    private final int tipoCelda;//0 -> celda normal, 1 -> encabezado fila, 2-> encabezado columna, 3-> esquinaNoroeste (la que especifica el tipo de datos que se encontrará en la tabla...)    
    
    public Cell(String contenido, int elTipoCelda, boolean edicionHabilitada){
        tipoCelda = elTipoCelda;               
        
        inicializarCelda(contenido, edicionHabilitada);
    }
    
    private void inicializarCelda(String contenido, boolean edicionHabilitada){              
        this.setSize(100, 100);                      
        
        campoTexto = new JTextField(contenido);        
        campoTexto.setBackground(new Color(229,230,232));            
        campoTexto.setPreferredSize(new Dimension(95, 95));
        campoTexto.setFont(new Font("Ubuntu", Font.PLAIN, 18));                  
        campoTexto.setVisible(true);
        
        if(!edicionHabilitada){
            campoTexto.setEditable(false);         
        }
        
        this.add(campoTexto);    
    }
    
    public void addListener(MouseAdapter listener){            
        this.addMouseListener(listener);
            //aquí el código para invocar al popMenu con las op corresp
            
            //si es el último entonces el menú sería diferente, pero creo que eso lo averiguarías con la tabla
            //o sería algo extra que se haría en la función del popMenu, pero aquí no creo se pueda hacer ese 
            //tipo de establecimiento        
    }
    
    public void desabilitarEdicion(){
           
    }
    
    public String getDato(){
        return campoTexto.getText();
    }
    
    public int getTipoCelda(){
        return tipoCelda;
    }        
}
