package com.dicsstartup.devformfx.devInputs;

import javafx.scene.control.CheckBox;

/**
 * Clase CheckBoxItem que representa una opción con un nombre, una etiqueta y un valor inicial.
 * <p>
 * Autor: Didier Piracoca
 */
public class CheckBoxItem extends CheckBox {

    // Nombre de la opción
    String key;

    // Etiqueta de la opción
    String label;

    /**
     * Constructor de la clase CheckBoxItem con valor inicial.
     *
     * @param name      El nombre de la opción.
     * @param label     La etiqueta de la opción.
     * @param initValue El valor inicial de la opción.
     */
    public CheckBoxItem(String name, String label, boolean initValue) {
        super(label);
        this.key = name;
        this.label = label;
        this.setSelected(initValue);
    }

    /**
     * Constructor de la clase CheckBoxItem sin valor inicial.
     *
     * @param name  El nombre de la opción.
     * @param label La etiqueta de la opción.
     */
    public CheckBoxItem(String name, String label) {
        super(label);
        this.key = name;
        this.label = label;
    }

    /**
     * Método para obtener el nombre de la opción.
     *
     * @return El nombre de la opción.
     */
    public String getKey() {
        return key;
    }

    /**
     * Método para obtener la etiqueta de la opción.
     *
     * @return La etiqueta de la opción.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Método para establecer la etiqueta de la opción.
     *
     * @param label La nueva etiqueta de la opción.
     */
    public void setLabel(String label) {
        this.label = label;
    }
}