package gui;

import javax.swing.*;

public class ScrollComponent extends JFrame {
    public ScrollComponent() {

        var wrap = new JPanel();
        wrap.setLayout(new BoxLayout(wrap, BoxLayout.Y_AXIS));

        for (int i = 0; i < 30; i++) {
            var post = new JPanel();
            post.add(new JLabel("Publication " + i));
            wrap.add(post);
        }

        var scroll = new JScrollPane(wrap);

        add(scroll);
    }

    public static void main(String[] args) {
        new ScrollComponent().setVisible(true);
    }
}
