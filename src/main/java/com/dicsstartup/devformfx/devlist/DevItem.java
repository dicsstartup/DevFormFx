package com.dicsstartup.devformfx.devlist;


import com.dicsstartup.devformfx.DevGrid;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 *
 * @author Didier
 * @param <T>
 * @param <Object>
 */
abstract public class DevItem <T> extends DevGrid {
    
    Label label;
    public HBox  actions;
    private T value;

    public DevItem( String s ,T value) {
       super();
        this.label = new Label(s);
        this.actions= new HBox();
        this.value = value;
        configInital();
    }
  
    public void configInital (){
        this.getStyleClass().add("item");
        this.addColsWithWidth(70,30);
        this.addRowsWithHeigtht(30);
        this.addRowsWithHeigtht(30);
        this.setPadding(new Insets(0, 10, 0, 10)); 
        GridPane.setValignment(label, VPos.BOTTOM);
        HBox.setHgrow(actions, Priority.ALWAYS);
        this.add(label, 0, 0);
        this.add(actions, 1, 0,1,2);
    }
  
    public abstract GridPane getBox();

 
    


    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    
}
