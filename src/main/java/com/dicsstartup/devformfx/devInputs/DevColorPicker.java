package com.dicsstartup.devformfx.devInputs;

import com.dicsstartup.devformfx.devInputs.core.DevInput;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 * Clase DevColorPicker que extiende de DevInput y encapsula un ColorPicker de JavaFX.
 * Proporciona métodos para configurar y manipular el ColorPicker, así como gestionar errores.
 *
 * @autor Didier piracoca
 */
public class DevColorPicker extends DevInput<Color> {

    private static final String DEVCOLORPICKER = "devColorPicker";
    // Instancia del ColorPicker
    ColorPicker colorPicker;

    /**
     * Constructor que inicializa el ColorPicker con un nombre y un título.
     *
     * @param name  Nombre del campo
     * @param title Título del campo
     */
    public DevColorPicker(String name, String title) {
        super(name, title);
        this.colorPicker = new ColorPicker();
        config();
    }

    /**
     * Constructor que inicializa el ColorPicker con un nombre, un título y un color inicial.
     *
     * @param name  Nombre del campo
     * @param title Título del campo
     * @param color Color inicial del ColorPicker
     */
    public DevColorPicker(String name, String title, Color color) {
        super(name, title);
        this.colorPicker = new ColorPicker(color);
        config();
    }

    /**
     * Método protegido que configura el ColorPicker.
     * - Define el espaciado entre los elementos del contenedor.
     * - Establece el tamaño máximo del ColorPicker.
     * - Agrega los elementos (título, ColorPicker y error) al contenedor.
     */
    @Override
    protected void config() {
        this.setSpacing(5);
        this.getStyleClass().add(DEVCOLORPICKER);
        this.colorPicker.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.getChildren().addAll(this.title, this.colorPicker, this.error);
    }

    /**
     * Método para obtener el valor seleccionado en el ColorPicker.
     *
     * @return Un InputValue que contiene la clave del campo y el color seleccionado.
     */
    @Override
    public Color getValue() {
        return this.colorPicker.getValue();
    }

    /**
     * Método para establecer el valor del ColorPicker.
     *
     * @param value El color a establecer en el ColorPicker.
     */
    @Override
    public void setValue(Color value) {
        this.colorPicker.setValue(value);
    }

    /**
     * Método para limpiar el mensaje de error del campo.
     */
    @Override
    public void clearError() {
        this.error.setText("");
        this.setErrorStatus(false);
    }

    /**
     * Método para limpiar el estado del campo, eliminando errores y restableciendo la corrección.
     */
    @Override
    public void clean() {
        this.clearError();
        this.setCorrectStatus(false);
    }
}
