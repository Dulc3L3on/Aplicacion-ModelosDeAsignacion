/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author phily
 */
public class ManejadorReporte {
    //Creo que tendŕia que tener el panel en donde se va a previsualizar el reporte [claro si no resulta muy complicado :v xD]
    
    public void mostrarReporte(String nombreDelProyecto, ArrayList<Resultado> resultadoMejorAsignacion, String tipoOperacion, String nombreTipoTarea, String nombreTipoCandidatos){
        if(resultadoMejorAsignacion == null){
            JOptionPane.showMessageDialog(null, "Imposible de calcular, \nIntente de nuevo", "Calculo fallido", JOptionPane.ERROR_MESSAGE);
        }else{
            //Se hace el proceso que se requiere para mostrar el JasperReport...
        }        
    }
    
    
}
