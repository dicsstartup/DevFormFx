/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

/**
 *
 * @author Didier
 */
public class DevColorPicker extends DevInput {

    ColorPicker colorPicker;

    public DevColorPicker(String name, String title) {
        super(name, title, TypeDevInput.COLOR_PICKER);
        this.colorPicker = new ColorPicker();
        configInitial();
    }

    public DevColorPicker(String name, String title, Color color) {
        super(name, title, TypeDevInput.COLOR_PICKER);
        this.colorPicker = new ColorPicker(color);
        configInitial();
    }

    private void configInitial() {
        this.setSpacing(5);
        this.colorPicker.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.getChildren().addAll(this.title, this.colorPicker);
    }
    
       @Override
    public Object getValue() {
        return this.colorPicker.getValue();
   }
    @Override
    public void addError(String message) {
    }

}
