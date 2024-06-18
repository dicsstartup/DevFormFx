package com.dicsstartup.devformfx.devInputs.core;

/**
 * Interfaz  Validator<T> que añade la funcion de agregar codigo para la validacion de el value.
 *
 * Autor: Didier Piracoca
 */
@FunctionalInterface
public interface Validator<T> {

    /**
     * Metodo  validate que añade la funcion de agregar codigo para la validacion de el value.
     *
     * @param value es el valor del input
     * @return boolean si cumple o no la validacion
     */
    boolean validate(T value);

}