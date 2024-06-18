package com.dicsstartup.devformfx.devActions;

import com.dicsstartup.devformfx.devIcons.DevIcon;
import javafx.scene.control.Button;

/**
 * Clase abstracta DevAction que extiende Button.
 * Proporciona configuraciones iniciales para botones con íconos y estilos personalizados.
 *
 * Autor: Didier Piracoca
 */
public abstract class DevAction extends Button {

    protected String size;          // Tamaño del botón
    protected String backgroundColor; // Color de fondo del botón
    protected DevIcon devIcon;      // Ícono del botón

    /**
     * Constructor que inicializa el botón con un tamaño y color de fondo.
     *
     * @param size El tamaño del botón.
     * @param backgroundColor El color de fondo del botón.
     */
    public DevAction(String size, String backgroundColor) {
        this.size = size;
        setBackgroundColor(backgroundColor);
        initialConfig();
    }

    /**
     * Constructor que inicializa el botón con una etiqueta, tamaño y color de fondo.
     *
     * @param label La etiqueta del botón.
     * @param size El tamaño del botón.
     * @param backgroundColor El color de fondo del botón.
     */
    public DevAction(String label, String size, String backgroundColor) {
        super(label);
        this.size = size;
        setBackgroundColor(backgroundColor);
        initialConfig();
    }

    /**
     * Constructor que inicializa el botón con una etiqueta, color de fondo, tamaño e ícono.
     *
     * @param label La etiqueta del botón.
     * @param backgroundColor El color de fondo del botón.
     * @param size El tamaño del botón.
     * @param icon El ícono del botón.
     */
    public DevAction(String label, String backgroundColor, String size, DevIcon icon) {
        super(label);
        setBackgroundColor(backgroundColor);
        this.size = size;
        this.devIcon = icon;
        initialConfig();
    }

    /**
     * Constructor que inicializa el botón con un tamaño, color de fondo e ícono.
     *
     * @param size El tamaño del botón.
     * @param backgroundColor El color de fondo del botón.
     * @param icon El ícono del botón.
     */
    public DevAction(String size, String backgroundColor, DevIcon icon) {
        super();
        this.size = size;
        setBackgroundColor(backgroundColor);
        this.devIcon = icon;
        initialConfig();
    }

    /**
     * Método de configuración inicial para aplicar los estilos y el ícono al botón.
     */
    private void initialConfig() {
        this.getStyleClass().add("devAction");
        if (this.devIcon != null) {
            this.setGraphic(devIcon);
        }
    }

    /**
     * Establece el color de fondo del botón.
     *
     * @param backgroundColor El color de fondo del botón.
     */
    public void setBackgroundColor(String backgroundColor) {
        this.setStyle("-fx-background-color:" + backgroundColor + ";");
        this.backgroundColor = backgroundColor;
    }

    // Métodos getters y setters

    public DevIcon getDevIcon() {
        return devIcon;
    }

    public String getSize() {
        return size;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

}