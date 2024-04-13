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

    ComboBox comboBox;

    public DevComboBox(String name, String title) {
        super(name, title, TypeDevInput.COMBO_BOX);
        comboBox = new ComboBox();
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
        this.getChildren().addAll(this.title, this.comboBox);

    }

       @Override
    public Object getValue() {
        return this.comboBox.getValue();
   }
}
