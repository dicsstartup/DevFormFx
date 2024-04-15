/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.inputs;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;

/**
 *
 * @author Didier
 */
public class DevCheckBoxList extends DevInput {

    List<CheckBox> listCheckbox;
    HBox hbox;

    public DevCheckBoxList(String name, String title, boolean OnlyOneOpction, String... options) {
        super(name, title, TypeDevInput.CHECK_BOX_LIST);
        listCheckbox = new ArrayList<>();
        hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        this.setSpacing(5);
        for (String i : options) {
            CheckBox check = new CheckBox(i);
            if (OnlyOneOpction) {
                check.setOnAction(event -> setOnlyOneTrue(check));
            }
            listCheckbox.add(check);
            hbox.getChildren().add(check);
            listCheckbox.add(check);
        }
        this.getChildren().addAll(this.title, this.hbox);
    }

    private void setOnlyOneTrue(CheckBox selectedCheckbox) {
        listCheckbox.forEach(checkbox -> {
            if (checkbox != selectedCheckbox) {
                checkbox.setSelected(false);
            } else {
                checkbox.setSelected(true);
            }
        });
    }

    @Override
    public Object getValue() {
        for(CheckBox check:listCheckbox){
           if (check.isSelected() ) {
              return  check.getText();
            } 
        }
      return null;
   }
    @Override
    public void addError(String message) {
    }

}
