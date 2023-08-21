package com.demo.overcooked.ui;

import com.demo.overcooked.ui.transporter.ingredients.cheese;
import com.demo.overcooked.ui.transporter.transporterBasePanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Transporter {

    private static Transporter instance;

    GameScreenUI gameScreen;
    private static Common common = new Common();

    private JPanel[] transporterContainerPanels = new JPanel[5];
    private JButton[] buttons = new JButton[10];

    public Transporter() {
        this.gameScreen = GameScreenUI.getInstance();
        
        JPanel transporter = gameScreen.getTransporterPanelOne();
        

        
        transporter.setSize(170, 200);
        transporter.setLocation(0,0);
        
        transporter.add(new transporterBasePanel()  , BorderLayout.CENTER);
        transporter.revalidate();
        transporter.repaint();
        
        
        //buttonsListeners();
    }

    public static Transporter getInstance() {
        if (instance == null) {
            instance = new Transporter();
        }
        return instance;
    }

    private void addIngredientToOrder() {
        System.out.println("com.demo.overcooked.ui.Transporter.addIngredientToOrder()");
    }

    private void deleteIngredientForTransporter() {
        System.out.println("com.demo.overcooked.ui.Transporter.deleteIngredientForTransporter()");
    }

    private void buttonsListeners() {
        for (JButton button : buttons) {
            button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to be executed when the button is clicked
                System.out.println("Button clicked!");
            }
        });
        }
    }

    public void setOpaqueTransporterComponents() {
        common.setPanelsOpaque(transporterContainerPanels);
        common.setBtnsOpaque(buttons);
    }

    private Component[] getComponents(String componentsName) {
        Component[] screenComponents = gameScreen.getContentPane().getComponents();
        int componentsSize = 0;

        for (Component screenComponent : screenComponents) {
            if (componentHasName(screenComponent, componentsName)) {
                componentsSize++;
            }
        }

        Component[] components = new Component[componentsSize];
        int componentsIndexer = 0;

        for (Component screenComponent : screenComponents) {
            if (componentHasName(screenComponent, componentsName)) {
                components[componentsIndexer] = screenComponent;
                componentsIndexer++;
            }
        }

        return components;
    }

    private boolean componentHasName(Component component, String name) {
        return component.getName() != null
                && component.getName().contains(name)
                ? true : false;
    }

    private void populatePanelsAndBtnsArrays() {
        Component[] transporterPanels = getComponents("transporter");

        int indexPanels = 0;
        int indexBtns = 0;

        for (Component panelComponent : transporterPanels) {
            JPanel panel = (JPanel) panelComponent;
            this.transporterContainerPanels[indexPanels] = panel;
            indexPanels++;
            
            buttons[indexBtns] = (JButton) panel.getComponents()[0];
            buttons[indexBtns+1] = (JButton) panel.getComponents()[1];
            indexBtns++;
        }
    }

    public void configTransporter() {
        
        
        //populatePanelsAndBtnsArrays();
        //setOpaqueTransporterComponents();
    }
}
