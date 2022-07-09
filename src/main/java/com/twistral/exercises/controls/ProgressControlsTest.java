package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ProgressControlsTest extends Application {

    private static final boolean DEBUG = false;

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();

        pane.setPadding(new Insets(15));
        pane.setHgap(30d);

        pane.getChildren().addAll(
                new ProgressIndicator(),
                new ProgressIndicator(0.5d),
                new ProgressBar(),
                new ProgressBar(0.75d)
        );

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}