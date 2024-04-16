/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Didier
 */
public class DevTextArea extends DevInput {

    private TextArea area;
    private int max;
    private Label maxLabel;
    private HBox footer;

    public DevTextArea(String name, String title) {
        super(name, title, TypeDevInput.TEXT_AREA);
        this.area = new TextArea();
        this.maxLabel = new Label();
        config();
    }

    public DevTextArea(String name, String title, int maxlength) {
        super(name, title, TypeDevInput.TEXT_AREA);
        this.area = new TextArea();
        this.maxLabel = new Label();
        config();
        addMaxLength(maxlength);
    }

    private void config() {
        this.maxLabel.getStyleClass().add(ClassCSS.MAXLABEL);
        this.footer = new HBox();
        this.footer.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.error.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.footer.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(this.error, Priority.ALWAYS);
        this.error.setTextAlignment(TextAlignment.LEFT);
        this.footer.getChildren().addAll(this.error, this.maxLabel);
        this.setSpacing(5);
        this.getChildren().addAll(this.title, this.area, this.footer);
        this.area.getStyleClass().add(ClassCSS.DEVTEXTAREA);
    }

    public void addMaxLength(int max) {
        this.max = max;
        this.area.textProperty().addListener((observable, oldValue, newValue) -> {
            setMaxLength(newValue);
            if (newValue.length() > max) {
                this.area.setText(oldValue);
            }
        });
    }

    private void setMaxLength(String texto) {
        this.maxLabel.setText(texto.length() + "/" + this.max);
    }

    @Override
    public Object getValue() {
        return this.area.getText();
    }

    @Override
    public void addError(String message) {
        error.setText(message);
        ClassCSS.addStyleClass(this.area, ClassCSS.ERROR);
    }

    @Override
    public void clearError() {
        error.setText("");
        this.area.getStyleClass().remove(ClassCSS.ERROR);
    }

    @Override
    public void clean() {
        this.clearError();
        this.area.setText("");
        ClassCSS.removeStyleClass(this.area, ClassCSS.ERROR);
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

}
