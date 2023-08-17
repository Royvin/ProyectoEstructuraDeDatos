/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.demo.overcooked.ui;

import com.demo.overcooked.estructuras.ordenes.*;
import com.demo.overcooked.ui.orders.tiny.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Puta'
 */
public class GameScreen extends javax.swing.JFrame {

    private JPanel[] ordersContainers = new JPanel[3];
    private UIMethods ui = new UIMethods();

    int segundos = 60;
    int minutos = 4;
    int segundosOrden = 2;

    Cola cola = new Cola();

    /**
     * Creates new form GameScreen
     */
    public GameScreen() {
        initComponents();

        this.ordersContainers[0] = this.orderOne;
        this.ordersContainers[1] = this.orderTwo;
        this.ordersContainers[2] = this.orderThree;

        initGameScreen();
        gameTimer();
        timerNewOrder();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        orderOne = new javax.swing.JPanel();
        orderTwo = new javax.swing.JPanel();
        orderThree = new javax.swing.JPanel();
        mainOrderPanel = new javax.swing.JPanel();
        gameCounter = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout orderOneLayout = new javax.swing.GroupLayout(orderOne);
        orderOne.setLayout(orderOneLayout);
        orderOneLayout.setHorizontalGroup(
            orderOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        orderOneLayout.setVerticalGroup(
            orderOneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        getContentPane().add(orderOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 200, 160));

        javax.swing.GroupLayout orderTwoLayout = new javax.swing.GroupLayout(orderTwo);
        orderTwo.setLayout(orderTwoLayout);
        orderTwoLayout.setHorizontalGroup(
            orderTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        orderTwoLayout.setVerticalGroup(
            orderTwoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        getContentPane().add(orderTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 200, 160));

        javax.swing.GroupLayout orderThreeLayout = new javax.swing.GroupLayout(orderThree);
        orderThree.setLayout(orderThreeLayout);
        orderThreeLayout.setHorizontalGroup(
            orderThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        orderThreeLayout.setVerticalGroup(
            orderThreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        getContentPane().add(orderThree, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 200, 160));

        javax.swing.GroupLayout mainOrderPanelLayout = new javax.swing.GroupLayout(mainOrderPanel);
        mainOrderPanel.setLayout(mainOrderPanelLayout);
        mainOrderPanelLayout.setHorizontalGroup(
            mainOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        mainOrderPanelLayout.setVerticalGroup(
            mainOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        getContentPane().add(mainOrderPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 190, 610, 320));

        gameCounter.setFont(new java.awt.Font("Poppins Black", 0, 24)); // NOI18N
        gameCounter.setForeground(new java.awt.Color(158, 176, 158));
        gameCounter.setText("00:00");
        gameCounter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(gameCounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 80, 50));

        background.setIcon(new javax.swing.ImageIcon("C:\\Users\\Puta'\\Desktop\\proyecto-ed\\ProyectoEstructuraDeDatos\\Overcooked\\assets\\backgrounds\\GameScreen1.png")); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameScreen().setVisible(true);
            }
        });
    }

    private void initGameScreen() {
        this.setLocationRelativeTo(this);

        orderOne.setOpaque(false);
        orderTwo.setOpaque(false);
        orderThree.setOpaque(false);
        mainOrderPanel.setOpaque(false);
    }

    private void addContentToOrderPanel(
            JPanel orderParentPanel,
            JPanel orderContent
    ) {
        orderContent.setSize(195, 156);
        orderContent.setLocation(0, 0);

        orderParentPanel.add(orderContent, BorderLayout.CENTER);
        orderParentPanel.revalidate();
        orderParentPanel.repaint();
    }
    
    private void addContentToMainOrderPanel(){
        String currentOrderName = cola.getFrente().getName();
        JPanel mainOrder = ui.getMainOrderPanel(currentOrderName);
        
        mainOrder.setSize(610, 320);
        mainOrder.setLocation(0, 0);

        mainOrderPanel.add(mainOrder, BorderLayout.CENTER);
        mainOrderPanel.revalidate();
        mainOrderPanel.repaint();
    }

    public void addNewOrder() {
        for (JPanel parentPanel : ordersContainers) {
            if (!orderParentPanelIsEmpty(parentPanel)) {
                continue;
            }

            System.out.println("Order is empty. Content being added");

            JPanel order = ui.getRandomOrder();
            cola.encola(new NodoCola(new Orden(order)));
            
            addContentToOrderPanel(parentPanel, order);
            addContentToMainOrderPanel();

            break;
        }
    }

    private boolean orderParentPanelIsEmpty(JPanel parentOrderPanel) {
        Component[] orderComponents = parentOrderPanel.getComponents();

        return orderComponents.length == 0 ? true : false;
    }

    public Cola getCola() {
        return cola;
    }

    public void gameTimer() {
        gameCounter.setText("5:00");

        Thread hilo = new Thread() {
            public void run() {

                while (true) {
                    try {
                        sleep(1000);
                        if (segundos == 0) {
                            segundos = 60;
                            minutos--;
                        } else {
                            segundos--;
                        }
                        gameCounter.setText(minutos + ":" + segundos);
                    } catch (Exception e) {
                    }
                }
            }
        };

        hilo.start();
    }

    public void timerNewOrder() {
        Thread hilo = new Thread() {
            public void run() {
                while (true) {
                    try {
                        sleep(1000);
                        if (segundosOrden == 0) {
                            segundosOrden = 2;
                            SwingUtilities.invokeLater(() -> {
                                addNewOrder();
                            });

                        } else {
                            segundosOrden--;
                        }

                    } catch (Exception e) {

                    }
                }
            }
        };
        hilo.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel gameCounter;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel mainOrderPanel;
    private javax.swing.JPanel orderOne;
    private javax.swing.JPanel orderThree;
    private javax.swing.JPanel orderTwo;
    // End of variables declaration//GEN-END:variables
}
