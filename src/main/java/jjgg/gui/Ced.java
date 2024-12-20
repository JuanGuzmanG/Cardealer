package jjgg.gui;

import jjgg.logic.Car;
import jjgg.logic.Controller;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Ced extends JFrame {
    private JTextField modeltf;
    private JSpinner doorsspnr;
    private JButton clearButton;
    private JList list1;
    private JButton deleteButton;
    private JButton editButton;
    private JPanel cebpanel;
    private JButton returnButton;
    private JTextField brandtx;
    private JTextField colortx;
    private JTextField motortx;
    private JTextField registertx;

    private Menu menu;
    public void openMenu(Menu menu){this.menu = menu;}

    Controller c = new Controller();

    public Ced() {
        setTitle("Create Edit Delete");
        setContentPane(cebpanel);
        pack();

        //----return
        returnButton.addActionListener(e -> {
            menu.openceb(Ced.this);
            setVisible(false);
            menu.setVisible(true);
        });

        //----cleartexts
        clearButton.addActionListener(e ->{
            modeltf.setText("");
            brandtx.setText("");
            colortx.setText("");
            motortx.setText("");
            registertx.setText("");
            doorsspnr.setValue(0);

        });

        //----edit
        editButton.addActionListener(e ->{
            if(list1.getSelectedValue()!=null){
                String model = list1.getSelectedValue().toString();
                Car car = c.getCarByModel(model);
                long id = car.getId();
                c.updatecar(id,modeltf.getText(),brandtx.getText(),colortx.getText(),motortx.getText(),registertx.getText(),(int)doorsspnr.getValue());
                loadinfo();
            } else{
                System.out.println("vacio");
            }

        });

        //----load car by selection
        list1.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                if(list1.getSelectedValue() != null){
                    String model = list1.getSelectedValue().toString();
                    Car car = c.getCarByModel(model);
                    modeltf.setText(car.getModel());
                    brandtx.setText(car.getBrand());
                    colortx.setText(car.getColor());
                    motortx.setText(car.getMotor());
                    registertx.setText(car.getRegistration());
                    doorsspnr.setValue(car.getDoors());
                }
            }
        });
        deleteButton.addActionListener(e -> {
            String model = list1.getSelectedValue().toString();
            Car car = c.getCarByModel(model);
            c.deleteCar(car);
            loadinfo();
        });
    }

    public void loadinfo() {
        DefaultListModel<String> dlm = new DefaultListModel<>(); // Crear modelo de lista
        List<Car> cars = c.getAllCars();
        List<String> name = new ArrayList<>();
        for(Car c : cars){
            name.add(c.getModel());
        }
        for (String s : name){
            dlm.addElement(s);
        }
        list1.setModel(dlm);
    }

}
