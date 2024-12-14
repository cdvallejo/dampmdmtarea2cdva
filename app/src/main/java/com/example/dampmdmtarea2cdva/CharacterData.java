package com.example.dampmdmtarea2cdva;

/**
 * Clase que representa los datos de un personaje, incluyendo su imagen, nombre, descripción y habilidades.
 */
public class CharacterData {

    /**
     * ID del recurso de la imagen del personaje.
     */
    private final int image;

    /**
     * Nombre del personaje.
     */
    private final String name;

    /**
     * Descripción del personaje.
     */
    private final String description;

    /**
     * Habilidades o destrezas del personaje.
     */
    private final String skills;

    /**
     * Constructor para inicializar los datos de un personaje.
     *
     * @param image       ID del recurso de la imagen del personaje.
     * @param name        Nombre del personaje.
     * @param description Descripción del personaje.
     * @param skills      Habilidades o destrezas del personaje.
     */
    public CharacterData(int image, String name, String description, String skills) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.skills = skills;
    }

    /**
     * Obtiene el ID del recurso de la imagen del personaje.
     *
     * @return ID del recurso de la imagen.
     */
    public int getImage() {
        return image;
    }

    /**
     * Obtiene el nombre del personaje.
     *
     * @return Nombre del personaje.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene la descripción del personaje.
     *
     * @return Descripción del personaje.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Obtiene las habilidades o destrezas del personaje.
     *
     * @return Habilidades del personaje.
     */
    public String getSkills() {
        return skills;
    }
}