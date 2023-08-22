package com.demo.overcooked.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Common {

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
