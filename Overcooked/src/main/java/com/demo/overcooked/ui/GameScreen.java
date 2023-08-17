package com.demo.overcooked.ui;

import com.demo.overcooked.estructuras.ordenes.Cola;
import com.demo.overcooked.estructuras.ordenes.NodoCola;
import com.demo.overcooked.estructuras.ordenes.Orden;
import java.awt.BorderLayout;
import java.awt.Component;
import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameScreen {

    private GameScreenUI screen;
    private UICommonMethods common = new UICommonMethods();

    private JPanel orderOneContainerPanel;
    private JPanel orderTwoContainerPanel;
    private JPanel orderThreeContainerPanel;
    private JPanel mainOrderContainerPanel;

    private JPanel[] ordersContainers = new JPanel[3];

    private JLabel gameTimerLabel;

    private Cola colaOrdenes;

    int segundos = 60;
    int minutos = 4;
    int segundosOrden = 2;

    public GameScreen() {
        this.colaOrdenes = Cola.getInstance();
        this.screen = new GameScreenUI();

        this.orderOneContainerPanel = screen.getOrderOnePanel();
        this.orderTwoContainerPanel = screen.getOrderTwoPanel();
        this.orderThreeContainerPanel = screen.getOrderThreePanel();
        this.mainOrderContainerPanel = screen.getMainOrderPanel();

        this.gameTimerLabel = screen.getTimerLabel();

        this.ordersContainers[0] = this.orderOneContainerPanel;
        this.ordersContainers[1] = this.orderTwoContainerPanel;
        this.ordersContainers[2] = this.orderThreeContainerPanel;

        initGameScreen();
        timerNewOrder();
        gameTimer();
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

    public void addNewOrder() {
        for (JPanel parentPanel : ordersContainers) {
            if (!orderParentPanelIsEmpty(parentPanel)) {
                continue;
            }

            System.out.println("Order is empty. Content being added");

            JPanel order = common.getRandomOrder();
            colaOrdenes.encola(new NodoCola(new Orden(order)));

            addContentToOrderPanel(parentPanel, order);
            common.addContentToMainOrderPanel(mainOrderContainerPanel);

            break;
        }
    }

    private boolean orderParentPanelIsEmpty(JPanel parentOrderPanel) {
        Component[] orderComponents = parentOrderPanel.getComponents();

        return orderComponents.length == 0 ? true : false;
    }

    public Cola getCola() {
        return colaOrdenes;
    }

    public void gameTimer() {
        gameTimerLabel.setText("5:00");

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
                        gameTimerLabel.setText(minutos + ":" + segundos);
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

    private void initGameScreen() {
        for (JPanel ordersContainer : ordersContainers) {
            ordersContainer.setOpaque(false);
        }
        mainOrderContainerPanel.setOpaque(false);
        
        screen.setVisible(true);
    }
}
