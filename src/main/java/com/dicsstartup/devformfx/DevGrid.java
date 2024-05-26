package com.dicsstartup.devformfx;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author Didier
 */
public class DevGrid extends GridPane {

    public DevGrid() {
        super();
    }

    public void addConstrainCol(double porcentaje) {
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(porcentaje);
        column.setHgrow(Priority.ALWAYS);
        getColumnConstraints().add(column);
    }

    public void addConstrainCol() {
        ColumnConstraints column = new ColumnConstraints();
        column.setHgrow(Priority.ALWAYS);
        getColumnConstraints().add(column);
    }

    public void addColsWithWidth(double... width) {
        for (double w : width) {
            addConstrainCol(w);
        }
    }

    public void addCols(int cantidad) {
        for (int i = 0; i > cantidad; i++) {
            addConstrainCol();
        }
    }

    public void addConstrainRow(double heigtht) {
        RowConstraints row = this.row();
        row.setPrefHeight(heigtht);
        getRowConstraints().add(row);
    }

    public void addConstrainRow() {
        getRowConstraints().add(this.row());
    }

    private RowConstraints row() {
        return new RowConstraints();
    }

    public void addRowsWithHeigtht(double... heigtht) {
        for (double h : heigtht) {
            addConstrainRow(h);
        }
    }

    public void addRows(int cantidad) {
        for (int i = 0; i > cantidad; i++) {
            addConstrainRow();
        }
    }

}
