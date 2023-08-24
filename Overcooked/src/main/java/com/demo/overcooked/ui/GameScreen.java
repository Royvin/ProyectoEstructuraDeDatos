package com.demo.overcooked.ui;

public class GameScreen {
    public GameScreen() {
        initGame();
    }
    
    private void initScreen(){
        Orders.getInstance();
        Transporter.getInstance();
    }
    
    private void initGame() {
        initScreen();
        new Timers().initTimers();
    }
}
