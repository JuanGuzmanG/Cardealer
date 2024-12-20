package jjgg.gui;

import javax.swing.*;

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
    }
}
