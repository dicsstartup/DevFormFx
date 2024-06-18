package com.dicsstartup.devformfx.devList;

/**
 * Interfaz funcional DeleteDevItem.
 * Proporciona un método para eliminar un ítem de DevItem.
 *
 * Autor: Didier Piracoca
 */
@FunctionalInterface
public interface DeleteDevItem {

    /**
     * Método para eliminar un ítem.
     *
     * @param item El ítem a eliminar.
     */
    void delete(DevItem item);

}
