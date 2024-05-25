package com.dicsstartup.devformfx;

import com.dicsstartup.devformfx.inputs.DevCheckBoxes;
import com.dicsstartup.devformfx.inputs.DevPasswordField;
import com.dicsstartup.devformfx.inputs.DevSwitchButton;
import com.dicsstartup.devformfx.inputs.Options;
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
        DevPasswordField texto= new DevPasswordField("name","Nombre");
        texto.addPattern(true,new Validation("[0-9]+","No es un numero."));
        texto.setIsStyleCorrect(true);
        form.addInput(texto, 0, 0);
        DevCheckBoxes color= new DevCheckBoxes("color","Opciones",true,new Options("a1","1"),new Options("a2","2",true));
        form.addInput(color, 0, 1);
        DevSwitchButton button= new DevSwitchButton("boolean","Modo oscuro",true);
        form.addInput(button, 0,2);
        form.Buider();
        scene = new Scene(form.getFXMLLoader(), 480, 480);

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}
