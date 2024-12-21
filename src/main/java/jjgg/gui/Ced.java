package jjgg.gui;

import jjgg.logic.Car;
import jjgg.logic.Controller;

import javax.swing.*;
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
            clear();
            menu.showMessage("clear","clear","info");
        });

        //----edit
        editButton.addActionListener(e ->{
            if(list1.getSelectedValue()!=null){
                Car car = (Car) list1.getSelectedValue();
                long id = car.getId();
                c.updatecar(id,modeltf.getText(),brandtx.getText(),motortx.getText(),colortx.getText(),registertx.getText(),(int)doorsspnr.getValue());
                loadinfo();
                clear();
                menu.showMessage("edit complete","edit","info");
            } else{
                menu.showMessage("No car selected","Error","error");
            }
        });

        //----load car by selection
        list1.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Car car =(Car)list1.getSelectedValue();
                if(car != null){
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
            Car car = (Car) list1.getSelectedValue();
            if(car != null){
                c.deleteCar(car);
                loadinfo();
                menu.showMessage("Delete complete","delete","warning");
            } else {
                menu.showMessage("No car selected","Error","error");
            }
        });
    }

    public void loadinfo() {
        DefaultListModel<Car> dlm = new DefaultListModel<>(); // Crear modelo de lista
        List<Car> cars = c.getAllCars();
        for(Car c : cars){
            dlm.addElement(c);
        }
        list1.setModel(dlm);
        clear();
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
