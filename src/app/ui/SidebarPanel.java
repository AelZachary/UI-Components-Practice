package app.ui;

import java.awt.*;
import javax.swing.*;

public class SidebarPanel extends JPanel {
    public SidebarPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(40, 40, 40));
        setPreferredSize(new Dimension(160, 0));

        String[] items = {"Home", "Class A", "Class B", "Class C", "Class D",};
        for (String item : items) {
            JButton button = new JButton(item);
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            button.setBackground(new Color(60, 60, 60));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorderPainted(false);
            add(Box.createRigidArea(new Dimension(0, 5)));
            add(button);
        }
    }
}