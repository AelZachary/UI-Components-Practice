package app;

import app.ui.CharacterGridPanel;
import app.ui.HeaderPanel;
import app.ui.SidebarPanel;
import java.awt.*;
import javax.swing.*;

public class MainApp extends JFrame {
    public MainApp() {
        setTitle("Classroom of the Elite Characters");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        HeaderPanel header = new HeaderPanel();
        SidebarPanel sidebar = new SidebarPanel();
        CharacterGridPanel grid = new CharacterGridPanel();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebar, grid);
        splitPane.setDividerLocation(180);
        splitPane.setResizeWeight(0);

        setLayout(new BorderLayout());
        add(header, BorderLayout.NORTH);
        add(splitPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainApp::new);
    }
}