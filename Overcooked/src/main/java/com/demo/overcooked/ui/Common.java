package com.demo.overcooked.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Common {

      public void clearPanel(JPanel panel) {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }
    
    public void setPanelOpaque(JPanel panel) {
        panel.setOpaque(false);
    }

    public void setPanelsOpaque(JPanel[] panels) {
        for (JPanel panel : panels) {
            panel.setOpaque(false);
        }
    }

    public void setBtnOpaque(JButton btn) {
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
    }

    public void setBtnsOpaque(JButton[] buttons) {
        for (JButton button : buttons) {
            setBtnOpaque(button);
        }
    }

    public void setBackgroundImage(JLabel backgroundLbl, String imagePath) {
        ImageIcon image = new ImageIcon(imagePath);
        backgroundLbl.setIcon(image);
    }
    
    public Component[] getComponents(JPanel parentPanel, String componentsName) {
        Component[] screenComponents = 
                GameScreenUI.getInstance().getContentPane().getComponents();

        if (parentPanel != null) {
            screenComponents = parentPanel.getComponents();
        }

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

    public void addContentToPanel(
            JPanel orderParentPanel,
            JPanel orderContent,
            int[] orderContentSize
    ) {
        orderContent.setSize(orderContentSize[0], orderContentSize[1]);
        orderContent.setLocation(0, 0);

        orderParentPanel.add(orderContent, BorderLayout.CENTER);
        orderParentPanel.revalidate();
        orderParentPanel.repaint();
    }
    
    public boolean panelIsEmpty(JPanel panel){
        Component[] panelComponents = panel.getComponents();
        
        return panelComponents.length == 0 ? true : false;
    }
    
    public boolean parentPanelIsEmpty(JPanel parentPanel) {
        Component[] orderComponents = parentPanel.getComponents();

        return orderComponents.length == 0 ? true : false;
    }
    
    public int getRandomNumber(int max){
        return new Random().nextInt(max);
    }
}
