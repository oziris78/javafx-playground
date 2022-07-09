package com.twistral.exercises.general;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class GroupTest extends Application {


    public void start(Stage stage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.show();

        Group g = new Group();
        for (int i = 0; i < 5; i++) {
            Rectangle r = new Rectangle();
            r.setX(50d);
            r.setY(i * 20);
            r.setWidth(100);
            r.setHeight(10);
            r.setFill(Color.BLACK);
            g.getChildren().add(r);
        }

        Button myBtn = new Button("test");
        myBtn.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent event) {
            g.setTranslateX(g.getTranslateX() + 10);
        }});
        root.getChildren().add(myBtn);
        root.getChildren().add(g);


    }

    public static void main(String[] args) { launch(); }

}