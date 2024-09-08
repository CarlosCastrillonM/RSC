package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class FormOferta extends JFrame{

    private int i;
    private JPanel panelMain;
    private JButton btnAgregarOf;
    private JScrollPane scrollPMain;
    private JPanel panelOferta;
    private JPanel panelPr1;
    private JPanel panelPr2;
    private JPanel panelPr3;
    private JScrollBar scrollBar1;
    private JPanel panelPr4;
    private JPanel panelPr5;
    private JPanel panelPr6;
    private JPanel panelPr7;
    private JPanel panelPr8;
    private JPanel panelPr9;
    private JPanel panelPr10;
    private JPanel panelPr11;
    private JPanel panelPr12;
    private JPanel panelPr13;


    public FormOferta(){
        btnAgregarOf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnAgregarOf, "Sirve");
            }
        });


        this.setContentPane(this.panelMain);
        this.setTitle("Ofertas");
        this.setVisible(true);
        this.setBounds(700, 100, 625, 300);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelOferta.setLayout(null);
        panelOferta.setBounds(0, 0, 580, 200);
        panelOferta.setBackground(Color.cyan);

        scrollPMain.setSize(625, 200);

        panelPr1.setBackground(Color.red);
        panelPr1.setBounds(0, 0, 580, 100);

        panelPr2.setBackground(Color.green);
        panelPr2.setBounds(0, 110, 580, 100);

        panelPr3.setBackground(Color.black);
        panelPr3.setBounds(0, 220, 580, 100);

        panelPr4.setBackground(Color.black);
        panelPr4.setBounds(0, 330, 580, 100);

        panelPr5.setBackground(Color.black);
        panelPr5.setBounds(0, 440, 580, 100);

        panelPr6.setBackground(Color.black);
        panelPr6.setBounds(0, 550, 580, 100);

        panelPr7.setBackground(Color.black);
        panelPr7.setBounds(0, 660, 580, 100);

        panelPr8.setBackground(Color.black);
        panelPr8.setBounds(0, 770, 580, 100);

        panelPr9.setBackground(Color.black);
        panelPr9.setBounds(0, 880, 580, 100);

        panelPr10.setBackground(Color.black);
        panelPr10.setBounds(0, 990, 580, 100);

        panelPr11.setBackground(Color.black);
        panelPr11.setBounds(0, 1100, 580, 100);

        panelPr12.setBackground(Color.black);
        panelPr12.setBounds(0, 1210, 580, 100);

        panelPr13.setBackground(Color.black);
        panelPr13.setBounds(0, 1320, 580, 100);

    }
}
