package com.dicsstartup.devformfx.devList;

import com.dicsstartup.devformfx.DevGrid;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * Clase abstracta DevItem que extiende DevGrid.
 * Proporciona la estructura básica para un ítem con una etiqueta y un contenedor de acciones.
 *
 * @param <T> Tipo del valor del ítem.
 * @author Didier
 */
abstract public class DevItem<T> extends DevGrid {

    private Label label;
    private HBox actions;
    private T value;

    /**
     * Constructor que inicializa el ítem con un texto y un valor.
     *
     * @param text El texto de la etiqueta.
     * @param value El valor del ítem.
     */
    public DevItem(String text, T value) {
        super();
        this.label = new Label(text);
        this.actions = new HBox();
        this.value = value;
        configInitial();
    }

    /**
     * Configuración inicial del ítem.
     */
    public void configInitial() {
        this.getStyleClass().add("item");
        this.addColumnsWithWidth(70, 30);
        this.addRowConstraint(30);
        this.addRowConstraint(30);
        this.setPadding(new Insets(0, 10, 0, 10));
        GridPane.setValignment(label, VPos.BOTTOM);
        HBox.setHgrow(actions, Priority.ALWAYS);
        this.add(label, 0, 0);
        this.add(actions, 1, 0, 1, 2);
    }

    /**
     * Método abstracto para obtener el GridPane del ítem.
     *
     * @return El GridPane del ítem.
     */
    public abstract GridPane getBox();

    // Getters y setters

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public HBox getActions() {
        return actions;
    }

    public void setActions(HBox actions) {
        this.actions = actions;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
