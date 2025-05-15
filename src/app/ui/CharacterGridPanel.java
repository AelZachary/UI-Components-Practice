package app.ui;

import app.model.GameCharacter;
import app.model.GameCharacter.CharacterClass;
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
    private List<GameCharacter> allCharacters;
    private JPanel gridPanel;

    public CharacterGridPanel() {
        allCharacters = getCharacters();
        gridPanel = new JPanel(new GridLayout(0, 4, 10, 10));
        gridPanel.setBackground(new Color(30, 30, 30));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setViewportView(gridPanel);
        getVerticalScrollBar().setUnitIncrement(16);
        showCharacters(CharacterClass.HOME); // Show all by default
    }

    public void showCharacters(CharacterClass filter) {
        gridPanel.removeAll();
        for (GameCharacter character : allCharacters) {
            if (filter == CharacterClass.HOME || character.getCharacterClass() == filter) {
                JPanel card = createCard(character);
                gridPanel.add(card);
            }
        }
        gridPanel.revalidate();
        gridPanel.repaint();
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
            // CLASS A
            {"Arisu Sakayanagi", "Physically frail but intellectually cunning leader of Class A.", "CLASS_A"},
            {"Kamuro Masumi", "Quiet and loyal, always supporting Sakayanagi from the shadows.", "CLASS_A"},
            {"Totsuka Yahiko", "Eager to prove himself, though often overlooked by his peers.", "CLASS_A"},
            {"Hashimoto Masayoshi", "An opportunist who's always looking for leverage.", "CLASS_A"},

            // CLASS B
            {"Ichinose Honami", "Leader of Class B, known for her charisma and strong moral compass.", "CLASS_B"},
            {"Shibata Sou", "Friendly and athletic, always ready to help classmates.", "CLASS_B"},
            {"Kanzaki Ryuuji", "Calm and analytical, a reliable strategist for Class A.", "CLASS_B"},
            {"Chihiro Shiranami", "kind-hearted and emotionally vulnerable student from Class B", "CLASS_B"},
            

            // CLASS C
            {"Kakeru Ryueen", "Ruthless leader of Class C who believes in domination and power.", "CLASS_C"},
            {"Ibuki Mio", "Strong-willed and competitive fighter from Class C.", "CLASS_C"},
            {"Ishizaki Daichi", "Loud and brash, fiercely loyal to Ryueen.", "CLASS_C"},
            {"Albert Yamada", "Tall and intimidating, but surprisingly gentle with friends.", "CLASS_C"},
            {"Hiyori Shiina", "Quiet but observant student with hidden skills.", "CLASS_C"},

            // CLASS D
            {"Ayanokouji Kiyotaka", "A mysterious and brilliant student from Class D with unmatched capability.", "CLASS_D"},
            {"Suzune Horikita", "Determined to reach Class A and gain her brother’s approval.", "CLASS_D"},
            {"Sakura Airi", "Shy girl with a surprising amount of inner strength.", "CLASS_D"},
            {"Karuizawa Kei", "Social butterfly hiding a more vulnerable side.", "CLASS_D"},
            {"Sudo Ken", "Hot-headed athlete who grows under Ayanokouji’s influence.", "CLASS_D"},
            {"Yosuke Hirata", "Popular student who tries to maintain peace among classmates.", "CLASS_D"},
            {"Matsushita Chiaki", "Smart and supportive girl with a calm personality.", "CLASS_D"},
            {"Kikyou Kushida", "Appears friendly, but hides a dark and manipulative personality.", "CLASS_D"},
            {"Kanji Ike", "Easygoing and cheerful, always lightening the mood.", "CLASS_D"},
            {"Yamauchi Haruki", "Comedic and sometimes clueless, but loyal to his friends.", "CLASS_D"},
            {"Miyake Akito", "Protective and straightforward, values honesty above all.", "CLASS_D"},
            {"Onodera Kayano", "Energetic and optimistic, brings positivity to the class.", "CLASS_D"},
        };

        for (String[] item : data) {
            String name = item[0];
            String description = item[1];
            String className = item[2];
            ImageIcon icon;

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

            CharacterClass characterClass = CharacterClass.valueOf(className);

            list.add(new GameCharacter(name, icon, description, characterClass));
        }
        return list;
    }
}
