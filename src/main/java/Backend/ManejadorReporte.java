/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author phily
 */
public class ManejadorReporte {
    //Creo que tendŕia que tener el panel en donde se va a previsualizar el reporte [claro si no resulta muy complicado :v xD]
    
    public void mostrarReporte(String nombreDelProyecto, ArrayList<Resultado> resultadoMejorAsignacion, String tipoOperacion, 
            String nombreTipoTarea, String nombreTipoCandidatos, String dataType){
        if(resultadoMejorAsignacion == null){
            JOptionPane.showMessageDialog(null, "Imposible de calcular, \nIntente de nuevo", "Calculo fallido", JOptionPane.ERROR_MESSAGE);
        }else{
            try{
             //File file = new File(this.getClass().getResource("/MejorAsignacion-MetodoHungaro.jrxml").getPath());                       
            //JasperReport jasperReports = JasperCompileManager.compileReport(file.getAbsolutePath());
            
            JasperReport jasperReports = JasperCompileManager.compileReport("src/main/resources/archivo/MejorAsignacion-MetodoHungaro.jrxml");            
            
            //Creas el objeto que te permite enviar el listado y utilizar los métodos para obtener la info
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(resultadoMejorAsignacion);
         
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("ProjectName", nombreDelProyecto);
            parametros.put("nombreTipoCandidato", nombreTipoCandidatos);
            parametros.put("nombreTipoAsignacion", nombreTipoTarea);
            parametros.put("dataType", dataType);
            parametros.put("tipoOperacion", tipoOperacion);
            
            //aquí creas el objeto que recibe todo lo que ya preparaste antes, para que pueda ser llenado y que tiene la capacidad de ser impreso, en una de muchas formas, p.ej PDF
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReports, parametros, dataSource);
            JasperViewer.viewReport(jasperPrint, true);
            
            System.out.println("si llego aquí xD :v");            
            } catch (JRException ex) {
                System.out.println("Imposible abrir el archivo"+ ex.getMessage());
            }                                    
        }        
    }
    
    
}
