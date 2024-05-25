/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import javafx.scene.control.ComboBox;

/**
 *
 * @author Didier
 */
public class DevComboBox extends DevInput {

    private ComboBox comboBox;

    public DevComboBox(String name, String title) {
        super(name, title, TypeDevInput.COMBO_BOX);
        this.comboBox = new ComboBox();
        configInitial();
    }

    public DevComboBox(String name, String title, ComboBox comboBox) {
        super(name, title, TypeDevInput.COMBO_BOX);
        this.comboBox = comboBox;
        configInitial();
    }

    private void configInitial() {
        this.setSpacing(5);
        this.comboBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.comboBox.getStyleClass().add("devComboBox");
        this.getChildren().addAll(this.title, this.comboBox, this.error);
     
    }

       @Override
    public Object getValue() {
        return this.comboBox.getValue();
   }
    @Override
    public void addError(String message) {
        this.error.setText(message);
        enumCSS.addStyleClass(this,enumCSS.ERROR);
        enumCSS.removeStyleClass(this,enumCSS.CORRECT);
    }
        @Override
    public void clearError() {
        this.error.setText("");
        enumCSS.removeStyleClass(this,enumCSS.ERROR);
    }

    @Override
    public void clean() {
        clearError();
        this.comboBox.getEditor().clear();
        this.comboBox.getSelectionModel().clearSelection();
        enumCSS.removeStyleClass(this,enumCSS.ERROR);
    }
}
