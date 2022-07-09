package com.twistral.exercises.events;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class HandleEventTest extends Application {

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();

        Button btn = new Button("test");
        btn.setOnAction(e -> {
            System.out.println(e.getEventType());
            btn.setDisable(true);
        });

        TextField tf = new TextField();
        tf.setOnAction(e -> {
            System.out.println(e.getEventType());
            System.out.println(tf.getText());
            tf.setDisable(true);
        });

        pane.getChildren().addAll(
                btn, tf
        );

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}