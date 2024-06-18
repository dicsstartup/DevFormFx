package com.dicsstartup.devformfx.devInputs.core;

/**
 * Clase InputValue que representa un par de clave-valor.
 *
 * @author Didier Piracoca
 */
public class InputValue<T> {

    // Valor del par clave-valor
    T value;

    /**
     * Constructor de la clase InputValue.
     *
     * @param value El valor del par clave-valor.
     */
    public InputValue( T value) {
        this.value = value;
    }

    /**
     * Método para obtener el valor del par clave-valor.
     *
     * @return El valor del par clave-valor.
     */
    public T getValue() {
        return value;
    }

    /**
     * Método para establecer el valor del par clave-valor.
     *
     * @param value El nuevo valor del par clave-valor.
     */
    public void setValue(T value) {
        this.value = value;
    }
}