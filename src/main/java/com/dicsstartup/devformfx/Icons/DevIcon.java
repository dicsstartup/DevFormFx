/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.dicsstartup.devformfx.Icons;

import javafx.scene.layout.Region;

/**
 *
 * @author Didier
 */
public class DevIcon extends Region {

    private String icon;
    private String color;
    private String size;

    public DevIcon() {
        super();
    }

    public DevIcon(String icon, String color, String size) {
        this.icon = icon;
        this.color = color;
        this.size = size;
        style() ;
    }

    public void style() {
        this.getStyleClass().addAll("devIcon", size,icon);
        this.setStyle("-fx-background-color:"+color+";");
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.getStyleClass().remove(this.icon);
        this.icon = icon;
        this.getStyleClass().add(this.icon);

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        this.setStyle("-fx-background-color:"+color+";");
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.getStyleClass().remove(this.size);
        this.size = size;
        this.getStyleClass().add(this.size);
    }

}
