package com.dicsstartup.devformfx.inputs;

import javafx.scene.control.CheckBox;

/**
 * Clase Options que representa una opción con un nombre, una etiqueta y un valor inicial.
 *
 * Autor: Didier Piracoca
 */
public class Options extends CheckBox {

    // Nombre de la opción
    String name;

    // Etiqueta de la opción
    String label;

    // Valor inicial de la opción
    boolean initValue = false;

    /**
     * Constructor de la clase Options con valor inicial.
     *
     * @param name El nombre de la opción.
     * @param label La etiqueta de la opción.
     * @param initValue El valor inicial de la opción.
     */
    public Options(String name, String label, boolean initValue) {
        super(label);
        this.name = name;
        this.label = label;
        this.initValue = initValue;
        this.setSelected(initValue);
    }

    /**
     * Constructor de la clase Options sin valor inicial.
     *
     * @param name El nombre de la opción.
     * @param label La etiqueta de la opción.
     */
    public Options(String name, String label) {
        super(label);
        this.name = name;
        this.label = label;
        this.setSelected(initValue);
    }

    /**
     * Método para obtener el nombre de la opción.
     *
     * @return El nombre de la opción.
     */
    public String getName() {
        return name;
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

    /**
     * Método para verificar si la opción tiene valor inicial.
     *
     * @return true si la opción tiene valor inicial, false en caso contrario.
     */
    public boolean isInitValue() {
        return initValue;
    }

    /**
     * Método para reiniciar la opción al valor inicial.
     */
    public void restart(){
        this.setSelected(initValue);
    }
}