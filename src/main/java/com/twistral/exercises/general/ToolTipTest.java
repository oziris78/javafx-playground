package com.twistral.exercises.general;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class ToolTipTest extends Application {

    private static final boolean DEBUG = false;

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();


        Button button1 = new Button("Hover Over Me");
        Tooltip tooltip = new Tooltip();
        HBox hBox = new HBox();
        hBox.getChildren().addAll(new Label("testLabel123  "), new Label("testLabel123  "));
        tooltip.setGraphic(hBox);
        button1.setTooltip(tooltip);


        Button button2 = new Button("Hover Over Me vol2");
        Tooltip tooltip2 = new Tooltip();
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(new Label("testLabel123456  "), new Label("testLabel123456  "));
        tooltip2.setGraphic(hBox2);
        button2.setTooltip(tooltip2);


        pane.getChildren().addAll(button1, button2);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}