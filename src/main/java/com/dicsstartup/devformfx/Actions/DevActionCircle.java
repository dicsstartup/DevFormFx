package com.dicsstartup.devformfx.Actions;

import com.dicsstartup.devformfx.Icons.DevIcon;
import javafx.scene.shape.Circle;

/**
 *
 * @author Didier
 */
public class DevActionCircle extends DevAction{
    
    public DevActionCircle( String size, String backgroudColor , DevIcon icon) {
        super(size,backgroudColor, icon);
        this.setShape(new Circle(35));
        this.getStyleClass().addAll(size+"heiht",size+"width");
    }
    
}
