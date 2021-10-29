/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulceingenio.metodohungaro.parcial3_io.Backtend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
 *
 * @author phily
 */
public class ElementList extends JPanel{
    private JTextField campoNombre;    
    private JLabel labelIdentificador;    
    
    public ElementList(String identificador, String contenidoCampo){//la posición se establecerá afuera xD para evitar que sea una localización abs...
        prepararElemento(identificador, contenidoCampo);               
    }
    
    private void prepararElemento(String identificador, String nombreCampo){        
        this.setSize(242, 65);              
        this.setLayout(new FlowLayout(FlowLayout.LEADING,4,3));
        this.setBackground(new Color(229,230,232));
        
        labelIdentificador = new JLabel(identificador,SwingConstants.CENTER);
        labelIdentificador.setOpaque(true);
        labelIdentificador.setBackground(new Color(207,233,236));
        labelIdentificador.setBorder(BorderFactory.createLineBorder(new Color(203,247,243), 1));        
        labelIdentificador.setPreferredSize(new Dimension(35, 37));
        labelIdentificador.setFont(new Font("Ubuntu", Font.PLAIN, 18));                      
        
        campoNombre = new JTextField(nombreCampo);
        campoNombre.setPreferredSize(new Dimension(195, 37));        
        campoNombre.setFont(new Font("Ubuntu", Font.PLAIN, 18));
        
        this.add(labelIdentificador);
        this.add(campoNombre);            
    }
    
    public void resetFieldName(String newName){               
        campoNombre.setText(newName);
    }
    
    public void resetIdentificador(String nuevoIdentificador){//Este método se emplearía al tener habilitada la eli en cualquier lugar, no solo como op para la última columna... xD
        labelIdentificador.setText(nuevoIdentificador);
    }
    
    /*Útil para armar los reportes*/
    public String getCampoNombre(){
        return campoNombre.getText();
    }
    
    /*Útil para armar los reportes
      y también para la eliminación en cualquier posición, pues
      este dato se convertiría a char para restarle uno...o quizá no
      porque bien pdría hacerse que solo al llegar a un elemento después
      del de eliminación, se haga la resta respectiva*/
    public String getIdentificador(){
        return labelIdentificador.getText();
    }           
}
