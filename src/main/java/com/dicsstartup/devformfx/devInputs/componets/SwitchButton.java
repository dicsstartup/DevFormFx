package com.dicsstartup.devformfx.devInputs.componets;

import com.dicsstartup.devformfx.DevForm;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.css.PseudoClass;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Clase SwitchButton que representa un botón de interruptor (switch) personalizado.
 *
 * Autor: Didier Piracoca
 */
public class SwitchButton extends StackPane {

    // Clase CSS
    public static final String CLASS = "switchButton";
    public static final String CLASS_R = "rectangle";
    public static final String CHECKED = "checked";

    // Pseudo-clase para el estado "checked"
    private static final PseudoClass checked_PSEUDO_CLASS = PseudoClass.getPseudoClass(CHECKED);

    // Rectángulo del interruptor
    private final Rectangle rectangle = new Rectangle(30, 10, Color.WHITE);

    // Botón del interruptor
    private final Button button = new Button();

    // Propiedad booleana para el estado "checked"
    private final BooleanProperty checked = new BooleanPropertyBase(false) {
        @Override
        protected void invalidated() {
            pseudoClassStateChanged(checked_PSEUDO_CLASS, get());
        }

        @Override
        public Object getBean() {
            return SwitchButton.this;
        }

        @Override
        public String getName() {
            return CHECKED;
        }
    };

    /**
     * Constructor de la clase SwitchButton.
     */
    public SwitchButton() {
        // Inicialización del interruptor
        init();

        // Manejador de eventos para el clic
        EventHandler<Event> click = new EventHandler<Event>() {
            @Override
            public void handle(Event e) {
                // Cambia el estado "checked" cuando se hace clic en el interruptor
                if (checked.get()) {
                    setAlignment(button, Pos.CENTER_LEFT);
                    checked.set(false);
                } else {
                    setAlignment(button, Pos.CENTER_RIGHT);
                    checked.set(true);
                }
            }
        };

        // Configuración del botón para que no sea focus traversable
        button.setFocusTraversable(false);

        // Asigna el manejador de eventos al StackPane y al botón
        setOnMouseClicked(click);
        button.setOnMouseClicked(click);
    }

    /**
     * Método de inicialización del interruptor.
     */
    private void init() {
        // Añade el rectángulo y el botón al StackPane
        getChildren().addAll(rectangle, button);

        // Establece el tamaño mínimo del StackPane
        setMinSize(35, 15);

        // Configura las esquinas redondeadas del rectángulo
        rectangle.setArcHeight(rectangle.getHeight());
        rectangle.setArcWidth(rectangle.getHeight());

        // Configura la forma del botón como un círculo
        button.setShape(new Circle(2.0));

        // Alinea el botón al centro izquierda del StackPane
        setAlignment(button, Pos.CENTER_LEFT);

        // Añade las clases CSS al botón y al rectángulo
        this.getStyleClass().add(CLASS);
        rectangle.getStyleClass().add(CLASS_R);
        this.getStylesheets().add(DevForm.class.getResource("style/switchButton.css").toExternalForm());
    }

    /**
     * Método para verificar si el interruptor está marcado.
     *
     * @return true si el interruptor está marcado, false en caso contrario.
     */
    public boolean isChecked() {
        return checked.get();
    }

    /**
     * Método para establecer el estado del interruptor.
     *
     * @param checked true para marcar el interruptor, false para desmarcarlo.
     */
    public void setChecked(boolean checked) {
        this.checked.set(checked);
        // Cambia la alineación del botón según el estado "checked"
        if (this.checked.get()) {
            setAlignment(button, Pos.CENTER_RIGHT);
            this.checked.set(true);
        } else {
            setAlignment(button, Pos.CENTER_LEFT);
            this.checked.set(false);
        }
    }

}
