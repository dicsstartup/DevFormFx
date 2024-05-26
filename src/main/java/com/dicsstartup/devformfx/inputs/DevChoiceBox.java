package com.dicsstartup.devformfx.inputs;

import javafx.scene.control.ChoiceBox;

/**
 *
 * @author Didier
 */
public class DevChoiceBox extends DevInput {

    ChoiceBox choiseBox;

    public DevChoiceBox(String name, String title) {
        super(name, title);
        choiseBox = new ChoiceBox();
        config();
    }

    public DevChoiceBox(String name, String title, ChoiceBox choiseBox) {
        super(name, title);
        this.choiseBox = choiseBox;
        config();

    }

    @Override
    protected void config() {
        this.setSpacing(5);
        this.choiseBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.getChildren().addAll(this.title, this.choiseBox);
    }
    
       @Override
    public InputValue getValue() {
        return new InputValue(key, this.choiseBox.getValue());
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
