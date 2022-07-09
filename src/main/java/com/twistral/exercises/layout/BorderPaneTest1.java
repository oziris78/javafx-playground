package com.twistral.exercises.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class BorderPaneTest1 extends Application {


    public void start(Stage stage) {
        BorderPane pane = new BorderPane();

        Button btn1 = new Button("Top");
        Button btn2 = new Button("Bottom");
        Button btn3 = new Button("Left");
        Button btn4 = new Button("Center");
        Button btn5 = new Button("Right");

        btn1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btn2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btn3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btn4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btn5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        pane.setTop(btn1);
        pane.setBottom(btn2);
        pane.setLeft(btn3);
        pane.setCenter(btn4);
        pane.setRight(btn5);


        Scene scene = new Scene(pane, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}