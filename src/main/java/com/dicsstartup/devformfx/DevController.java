/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dicsstartup.devformfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Didier
 */
public class DevController implements Initializable {

    @FXML
    VBox content;
    @FXML
    HBox controls;

    Label titulo;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        header();
    }


    private void header() {
        titulo = new Label("Formulario 1");
        titulo.getStyleClass().add("titulo");
        titulo.setAlignment(Pos.CENTER);
        titulo.setMaxWidth(Double.MAX_VALUE);
        content.getChildren().add(titulo);
    }

    public void grid(GridPane grid) {
        // Agregar el GridPane al VBox
        content.getChildren().add(grid);
    }

    
}

