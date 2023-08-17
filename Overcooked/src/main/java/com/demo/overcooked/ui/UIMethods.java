package com.demo.overcooked.ui;

import com.demo.overcooked.ui.orders.tiny.TinyCheeseBurger;
import com.demo.overcooked.ui.orders.tiny.TinyCheeseMeatBurger;
import com.demo.overcooked.ui.orders.tiny.TinyMeatBurger;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UIMethods {

    public void setBackgroundImage(JLabel label, String imagePath) {
        ImageIcon image = new ImageIcon(imagePath);
        label.setIcon(image);
    }

    public JPanel getRandomOrder(){
        JPanel[] orders = {
            new TinyCheeseBurger(),
            new TinyMeatBurger(),
            new TinyCheeseMeatBurger()
        };
        
        int randomIndex = new Random().nextInt(orders.length);
        
        return orders[randomIndex];
    }
}
