package gui;

import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
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

        button.setBackground(new Color(21, 21, 220));
        button.setForeground(new Color(255, 255, 255));

        button.setBounds(450, 800, 50, 50);
        absolute.add(button);

        button.addActionListener(e -> {

            Boolean isActivo = false;

            var formNuevaO = new FormNuevaOferta(this);
            formNuevaO.setVisible(true);
            this.dispose();



            var panelPr = new JPanel();
            panelPr.setLayout(new BorderLayout());
            panelPr.add(new JLabel("Hello world"));
            panelPr.setBackground(i % 2 == 0 ? Color.BLUE : Color.PINK);
            //panelPr.setPreferredSize(new Dimension(100, 125));

            Dimension fixedSize = new Dimension(100, 125);
            panelPr.setPreferredSize(fixedSize);
            panelPr.setMinimumSize(fixedSize);
            panelPr.setMaximumSize(fixedSize);

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
    private final int radius;

    public RoundedButtonAgregar(String text, int radius) {
        super(text);
        this.radius = radius;
        setContentAreaFilled(false); // Evita el fondo por defecto
        setFocusPainted(false); // Evita el borde de enfoque al hacer clic
        setOpaque(false); // Hace el botón no opaco para evitar problemas de fondo
        setBorderPainted(false); // Evita que el botón pinte su propio borde
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja el fondo redondeado del botón
        if (getModel().isPressed()) {
            g2.setColor(getBackground().darker()); // Cambia el color al hacer clic
        } else if (getModel().isRollover()) {
            g2.setColor(getBackground().brighter()); // Cambia el color al pasar el mouse
        } else {
            g2.setColor(getBackground());
        }

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // Ajuste de opacidad para asegurar que solo se dibuje el texto sin fondo
        g2.setComposite(AlphaComposite.SrcOver);
        super.paintComponent(g2);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius); // Borde redondeado
        g2.dispose();
    }
}
