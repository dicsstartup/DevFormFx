/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import javafx.geometry.Orientation;
import javafx.scene.control.Slider;

/**
 *
 * @author Didier
 */
public class DevSlider extends DevInput {

    Slider slider;

    public DevSlider(String name, String title, Orientation or) {
        super(name, title);
        slider = new Slider();
        config(or);
    }

    public DevSlider(String name, String title, Orientation or, double d, double d1, double d2) {
        super(name, title);
        slider = new Slider(d, d1, d2);
        config(or);
    }

    @Override
    protected void config() {
        this.setSpacing(5);
        this.slider.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.getChildren().addAll(this.title, this.slider);
    }

    protected void config(Orientation or) {
        slider.setOrientation(or);
        this.config();
    }

    public Slider getSlider() {
        return slider;
    }

    @Override
    public InputValue getValue() {
        return new InputValue(this.key, this.slider.getValue());
   }
    @Override
    public void addError(String message) {
    }
        @Override
    public void clearError() {
    }

    @Override
    public void clean() {
    }
    
    
}
