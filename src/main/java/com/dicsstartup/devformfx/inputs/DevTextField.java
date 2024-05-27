package com.dicsstartup.devformfx.inputs;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;

/**
 * Clase DevTextField que representa un campo de texto con validaciones.
 * Extiende la clase abstracta DevInput.
 *
 * Autor: Didier Piracoca
 */
public class DevTextField extends DevInput {

    // Campo de texto para la entrada de usuario
    private final TextField textField;

    // Lista de patrones de validación
    private List<Validation> patterns;

    // Bandera para aplicar estilos correctos
    private boolean isStyleCorrect;

    /**
     * Constructor que inicializa el campo de texto con un nombre y un título.
     *
     * @param name Clave identificadora del campo de texto.
     * @param title Título del campo de texto.
     */
    public DevTextField(String name, String title) {
        super(name, title);
        this.textField = new TextField();
        this.patterns = new ArrayList<>();
        config();
    }

    /**
     * Configuración inicial del DevTextField.
     * Configura el espacio entre elementos, enlaza la propiedad de ancho,
     * añade los elementos al contenedor y aplica estilos CSS.
     */
    @Override
    protected void config() {
        this.setSpacing(5);
        this.textField.prefWidthProperty().bind(this.widthProperty());
        this.getChildren().addAll(this.title, this.textField, this.error);
        this.textField.getStyleClass().add(enumCSS.DEVTEXTFIELD);
    }

    /**
     * Obtiene el valor actual del campo de texto.
     *
     * @return Un objeto InputValue con la clave y el texto del campo.
     */
    @Override
    public InputValue getValue() {
        return new InputValue(this.key, this.textField.getText());
    }

    /**
     * Añade un mensaje de error al campo de texto.
     *
     * @param message El mensaje de error a mostrar.
     */
    @Override
    public void addError(String message) {
        this.error.setText(message);
        enumCSS.addStyleClass(this.textField, enumCSS.ERROR);
        enumCSS.removeStyleClass(this.textField, enumCSS.CORRECT);
    }

    /**
     * Limpia el campo de texto y los estilos de error.
     */
    @Override
    public void clean() {
        clearError();
        this.textField.setText("");
        enumCSS.removeStyleClass(this.textField, enumCSS.ERROR);
    }

    /**
     * Limpia el mensaje de error del campo de texto.
     */
    @Override
    public void clearError() {
        error.setText("");
        textField.getStyleClass().remove(enumCSS.ERROR);
    }

    /**
     * Añade un patrón de validación a la lista de patrones.
     *
     * @param pattern El patrón de validación a añadir.
     */
    public void addPattern(Validation pattern) {
        this.patterns.add(pattern);
    }

    /**
     * Limpia todos los patrones de validación.
     */
    public void clearPatterns() {
        this.patterns.clear();
    }

    /**
     * Verifica si el texto del campo cumple con todos los patrones de validación.
     *
     * @return true si el texto es válido, false en caso contrario.
     */
    public boolean isValid() {
        if (this.patterns.isEmpty()) {
            return true;
        }
        for (Validation validation : this.patterns) {
            if (!this.textField.getText().matches(validation.pattern)) {
                this.addError(validation.getMessage());
                return false;
            }
        }
        return true;
    }

    /**
     * Valida el texto del campo y aplica estilos según corresponda.
     */
    public void validate() {
        if (isValid()) {
            if (this.isStyleCorrect) {
                enumCSS.addStyleClass(this.textField, enumCSS.CORRECT);
            }
            clearError();
        }
    }

    /**
     * Activa la validación en tiempo real del campo de texto.
     *
     * @param applyStyle Si debe aplicarse estilo al campo en caso de ser válido.
     */
    public void validationActive(boolean applyStyle) {
        this.textField.textProperty().addListener((observable, oldValue, newValue) -> validate());
    }

    /**
     * Obtiene la lista de patrones de validación.
     *
     * @return La lista de patrones de validación.
     */
    public List<Validation> getPatterns() {
        return patterns;
    }

    /**
     * Establece la lista de patrones de validación.
     *
     * @param patterns La nueva lista de patrones de validación.
     */
    public void setPatterns(List<Validation> patterns) {
        this.patterns = patterns;
    }

    /**
     * Obtiene si el estilo correcto está habilitado.
     *
     * @return true si el estilo correcto está habilitado, false en caso contrario.
     */
    public boolean isIsStyleCorrect() {
        return isStyleCorrect;
    }

    /**
     * Establece si el estilo correcto debe estar habilitado.
     *
     * @param isStyleCorrect El nuevo estado del estilo correcto.
     */
    public void setIsStyleCorrect(boolean isStyleCorrect) {
        this.isStyleCorrect = isStyleCorrect;
    }

    /**
     * Añade un patrón de validación y activa la validación en tiempo real.
     *
     * @param IsActive Si debe activarse la validación en tiempo real.
     * @param validation El patrón de validación a añadir.
     */
    public void addPattern(boolean IsActive, Validation validation) {
        this.addPattern(validation);
        validationActive(true);
    }

}
