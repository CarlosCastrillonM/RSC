package gui;

import javax.swing.*;
import java.awt.*;

public class FormPrueba extends JFrame{
    private JPanel panelOferta;
    private JScrollBar scrollBar;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;

    public FormPrueba(){
        this.setLayout(null);
        this.setContentPane(this.panelOferta);
        this.setTitle("Ofertas");
        this.setVisible(true);
        this.setBounds(700, 100, 625, 300);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        p1.setBackground(Color.red);
        p1.setBounds(0, 0, 580, 250);

        p2.setBackground(Color.green);
        p2.setBounds(0, 110, 580, 250);

        p3.setBackground(Color.black);
        p3.setBounds(0, 220, 580, 250);

        p4.setBackground(Color.black);
        p4.setBounds(0, 330, 580, 250);
    }
}
