package app.ui;

import app.model.GameCharacter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * Panel that displays characters in a grid. Clicking a card shows character details.
 */
public class CharacterGridPanel extends JScrollPane {
    public CharacterGridPanel() {
        JPanel gridPanel = new JPanel(new GridLayout(0, 4, 10, 10));
        gridPanel.setBackground(new Color(30, 30, 30));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (GameCharacter character : getCharacters()) {
            JPanel card = createCard(character);
            gridPanel.add(card);
        }

        setViewportView(gridPanel);
        getVerticalScrollBar().setUnitIncrement(16);
    }

    private JPanel createCard(GameCharacter character) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        card.setPreferredSize(new Dimension(140, 200));
        card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel imgLabel = new JLabel(character.getImage());
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        imgLabel.setPreferredSize(new Dimension(120, 160));
        imgLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel nameLabel = new JLabel(character.getName(), JLabel.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        card.add(imgLabel, BorderLayout.CENTER);
        card.add(nameLabel, BorderLayout.SOUTH);

        MouseAdapter clickListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(card,
                        character.getDescription(),
                        character.getName(),
                        JOptionPane.INFORMATION_MESSAGE);
            }
        };
        card.addMouseListener(clickListener);
        imgLabel.addMouseListener(clickListener);
        nameLabel.addMouseListener(clickListener);

        return card;
    }

    private List<GameCharacter> getCharacters() {
        List<GameCharacter> list = new ArrayList<>();
        String[][] data = {
            {"Ayanokouji Kiyotaka", "A mysterious and brilliant student from Class D with unmatched capability."},
            {"Ichinose Honami", "Leader of Class B, known for her charisma and strong moral compass."},
            {"Suzune Horikita", "Determined to reach Class A and gain her brother’s approval."},
            {"Kakeru Ryueen", "Ruthless leader of Class C who believes in domination and power."},
            {"Hiyori Shiina", "Quiet but observant student with hidden skills."},
            {"Sakura Airi", "Shy girl with a surprising amount of inner strength."},
            {"Karuizawa Kei", "Social butterfly hiding a more vulnerable side."},
            {"Arisu Sakayanagi", "Physically frail but intellectually cunning leader of Class A."},
            {"Hashimoto Masayoshi", "An opportunist who's always looking for leverage."},
            {"Ibuki Mio", "Strong-willed and competitive fighter from Class C."},
            {"Sudo Ken", "Hot-headed athlete who grows under Ayanokouji’s influence."},
            {"Yosuke Hirata", "Popular student who tries to maintain peace among classmates."},
            {"Matsushita Chiaki", "Smart and supportive girl with a calm personality."},
            {"Kikyou Kushida", "Appears friendly, but hides a dark and manipulative personality."}
        };

        for (String[] item : data) {
            String name = item[0];
            String description = item[1];
            ImageIcon icon;

            // Use lowercase "chara" and a leading slash for getResource
            String imagePath = "/chara/" + name + ".jpg";
            java.net.URL imgUrl = getClass().getResource(imagePath);

            if (imgUrl != null) {
                icon = new ImageIcon(imgUrl);
            } else {
                System.out.println("Loading: " + imagePath + " -> " + imgUrl);
                icon = new ImageIcon(new BufferedImage(160, 160, BufferedImage.TYPE_INT_RGB));
            }

            Image scaled = icon.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaled);

            list.add(new GameCharacter(name, icon, description));
        }
        return list;
    }
}
