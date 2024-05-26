package com.dicsstartup.devformfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }


    public void grid(GridPane grid) {
        content.getChildren().add(grid);
    }

    
}

