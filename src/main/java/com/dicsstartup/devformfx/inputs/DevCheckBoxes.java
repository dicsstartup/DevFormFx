package com.dicsstartup.devformfx.inputs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;

/**
 * Clase DevCheckBoxes que representa un grupo de opciones que pueden ser seleccionadas o deseleccionadas mediante CheckBoxes.
 *
 * Autor: Didier Piracoca
 */
public class DevCheckBoxes extends DevInput {

    // Lista de opciones
    private List<Options> options;

    // Contenedor para las opciones
    private HBox hbox;

    // Indicador para permitir solo una opción seleccionada
    private boolean onlyOneOption = false;

    /**
     * Constructor de la clase DevCheckBoxes.
     *
     * @param name    El nombre del componente.
     * @param title   El título del componente.
     * @param options Las opciones disponibles para el componente.
     */
    public DevCheckBoxes(String name, String title, Options... options) {
        super(name, title);
        // Convierte el arreglo de opciones en una lista
        this.options = Arrays.stream(options).collect(Collectors.toCollection(ArrayList::new));
        hbox = new HBox();
        config();
    }

    /**
     * Constructor de la clase DevCheckBoxes con opción para permitir solo una opción seleccionada.
     *
     * @param name          El nombre del componente.
     * @param title         El título del componente.
     * @param onlyOneOption Indica si se permite solo una opción seleccionada.
     * @param options       Las opciones disponibles para el componente.
     */
    public DevCheckBoxes(String name, String title, boolean onlyOneOption, Options... options) {
        super(name, title);
        // Convierte el arreglo de opciones en una lista
        this.onlyOneOption = onlyOneOption;
        this.options = Arrays.stream(options).collect(Collectors.toCollection(ArrayList::new));
        hbox = new HBox();
        config();
    }

    /**
     * Método para configurar el componente.
     */
    @Override
    protected void config() {
        // Configura el espaciado y la alineación del contenedor
        this.hbox.setSpacing(10);
        this.hbox.setAlignment(Pos.CENTER);
        this.hbox.getStyleClass().add("box");
        this.setSpacing(15);

        // Agrega las opciones al contenedor
        for (Options i : options) {
            this.changeOnlyOneOption(i);
            i.getStyleClass().add(enumCSS.DEVCHECKBOX);
            hbox.getChildren().add(i);
        }

        // Agrega el título, el contenedor de opciones y el componente de error al componente
        this.getChildren().addAll(this.title, this.hbox, this.error);
    }

    /**
     * Método para cambiar la configuración de permitir solo una opción seleccionada.
     *
     * @param checkBox El CheckBox seleccionado.
     */
    private void changeOnlyOneOption(CheckBox checkBox) {
        if (this.onlyOneOption) {
            checkBox.setOnAction(event -> setOnlyOneTrue(checkBox));
        } else {
            checkBox.setOnAction(null);
        }
    }

    /**
     * Método para seleccionar solo una opción verdadera cuando se permite solo una opción seleccionada.
     *
     * @param selectedCheckbox El CheckBox seleccionado.
     */
    private void setOnlyOneTrue(CheckBox selectedCheckbox) {
        this.options.forEach(checkbox -> {
            if (checkbox != selectedCheckbox) {
                checkbox.setSelected(false);
            } else {
                checkbox.setSelected(true);
            }
        });
    }

    /**
     * Método para obtener el valor del componente.
     *
     * @return El valor del componente.
     */
    @Override
    public InputValue getValue() {
        if (this.onlyOneOption) {
            for (Options o : this.options) {
                if (o.isSelected()) {
                    return new InputValue(this.key, o.getText());
                }
            }
            return null;
        } else {
            Map<String, Boolean> results = new HashMap<>();
            for (Options o : this.options) {
                results.put(o.name, o.isSelected());
            }
            return new InputValue(this.key, results);
        }
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

    @Override
    public void clean() {
        clearError();
        options.forEach(Options::restart);
    }

    /**
     * Método para obtener la lista de opciones del componente.
     *
     * @return La lista de opciones.
     */
    public List<Options> getOptions() {
        return options;
    }

    /**
     * Método para obtener el contenedor de opciones del componente.
     *
     * @return El contenedor de opciones.
     */
    public HBox getHbox() {
        return hbox;
    }

    /**
     * Método para verificar si se permite solo una opción seleccionada.
     *
     * @return true si se permite solo una opción seleccionada, false de lo contrario.
     */
    public boolean isOnlyOneOpction() {
        return this.onlyOneOption;
    }

    /**
     * Método para establecer si se permite solo una opción seleccionada.
     *
     * @param onlyOneOption true si se permite solo una opción seleccionada, false de lo contrario.
     */
    public void setOnlyOneOpction(boolean onlyOneOption) {
        this.onlyOneOption = onlyOneOption;
    }
}