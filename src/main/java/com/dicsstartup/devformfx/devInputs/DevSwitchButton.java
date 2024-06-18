package com.dicsstartup.devformfx.devInputs;

import com.dicsstartup.devformfx.DevGrid;
import com.dicsstartup.devformfx.devInputs.componets.SwitchButton;
import com.dicsstartup.devformfx.devInputs.core.DevInput;

/**
 * Clase DevSwitchButton que representa un componente de entrada personalizado que incluye un interruptor.
 * <p>
 * Autor: Didier Piracoca
 */
public class DevSwitchButton extends DevInput<Boolean> {

    private static final String DEVSWITCHBUTTON = "devSwitchButton";

    // Botón de interruptor
    private SwitchButton button;

    // Contenedor para el título y el botón
    private DevGrid box;


    /**
     * Constructor de la clase DevSwitchButton.
     *
     * @param name  El nombre del componente.
     * @param title El título del componente.
     */
    public DevSwitchButton(String name, String title) {
        super(name, title);
        button = new SwitchButton();
        box = new DevGrid();
        config();
    }

    /**
     * Método para configurar el componente.
     */
    @Override
    protected void config() {
        // Establece las clases CSS
        this.box.getStyleClass().add("box");
        this.getStyleClass().add(DEVSWITCHBUTTON);

        // Configura el valor inicial del interruptor
        this.button.setChecked(false);

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
    public Boolean getValue() {
        return button.isChecked();
    }

    @Override
    public void setValue(Boolean value) {
        this.button.setChecked(value);
    }


    /**
     * Método para limpiar el mensaje de error del componente.
     */
    @Override
    public void clearError() {
        this.error.setText("");
        this.setErrorStatus(false);
    }

    /**
     * Método para limpiar el componente.
     */
    @Override
    public void clean() {
        clearError();
        this.button.setChecked(false);
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
}