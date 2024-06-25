package com.dicsstartup.devformfx;

import com.dicsstartup.devformfx.devActions.DevAction;
import com.dicsstartup.devformfx.devInputs.core.DevInput;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DevForm extends AnchorPane {

    private HBox controls;
    private Object model;
    private final DevGrid grid;
    private List<DevAction> actions;
    private List<DevInput> inputs;
    private DevMapper maper;
    private ScrollPane scrollPane;
    private AnchorPane pane ;

    private PalleteColors pallete;

    public DevForm(DevFormBuilder builder) throws Exception {
        super();
        this.model=  builder.getModel();
        this.grid = builder.getGrid();
        this.actions = builder.getActions();
        this.inputs = builder.getInputs();
        this.pallete=builder.getPallete();
        this.maper= new DevMapper();
        this.controls = new HBox();
        this.getStyleClass().add("form");
        this.controls.getStyleClass().add("controls");
        grid.getStyleClass().add("grid");
        pane = new AnchorPane(grid);
        scrollPane = new ScrollPane(pane);
        scrollPane.getStyleClass().add("content");
        this.getChildren().addAll(scrollPane, controls);
        AnchorPane.setTopAnchor(scrollPane, 10.0);
        AnchorPane.setLeftAnchor(scrollPane, 10.0);
        AnchorPane.setRightAnchor(scrollPane, 10.0);
        AnchorPane.setBottomAnchor(scrollPane, 70.0);

        AnchorPane.setTopAnchor(grid, 20.0);
        AnchorPane.setLeftAnchor(grid, 20.0);
        AnchorPane.setRightAnchor(grid, 20.0);
        AnchorPane.setBottomAnchor(grid, 20.0);

        // Configurar las anclas del HBox
        AnchorPane.setBottomAnchor(controls, 10.0);
        AnchorPane.setLeftAnchor(controls, 10.0);
        AnchorPane.setRightAnchor(controls, 10.0);
        this.scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.pane.prefWidthProperty().bind(scrollPane.widthProperty());
        this.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/DevFormFx.css")).toExternalForm());
        buildForm();
        // Agregar listener para el ancho del grid
        this.widthProperty().addListener((observable, oldValue, newValue) -> adjustScrollPaneHBarPolicy());
    }

    private void adjustScrollPaneHBarPolicy() {
        if (grid.getMinWidth() > scrollPane.getViewportBounds().getWidth()) {
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        } else {
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        }
    }

    /**
     * Método para añadir mensajes de error a un input específico.
     *
     * @param key Key del input.
     * @param errorMessage Mensaje de error.
     */
    public void addErrorToInput(String key, String errorMessage) {
        inputs.stream()
                .filter(input -> input.getKey().equals(key))
                .findFirst()
                .ifPresent(input -> input.addError(errorMessage));
    }


    /**
     * Método para limpiar todos los inputs del formulario.
     */
    public void clearForm() {
        inputs.forEach(DevInput::clean);
    }


    public void validForm() {
        inputs.forEach(DevInput::validate);
    }
    public void buildForm() throws Exception {
        this.maper.updateInputsFromObject(this.model, getInputs());
        this.grid.setVgap(8);
        this.grid.setHgap(8);
        this.actions.forEach(a -> this.controls.getChildren().add(a));
        applyPaletteColors(this.pallete);
    }
    public void applyPaletteColors(PalleteColors colors) {
        this.setStyle(
                "--primary-color: " + colors.getPrimary() + ";" +
                        "background-color: " + colors.getBackground() + ";" +
                        "secondary-color: " + colors.getSecondary() + ";" +
                        "text-color: " + colors.getText() + ";"+
                        "primary-color: " + colors.getPrimary() + ";"+
                        "warn-color: " + colors.getWarn() + ";"+
                        "correct-color: " + colors.getCorrect()+ ";"
        );
    }

    public DevGrid getGrid() {
        return grid;
    }

    public List<DevAction> getActions() {
        return actions;
    }

    public void setActions(List<DevAction> actions) {
        this.actions = actions;
    }

    public List<DevInput> getInputs() {
        return inputs;
    }

    public void setInputs(List<DevInput> inputs) {
        this.inputs = inputs;
    }

    public static class DevFormBuilder {
        private Object model;
        private DevGrid grid = new DevGrid();
        private List<DevAction> actions = new ArrayList<>();
        private List<DevInput> inputs = new ArrayList<>();
        private PalleteColors pallete= new PalleteColors("#1f3a60", "#0f1c2e","#3d597f","#ffffff","#2E8B57","#FF4D4D");

        public DevFormBuilder setModel(Object model) {
            this.model= model;
            return this;
        }
        public DevFormBuilder setPallete(PalleteColors pallete) {
            this.pallete= pallete;
            return this;
        }

        public DevFormBuilder addColumnsWithWidth(double... widths) {
            this.grid.addColumnsWithWidth(widths);
            return this;
        }
        public DevFormBuilder addRowsWithHeight(double... heights) {
            this.grid.addRowsWithHeight(heights);
            return this;
        }
        public DevFormBuilder addDevInput(DevInput input , int x , int y) {
            this.addInput(input,x,y);
            return this;
        }

        public DevFormBuilder addDevInput(DevInput input, int x, int y, int col, int row) {
            this.addInput(input, x, y, col, row);
            return this;
        }

        public DevFormBuilder addDevActions(DevAction devAction) {
            this.addDevAction(devAction);
            return this;
        }

        public DevForm build() throws Exception {
            return new DevForm(this);
        }

        public void addDevAction(DevAction devAction){
            this.actions.add(devAction);
        }

        public void addInput(DevInput input, int x, int y) {
            this.grid.add(input, x, y);
            this.inputs.add(input);
        }

        public void addInput(DevInput input, int x, int y, int col, int row) {
            this.grid.add(input, x, y, col, row);
            this.inputs.add(input);
        }

        public Object getModel() {
            return model;
        }

        public DevGrid getGrid() {
            return grid;
        }

        public List<DevAction> getActions() {
            return actions;
        }

        public List<DevInput> getInputs() {
            return inputs;
        }

        public PalleteColors getPallete() {
            return pallete;
        }

    }

}