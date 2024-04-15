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
public abstract class DevInput extends VBox {

    protected String name;
    protected Label title;
    protected Label error;
    protected TypeDevInput type;

    public DevInput(String name, String title, TypeDevInput type) {
        super();
        this.title = new Label(title);
        this.error = new Label();
        this.type = type;
        addClassStyle();
    }

    public void addClassStyle() {
        this.getStyleClass().add(ClassCSS.DEV_INPUT);
        this.error.getStyleClass().add("label_error");
        this.title.getStyleClass().add("title");
    }
    
    public abstract Object getValue();
    
    public abstract void addError(String message);
    

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

    public String getName() {
        return name;
    }
    
}
