package jjgg.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel principaljframe;
    private JPanel TITLE;
    private JButton altaDeAutomovilesButton;
    private JButton salirButton;
    private JButton consultaEdicionYBajaButton;

    //windows
    private AltaAutomoviles aa = new AltaAutomoviles();
    public void openAltaAutomoviles(AltaAutomoviles altaAutomoviles) {this.aa = altaAutomoviles;}
    private Ced c = new Ced();
    public void openceb(Ced c){this.c = c;}

    public Menu() {
        setTitle("Menu");
        setContentPane(principaljframe);
        pack();

        altaDeAutomovilesButton.addActionListener(e -> {
            aa.setMenu(Menu.this);
            aa.setVisible(true);
            aa.setLocationRelativeTo(Menu.this);
            setVisible(false);
        });
        consultaEdicionYBajaButton.addActionListener(e -> {
            c.loadinfo();
            c.openMenu(Menu.this);
            c.setVisible(true);
            c.setLocationRelativeTo(Menu.this);
            setVisible(false);
        });
        salirButton.addActionListener(e ->{
            System.exit(0);
        });
    }

    public void showMessage(String msg,String title,String type) {
        JOptionPane op = new JOptionPane(msg);
        if(type.equals("info")){
            op.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }else if(type.equals("error")){
            op.setMessageType(JOptionPane.ERROR_MESSAGE);
        }else if(type.equals("warning")){
            op.setMessageType(JOptionPane.WARNING_MESSAGE);
        }
        JDialog dialog = op.createDialog(title);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
}
