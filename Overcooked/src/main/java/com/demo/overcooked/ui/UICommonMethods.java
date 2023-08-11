package com.demo.overcooked.ui;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class UICommonMethods {
    
        public void setBackgroundImage(JLabel label, String imagePath) {
        ImageIcon image = new ImageIcon(imagePath);
        label.setIcon(image);
    }
}
