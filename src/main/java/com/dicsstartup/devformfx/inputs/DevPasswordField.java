package com.dicsstartup.devformfx.inputs;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * Clase DevPasswordField que representa un campo de contraseña con validaciones.
 * Extiende la clase abstracta DevInput.
 *
 * Autor: Didier Piracoca
 */
public class DevPasswordField extends DevInput {

    // Campo de texto para la contraseña
    private PasswordField passwordField;

    // Lista de patrones de validación
    private List<Validation> patterns;

    // Personalización de la visibilidad de la contraseña
    private VisiblePasswordFieldSkin visibility;

    // Bandera para aplicar estilos correctos
    private boolean isStyleCorrect;

    /**
     * Constructor que inicializa el campo de contraseña con un nombre y un título.
     *
     * @param name Clave identificadora del campo de contraseña.
     * @param title Título del campo de contraseña.
     */
    public DevPasswordField(String name, String title) {
        super(name, title);
        this.passwordField = new PasswordField();
        this.patterns = new ArrayList<>();
        this.visibility = new VisiblePasswordFieldSkin(passwordField);
        config();
    }

    /**
     * Configuración inicial del DevPasswordField.
     * Configura el espacio entre elementos, establece la visibilidad del campo,
     * añade los elementos al contenedor y aplica estilos CSS.
     */
    @Override
    protected void config() {
        this.setSpacing(5);
        passwordField.setSkin(this.visibility);
        this.getChildren().addAll(this.title, this.passwordField, this.error);
        this.passwordField.getStyleClass().add(enumCSS.DEVTEXTFIELD);
    }

    /**
     * Obtiene el valor actual del campo de contraseña.
     *
     * @return Un objeto InputValue con la clave y el texto del campo.
     */
    @Override
    public InputValue getValue() {
        return new InputValue(this.key, passwordField.getText());
    }

    /**
     * Añade un mensaje de error al campo de contraseña.
     *
     * @param message El mensaje de error a mostrar.
     */
    @Override
    public void addError(String message) {
        error.setText(message);
        enumCSS.addStyleClass(this.passwordField, enumCSS.ERROR);
        enumCSS.removeStyleClass(this.passwordField, enumCSS.CORRECT);
    }

    /**
     * Limpia el campo de contraseña y los estilos de error.
     */
    @Override
    public void clean() {
        clearError();
        passwordField.setText("");
        enumCSS.removeStyleClass(this.passwordField, enumCSS.ERROR);
    }

    /**
     * Limpia el mensaje de error del campo de contraseña.
     */
    @Override
    public void clearError() {
        error.setText("");
        passwordField.getStyleClass().remove(enumCSS.ERROR);
    }

    /**
     * Añade un patrón de validación a la lista de patrones.
     *
     * @param pattern El patrón de validación a añadir.
     */
    public void addPattern(Validation pattern) {
        patterns.add(pattern);
    }

    /**
     * Limpia todos los patrones de validación.
     */
    public void clearPatterns() {
        patterns.clear();
    }

    /**
     * Verifica si la contraseña cumple con todos los patrones de validación.
     *
     * @return true si la contraseña es válida, false en caso contrario.
     */
    public boolean isValid() {
        if (patterns.isEmpty()) {
            return true;
        }
        for (Validation validation : patterns) {
            if (!this.passwordField.getText().matches(validation.pattern)) {
                this.addError(validation.massage);
                return false;
            }
        }
        return true;
    }

    /**
     * Valida la contraseña y aplica estilos según corresponda.
     */
    public void validate() {
        if (isValid()) {
            if (isStyleCorrect) {
                enumCSS.addStyleClass(this.passwordField, enumCSS.CORRECT);
            }
            clearError();
        }
    }

    /**
     * Activa la validación en tiempo real del campo de contraseña.
     *
     * @param applyStyle Si debe aplicarse estilo al campo en caso de ser válido.
     */
    public void validationActive(boolean applyStyle) {
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> validate());
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

    /**
     * Extiende el campo de contraseña para ocupar todo el espacio vertical disponible.
     */
    public void extend() {
        VBox.setVgrow(this.passwordField, Priority.ALWAYS);
    }

    /**
     * Obtiene el campo de contraseña.
     *
     * @return El campo de contraseña.
     */
    public PasswordField getPasswordField() {
        return passwordField;
    }

    /**
     * Establece el campo de contraseña.
     *
     * @param passwordField El nuevo campo de contraseña.
     */
    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    /**
     * Obtiene la visibilidad personalizada del campo de contraseña.
     *
     * @return La visibilidad personalizada del campo de contraseña.
     */
    public VisiblePasswordFieldSkin getVisibility() {
        return visibility;
    }

    /**
     * Establece la visibilidad personalizada del campo de contraseña.
     *
     * @param visibility La nueva visibilidad personalizada del campo de contraseña.
     */
    public void setVisibility(VisiblePasswordFieldSkin visibility) {
        this.visibility = visibility;
    }

}