package com.dicsstartup.devformfx.devInputs;

import com.dicsstartup.devformfx.devInputs.core.DevInput;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;


/**
 * Clase DevComboBox que extiende DevInput.
 * Representa un input de tipo ComboBox con funcionalidades adicionales.
 *
 * @author Didier Piracoca
 */
public class DevComboBox<T> extends DevInput<T> {

    private static final String DEVCOMBOBOX = "devComboBox";

    private final ComboBox<T> comboBox; // ComboBox para seleccionar opciones

    /**
     * Constructor que inicializa el DevComboBox con un nombre y un título.
     *
     * @param name  Nombre del input.
     * @param title Título del input.
     */
    public DevComboBox(String name, String title) {
        super(name, title);
        this.comboBox = new ComboBox<>();
        config();
    }

    /**
     * Constructor que inicializa el DevComboBox con un nombre y un título.
     *
     * @param name  Nombre del input.
     * @param title Título del input.
     */
    public DevComboBox(String name, String title, ObservableList<T> list) {
        super(name, title);
        this.comboBox = new ComboBox<>(list);
        config();
    }

    /**
     * Configuración inicial del DevComboBox.
     */
    @Override
    protected void config() {
        this.setSpacing(5);
        this.comboBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.getStyleClass().add(DEVCOMBOBOX);
        this.getChildren().addAll(this.title, this.comboBox, this.error);
    }

    /**
     * Obtiene el valor actual del ComboBox.
     *
     * @return InputValue con el nombre del input y el valor seleccionado.
     */
    @Override
    public T getValue() {
        return this.comboBox.getSelectionModel().getSelectedItem();
    }

    /**
     * Método para establecer el valor del ComboBox.
     *
     * @param value El color a establecer en el ComboBox.
     */
    @Override
    public void setValue(T value) {
        this.comboBox.getSelectionModel().select(value);
    }

    /**
     * Elimina el mensaje de error y el estilo de error.
     */
    @Override
    public void clearError() {
        this.error.setText("");
        this.setErrorStatus(false);
    }

    /**
     * Limpia el ComboBox, eliminando cualquier selección y mensaje de error.
     */
    @Override
    public void clean() {
        clearError();
        this.setCorrectStatus(false);
        this.comboBox.getEditor().clear();
        this.comboBox.getSelectionModel().clearSelection();
    }

    public ComboBox<T> getComboBox() {
        return comboBox;
    }
}
