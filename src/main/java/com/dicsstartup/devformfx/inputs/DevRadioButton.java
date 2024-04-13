/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import javafx.scene.control.RadioButton;

/**
 *
 * @author Didier
 */
public class DevRadioButton extends DevInput {

    RadioButton RBotton;

    public DevRadioButton(String name, String title, String label) {
        super(name, title, TypeDevInput.RADIO_BUTTON);
        RBotton = new RadioButton(label);
        this.setSpacing(5);
        this.getChildren().addAll(this.title, this.RBotton);
    }

       @Override
    public Object getValue() {
        return this.RBotton.isSelected();
   }
}
