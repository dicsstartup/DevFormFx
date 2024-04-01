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

    public DevSlider(String title,Orientation or) {
        super(title, TypeDevInput.SLIDER);
        slider = new Slider();
         configInitial(or);
    }

    public DevSlider(String title ,Orientation or, double d, double d1, double d2) {
        super(title, TypeDevInput.SLIDER);
        slider = new Slider(d, d1, d2);
         configInitial(or);
    }

    private void configInitial(Orientation or){
        slider.setOrientation(or);
        this.setSpacing(5);
        this.slider.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
         this.getChildren().addAll(this.title,this.slider);
    }
    
    public Slider getSlider() {
        return slider;
    }
    
    

}
