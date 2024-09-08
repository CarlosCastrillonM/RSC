package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FormOferta extends JFrame {

    private JPanel panelMain;
    private JPanel panelOferta;

    private Integer i = 0;

    public FormOferta() {
        panelOferta = new JPanel();
        panelOferta.setLayout(new GridLayout(0, 1, 0, 0));

        this.setTitle("Ofertas");
        this.setBounds(700, 100, 545, 900);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelOferta.setBackground(Color.cyan);

        var absolute = new JPanel(null);

        JButton button;
        button = new RoundedButtonAgregar("+", 100);

        button.setBounds(450, 800, 50, 50);
        absolute.add(button);

        button.addActionListener(e -> {
            var panelPr = new JPanel();
            panelPr.setLayout(new BorderLayout());
            panelPr.add(new JLabel("Hello world"));
            panelPr.setBackground(i % 2 == 0 ? Color.BLUE : Color.PINK);
            panelPr.setPreferredSize(new Dimension(100, 100));
            panelOferta.add(panelPr);
            panelOferta.revalidate();
            panelOferta.repaint();
            i++;
        });
        var wrap = new JPanel();
        wrap.setLayout(new BorderLayout());
        wrap.add(button, BorderLayout.CENTER);
        wrap.add(panelOferta);
        var scroll = new JScrollPane(wrap);
        scroll.getVerticalScrollBar().setUnitIncrement(15);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scroll.addMouseWheelListener(e -> {
            int dy = scroll.getVerticalScrollBar().getValue();
            var bounds = button.getBounds();
            bounds.y = 800 + dy;
            button.setBounds(bounds);
            absolute.revalidate();
            absolute.repaint();
        });

        add(scroll);

    }
}

class RoundedButtonAgregar extends JButton {
    private int radius;

    public RoundedButtonAgregar(String text, int radius) {
        super(text);
        this.radius = radius;
        setContentAreaFilled(false); // Evita el fondo por defecto
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius); // Fondo redondeado
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius); // Borde redondeado
        g2.dispose();
    }
}
