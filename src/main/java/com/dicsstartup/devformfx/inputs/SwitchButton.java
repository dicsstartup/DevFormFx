/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.css.PseudoClass;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Didier
 */
public class SwitchButton extends StackPane {

    private final Rectangle back = new Rectangle(30, 10, Color.RED);
    private final Button button = new Button();
    private static final PseudoClass checked_PSEUDO_CLASS = PseudoClass.getPseudoClass("checked");

    public SwitchButton() {
        init();
        EventHandler<Event> click = new EventHandler<Event>() {
            @Override
            public void handle(Event e) {
                if (checked.get()) {
                    setAlignment(button, Pos.CENTER_LEFT);
                    checked.set(false);
                } else {
                    setAlignment(button, Pos.CENTER_RIGHT);
                    checked.set(true);
                }
            }
        };
        button.setFocusTraversable(false);
        setOnMouseClicked(click);
        button.setOnMouseClicked(click);

    }

    private void init() {
        getChildren().addAll(back, button);
        setMinSize(35, 15);
        back.setArcHeight(back.getHeight());
        back.setArcWidth(back.getHeight());
        button.setShape(new Circle(2.0));
        setAlignment(button, Pos.CENTER_LEFT);
        button.getStyleClass().add("switchButton");
        back.getStyleClass().add("back");
    }

    private BooleanProperty checked
            = new BooleanPropertyBase(false) {
        @Override
        protected void invalidated() {
            pseudoClassStateChanged(checked_PSEUDO_CLASS, get());
        }

        @Override
        public Object getBean() {
            return SwitchButton.this;
        }

        @Override
        public String getName() {
            return "checked";
        }
    };

    public boolean IsChecked() {
        return checked.get();
    }

    public void setChecked(boolean checked) {
        this.checked.set(checked);
        if (this.checked.get()) {
            setAlignment(button, Pos.CENTER_RIGHT);
            this.checked.set(true);
        } else {
            setAlignment(button, Pos.CENTER_LEFT);
            this.checked.set(false);
        }
    }

}
