/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import javafx.scene.control.TextArea;

/**
 *
 * @author Didier
 */
public class DevTextArea extends DevInput{
    
    TextArea area;
    
    public DevTextArea(String title) {
        super(title, TypeDevInput.TEXT_AREA);
        area= new TextArea();
        this.setSpacing(5);
        this.getChildren().addAll(this.title,this.area);
    }
    
}