package gui;

import datos.Oferta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CartaOferta extends JPanel {
    public CartaOferta(Oferta oferta) {
        setLayout(new GridLayout(2, 3, 0, 0));
        setForeground(Color.WHITE);
        List<JPanel> infos = List.of(
                new InfoOfertaBuilder()
                        .propertyName("Tipo de transporte")
                        .propertyValue(oferta.getTipoTransporte())
                        .build(),
                new InfoOfertaBuilder()
                        .propertyName("Destino")
                        .propertyValue(oferta.getDestino())
                        .build(),
                new InfoOfertaBuilder()
                        .propertyName("Fecha")
                        .propertyValue(oferta.getFecha().toString())
                        .build(),
                new InfoOfertaBuilder()
                        .propertyName("Marca")
                        .propertyValue(oferta.getMarca())
                        .build(),
                new InfoOfertaBuilder()
                        .propertyName("Capacidad")
                        .propertyValue(Integer.toString(oferta.getCapacidad()))
                        .build(),
                new InfoOfertaBuilder()
                        .propertyName("Hora")
                        .propertyValue(oferta.getHorario().format(DateTimeFormatter.ofPattern("HH:mm")))
                        .build()
                );

        for (var info : infos) {
            add(info);
        }
    }
}

class InfoOfertaBuilder {
    private final JPanel panel;
    private final JLabel propertyName;
    private final JLabel propertyValue;

    public InfoOfertaBuilder() {
        panel = new JPanel(new GridLayout(2, 1, 0, 0));

        var pnl = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        var pvl = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        pnl.setBackground(new Color(7, 98, 228));
        pvl.setBackground(new Color(7, 98, 228));
        panel.setBackground(new Color(7, 98, 228));

        propertyName = new JLabel();
        propertyValue = new JLabel();
        propertyName.setForeground(Color.WHITE);
        propertyValue.setForeground(Color.WHITE);

        propertyName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        propertyValue.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        pnl.add(propertyName);
        pvl.add(propertyValue);
        panel.add(pnl);
        panel.add(pvl);
        panel.setPreferredSize(new Dimension(161, 59));
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("panel info size: " + panel.getSize());
                System.out.println("panel property name size: " + pnl.getSize());
                System.out.println("panel property value size: " + pvl.getSize());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public InfoOfertaBuilder propertyValue(String pv) {
        propertyValue.setText(pv);
        return this;
    }

    public InfoOfertaBuilder propertyName(String pn) {
        propertyName.setText(pn);
        return this;
    }

    public JPanel build() {
        return panel;
    }

}
