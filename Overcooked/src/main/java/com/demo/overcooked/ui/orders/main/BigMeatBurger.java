package com.demo.overcooked.ui.orders.main;

import com.demo.overcooked.ui.GameScreen;
import javax.swing.ImageIcon;

public class BigMeatBurger extends javax.swing.JPanel {

    GameScreen gameScreen;
    
    public BigMeatBurger(GameScreen gameScreen) {
        initComponents();
        this.gameScreen = gameScreen;
        
        this.setOpaque(false);

        completeOrderBtn.setOpaque(false);
        completeOrderBtn.setContentAreaFilled(false);
        completeOrderBtn.setBorderPainted(false);
        
        ImageIcon image = new ImageIcon("assets/orders/big-meat.png");
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

        completeOrderBtn = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        completeOrderBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                completeOrderBtnMouseClicked(evt);
            }
        });
        add(completeOrderBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 290, 50));

        background.setIcon(new javax.swing.ImageIcon("C:\\Users\\Puta'\\Desktop\\proyecto-ed\\ProyectoEstructuraDeDatos\\Overcooked\\assets\\orders\\big-meat.png")); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void completeOrderBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_completeOrderBtnMouseClicked
        System.out.println("com.demo.overcooked.ui.orders.main.BigMeatBurger.completeOrderBtnMouseClicked()");
        gameScreen.completeOrder();
    }//GEN-LAST:event_completeOrderBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton completeOrderBtn;
    // End of variables declaration//GEN-END:variables
}
