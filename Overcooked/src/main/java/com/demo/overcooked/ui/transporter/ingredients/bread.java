/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.demo.overcooked.ui.transporter.ingredients;

import javax.swing.ImageIcon;

/**
 *
 * @author Puta'
 */
public class bread extends javax.swing.JPanel {

    /**
     * Creates new form lettuce
     */
    public bread() {
        initComponents();
        this.setOpaque(false);
        
        ImageIcon image = new ImageIcon("assets/ingredients/bread.png");
        background.setIcon(image);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 120));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    // End of variables declaration//GEN-END:variables
}
