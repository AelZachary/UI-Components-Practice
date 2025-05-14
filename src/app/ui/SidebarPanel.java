package app.ui;

import app.model.GameCharacter.CharacterClass;
import java.awt.*;
import java.util.function.Consumer;
import javax.swing.*;

public class SidebarPanel extends JPanel {
    public SidebarPanel(Consumer<CharacterClass> onClassSelected) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(40, 40, 40));
        setPreferredSize(new Dimension(160, 0));

        Object[][] items = {
            {"Home", CharacterClass.HOME},
            {"Class A", CharacterClass.CLASS_A},
            {"Class B", CharacterClass.CLASS_B},
            {"Class C", CharacterClass.CLASS_C},
            {"Class D", CharacterClass.CLASS_D}
        };
        for (Object[] item : items) {
            JButton button = new JButton((String)item[0]);
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            button.setBackground(new Color(60, 60, 60));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorderPainted(false);
            button.addActionListener(e -> onClassSelected.accept((CharacterClass)item[1]));
            add(Box.createRigidArea(new Dimension(0, 5)));
            add(button);
        }
    }
}