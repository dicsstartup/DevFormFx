package com.dicsstartup.devformfx;

import com.dicsstartup.devformfx.inputs.DevTextField;
import com.dicsstartup.devformfx.inputs.Validation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import static javafx.application.Application.launch;

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
        DevTextField texto= new DevTextField("name","Nombre");
        texto.addPattern(true,new Validation("[0-9]+","No es un numero."));
        form.addInput(texto, 0, 0);
        
        DevTextField color= new DevTextField("color","Color");
        form.addInput(color, 0, 1);
        form.Buider();
        scene = new Scene(form.getFXMLLoader(), 480, 480);

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}
