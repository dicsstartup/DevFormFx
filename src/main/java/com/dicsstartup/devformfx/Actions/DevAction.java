/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.Actions;

import com.dicsstartup.devformfx.Icons.DevIcon;
import javafx.scene.control.Button;

/**
 *
 * @author Didier
 */
public abstract class DevAction extends Button {
    
    protected String size;
    protected String backgroudColor;
    protected DevIcon devicon;
    
    public DevAction(String size, String backgroudColor) {
        this.size = size;
        setBackgroudColor(backgroudColor);
        initialConfig();
    }
    
    public DevAction(String label, String size, String backgroudColor) {
        super(label);
        this.size = size;
        setBackgroudColor(backgroudColor);
        initialConfig();
    }
    
    public DevAction(String label, String backgroudColor, String size, DevIcon icon) {
        super(label);
        setBackgroudColor(backgroudColor);
        this.size = size;
        this.devicon = icon;
        initialConfig();
        
    }
    
    public DevAction(String size, String backgroudColor, DevIcon icon) {
        super();
        this.size = size;
        setBackgroudColor(backgroudColor);
        this.devicon = icon;
        initialConfig();
    }
    
    private void initialConfig() {
        this.getStyleClass().add("devAction");
        if (this.devicon != null) {
            this.setGraphic(devicon);
        } else {
            this.setGraphic(devicon);
        }
    }
    
    public DevIcon getDevicon() {
        return devicon;
    }
    
    public String getSize() {
        return size;
    }
    
    public String getBackgroudColor() {
        return backgroudColor;
    }
    
    public void setBackgroudColor(String backgroudColor) {
        this.setStyle("-fx-background-color:" + backgroudColor + ";");
        this.backgroudColor = backgroudColor;
    }
    
}
