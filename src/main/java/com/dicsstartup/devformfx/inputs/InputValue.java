package com.dicsstartup.devformfx.inputs;

/**
 * Clase InputValue que representa un par de clave-valor.
 *
 * @author Didier Piracoca
 */
public class InputValue {

    // Clave del par clave-valor
    String key;

    // Valor del par clave-valor
    Object value;

    /**
     * Constructor de la clase InputValue.
     *
     * @param key La clave del par clave-valor.
     * @param value El valor del par clave-valor.
     */
    public InputValue(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Método para obtener la clave del par clave-valor.
     *
     * @return La clave del par clave-valor.
     */
    public String getKey() {
        return key;
    }

    /**
     * Método para establecer la clave del par clave-valor.
     *
     * @param key La nueva clave del par clave-valor.
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Método para obtener el valor del par clave-valor.
     *
     * @return El valor del par clave-valor.
     */
    public Object getValue() {
        return value;
    }

    /**
     * Método para establecer el valor del par clave-valor.
     *
     * @param value El nuevo valor del par clave-valor.
     */
    public void setValue(Object value) {
        this.value = value;
    }
}