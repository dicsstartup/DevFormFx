/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.Actions;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

/**
 *
 * @author Didier
 */
public class DevAction extends Button {
    //type shape
    public static final char CIRCLE = 'C';
    public static final char SQUERE = 'S';
    //type size
    public static final char SMALL = 'S';
    public static final char MEDIUM = 'M';
    public static final char LARGE = 'L';

    private char size;
    private char type;
    private DevIcon devicon;

    public DevAction(String label, char size, char type) {
        super(label);
        this.size = size;
        this.type = type;
        initialConfig();
    }

    public DevAction(String label, String icon, char size, char type, String iconColor) {
        super(label);
        this.size = size;
        this.type = type;
        this.devicon = new DevIcon(icon, iconColor, this.sizeIcon(this.size), this.sizeIcon(this.size));
        initialConfig();

    }

    public DevAction(String icon, char size, char type, String iconColor) {
        super();
        this.size = size;
        this.type = type;
        this.devicon = new DevIcon(icon, iconColor, this.sizeIcon(this.size), this.sizeIcon(this.size));
        initialConfig();
    }

    private void initialConfig() {
        this.getStyleClass().add("dev-action");
        if (type == CIRCLE) {
            this.setShape(new Circle(35));
            this.setPrefSize(sizes(this.size), sizes(this.size));
        } else if (type == this.SQUERE) {
            this.setStyle("-fx-background-radius:4px; ");
            if (this.devicon != null) {
                this.setPrefSize(sizes(this.size), sizes(this.size));
            } else {
                this.setPrefHeight(sizes(this.size));

            }
        }
        if (this.devicon != null) {
            this.setGraphic(devicon);
        } else {
            this.setGraphic(devicon);

        }

    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public DevIcon getDevicon() {
        return devicon;
    }

    public double sizes(char size) {
        switch (size) {
            case SMALL:
                return 32;

            case MEDIUM:
                return 44;

            case LARGE:
                return 52;
        }
        return Button.USE_COMPUTED_SIZE;
    }

    public double sizeIcon(char size) {
        switch (size) {
            case SMALL:
                return 16;

            case MEDIUM:
                return 20;

            case LARGE:
                return 24;
        }
        return Button.USE_COMPUTED_SIZE;
    }

}
