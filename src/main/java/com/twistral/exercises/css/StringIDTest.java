package com.twistral.exercises.css;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class StringIDTest extends Application {


    @Override
    public void start(Stage stage) {
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root, 500, 300);

        Button btn1 = new Button("btn1");
        btn1.getStyleClass().add("btn");
        Button btn2 = new Button("btn2");
        btn2.getStyleClass().add("btn");
        Button btn3 = new Button("btn3");
        btn3.getStyleClass().add("btn");
        Button btn4 = new Button("btn4");
        btn4.getStyleClass().add("btn");
        Button btn5 = new Button("btn5");
        btn5.getStyleClass().add("btn");
        btn5.setId("btn5");

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(Node node : root.lookupAll(".btn"))
                    ((Button) node).setText("new text");
            }
        });

        root.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) { launch(); }

}