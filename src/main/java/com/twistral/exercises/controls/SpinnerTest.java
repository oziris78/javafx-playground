package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class SpinnerTest extends Application {

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();

        Spinner<Integer> spinner = new Spinner<>(0d, 100d, 50d, 15d);
        spinner.getValueFactory().wrapAroundProperty().set(true);
        spinner.getStyleClass().addAll(Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL);
        spinner.setEditable(true);


        pane.getChildren().addAll(spinner);
        pane.getChildren().addAll();

        pane.setVgap(20); pane.setHgap(20);
        pane.setPadding(new Insets(15));
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}