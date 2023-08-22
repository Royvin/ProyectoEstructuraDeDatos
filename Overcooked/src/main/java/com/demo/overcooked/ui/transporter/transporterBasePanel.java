/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.demo.overcooked.ui.transporter;

import com.demo.overcooked.ui.Common;
import com.demo.overcooked.ui.Constants;
import javax.swing.JButton;

/**
 *
 * @author Puta'
 */
public class transporterBasePanel extends javax.swing.JPanel {

    private static Common common = new Common();
    private static Constants constant = new Constants();

    public transporterBasePanel() {
        initComponents();
        this.setOpaque(false);
        common.setBtnsOpaque(new JButton[]{addBtn, delBtn});
        common.setPanelOpaque(ingredientPanel);
        
        common.setBackgroundImage(
                background,
                constant.TRANSPORTER_BASE_PANEL_IMG_PATH
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        addBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        ingredientPanel = new javax.swing.JPanel();
        background = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 70, 50));
        addBtn.setName("add-ingredient-btn");
        add(delBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 60, 50));
        delBtn.setName("delete-ingredient-btn");

        javax.swing.GroupLayout ingredientPanelLayout = new javax.swing.GroupLayout(ingredientPanel);
        ingredientPanel.setLayout(ingredientPanelLayout);
        ingredientPanelLayout.setHorizontalGroup(
            ingredientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        ingredientPanelLayout.setVerticalGroup(
            ingredientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );

        add(ingredientPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 130));

        background.setIcon(new javax.swing.ImageIcon("C:\\Users\\Puta'\\Desktop\\estructura-datos\\proyecto\\ProyectoEstructuraDeDatos\\Overcooked\\assets\\ingredients\\base-panel.png")); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 200));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel background;
    private javax.swing.JButton delBtn;
    private javax.swing.JPanel ingredientPanel;
    private javax.swing.JRadioButton jRadioButton1;
    // End of variables declaration//GEN-END:variables
}
