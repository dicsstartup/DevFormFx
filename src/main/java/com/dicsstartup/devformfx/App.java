package com.dicsstartup.devformfx;

import com.dicsstartup.devformfx.inputs.DevComboBox;
import com.dicsstartup.devformfx.inputs.DevPasswordField;
import com.dicsstartup.devformfx.inputs.Validation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        DevFormBuilder form = new DevFormBuilder();
        form.grid.addColsWithWidth(100);
        form.grid.setHgap(10);
        form.grid.setVgap(10);
        DevPasswordField texto = new DevPasswordField("name", "Nombre");
        texto.addPattern(true, new Validation("[0-9]+", "No es un numero."));
        texto.setIsStyleCorrect(true);
        form.addInput(texto, 0, 0);
        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "Option 1",
                        "Option 2",
                        "Option 3",
                         "Option 4",
                         "Option 1",
                        "Option 2",
                        "Option 3"
                       
                );
        ComboBox<String> myComboBox = new ComboBox<>(options);
        myComboBox.setEditable(true);
        DevComboBox button = new DevComboBox("boolean", "Modo oscuro", myComboBox);
        form.addInput(button, 0, 1);
        button.addError("1231");
        form.actions.get(0).setOnAction(event -> {
            button.clean();
        });;
        form.Buider();
        scene = new Scene(form.getFXMLLoader(), 480, 480);

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}
