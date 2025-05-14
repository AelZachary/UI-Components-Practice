package app.model;

import javax.swing.ImageIcon;

/**
 * Model class representing a character.
 */
public class GameCharacter {
    private final String name;
    private final ImageIcon image;
    private final String description;

    /**
     * Constructs a GameCharacter with name, image, and description.
     */
    public GameCharacter(String name, ImageIcon image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}