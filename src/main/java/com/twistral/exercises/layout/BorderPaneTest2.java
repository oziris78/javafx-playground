package com.twistral.exercises.layout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class BorderPaneTest2 extends Application {


    public void start(Stage stage) {
        BorderPane pane = new BorderPane();

        Button btn1 = new Button("Top");
        Button btn2 = new Button("Bottom");
        Button btn3 = new Button("Left");
        Button btn4 = new Button("Center");
        Button btn5 = new Button("Right");

        pane.setTop(btn1);
        pane.setBottom(btn2);
        pane.setLeft(btn3);
        pane.setCenter(btn4);
        pane.setRight(btn5);

        BorderPane.setAlignment(pane.getTop(), Pos.CENTER);
        BorderPane.setAlignment(pane.getBottom(), Pos.CENTER);
        BorderPane.setAlignment(pane.getLeft(), Pos.CENTER);
        BorderPane.setAlignment(pane.getCenter(), Pos.CENTER);
        BorderPane.setAlignment(pane.getRight(), Pos.CENTER);

        Scene scene = new Scene(pane, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}