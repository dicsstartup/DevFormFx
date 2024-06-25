package com.dicsstartup;

import com.dicsstartup.devformfx.DevForm;
import com.dicsstartup.devformfx.DevMapper;
import com.dicsstartup.devformfx.FileChoser;
import com.dicsstartup.devformfx.PalleteColors;
import com.dicsstartup.devformfx.devActions.DevAction;
import com.dicsstartup.devformfx.devActions.DevActionSquare;
import com.dicsstartup.devformfx.devIcons.DevIcon;
import com.dicsstartup.devformfx.devInputs.*;
import com.dicsstartup.devformfx.devInputs.core.ValidationActive;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    Lenguaje[] lenguajes = {
            new Lenguaje("Java"),
            new Lenguaje("Python"),
            new Lenguaje("JavaScript"),
            new Lenguaje("C#"),
            new Lenguaje("Ruby")
    };

    @Override
    public void start(Stage stage) throws Exception {
        Usuario user = new Usuario("", "Doe", "", "Admin", Arrays.stream(lenguajes).findFirst().get(), "Me gusta el culo de mi gata", true,
                Color.BLUE, LocalDate.of(2024, 6, 15), 50.0);

        DevTextField textField = new DevTextField("name", "Nombre", true);
        textField.addPattern(new ValidationActive("^[a-zA-Z\\s]*$","Tiene que ser solo letras"));
        textField.addValidator(value ->  !value.equals("didier"),"ya existe el usuario");

        DevTextField textField2 = new DevTextField("last_name", "Apellido", true);
        textField2.addPattern(new ValidationActive("^[a-zA-Z\\s]*$","Tiene que ser solo letras"));
        textField2.addValidator(value ->  !value.equals("piracoca"),"ya existe el usuario");

        DevPasswordField password = new DevPasswordField("password", "Contraseña", true);
        password.addPattern(new ValidationActive( "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[a-zA-Z\\d@$!%*?&]+$","Tiene que contener almenos un numero y un caracter especial"));
        password.addValidator(value ->  !value.isEmpty(),"No puede estar vacio");

        DevSwitchButton login = new DevSwitchButton("loginPersist", "Mantener Loguiado");

        DevCheckBoxes checkBoxes= new DevCheckBoxes("rol","¿Cual es tu rol?",true,new CheckBoxItem("User","usuario",true),new CheckBoxItem("Admin","administrador"),new CheckBoxItem("root","usuario root"));

        DevColorPicker colorPicker= new DevColorPicker("color","Color favorito");

        DevDatePicker date = new DevDatePicker("date_birday","Fecha de Nacimiento");

        DevAction add = new DevActionSquare("large","primary-color",new DevIcon("check","text-color","large"));

        DevSlider nivel = new DevSlider("level","Que nivel tienes?",10,100,0);
        ObservableList<Lenguaje> lenguajesList = FXCollections.observableArrayList(lenguajes);
        DevComboBox<Lenguaje> comboBox = new DevComboBox<>("lenguage","¿Lenguaje principal?",lenguajesList);
        comboBox.getComboBox().setConverter(new StringConverter<>() {
            @Override
            public String toString(Lenguaje lenguaje) {
                return lenguaje != null ? lenguaje.getNombre() : "";
            }

            @Override
            public Lenguaje fromString(String string) {
                return null; // No es necesario convertir de String a Lenguaje
            }
        });

        comboBox.getComboBox().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            Lenguaje selectedLenguaje = comboBox.getComboBox().getSelectionModel().getSelectedItem();
            if (selectedLenguaje != null) {
                nivel.setDisable(false);
            }
        });

        DevTextArea area = new DevTextArea("comments","Comentarios",200);

        FileChoser fileChoser= new FileChoser("files","ficheros");

        DevForm form = new DevForm.DevFormBuilder()
                .setModel(user)
                .addColumnsWithWidth(50,50)
             .setPallete(new PalleteColors("#20201E","#171717","#e8e8e8","#e8e8e8","#5BA025","#B81818"))
                .setPallete(new PalleteColors("#92dec5","#091f19","#522579","#DBF4EC","#5BA025","#B81818"))
                .addDevInput(textField,0,0)
                .addDevInput(textField2,1,0)
                .addDevInput(password,0,1,2,1)
                .addDevInput(login,0,2)
                .addDevInput(checkBoxes,0,3,2,1)
                .addDevInput(colorPicker,0,4)
                .addDevInput(date,1,4)
                .addDevInput(comboBox,0,5)
                .addDevInput(nivel,1,5)
                .addDevInput(area,0,6,2,1)
                .addDevInput(area,0,6,2,1)
                .addDevActions(add)
                .build();
        form.getGrid().setMinWidth(400);

        add.setOnAction( value -> { form.validForm();
            try {
                System.out.println(user.toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        scene = new Scene(form,600,670, Color.AQUA);

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }


    public static class Lenguaje {
        String nombre;


        public Lenguaje() {

        }
        public Lenguaje(String nombre) {
            this.nombre = nombre;

        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }

}
