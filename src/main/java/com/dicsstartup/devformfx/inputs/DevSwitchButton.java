package com.dicsstartup.devformfx.inputs;

import com.dicsstartup.devformfx.DevGrid;

/**
 * Clase DevSwitchButton que representa un componente de entrada personalizado que incluye un interruptor.
 *
 * Autor: Didier Piracoca
 */
public class DevSwitchButton extends DevInput {

    // Botón de interruptor
    private SwitchButton button;

    // Contenedor para el título y el botón
    private DevGrid box;

    // Valor inicial del interruptor
    private boolean initvalue = false;

    /**
     * Constructor de la clase DevSwitchButton.
     *
     * @param name El nombre del componente.
     * @param title El título del componente.
     */
    public DevSwitchButton(String name, String title) {
        super(name, title);
        button = new SwitchButton();
        box = new DevGrid();
        config();
    }

    /**
     * Constructor de la clase DevSwitchButton con valor inicial.
     *
     * @param name El nombre del componente.
     * @param title El título del componente.
     * @param initvalue El valor inicial del interruptor.
     */
    public DevSwitchButton(String name, String title, boolean initvalue) {
        super(name, title);
        button = new SwitchButton();
        box = new DevGrid();
        this.initvalue = initvalue;
        config();
    }

    /**
     * Método para configurar el componente.
     */
    @Override
    protected void config() {
        // Establece las clases CSS
        this.box.getStyleClass().add("box");
        this.button.getStyleClass().add(enumCSS.DEVSWITCHBUTTON);

        // Configura el valor inicial del interruptor
        this.button.setChecked(initvalue);

        // Configura el espacio entre columnas del contenedor
        this.box.setHgap(20);

        // Agrega el título y el botón al contenedor
        this.box.add(this.title, 0, 0);
        this.box.add(this.button, 1, 0);

        // Agrega el contenedor y el componente de error al componente
        this.getChildren().addAll(this.box, this.error);
    }

    /**
     * Método para obtener el valor del componente.
     *
     * @return El valor del interruptor.
     */
    @Override
    public InputValue getValue() {
        return new InputValue(this.key, button.isChecked());
    }

    /**
     * Método para agregar un mensaje de error al componente.
     *
     * @param message El mensaje de error.
     */
    @Override
    public void addError(String message) {
        this.error.setText(message);
        enumCSS.addStyleClass(this, enumCSS.ERROR);
        enumCSS.removeStyleClass(this, enumCSS.CORRECT);
    }

    /**
     * Método para limpiar el mensaje de error del componente.
     */
    @Override
    public void clearError() {
        this.error.setText("");
        enumCSS.addStyleClass(this, enumCSS.CORRECT);
        enumCSS.removeStyleClass(this, enumCSS.ERROR);
    }

    /**
     * Método para limpiar el componente.
     */
    @Override
    public void clean() {
        clearError();
        this.button.setChecked(initvalue);
    }

    /**
     * Método para obtener el botón de interruptor.
     *
     * @return El botón de interruptor.
     */
    public SwitchButton getButton() {
        return button;
    }

    /**
     * Método para obtener el contenedor del componente.
     *
     * @return El contenedor del componente.
     */
    public DevGrid getBox() {
        return box;
    }

    /**
     * Método para verificar el valor inicial del interruptor.
     *
     * @return true si el interruptor está marcado inicialmente, false en caso contrario.
     */
    public boolean isInitvalue() {
        return initvalue;
    }

}