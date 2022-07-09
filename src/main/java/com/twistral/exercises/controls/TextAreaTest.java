package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class TextAreaTest extends Application {

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();

        TextArea ta = new TextArea();
        ta.setPromptText("write something here");
        ta.lengthProperty().addListener( e -> {
            System.out.println("b");
        });
        pane.getChildren().addAll(ta );



        pane.setVgap(20); pane.setHgap(20);
        pane.setPadding(new Insets(15));
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}