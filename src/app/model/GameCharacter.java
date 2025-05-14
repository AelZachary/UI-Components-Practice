package app.model;

import javax.swing.*;

/**
 * Model class representing a character.
 */
public class GameCharacter {
    public enum CharacterClass { HOME, CLASS_A, CLASS_B, CLASS_C, CLASS_D }

    private String name;
    private ImageIcon image;
    private String description;
    private CharacterClass characterClass;

    /**
     * Constructs a GameCharacter with name, image, description, and character class.
     */
    public GameCharacter(String name, ImageIcon image, String description, CharacterClass characterClass) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.characterClass = characterClass;
    }

    public String getName() { return name; }
    public ImageIcon getImage() { return image; }
    public String getDescription() { return description; }
    public CharacterClass getCharacterClass() { return characterClass; }
}