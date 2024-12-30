package com.managementtask.ui;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        MainForm app = new MainForm();
        
        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setVisible(true);
    }
}
