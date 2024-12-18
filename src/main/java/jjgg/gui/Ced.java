package jjgg.gui;

import javax.swing.*;

public class Ceb extends JFrame {
    private JTextField modeltf;
    private JSpinner doorsspnr;
    private JButton clearButton;
    private JList list1;
    private JButton deleteButton;
    private JButton editButton;
    private JPanel cebpanel;
    private JButton returnButton;

    private Menu menu;
    public void openMenu(Menu menu){this.menu = menu;}

    public Ceb() {
       pack();
       setTitle("Create Edit Delete");
       setContentPane(cebpanel);

        returnButton.addActionListener(e -> {
            menu.openceb(Ceb.this);
            setVisible(false);
            menu.setVisible(true);
        });
    }
}
