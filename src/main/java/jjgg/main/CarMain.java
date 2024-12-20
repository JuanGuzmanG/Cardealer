package jjgg.main;

import jjgg.gui.Menu;

import javax.swing.*;

public class CarMain {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}