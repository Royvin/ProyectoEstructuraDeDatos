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
import javax.swing.JPanel;

public class Orders {

    private static Orders instance;

    private GameScreenUI gameScreen;

    private JPanel[] ordersContainers = new JPanel[3];
    private JPanel mainOrderPanel;

    private Cola ordenes;

    private Common common = new Common();
    private static Constants constant = new Constants();
    private JPanel currentMainOrderPanel;

    public Orders() {
        this.gameScreen = GameScreenUI.getInstance();
        this.ordenes = Cola.getInstance();

        this.ordersContainers[0] = gameScreen.getOrderOnePanel();
        this.ordersContainers[1] = gameScreen.getOrderTwoPanel();
        this.ordersContainers[2] = gameScreen.getOrderThreePanel();
        this.mainOrderPanel = gameScreen.getMainOrderPanel();
        setOpaqueOrderComponents();
    }
    
    private boolean isOrderComplete(){
        return IngredientsCounter.getInstance().allIngredientsAreInOrder();
    }

    public void completeOrder() {
        
        if(!isOrderComplete()){
            return;
        }
        
        Points.getInstance().pointsSystem();
        ordenes.desencola();

        for (int i = 0; i < ordersContainers.length; i++) {
            JPanel orderContainer = ordersContainers[i];
            common.clearPanel(orderContainer);

            if (i + 1 < ordersContainers.length
                    && ordersContainers[i + 1].getComponents().length != 0) {
                JPanel nextOrderContainer = ordersContainers[i + 1];

                JPanel nextOrder = (JPanel) nextOrderContainer.getComponents()[0];
                common.addContentToPanel(
                        orderContainer,
                        nextOrder,
                        constant.TINY_ORDERS_SIZE
                );
                common.clearPanel(nextOrderContainer);

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

        return orders[common.getRandomNumber(orders.length)];
    }

    private JPanel getMainOrderPanel(String orderName) {
        if (orderName == constant.MEAT_AND_CHEESE_BURGER) {
            return new BigCheeseMeatBurger(this);
        } else if (orderName == constant.CHEESE_BURGER) {
            return new BigCheeseBurger(this);
        }

        return new BigMeatBurger(this);
    }

    private void refreshMainOrderPanelContent() {
        String currentOrderName = Cola.getInstance().getFrente().getName();
        JPanel mainOrder = getMainOrderPanel(currentOrderName);
        currentMainOrderPanel = mainOrder;

        mainOrder.setSize(610, 320);
        mainOrder.setLocation(0, 0);

        this.mainOrderPanel.removeAll();
        this.mainOrderPanel.add( 
                mainOrder,
                BorderLayout.CENTER
        );
        this.mainOrderPanel.revalidate();
        this.mainOrderPanel.repaint();
    }

    public void addNewOrder() {
        for (JPanel parentPanel : ordersContainers) {
            if (!common.parentPanelIsEmpty(parentPanel)) {
                continue;
            }

            System.out.println("Order is empty. Content being added");

            JPanel order = getRandomOrder();
            ordenes.encola(new NodoCola(new Orden(order)));

            common.addContentToPanel(
                    parentPanel,
                    order,
                    constant.TINY_ORDERS_SIZE
            );
            refreshMainOrderPanelContent();

            break;
        }
    }

    public void setOpaqueOrderComponents() {
        common.setPanelsOpaque(ordersContainers);
        common.setPanelOpaque(mainOrderPanel);
    }

    public JPanel getCurrentMainOrderPanel() {
        return currentMainOrderPanel;
    }
    
    public String getCurrentMainOrderName(){
        return ordenes.getFrente().getName();    
    }
    
    public static Orders getInstance() {
        if (instance == null) {
            instance = new Orders();
        }
        return instance;
    } 

}
