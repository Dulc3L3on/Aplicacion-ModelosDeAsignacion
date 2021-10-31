/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulceingenio.metodohungaro.parcial3_io.InterfazManual;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;

/**
 *
 * @author phily
 */
public class HeaderTableListener extends MouseAdapter{
    private JPopupMenu popup;    
    
    public HeaderTableListener(Table laTabla, List laLista, String elTipoEncabezado){//será mehor usar este método, para establecer el popUp hasta que tenga todo lo que requiere, o en el cnstrc, de todos modos no requerirá de la tabla y la lista hasta que se de clic derecho, y eso sería depués de terminar con el método init, en el cual ya se habrá hecho todos los establecimientos que el popUp y demás clases, requieren...
        popup = new JPopupMenu();        
         
        popup.add(new AccionesPopupMenu(laTabla, laLista, elTipoEncabezado, "Agregar a la derecha"));
        System.out.println(elTipoEncabezado);
        popup.add(new AccionesPopupMenu(laTabla, laLista, elTipoEncabezado, "Agregar a la izquierda"));
        popup.add(new AccionesPopupMenu(laTabla, laLista, elTipoEncabezado, "Eliminar"));
        popup.add(new AccionesPopupMenu(laTabla, laLista, elTipoEncabezado, "Cambiar nombre"));
    }    
    
    private void mostrarPopup(MouseEvent e){
      if (e.isPopupTrigger()) {
            popup.setLocation(e.getLocationOnScreen());
            popup.setVisible(true);            
            System.out.println("Si escucha!!!");
        }        
    }
    
    @Override
    public void mouseClicked( MouseEvent  e){
        //Aquí debería ir un if que detecte si fue hecho fuera del componente...
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        mostrarPopup(e);
    }

			

}
