package app.ui;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HeaderPanel extends JPanel {
    private static final long serialVersionUID = 1L; {
        setLayout(new BorderLayout());
        setBackground(new Color(30, 30, 30));
        setPreferredSize(new Dimension(0, 50));

        JLabel title = new JLabel("   Character Viewer");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel buttons = new JPanel();
        buttons.setOpaque(false);
        JButton discordButton = new JButton("Discord");
        JButton koFiButton = new JButton("Ko-Fi");

        ActionListener dummyAction = e -> JOptionPane.showMessageDialog(this, "Coming Soon!");
        discordButton.addActionListener(dummyAction);
        koFiButton.addActionListener(dummyAction);

        for (JButton b : new JButton[]{discordButton, koFiButton}) {
            b.setBackground(new Color(66, 133, 244));
            b.setForeground(Color.WHITE);
            b.setFocusPainted(false);
            b.setBorderPainted(false);
            buttons.add(b);
        }

        add(title, BorderLayout.WEST);
        add(buttons, BorderLayout.EAST);
    }
}
