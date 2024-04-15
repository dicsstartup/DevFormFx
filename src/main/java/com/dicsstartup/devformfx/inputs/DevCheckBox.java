/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import javafx.scene.control.CheckBox;

/**
 *
 * @author Didier
 */
public class DevCheckBox extends DevInput {

    CheckBox check;

    public DevCheckBox(String name, String title, String value) {
        super(name, title, TypeDevInput.CHECK_BOX);
        check = new CheckBox(value);
        this.setSpacing(5);
        this.getChildren().addAll(this.title, this.check);
    }

    @Override
    public Object getValue() {
        return check.isSelected();
   }

    @Override
    public void addError(String message) {
    }
}
