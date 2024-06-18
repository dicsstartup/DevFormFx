package com.dicsstartup.devformfx.devInputs.core;

/**
 * Clase Validation que representa una validación con un patrón y un mensaje de error.
 *
 * Autor: Didier Piracoca
 */
public class ValidationActive {

    // Atributo para almacenar el patrón de validación
    private String pattern;

    // Atributo para almacenar el mensaje de error
    private String message;

    /**
     * Constructor que inicializa el patrón y el mensaje de error.
     *
     * @param pattern El patrón de validación (expresión regular).
     * @param message El mensaje de error que se muestra si la validación falla.
     */
    public ValidationActive(String pattern, String message) {
        this.pattern = pattern;
        this.message = message;
    }

    /**
     * Obtiene el patrón de validación.
     *
     * @return El patrón de validación.
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * Establece el patrón de validación.
     *
     * @param pattern El nuevo patrón de validación.
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * Obtiene el mensaje de error.
     *
     * @return El mensaje de error.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Establece el mensaje de error.
     *
     * @param message El nuevo mensaje de error.
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
