package com.demo.overcooked.ui;

public class GameScreen {
    public GameScreen() {
        initGame();
    }
    
    private void initScreen(){
        Orders orders = Orders.getInstance();
        Transporter transporter = Transporter.getInstance();
        
        orders.setOpaqueOrderComponents();
        transporter.setOpaqueTransporterComponents();
    }
    
    private void initGame() {
        initScreen();
        new Timers().initTimers();
    }
}
