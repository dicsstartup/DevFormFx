/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author Didier
 */
public class DevInput extends VBox {
    
    protected Label title;
    protected Label error;
    protected TypeDevInput type;

    public DevInput(String title,TypeDevInput type) {
        super();
        this.title= new Label(title);
        this.error= new Label();
        this.type= type;
        
    }

    public void  addClassStyle(){
         this.error.getStyleClass().add("error");
         this.title.getStyleClass().add("label");
    }

    public Label getTitle() {
        return title;
    }

    public void setTitle(Label title) {
        this.title = title;
    }

    public Label getError() {
        return error;
    }

    public void setError(Label error) {
        this.error = error;
    }

    public TypeDevInput getType() {
        return type;
    }
    
}
