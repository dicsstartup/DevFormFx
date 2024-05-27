package com.dicsstartup.devformfx;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * Clase DevGrid que extiende GridPane y proporciona métodos para gestionar restricciones de columnas y filas.
 *
 * Autor: Didier Piracoca
 */
public class DevGrid extends GridPane {

    /**
     * Constructor de la clase DevGrid.
     */
    public DevGrid() {
        super();
    }

    /**
     * Agrega una restricción de columna con un ancho porcentual.
     *
     * @param percentage El ancho porcentual de la columna.
     */
    public void addColumnConstraint(double percentage) {
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(percentage);
        column.setHgrow(Priority.ALWAYS);
        getColumnConstraints().add(column);
    }

    /**
     * Agrega una restricción de columna con crecimiento prioritario.
     */
    public void addColumnConstraint() {
        ColumnConstraints column = new ColumnConstraints();
        column.setHgrow(Priority.ALWAYS);
        getColumnConstraints().add(column);
    }

    /**
     * Agrega columnas con anchos específicos.
     *
     * @param widths Los anchos de las columnas.
     */
    public void addColumnsWithWidth(double... widths) {
        for (double width : widths) {
            addColumnConstraint(width);
        }
    }

    /**
     * Agrega una cantidad especificada de columnas con crecimiento prioritario.
     *
     * @param count La cantidad de columnas a agregar.
     */
    public void addColumns(int count) {
        for (int i = 0; i < count; i++) {
            addColumnConstraint();
        }
    }

    /**
     * Agrega una restricción de fila con una altura específica.
     *
     * @param height La altura de la fila.
     */
    public void addRowConstraint(double height) {
        RowConstraints row = new RowConstraints();
        row.setPrefHeight(height);
        getRowConstraints().add(row);
    }

    /**
     * Agrega una restricción de fila con altura predeterminada.
     */
    public void addRowConstraint() {
        getRowConstraints().add(new RowConstraints());
    }

    /**
     * Agrega filas con alturas específicas.
     *
     * @param heights Las alturas de las filas.
     */
    public void addRowsWithHeight(double... heights) {
        for (double height : heights) {
            addRowConstraint(height);
        }
    }

    /**
     * Agrega una cantidad especificada de filas con altura predeterminada.
     *
     * @param count La cantidad de filas a agregar.
     */
    public void addRows(int count) {
        for (int i = 0; i < count; i++) {
            addRowConstraint();
        }
    }
}