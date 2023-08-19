package com.demo.overcooked.ui;

import com.demo.overcooked.estructuras.ordenes.Cola;
import com.demo.overcooked.estructuras.ordenes.NodoCola;
import com.demo.overcooked.estructuras.ordenes.Orden;
import com.demo.overcooked.ui.orders.main.BigCheeseBurger;
import com.demo.overcooked.ui.orders.main.BigCheeseMeatBurger;
import com.demo.overcooked.ui.orders.main.BigMeatBurger;
import com.demo.overcooked.ui.orders.tiny.TinyCheeseBurger;
import com.demo.overcooked.ui.orders.tiny.TinyCheeseMeatBurger;
import com.demo.overcooked.ui.orders.tiny.TinyMeatBurger;
import java.awt.BorderLayout;
import java.awt.Component;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameScreen {

    private GameScreenUI screen;

    private Constants constants = new Constants();

    private JPanel[] ordersContainers = new JPanel[3];
    private JPanel[] ingredientsContainers = new JPanel[5];

    private JPanel orderOneContainerPanel;
    private JPanel orderTwoContainerPanel;
    private JPanel orderThreeContainerPanel;
    private JPanel mainOrderContainerPanel;

    private JPanel cintaIngredientOnePanel;
    private JPanel cintaIngredientTwoPanel;
    private JPanel cintaIngredientThreePanel;
    private JPanel cintaIngredientFourPanel;
    private JPanel cintaIngredientFivePanel;

    private JLabel gameTimerLabel;

    private Cola colaOrdenes;

    int segundos = 60;
    int minutos = 4;
    int segundosOrden = 2;

    public GameScreen() {
        this.colaOrdenes = Cola.getInstance();
        this.screen = GameScreenUI.getInstance();

        this.getScreenVariables();
        this.populateArrays();

        initGameScreen();
        initGame();
    }

    private void clearPanel(JPanel panel) {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }

    public void completeOrder() {
        colaOrdenes.desencola();

        for (int i = 0; i < ordersContainers.length; i++) {
            JPanel orderContainer = ordersContainers[i];
            clearPanel(orderContainer);

            if (i + 1 < ordersContainers.length && ordersContainers[i + 1].getComponents().length != 0) {
                JPanel nextOrderContainer = ordersContainers[i + 1];

                JPanel nextOrder = (JPanel) nextOrderContainer.getComponents()[0];
                addContentToOrderPanel(orderContainer, nextOrder);
                clearPanel(nextOrderContainer);

                refreshMainOrderPanelContent();
            }
        }
    }

    private JPanel getRandomOrder() {
        JPanel[] orders = {
            new TinyCheeseBurger(),
            new TinyMeatBurger(),
            new TinyCheeseMeatBurger()
        };

        orders[0].setName(constants.CHEESE_BURGER());
        orders[1].setName(constants.MEAT_BURGER());
        orders[2].setName(constants.MEAT_AND_CHEESE_BURGER());

        int randomIndex = new Random().nextInt(orders.length);

        return orders[randomIndex];
    }

    private JPanel getMainOrderPanel(String orderName) {
        if (orderName == constants.MEAT_AND_CHEESE_BURGER()) {
            return new BigCheeseMeatBurger(this);
        } else if (orderName == constants.CHEESE_BURGER()) {
            return new BigCheeseBurger(this);
        }

        return new BigMeatBurger(this);
    }

    private void refreshMainOrderPanelContent() {
        String currentOrderName = Cola.getInstance().getFrente().getName();
        JPanel mainOrder = getMainOrderPanel(currentOrderName);

        mainOrder.setSize(610, 320);
        mainOrder.setLocation(0, 0);

        mainOrderContainerPanel.removeAll();
        mainOrderContainerPanel.add(
                mainOrder,
                BorderLayout.CENTER
        );
        mainOrderContainerPanel.revalidate();
        mainOrderContainerPanel.repaint();
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

    private void addNewOrder() {
        for (JPanel parentPanel : ordersContainers) {
            if (!orderParentPanelIsEmpty(parentPanel)) {
                continue;
            }

            System.out.println("Order is empty. Content being added");

            JPanel order = getRandomOrder();
            colaOrdenes.encola(new NodoCola(new Orden(order)));

            addContentToOrderPanel(parentPanel, order);
            refreshMainOrderPanelContent();

            break;
        }
    }

    private boolean orderParentPanelIsEmpty(JPanel parentOrderPanel) {
        Component[] orderComponents = parentOrderPanel.getComponents();

        return orderComponents.length == 0 ? true : false;
    }

    private void gameTimer() {
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

    private void timerNewOrder() {
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

    private void getScreenVariables() {
        this.orderOneContainerPanel = screen.getOrderOnePanel();
        this.orderTwoContainerPanel = screen.getOrderTwoPanel();
        this.orderThreeContainerPanel = screen.getOrderThreePanel();
        this.mainOrderContainerPanel = screen.getMainOrderPanel();

        this.cintaIngredientOnePanel = screen.getCintaIngredientOne();
        this.cintaIngredientTwoPanel = screen.getCintaIngredientTwo();
        this.cintaIngredientThreePanel = screen.getCintaIngredientThree();
        this.cintaIngredientFourPanel = screen.getCintaIngredientFour();
        this.cintaIngredientFivePanel = screen.getCintaIngredientFive();

        this.gameTimerLabel = screen.getTimerLabel();
    }

    private void populateArrays() {
        this.ordersContainers[0] = this.orderOneContainerPanel;
        this.ordersContainers[1] = this.orderTwoContainerPanel;
        this.ordersContainers[2] = this.orderThreeContainerPanel;

        this.ingredientsContainers[0] = this.cintaIngredientOnePanel;
        this.ingredientsContainers[1] = this.cintaIngredientTwoPanel;
        this.ingredientsContainers[2] = this.cintaIngredientThreePanel;
        this.ingredientsContainers[3] = this.cintaIngredientFourPanel;
        this.ingredientsContainers[4] = this.cintaIngredientFivePanel;
    }

    private void initGameScreen() {
        for (JPanel ordersContainer : ordersContainers) {
            ordersContainer.setOpaque(false);
        }

        for (JPanel ingredientContainer : ingredientsContainers) {
            ingredientContainer.setOpaque(false);
        }

        mainOrderContainerPanel.setOpaque(false);

        screen.setVisible(true);
    }

    private void initGame() {
        gameTimer();
        timerNewOrder();
    }
}
