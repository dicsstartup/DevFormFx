package com.dicsstartup.devformfx.Actions;

import com.dicsstartup.devformfx.Icons.DevIcon;

/**
 * Clase DevActionSquare que extiende DevAction.
 * Proporciona configuración específica para botones con forma de cuadrado.
 *
 * Autor: Didier
 */
public class DevActionSquare extends DevAction {

    /**
     * Constructor que inicializa el botón con etiqueta, tamaño y color de fondo.
     *
     * @param label La etiqueta del botón.
     * @param size El tamaño del botón.
     * @param backgroundColor El color de fondo del botón.
     */
    public DevActionSquare(String label, String size, String backgroundColor) {
        super(label, size, backgroundColor);
        this.getStyleClass().addAll(size + "height"); // Añade clase de estilo para la altura
    }

    /**
     * Constructor que inicializa el botón con tamaño, color de fondo y un ícono.
     *
     * @param size El tamaño del botón.
     * @param backgroundColor El color de fondo del botón.
     * @param icon El ícono del botón.
     */
    public DevActionSquare(String size, String backgroundColor, DevIcon icon) {
        super(size, backgroundColor, icon);
        this.getStyleClass().addAll(size + "height", size + "width"); // Añade clases de estilo para la altura y anchura
    }

    /**
     * Constructor que inicializa el botón con etiqueta, tamaño, color de fondo y un ícono.
     *
     * @param label La etiqueta del botón.
     * @param size El tamaño del botón.
     * @param backgroundColor El color de fondo del botón.
     * @param icon El ícono del botón.
     */
    public DevActionSquare(String label, String size, String backgroundColor, DevIcon icon) {
        super(label, size, backgroundColor, icon);
        this.getStyleClass().addAll(size + "height"); // Añade clase de estilo para la altura
    }
}
