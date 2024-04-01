/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.dicsstartup.devformfx.Actions;

import javafx.scene.layout.Region;

/**
 *
 * @author Didier
 */
public class DevIcon extends Region{
    
    private String icon;
    private String color;
    private double widthIcon;
    private double heidthIcon;
    
    public DevIcon() {
        super();
    }

    public DevIcon(String icon, String color, double widthIcon, double heidthIcon) {
        this.icon = icon;
        this.color = color;
        this.widthIcon = widthIcon;
        this.heidthIcon = heidthIcon;
        style();
    }
    
    public void style(){
        StringBuilder sb= new StringBuilder();
        sb.append("-fx-shape: \"").append(icon).append("\"; ");
        sb.append("-fx-background-color: ").append(color).append("; ");
        sb.append("-fx-max-height: ").append(this.heidthIcon).append("px; ");
        sb.append("-fx-max-width:").append(this.widthIcon).append("px;");
        this.setStyle(sb.toString());
    }
    

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
        style();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        style();
    }

    public double getWidthIcon() {
        return widthIcon;
    }

    public void setWidthIcon(double widthIcon) {
        this.widthIcon = widthIcon;
        style();
    }

    public double getHeidthIcon() {
        return heidthIcon;
    }

    public void setHeidthIcon(double heidthIcon) {
        this.heidthIcon = heidthIcon;
          style();
    }


}
