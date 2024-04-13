/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import javafx.scene.control.TextField;

/**
 *
 * @author Didier
 */
public class DevTextFild extends DevInput {

    private TextField textField;

    public DevTextFild(String name, String title) {
        super(name, title, TypeDevInput.TEXT_FIELD);
        this.setSpacing(5);
        textField = new TextField();
        textField.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.getChildren().addAll(this.title, this.textField);
    }

       @Override
    public Object getValue() {
        return textField.getText();
   }
}
