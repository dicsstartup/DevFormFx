package com.dicsstartup.devformfx.devInputs;

import com.dicsstartup.devformfx.devInputs.core.DevInput;
import com.dicsstartup.devformfx.devInputs.core.ValidationActive;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase DevTextField que representa un campo de texto con validaciones.
 * Extiende la clase abstracta DevInput.
 * <p>
 * Autor: Didier Piracoca
 */
public class DevTextField extends DevInput<String> {

    public static final String DEVTEXTFIELD = "devTextField";

    // Campo de texto para la entrada de usuario
    private final TextField textField;

    // Lista de patrones de validación
    private List<ValidationActive> patterns;

    //Activar o no validacion activa
    private boolean activeValid;

    /**
     * Constructor que inicializa el campo de texto con un nombre y un título.
     *
     * @param name  Clave identificadora del campo de texto.
     * @param title Título del campo de texto.
     */
    public DevTextField(String name, String title) {
        super(name, title);
        this.textField = new TextField();
        this.patterns = new ArrayList<>();
        this.activeValid = false;
        config();
    }

    /**
     * Constructor que inicializa el campo de texto con un nombre y un título.
     *
     * @param name  Clave identificadora del campo de texto.
     * @param title Título del campo de texto.
     * @para isActiveValid Campo que activa o no la validación constante.
     */
    public DevTextField(String name, String title, boolean isActiveValid) {
        super(name, title);
        this.textField = new TextField();
        this.patterns = new ArrayList<>();
        this.activeValid = isActiveValid;
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
        this.getStyleClass().add(DEVTEXTFIELD);
        if (this.activeValid)
            startActiveValid();
    }

    /**
     * Obtiene el valor actual del campo de texto.
     *
     * @return Un objeto InputValue con la clave y el texto del campo.
     */
    @Override
    public String getValue() {
        return this.textField.getText();
    }

    @Override
    public void setValue(String value) {
        this.textField.setText(value);
    }

    /**
     * Añade un mensaje de error al campo de texto.
     *
     * @param message El mensaje de error a mostrar.
     */
    @Override
    public void addError(String message) {
        this.error.setText(message);
        this.setCorrectStatus(false);
        this.setErrorStatus(true);
    }

    /**
     * Limpia el campo de texto y los estilos de error.
     */
    @Override
    public void clean() {
        clearError();
        this.textField.setText("");
        this.setCorrectStatus(false);
    }

    /**
     * Limpia el mensaje de error del campo de texto.
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
    public boolean isValidPatterns() {
        if (this.patterns.isEmpty()) {
            return true;
        }
        for (ValidationActive validation : this.patterns) {
            if (!this.textField.getText().matches(validation.getPattern())) {
                this.addError(validation.getMessage());
                return false;
            }
        }
        return true;
    }

    /**
     * Valida el texto del campo y aplica estilos según corresponda.
     */
    public boolean validActive() {
        if (isValidPatterns()) {
            this.setCorrectStatus(true);
            clearError();
            return true;
        }
        return false;
    }

    @Override
    public boolean validate() {
        return (super.validate() && validActive());
    }

    /**
     * Activa la validación en tiempo real del campo de texto.
     */
    public void startActiveValid() {
        this.textField.textProperty().addListener((observable, oldValue, newValue) -> validActive());
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


    public boolean isActiveValid() {
        return activeValid;
    }

    public void setActiveValid(boolean activeValid) {
        this.activeValid = activeValid;
    }
}
