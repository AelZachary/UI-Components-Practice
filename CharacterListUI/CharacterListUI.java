
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;

// Character model
class Character {
    String name;
    ImageIcon image;

    public Character(String name, ImageIcon image) {
        this.name = name;
        this.image = image;
    }
}

// Main UI class
public class CharacterListUI extends JFrame {

    public CharacterListUI() {
        // Optional: Remove window frame
        setUndecorated(true);

        setTitle("Honkai: Star Rail Characters");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(createTopBar(), BorderLayout.NORTH);
        add(createSidebar(), BorderLayout.WEST);
        add(createCharacterGrid(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createTopBar() {
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(30, 30, 30));
        topBar.setPreferredSize(new Dimension(0, 50));

        JLabel title = new JLabel("  Honkai: Star Rail Characters List");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel buttons = new JPanel();
        buttons.setOpaque(false);
        JButton discordButton = new JButton("Join Discord");
        JButton koFiButton = new JButton("Buy us a Ko-Fi");

        // Button styles
        discordButton.setBackground(new Color(66, 133, 244));
        koFiButton.setBackground(new Color(255, 66, 77));
        for (JButton b : new JButton[]{discordButton, koFiButton}) {
            b.setForeground(Color.WHITE);
            b.setFocusPainted(false);
            b.setBorderPainted(false);
        }

        buttons.add(discordButton);
        buttons.add(koFiButton);

        topBar.add(title, BorderLayout.WEST);
        topBar.add(buttons, BorderLayout.EAST);

        return topBar;
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(40, 40, 40));
        sidebar.setPreferredSize(new Dimension(160, 0));

        String[] menuItems = {
                "Home", "Characters", "Tier List", "Memory of Chaos",
                "Light Cones", "Relics", "Guides", "Tools"
        };

        for (String item : menuItems) {
            JButton button = new JButton(item);
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            button.setFocusPainted(false);
            button.setBorderPainted(false);
            button.setBackground(new Color(60, 60, 60));
            button.setForeground(Color.WHITE);
            sidebar.add(Box.createRigidArea(new Dimension(0, 5)));
            sidebar.add(button);
        }

        return sidebar;
    }

    private JScrollPane createCharacterGrid() {
        JPanel gridPanel = new JPanel(new GridLayout(0, 4, 10, 10));
        gridPanel.setBackground(new Color(30, 30, 30));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        List<Character> characters = getCharacters();

        for (Character character : characters) {
            JPanel card = new JPanel();
            card.setLayout(new BorderLayout());
            card.setBackground(Color.WHITE);
            card.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

            JLabel imgLabel = new JLabel(character.image);
            imgLabel.setHorizontalAlignment(JLabel.CENTER);
            JLabel nameLabel = new JLabel(character.name, JLabel.CENTER);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 14));

            card.add(imgLabel, BorderLayout.CENTER);
            card.add(nameLabel, BorderLayout.SOUTH);

            gridPanel.add(card);
        }

        JScrollPane scrollPane = new JScrollPane(gridPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        return scrollPane;
    }

    private List<Character> getCharacters() {
        List<Character> list = new ArrayList<>();
        String[] names = {
            "Ayanokouji Kiyotaka", "Ichinose Honami", "Suzune Horikita", "Kakeru Ryueen", "Hiyori Shiina",
            "Sakura Airi", "Karuizawa Kei", "Arisu Sakayanagi",
            "Hashimoto Masayoshi", "Ibuki Mio", "Sudo Ken",
            "Yosuke Hirata", "Matsushita Chiaki", "Kikyou Kushida"
        };

    // Load your one image
        for (String name : names) {
        try {
            ImageIcon icon = new ImageIcon("Characters/" + name + ".jpg");
            Image scaledImage = icon.getImage().getScaledInstance(120, 160, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
            list.add(new Character(name, icon));
        } catch (Exception e) {
            System.out.println("Image not found for: " + name);
            // Use blank placeholder
            ImageIcon placeholder = new ImageIcon(new BufferedImage(120, 160, BufferedImage.TYPE_INT_RGB));
            list.add(new Character(name, placeholder));
        }
    }

    return list;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CharacterListUI::new);
    }
}
