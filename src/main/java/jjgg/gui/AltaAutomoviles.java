package jjgg.gui;

import jjgg.logic.Controller;

import javax.swing.*;

public class AltaAutomoviles extends JFrame {

    private JTextField modeltf;
    private JSpinner doorsspnr;
    private JButton addButton;
    private JButton clearButton;
    private JButton returnButton;
    private JPanel aapane;
    private JTextField brandtx;
    private JTextField motortx;
    private JTextField colortx;
    private JTextField registertx;

    //----windows
    private Menu menu;
    public void setMenu(Menu menu) {this.menu = menu;}

    //----controllers
    private Controller ctr= new Controller();

    public AltaAutomoviles() {
        //----init
        setContentPane(aapane);
        setTitle("Alta");
        pack();

        //----return button
        returnButton.addActionListener(e -> {
            menu.openAltaAutomoviles(AltaAutomoviles.this);
            setVisible(false);
            menu.setVisible(true);
        });

        //----add button
        addButton.addActionListener(e ->{
            String model = modeltf.getText();
            String brand = brandtx.getText();
            String motor = motortx.getText();
            String color = colortx.getText();
            String registration = registertx.getText();
            int doors = (int)doorsspnr.getValue();

            ctr.createCar(model,brand,motor,color,registration,doors);
            menu.showMessage("Create Successfully","Create","info");
            clear();
        });

        //---clear button
        clearButton.addActionListener(e ->{
            clear();
        });
    }

    public void clear(){
        modeltf.setText("");
        brandtx.setText("");
        motortx.setText("");
        colortx.setText("");
        registertx.setText("");
        doorsspnr.setValue(0);
    }

}
