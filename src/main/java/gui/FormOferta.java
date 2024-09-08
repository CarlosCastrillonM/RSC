package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormOferta extends JFrame{

    private JPanel panelMain;
    private JButton btnAgregarOf;
    private JScrollPane scrollPMain;
    private JPanel panelOferta;
    private JPanel panelPr1;
    private JPanel panelPr2;


    public FormOferta(){
        btnAgregarOf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnAgregarOf, "Sirve");
            }
        });

        this.setLayout(null);
        this.setContentPane(this.panelMain);
        this.setTitle("Ofertas");
        this.setVisible(true);
        this.setBounds(700, 100, 600, 900);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelOferta.setLayout(null);
        panelOferta.setBounds(0, 0, 580, 200);
        panelOferta.setBackground(Color.cyan);

        panelPr1.setBackground(Color.red);
        panelPr1.setBounds(0, 0, 580, 100);

        panelPr2.setBackground(Color.green);
        panelPr2.setBounds(0, 110, 580, 100);



    }
}
