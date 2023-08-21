package com.demo.overcooked.ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class Common {
    public void setBtnOpaque(JButton btn){
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
    }
    
    public void setBackgroundImage(JLabel backgroundLbl, String imagePath){
        ImageIcon image = new ImageIcon(imagePath);
        backgroundLbl.setIcon(image);
    }
}
