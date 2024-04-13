/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx.devlist;

import com.dicsstartup.devformfx.Actions.DevActionCircle;
import com.dicsstartup.devformfx.Icons.DevIcon;
import com.dicsstartup.devformfx.inputs.DevInput;
import com.dicsstartup.devformfx.inputs.TypeDevInput;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author Didier
 * @param <T>
 */
abstract public class DevListItems<T> extends DevInput {

    public DevActionCircle add;
    AnchorPane header;
    public VBox vbox;
    ScrollPane scroll;
    public List<DevItem<T>> list;
    public DeleteDevItem deleteCallback;

    public DevListItems(String name, String title) {
        super(name, title, TypeDevInput.LIST_ITEMS);
        initialConfig();

    }

    private void initialConfig() {
        this.add = new DevActionCircle("medium","primary",new DevIcon("add","secundary","medium"));
        this.add.getStyleClass().add("dev-add-item");
        this.header = new AnchorPane();
        this.vbox = new VBox();
        this.header.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.list = new ArrayList<>();
        AnchorPane.setLeftAnchor(this.title, 5.0);
        AnchorPane.setBottomAnchor(this.title, 5.0);
        AnchorPane.setTopAnchor(this.title, 5.0);
        AnchorPane.setRightAnchor(this.add, 1.0);
        this.header.getChildren().addAll(this.title, this.add);
        this.scroll = new ScrollPane();
        this.scroll.setContent(vbox);
        this.scroll.setFitToWidth(true);
        this.setSpacing(5);
        VBox.setVgrow(scroll, Priority.ALWAYS);
        this.vbox.setSpacing(3);
        this.vbox.setPadding(new javafx.geometry.Insets(5));
        this.getChildren().addAll(this.header, scroll);
        this.add.setOnAction(event -> {
            addItem();
        });
        this.deleteCallback = (item) -> {
            deleteItem(item);
        };
    }

    public void addItemPanel(DevItem<T> item) {
        this.list.add(item);
        this.vbox.getChildren().add(item);
    }

    public abstract void addItem();

    public abstract void deleteItem(DevItem<T> object);
}
