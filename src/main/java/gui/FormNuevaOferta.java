package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FormNuevaOferta extends JFrame {

    private JComboBox<String> tipoVehiculo;
    private JTextField marcaField, capacidadField, fechaField, horarioField, destinoField;
    private JButton btnCrear;
    private FormOferta formOferta;

    public FormNuevaOferta(FormOferta formOferta) {

        this.formOferta = formOferta;

        // Agregar un WindowListener para detectar cuando se cierra el Formulario2
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Mostrar el Formulario1 cuando se cierra el Formulario2
                formOferta.setVisible(true);
            }
        });

        // Configuración de la ventana
        setResizable(false);
        setTitle("Agregar nueva oferta");
        setSize(600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));

        JPanel c = new JPanel();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        c.setBorder(new EmptyBorder(30, 30, 300, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // Título
        var contTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        var titulo = new CustomText("Agregar nueva oferta", 24);
        contTitulo.add(titulo);
        c.add(contTitulo);

        // Información del vehículo
        JPanel infoVehiculo = new JPanel();
        infoVehiculo.setLayout(new GridLayout(4, 2, 10, 10));
        infoVehiculo.setBorder(new EmptyBorder(20, 20,20,20));
        infoVehiculo.setBackground(new Color(217, 217, 217));

        infoVehiculo.add(new CustomText("Información del vehículo").setStyle(Font.BOLD));
        infoVehiculo.add(new CustomText(""));
        infoVehiculo.add(new CustomText("Tipo de vehículo:"));
        tipoVehiculo = new JComboBox<>(new String[]{"Bus", "Taxi", "Moto", "Particular"});
        tipoVehiculo.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 16));
        infoVehiculo.add(tipoVehiculo);

        infoVehiculo.add(new CustomText("Marca:"));
        marcaField = new CustomInput();
        infoVehiculo.add(marcaField);

        infoVehiculo.add(new CustomText("Capacidad:"));
        capacidadField = new CustomInput();
        infoVehiculo.add(capacidadField);

        c.add(infoVehiculo);

        // Detalles de la oferta

        JPanel infoOferta = new JPanel();
        infoOferta.setBorder(new EmptyBorder(20, 20,20,20));
        infoOferta.setLayout(new GridLayout(3, 2, 10, 10));

        infoOferta.add(new CustomText("Fecha:", Color.WHITE));
        fechaField = new CustomInput();
        fechaField.setBackground(Color.WHITE);
        infoOferta.add(fechaField);

        infoOferta.add(new CustomText("Horario:", Color.WHITE));
        horarioField = new CustomInput();
        horarioField.setBackground(Color.WHITE);
        infoOferta.add(horarioField);

        infoOferta.add(new CustomText("Destino:", Color.WHITE));
        destinoField = new CustomInput();
        destinoField.setBackground(Color.WHITE);
        infoOferta.add(destinoField);

        c.add(infoOferta);

        // Botón para crear
        btnCrear = new RoundedButton("Crear oferta", 20);
        btnCrear.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        btnCrear.setBackground(new Color(13, 71, 153));
        btnCrear.setBorder(new EmptyBorder(20, 40, 20, 40));
        btnCrear.setForeground(Color.WHITE);
        var btnContenedor = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnContenedor.add(btnCrear);
        c.add(btnContenedor);

        add(c);

        // Acción del botón
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = tipoVehiculo.getSelectedItem().toString();
                String marca = marcaField.getText();
                int capacidad = Integer.parseInt(capacidadField.getText());
                String fecha = fechaField.getText();
                String horario = horarioField.getText();
                String destino = destinoField.getText();

                // Aquí puedes procesar los datos o guardarlos según sea necesario
                JOptionPane.showMessageDialog(null, "Oferta creada:\n" +
                        "Tipo: " + tipo + "\n" +
                        "Marca: " + marca + "\n" +
                        "Capacidad: " + capacidad + "\n" +
                        "Fecha: " + fecha + "\n" +
                        "Horario: " + horario + "\n" +
                        "Destino: " + destino);
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormNuevaOferta(new FormOferta()).setVisible(true);
            }
        });
    }
}

class CustomText extends JLabel {

    public CustomText(String text, Color color) {
        setText(text);
        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        setBackground(color);
    }
    public CustomText(String text, int size) {
        setText(text);
        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, size));
    }

    public CustomText(String text) {
        this(text, 18);
    }

    public CustomText setStyle(int constant) {
        Font font = getFont();
        setFont(new Font(font.getName(), constant, font.getSize()));
        return this;
    }
}

class CustomInput extends JTextField {


    public CustomInput() {
        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
    }

}


class RoundedButton extends JButton {
    private int radius;

    public RoundedButton(String text, int radius) {
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
