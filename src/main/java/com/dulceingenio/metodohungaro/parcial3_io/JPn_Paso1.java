/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulceingenio.metodohungaro.parcial3_io;

import com.dulceingenio.metodohungaro.parcial3_io.Backtend.List;
import com.dulceingenio.metodohungaro.parcial3_io.Backtend.Table;

/**
 *
 * @author phily
 */
public class JPn_Paso1 extends javax.swing.JPanel {
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
        manejadorTabla = new Table(scrollPane_TablaDatos, 2, 2);
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
        cbBox_tipoOperacion = new javax.swing.JComboBox<>();
        txtF_nombreProyecto = new javax.swing.JTextField();
        btn_descargar = new javax.swing.JButton();
        btn_Calcular = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1782, 761));
        setPreferredSize(new java.awt.Dimension(1782, 761));

        jpn_nombresCampos.setBackground(new java.awt.Color(229, 230, 232));

        scrollP_listAsignaciones.setBackground(new java.awt.Color(229, 230, 232));
        scrollP_listAsignaciones.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollP_listAsignaciones.setViewportView(JP_listAsignaciones);

        JP_listAsignaciones.setBackground(new java.awt.Color(229, 230, 232));
        JP_listAsignaciones.setBorder(null);
        JP_listAsignaciones.setAutoscrolls(true);

        javax.swing.GroupLayout JP_listAsignacionesLayout = new javax.swing.GroupLayout(JP_listAsignaciones);
        JP_listAsignaciones.setLayout(JP_listAsignacionesLayout);
        JP_listAsignacionesLayout.setHorizontalGroup(
            JP_listAsignacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );
        JP_listAsignacionesLayout.setVerticalGroup(
            JP_listAsignacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );

        scrollP_listAsignaciones.setViewportView(JP_listAsignaciones);

        scrollP_listCandidatos.setBackground(new java.awt.Color(229, 230, 232));

        JP_listCandidatos.setBackground(new java.awt.Color(229, 230, 232));
        JP_listCandidatos.setBorder(null);

        javax.swing.GroupLayout JP_listCandidatosLayout = new javax.swing.GroupLayout(JP_listCandidatos);
        JP_listCandidatos.setLayout(JP_listCandidatosLayout);
        JP_listCandidatosLayout.setHorizontalGroup(
            JP_listCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );
        JP_listCandidatosLayout.setVerticalGroup(
            JP_listCandidatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );

        scrollP_listCandidatos.setViewportView(JP_listCandidatos);

        spn_numAsignaciones.setModel(new javax.swing.SpinnerNumberModel(2, 2, 25, 1));
        spn_numAsignaciones.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spn_numAsignacionesStateChanged(evt);
            }
        });

        spn_numCandidatos.setModel(new javax.swing.SpinnerNumberModel(2, 2, 25, 1));
        spn_numCandidatos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spn_numCandidatosStateChanged(evt);
            }
        });

        txt_nombreTipoAsignacion.setText("Tipo de Asignación");
        txt_nombreTipoAsignacion.setPreferredSize(new java.awt.Dimension(153, 35));

        txt_nombreTipoCandidato.setText("Tipo de Candidato");
        txt_nombreTipoCandidato.setPreferredSize(new java.awt.Dimension(153, 35));

        javax.swing.GroupLayout jpn_nombresCamposLayout = new javax.swing.GroupLayout(jpn_nombresCampos);
        jpn_nombresCampos.setLayout(jpn_nombresCamposLayout);
        jpn_nombresCamposLayout.setHorizontalGroup(
            jpn_nombresCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_nombresCamposLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jpn_nombresCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollP_listAsignaciones)
                    .addComponent(scrollP_listCandidatos)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_nombresCamposLayout.createSequentialGroup()
                        .addComponent(txt_nombreTipoAsignacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spn_numAsignaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_nombresCamposLayout.createSequentialGroup()
                        .addComponent(txt_nombreTipoCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(spn_numCandidatos, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(scrollP_listAsignaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addGroup(jpn_nombresCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spn_numCandidatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombreTipoCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollP_listCandidatos, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        jP_panelContent.setBackground(new java.awt.Color(240, 241, 242));

        scrollPane_TablaDatos.setBackground(new java.awt.Color(250, 252, 254));
        scrollPane_TablaDatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(216, 226, 228)));
        scrollPane_TablaDatos.setAutoscrolls(true);
        scrollPane_TablaDatos.setViewportView(null);

        cbBox_tipoOperacion.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        cbBox_tipoOperacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maximización", "MInimización" }));

        txtF_nombreProyecto.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        txtF_nombreProyecto.setText("Nombre del proyecto");

        btn_descargar.setText("DESCARGAR");
        btn_descargar.setEnabled(false);

        btn_Calcular.setText("CALCULAR");

        javax.swing.GroupLayout jP_panelContentLayout = new javax.swing.GroupLayout(jP_panelContent);
        jP_panelContent.setLayout(jP_panelContentLayout);
        jP_panelContentLayout.setHorizontalGroup(
            jP_panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_panelContentLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jP_panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane_TablaDatos)
                    .addGroup(jP_panelContentLayout.createSequentialGroup()
                        .addGroup(jP_panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbBox_tipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtF_nombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 833, Short.MAX_VALUE)))
                .addGap(52, 52, 52)
                .addGroup(jP_panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_descargar, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(btn_Calcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        jP_panelContentLayout.setVerticalGroup(
            jP_panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_panelContentLayout.createSequentialGroup()
                .addGroup(jP_panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jP_panelContentLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_descargar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jP_panelContentLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtF_nombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(cbBox_tipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane_TablaDatos)))
                .addGap(36, 36, 36))
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
        if((Integer)spn_numAsignaciones.getValue() > cantidadAsignacionesPrevia){
            manejadorTabla.cambiarTamanioTabla(true, false);
            manejadorListas.cambiarTamanioLista(true, true);
        }else{
            manejadorTabla.cambiarTamanioTabla(false, false);
            manejadorListas.cambiarTamanioLista(false, true);
        }       

        cantidadAsignacionesPrevia = (Integer) spn_numAsignaciones.getValue();            
    }//GEN-LAST:event_spn_numAsignacionesStateChanged

    private void spn_numCandidatosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spn_numCandidatosStateChanged
        if((Integer)spn_numCandidatos.getValue() > cantidadCandidatosPrevia){
            manejadorTabla.cambiarTamanioTabla(true, true);
            manejadorListas.cambiarTamanioLista(true, false);
        }else{
            manejadorTabla.cambiarTamanioTabla(false, true);
            manejadorListas.cambiarTamanioLista(false, false);
        }       

        cantidadCandidatosPrevia = (Integer) spn_numCandidatos.getValue();                
    }//GEN-LAST:event_spn_numCandidatosStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JP_listAsignaciones;
    private javax.swing.JPanel JP_listCandidatos;
    private javax.swing.JButton btn_Calcular;
    private javax.swing.JButton btn_descargar;
    private javax.swing.JComboBox<String> cbBox_tipoOperacion;
    private javax.swing.JPanel jP_panelContent;
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
