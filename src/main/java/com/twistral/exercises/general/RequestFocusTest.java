package com.twistral.exercises.general;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class RequestFocusTest extends Application {


    public void start(Stage stage) {
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 600, 600);

        Label lb = new Label("Press TAB");
        lb.setFont(Font.font(60d));
        lb.setPrefSize(300d, 150d);
        Button btn = new Button("testdfg");
        lb.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btn.requestFocus();
            }
        });

        root.getChildren().add(lb);
        root.getChildren().add(btn);
        int i = 0;
        root.getChildren().add(new Button(String.valueOf(i++)));
        root.getChildren().add(new Button(String.valueOf(i++)));
        root.getChildren().add(new Button(String.valueOf(i++)));
        root.getChildren().add(new Button(String.valueOf(i++)));
        root.getChildren().add(new Button(String.valueOf(i++)));
        root.getChildren().add(new Button(String.valueOf(i++)));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}