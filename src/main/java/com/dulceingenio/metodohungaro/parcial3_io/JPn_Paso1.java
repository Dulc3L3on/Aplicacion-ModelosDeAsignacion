/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulceingenio.metodohungaro.parcial3_io;

import Backend.ManejadorReporte;
import Backend.MetodoHungaro;
import com.dulceingenio.metodohungaro.parcial3_io.InterfazManual.List;
import com.dulceingenio.metodohungaro.parcial3_io.InterfazManual.Table;

/**
 *
 * @author phily
 */
public class JPn_Paso1 extends javax.swing.JPanel {
    private MetodoHungaro metodoHungaro;
    private ManejadorReporte manejadorReporte;
    private List manejadorListas;
    private Table manejadorTabla;    
    private int cantidadAsignacionesPrevia = 2;
    private int cantidadCandidatosPrevia = 2;        
    
    /**
     * Creates new form JPn_Paso1
     */
    public JPn_Paso1() {
        initComponents();                                   
        
        manejadorListas = new List(JP_listCandidatos, JP_listAsignaciones, 2, 2);        
        manejadorTabla = new Table(jPn_contenedorTablaDatos, 2, 2, manejadorListas);                        
        metodoHungaro = new MetodoHungaro();
        manejadorReporte = new ManejadorReporte();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpn_nombresCampos = new javax.swing.JPanel();
        scrollP_listAsignaciones = new javax.swing.JScrollPane();
        JP_listAsignaciones = new javax.swing.JPanel();
        scrollP_listCandidatos = new javax.swing.JScrollPane();
        JP_listCandidatos = new javax.swing.JPanel();
        spn_numAsignaciones = new javax.swing.JSpinner();
        spn_numCandidatos = new javax.swing.JSpinner();
        txt_nombreTipoAsignacion = new javax.swing.JTextField();
        txt_nombreTipoCandidato = new javax.swing.JTextField();
        jP_panelContent = new javax.swing.JPanel();
        scrollPane_TablaDatos = new javax.swing.JScrollPane();
        jPn_contenedorTablaDatos = new javax.swing.JPanel();
        cbBox_tipoOperacion = new javax.swing.JComboBox<>();
        txtF_nombreProyecto = new javax.swing.JTextField();
        btn_descargar = new javax.swing.JButton();
        btn_Calcular = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1782, 761));
        setPreferredSize(new java.awt.Dimension(1782, 761));

        jpn_nombresCampos.setBackground(new java.awt.Color(229, 230, 232));

        scrollP_listAsignaciones.setBackground(new java.awt.Color(229, 230, 232));
        scrollP_listAsignaciones.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollP_listAsignaciones.setPreferredSize(new java.awt.Dimension(244, 397));
        scrollP_listAsignaciones.setViewportView(JP_listAsignaciones);

        JP_listAsignaciones.setBackground(new java.awt.Color(229, 230, 232));
        JP_listAsignaciones.setBorder(null);
        JP_listAsignaciones.setAutoscrolls(true);
        JP_listAsignaciones.setPreferredSize(new java.awt.Dimension(242, 395));

        javax.swing.GroupLayout JP_listAsignacionesLayout = new javax.swing.GroupLayout(JP_listAsignaciones);
        JP_listAsignaciones.setLayout(JP_listAsignacionesLayout);
        JP_listAsignacionesLayout.setHorizontalGroup(
            JP_listAsignacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );
        JP_listAsignacionesLayout.setVerticalGroup(
            JP_listAsignacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        scrollP_listAsignaciones.setViewportView(JP_listAsignaciones);

        scrollP_listCandidatos.setBackground(new java.awt.Color(229, 230, 232));
        scrollP_listCandidatos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollP_listCandidatos.setPreferredSize(new java.awt.Dimension(244, 397));

        JP_listCandidatos.setBackground(new java.awt.Color(229, 230, 232));
        JP_listCandidatos.setBorder(null);
        JP_listCandidatos.setPreferredSize(new java.awt.Dimension(242, 395));

        javax.swing.GroupLayout JP_listCandidatosLayout = new javax.swing.GroupLayout(JP_listCandidatos);
        JP_listCandidatos.setLayout(JP_listCandidatosLayout);
        JP_listCandidatosLayout.setHorizontalGroup(
            JP_listCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );
        JP_listCandidatosLayout.setVerticalGroup(
            JP_listCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        scrollP_listCandidatos.setViewportView(JP_listCandidatos);

        spn_numAsignaciones.setModel(new javax.swing.SpinnerNumberModel(2, 2, 26, 1));
        spn_numAsignaciones.setMaximumSize(new java.awt.Dimension(67, 35));
        spn_numAsignaciones.setMinimumSize(new java.awt.Dimension(67, 35));
        spn_numAsignaciones.setPreferredSize(new java.awt.Dimension(67, 35));
        spn_numAsignaciones.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spn_numAsignacionesStateChanged(evt);
            }
        });
        spn_numAsignaciones.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                spn_numAsignacionesInputMethodTextChanged(evt);
            }
        });

        spn_numCandidatos.setModel(new javax.swing.SpinnerNumberModel(2, 2, 26, 1));
        spn_numCandidatos.setMaximumSize(new java.awt.Dimension(67, 35));
        spn_numCandidatos.setMinimumSize(new java.awt.Dimension(67, 35));
        spn_numCandidatos.setName(""); // NOI18N
        spn_numCandidatos.setPreferredSize(new java.awt.Dimension(67, 35));
        spn_numCandidatos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spn_numCandidatosStateChanged(evt);
            }
        });
        spn_numCandidatos.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                spn_numCandidatosInputMethodTextChanged(evt);
            }
        });

        txt_nombreTipoAsignacion.setText("Tipo de Asignación");
        txt_nombreTipoAsignacion.setPreferredSize(new java.awt.Dimension(154, 35));

        txt_nombreTipoCandidato.setText("Tipo de Candidato");
        txt_nombreTipoCandidato.setPreferredSize(new java.awt.Dimension(154, 35));

        javax.swing.GroupLayout jpn_nombresCamposLayout = new javax.swing.GroupLayout(jpn_nombresCampos);
        jpn_nombresCampos.setLayout(jpn_nombresCamposLayout);
        jpn_nombresCamposLayout.setHorizontalGroup(
            jpn_nombresCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_nombresCamposLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jpn_nombresCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollP_listAsignaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollP_listCandidatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_nombresCamposLayout.createSequentialGroup()
                        .addComponent(txt_nombreTipoAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spn_numAsignaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpn_nombresCamposLayout.createSequentialGroup()
                        .addComponent(txt_nombreTipoCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spn_numCandidatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jpn_nombresCamposLayout.setVerticalGroup(
            jpn_nombresCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_nombresCamposLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jpn_nombresCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spn_numAsignaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombreTipoAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollP_listAsignaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jpn_nombresCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombreTipoCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spn_numCandidatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollP_listCandidatos, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jP_panelContent.setBackground(new java.awt.Color(240, 241, 242));

        scrollPane_TablaDatos.setBackground(new java.awt.Color(250, 252, 254));
        scrollPane_TablaDatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(216, 226, 228)));
        scrollPane_TablaDatos.setAutoscrolls(true);
        scrollPane_TablaDatos.setViewportView(null);

        javax.swing.GroupLayout jPn_contenedorTablaDatosLayout = new javax.swing.GroupLayout(jPn_contenedorTablaDatos);
        jPn_contenedorTablaDatos.setLayout(jPn_contenedorTablaDatosLayout);
        jPn_contenedorTablaDatosLayout.setHorizontalGroup(
            jPn_contenedorTablaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1196, Short.MAX_VALUE)
        );
        jPn_contenedorTablaDatosLayout.setVerticalGroup(
            jPn_contenedorTablaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );

        scrollPane_TablaDatos.setViewportView(jPn_contenedorTablaDatos);

        cbBox_tipoOperacion.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        cbBox_tipoOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maximización", "MInimización" }));

        txtF_nombreProyecto.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        txtF_nombreProyecto.setText("Nombre del proyecto");

        btn_descargar.setText("DESCARGAR");
        btn_descargar.setEnabled(false);

        btn_Calcular.setText("CALCULAR");
        btn_Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jP_panelContentLayout = new javax.swing.GroupLayout(jP_panelContent);
        jP_panelContent.setLayout(jP_panelContentLayout);
        jP_panelContentLayout.setHorizontalGroup(
            jP_panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_panelContentLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jP_panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbBox_tipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtF_nombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPane_TablaDatos))
                .addGap(35, 35, 35)
                .addGroup(jP_panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_descargar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        jP_panelContentLayout.setVerticalGroup(
            jP_panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_panelContentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_descargar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_panelContentLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtF_nombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(cbBox_tipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPane_TablaDatos)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpn_nombresCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpn_nombresCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jP_panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void spn_numAsignacionesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spn_numAsignacionesStateChanged
        updateColumComponents();
    }//GEN-LAST:event_spn_numAsignacionesStateChanged

    private void spn_numCandidatosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spn_numCandidatosStateChanged
        updateRowComponents();
    }//GEN-LAST:event_spn_numCandidatosStateChanged

    private void spn_numAsignacionesInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_spn_numAsignacionesInputMethodTextChanged
        updateColumComponents();
    }//GEN-LAST:event_spn_numAsignacionesInputMethodTextChanged

    private void spn_numCandidatosInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_spn_numCandidatosInputMethodTextChanged
        updateRowComponents();
    }//GEN-LAST:event_spn_numCandidatosInputMethodTextChanged

    private void btn_CalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CalcularActionPerformed
        if(btn_Calcular.getText().equals("Calcular")){
            btn_Calcular.setText("Recalcular");
        }
        
        appHungaroMetod();
    }//GEN-LAST:event_btn_CalcularActionPerformed

    private void updateColumComponents(){
        int cantidadNueva = (Integer)spn_numAsignaciones.getValue();
        
        if(cantidadNueva > cantidadAsignacionesPrevia){
            manejadorTabla.cambiarTamanioTabla(true, false, cantidadNueva);
            manejadorListas.cambiarTamanioLista(true, true, cantidadNueva);
        }else{
            manejadorTabla.cambiarTamanioTabla(false, false, cantidadNueva);
            manejadorListas.cambiarTamanioLista(false, true, cantidadNueva);
        }       

        cantidadAsignacionesPrevia = cantidadNueva;                
    }
    
    private void updateRowComponents(){
        int cantidadNueva = (Integer)spn_numCandidatos.getValue();
        
        if(cantidadNueva > cantidadCandidatosPrevia){
            manejadorTabla.cambiarTamanioTabla(true, true, cantidadNueva);
            manejadorListas.cambiarTamanioLista(true, false, cantidadNueva);
        }else{
            manejadorTabla.cambiarTamanioTabla(false, true, cantidadNueva);
            manejadorListas.cambiarTamanioLista(false, false, cantidadNueva);
        }       

        cantidadCandidatosPrevia = cantidadNueva;      
    }    
    
    private void appHungaroMetod(){
        double matrizDatos[][] = manejadorTabla.darInfo();
        System.out.println((((String)cbBox_tipoOperacion.getSelectedItem()).equals("Maximización")));
        
        if(matrizDatos!= null){            
            manejadorReporte.mostrarReporte(txtF_nombreProyecto.getText(),metodoHungaro.hallarValorOptimo((((String)cbBox_tipoOperacion.getSelectedItem()).equals("Maximización")), matrizDatos, manejadorTabla.getMayorDeLosDatos()),
                    (String)cbBox_tipoOperacion.getSelectedItem(), txt_nombreTipoAsignacion.getText(), txt_nombreTipoCandidato.getText());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JP_listAsignaciones;
    private javax.swing.JPanel JP_listCandidatos;
    private javax.swing.JButton btn_Calcular;
    private javax.swing.JButton btn_descargar;
    private javax.swing.JComboBox<String> cbBox_tipoOperacion;
    private javax.swing.JPanel jP_panelContent;
    private javax.swing.JPanel jPn_contenedorTablaDatos;
    private javax.swing.JPanel jpn_nombresCampos;
    private javax.swing.JScrollPane scrollP_listAsignaciones;
    private javax.swing.JScrollPane scrollP_listCandidatos;
    private javax.swing.JScrollPane scrollPane_TablaDatos;
    private javax.swing.JSpinner spn_numAsignaciones;
    private javax.swing.JSpinner spn_numCandidatos;
    private javax.swing.JTextField txtF_nombreProyecto;
    private javax.swing.JTextField txt_nombreTipoAsignacion;
    private javax.swing.JTextField txt_nombreTipoCandidato;
    // End of variables declaration//GEN-END:variables
}
