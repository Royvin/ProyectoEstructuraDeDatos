package com.demo.overcooked.ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Common {
    
    public void setPanelOpaque(JPanel panel){
        panel.setOpaque(false);
    }
    
    public void setPanelsOpaque(JPanel[] panels){
        for (JPanel panel : panels) {
            panel.setOpaque(false);
        }
    }
    
    public void setBtnOpaque(JButton btn){
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
    }
    
    public void setBtnsOpaque(JButton[] buttons){
        for (JButton button : buttons) {
            setBtnOpaque(button);
        }
    }
    
    public void setBackgroundImage(JLabel backgroundLbl, String imagePath){
        ImageIcon image = new ImageIcon(imagePath);
        System.out.println(image);
        backgroundLbl.setIcon(image);
    }
}
