/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import javafx.scene.control.Spinner;

/**
 *
 * @author Didier
 */
public class DevSpinner extends DevInput {

    Spinner spinner;

    public DevSpinner(String name, String title, Spinner spinner) {
        super(name, title, TypeDevInput.SPINNER);
        this.spinner = spinner;
        this.setSpacing(5);
        this.spinner.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.getChildren().addAll(this.title, this.spinner);
    }
    
       @Override
    public Object getValue() {
        return this.spinner.getValue();
   }

}
