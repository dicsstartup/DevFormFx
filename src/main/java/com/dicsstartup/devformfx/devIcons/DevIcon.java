package com.dicsstartup.devformfx.devIcons;

import javafx.scene.layout.Region;

/**
 * Clase DevIcon que extiende Region.
 * Representa un icono con propiedades de tamaño, color y estilo.
 *
 * @autor Didier
 */
public class DevIcon extends Region {

    private String icon; // Nombre del icono
    private String color; // Color del icono
    private String size; // Tamaño del icono

    /**
     * Constructor por defecto.
     */
    public DevIcon() {
        super();
    }

    /**
     * Constructor que inicializa el icono con los parámetros dados.
     *
     * @param icon Nombre del icono.
     * @param color Color del icono.
     * @param size Tamaño del icono.
     */
    public DevIcon(String icon, String color, String size) {
        this.icon = icon;
        this.color = color;
        this.size = size;
        style();
    }

    /**
     * Aplica los estilos CSS al icono.
     */
    public void style() {
        this.getStyleClass().addAll("devIcon", size, icon);
        this.setStyle("-fx-background-color:" + color + ";");
    }

    /**
     * Obtiene el nombre del icono.
     *
     * @return Nombre del icono.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Establece un nuevo nombre para el icono y actualiza la clase CSS.
     *
     * @param icon Nuevo nombre del icono.
     */
    public void setIcon(String icon) {
        this.getStyleClass().remove(this.icon);
        this.icon = icon;
        this.getStyleClass().add(this.icon);
    }

    /**
     * Obtiene el color del icono.
     *
     * @return Color del icono.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece un nuevo color para el icono y actualiza el estilo CSS.
     *
     * @param color Nuevo color del icono.
     */
    public void setColor(String color) {
        this.color = color;
        this.setStyle("-fx-background-color:" + color + ";");
    }

    /**
     * Obtiene el tamaño del icono.
     *
     * @return Tamaño del icono.
     */
    public String getSize() {
        return size;
    }

    /**
     * Establece un nuevo tamaño para el icono y actualiza la clase CSS.
     *
     * @param size Nuevo tamaño del icono.
     */
    public void setSize(String size) {
        this.getStyleClass().remove(this.size);
        this.size = size;
        this.getStyleClass().add(this.size);
    }

}
