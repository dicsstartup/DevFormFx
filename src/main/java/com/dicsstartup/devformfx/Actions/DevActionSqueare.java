/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.Actions;

import com.dicsstartup.devformfx.Icons.DevIcon;

/**
 *
 * @author Didier
 */
public class DevActionSqueare extends DevAction {

    public DevActionSqueare(String label, String size,String backgroudColor) {
        super(label,size,backgroudColor);
         this.getStyleClass().addAll(size+"height");
    }
    public DevActionSqueare( String size,String backgroudColor,DevIcon icon) {
        super(size ,backgroudColor,icon);
         this.getStyleClass().addAll(size+"height",size+"width");
    }
    public DevActionSqueare(String label, String size,String backgroudColor,DevIcon icon) {
        super(label, size,backgroudColor,icon);
         this.getStyleClass().addAll(size+"height");
         
    }
}
