package com.dicsstartup.devformfx.inputs;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Clase abstracta DevInput que representa un componente de entrada de datos en la UI.
 * Esta clase extiende VBox e incluye elementos para una clave, un t&iacute;tulo y un mensaje de error.
 *
 * Autor: Didier Piracoca
 */
public abstract class DevInput extends VBox {

    // Clave identificadora del input
    protected String key;

    // Etiqueta para el título del input
    protected Label title;

    // Etiqueta para mostrar mensajes de error
    protected Label error;

    /**
     * Constructor de la clase DevInput.
     * Inicializa el input con una clave y un título, y configura las clases de estilo.
     *
     * @param key Clave identificadora del input.
     * @param title Título del input.
     */
    public DevInput(String key, String title) {
        super();
        this.key = key;
        this.title = new Label(title);
        this.error = new Label();
        addClassStyle();
    }

    /**
     * Método para añadir las clases de estilo CSS a los elementos del input.
     * Las clases de estilo se definen en el enum enumCSS.
     */
    public void addClassStyle() {
        this.getStyleClass().add(enumCSS.DEV_INPUT);
        this.error.getStyleClass().add(enumCSS.ERROR_LABEL);
        this.title.getStyleClass().add(enumCSS.TITLE_LABEL);
    }

    /**
     * Método abstracto para configurar el input.
     * Debe ser implementado por las subclases.
     */
    protected abstract void config();

    /**
     * Método abstracto para obtener el valor del input.
     * Debe ser implementado por las subclases.
     *
     * @return El valor del input.
     */
    public abstract InputValue getValue();

    /**
     * Método abstracto para añadir un mensaje de error al input.
     * Debe ser implementado por las subclases.
     *
     * @param message El mensaje de error.
     */
    public abstract void addError(String message);

    /**
     * Método abstracto para limpiar el mensaje de error del input.
     * Debe ser implementado por las subclases.
     */
    public abstract void clearError();

    /**
     * Método abstracto para limpiar el input.
     * Debe ser implementado por las subclases.
     */
    public abstract void clean();

    /**
     * Método para obtener el título del input.
     *
     * @return La etiqueta del título.
     */
    public Label getTitle() {
        return title;
    }

    /**
     * Método para establecer el título del input.
     *
     * @param title La nueva etiqueta del título.
     */
    public void setTitle(Label title) {
        this.title = title;
    }

    /**
     * Método para obtener el mensaje de error del input.
     *
     * @return La etiqueta del error.
     */
    public Label getError() {
        return error;
    }

    /**
     * Método para establecer el mensaje de error del input.
     *
     * @param error La nueva etiqueta del error.
     */
    public void setError(Label error) {
        this.error = error;
    }

    /**
     * Método para obtener la clave del input.
     *
     * @return La clave del input.
     */
    public String getKey() {
        return key;
    }

}
