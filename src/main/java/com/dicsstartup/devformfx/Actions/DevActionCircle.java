package com.dicsstartup.devformfx.Actions;

import com.dicsstartup.devformfx.Icons.DevIcon;
import javafx.scene.shape.Circle;

/**
 * Clase DevActionCircle que extiende DevAction.
 * Proporciona configuración específica para botones con forma de círculo.
 *
 * Autor: Didier Piracoca
 */
public class DevActionCircle extends DevAction {

    /**
     * Constructor que inicializa el botón con tamaño, color de fondo y un ícono.
     *
     * @param size El tamaño del botón.
     * @param backgroundColor El color de fondo del botón.
     * @param icon El ícono del botón.
     */
    public DevActionCircle(String size, String backgroundColor, DevIcon icon) {
        super(size, backgroundColor, icon);
        this.setShape(new Circle(35)); // Establece la forma del botón como un círculo con radio 35
        this.getStyleClass().addAll(size + "height", size + "width"); // Añade clases de estilo para el tamaño
    }

}

