package com.demo.overcooked.ui.orders.main;

import com.demo.overcooked.ui.Common;
import com.demo.overcooked.ui.Constants;
import com.demo.overcooked.ui.GameScreen;
import com.demo.overcooked.ui.Orders;
import javax.swing.ImageIcon;

public class BigCheeseMeatBurger extends javax.swing.JPanel {

    private Orders orders;
    private static Common common = new Common();
    private static Constants constant = new Constants();

    public BigCheeseMeatBurger(Orders orders) {
        initComponents();
        this.orders = orders;
        this.setOpaque(false);
        this.setName(constant.MEAT_AND_CHEESE_BURGER);

        common.setBtnOpaque(completeOrderBtn);
        common.setBackgroundImage(
                background,
                constant.BIG_MEAT_AND_CHEESE_IMG_PATH
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

        completeOrderBtn = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        completeOrderBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                completeOrderBtnMouseClicked(evt);
            }
        });
        add(completeOrderBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 290, 50));
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 320));
    }// </editor-fold>//GEN-END:initComponents

    private void completeOrderBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_completeOrderBtnMouseClicked
        System.out.println("completeOrderBtnMouseClicked()");
        orders.completeOrder();
    }//GEN-LAST:event_completeOrderBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton completeOrderBtn;
    // End of variables declaration//GEN-END:variables
}
