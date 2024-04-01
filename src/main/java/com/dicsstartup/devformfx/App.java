package com.dicsstartup.devformfx;

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
        form.grid.addRowsWithHeigtht(200);
        form.Buider();
        scene = new Scene(form.getFXMLLoader(), 480, 480);

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}
