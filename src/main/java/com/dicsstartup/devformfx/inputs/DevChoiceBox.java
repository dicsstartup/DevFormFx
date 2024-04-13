/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import javafx.scene.control.ChoiceBox;

/**
 *
 * @author Didier
 */
public class DevChoiceBox extends DevInput {

    ChoiceBox choiseBox;

    public DevChoiceBox(String name, String title) {
        super(name, title, TypeDevInput.CHOICE_BOX);
        choiseBox = new ChoiceBox();
        configInitial();
    }

    public DevChoiceBox(String name, String title, ChoiceBox choiseBox) {
        super(name, title, TypeDevInput.CHOICE_BOX);
        this.choiseBox = choiseBox;
        configInitial();

    }

    private void configInitial() {
        this.setSpacing(5);
        this.choiseBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.getChildren().addAll(this.title, this.choiseBox);
    }
    
       @Override
    public Object getValue() {
        return this.choiseBox.getValue();
   }
}
