package com.dicsstartup.devformfx.devInputs;

import com.dicsstartup.devformfx.devInputs.componets.VisiblePasswordFieldSkin;
import com.dicsstartup.devformfx.devInputs.core.DevInput;
import com.dicsstartup.devformfx.devInputs.core.ValidationActive;
import javafx.scene.control.PasswordField;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase DevPasswordField que representa un campo de contraseña con validaciones.
 * Extiende la clase abstracta DevInput.
 * <p>
 * Autor: Didier Piracoca
 */
public class DevPasswordField extends DevInput<String> {

    private static final String DEVPASSWORDFIELD = "devPassWordField";

    // Campo de texto para la contraseña
    private PasswordField passwordField;

    // Lista de patrones de validación
    private List<ValidationActive> patterns;

    // Personalización de la visibilidad de la contraseña
    private VisiblePasswordFieldSkin visibility;

    //Activar o no validacion activa
    private boolean activeValid;

    /**
     * Constructor que inicializa el campo de contraseña con un nombre y un título.
     *
     * @param name  Clave identificadora del campo de contraseña.
     * @param title Título del campo de contraseña.
     */
    public DevPasswordField(String name, String title) {
        super(name, title);
        this.passwordField = new PasswordField();
        this.patterns = new ArrayList<>();
        this.activeValid = false;
        this.visibility = new VisiblePasswordFieldSkin(passwordField);
        config();
    }

    /**
     * Constructor que inicializa el campo de contraseña con un nombre y un título.
     *
     * @param name          Clave identificadora del campo de contraseña.
     * @param title         Título del campo de contraseña.
     * @param isActiveValid es para controlar la correccion activa
     */
    public DevPasswordField(String name, String title, boolean isActiveValid) {
        super(name, title);
        this.passwordField = new PasswordField();
        this.patterns = new ArrayList<>();
        this.activeValid = isActiveValid;
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
        this.getStyleClass().add(DEVPASSWORDFIELD);
        this.passwordField.prefWidthProperty().bind(this.widthProperty());
        if (activeValid)
            startActiveValid();
    }

    /**
     * Obtiene el valor actual del campo de contraseña.
     *
     * @return Un objeto InputValue con la clave y el texto del campo.
     */
    @Override
    public String getValue() {
        return passwordField.getText();
    }

    @Override
    public void setValue(String value) {
        this.passwordField.setText(value);
    }

    /**
     * Limpia el campo de contraseña y los estilos de error.
     */
    @Override
    public void clean() {
        clearError();
        passwordField.setText("");
        this.setCorrectStatus(false);
    }

    /**
     * Limpia el mensaje de error del campo de contraseña.
     */
    @Override
    public void clearError() {
        error.setText("");
        this.setErrorStatus(false);
    }

    /**
     * Añade un patrón de validación a la lista de patrones.
     *
     * @param pattern El patrón de validación a añadir.
     */
    public void addPattern(ValidationActive pattern) {
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
    public boolean isValidPatterns() {
        if (patterns.isEmpty()) {
            return true;
        }
        for (ValidationActive validation : patterns) {
            if (!this.passwordField.getText().matches(validation.getPattern())) {
                this.addError(validation.getMessage());
                return false;
            }
        }
        return true;
    }

    /**
     * Valida la contraseña y aplica estilos según corresponda.
     */
    public boolean validActive() {
        if (isValidPatterns()) {
            this.setCorrectStatus(true);
            clearError();
            return true;
        }
        this.setErrorStatus(true);
        return false;
    }

    @Override
    public boolean validate() {
        return (super.validate() && validActive());
    }

    /**
     * Activa la validación en tiempo real del campo de contraseña.
     */
    public void startActiveValid() {
        this.passwordField.textProperty().addListener((observable, oldValue, newValue) -> validActive());
    }

    /**
     * Obtiene la lista de patrones de validación.
     *
     * @return La lista de patrones de validación.
     */
    public List<ValidationActive> getPatterns() {
        return patterns;
    }

    /**
     * Establece la lista de patrones de validación.
     *
     * @param patterns La nueva lista de patrones de validación.
     */
    public void setPatterns(List<ValidationActive> patterns) {
        this.patterns = patterns;
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
    private VisiblePasswordFieldSkin getVisibility() {
        return visibility;
    }

    /**
     * Establece la visibilidad personalizada del campo de contraseña.
     *
     * @param visibility La nueva visibilidad personalizada del campo de contraseña.
     */
    private void setVisibility(VisiblePasswordFieldSkin visibility) {
        this.visibility = visibility;
    }

    public boolean isActiveValid() {
        return activeValid;
    }

    public void setActiveValid(boolean activeValid) {
        this.activeValid = activeValid;
    }
}