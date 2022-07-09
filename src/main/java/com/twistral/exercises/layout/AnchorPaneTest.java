package com.twistral.exercises.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AnchorPaneTest extends Application {

    public void start(Stage stage) {

        AnchorPane anchorPane = new AnchorPane();

        Button btn1 = new Button("btn1");
        btn1.setPrefHeight(40); // remove to see the effect
        Button btn2 = new Button("btn2");
        btn2.setPrefHeight(40); // remove to see the effect

        AnchorPane.setBottomAnchor(btn1, 0d);
        AnchorPane.setLeftAnchor(btn1, 0d);
        AnchorPane.setRightAnchor(btn1, 0d);

        AnchorPane.setTopAnchor(btn2, 100d);
        AnchorPane.setLeftAnchor(btn2, 100d);
        AnchorPane.setRightAnchor(btn2, 100d);


        anchorPane.getChildren().addAll(btn1, btn2);

        Scene scene = new Scene(anchorPane, 600, 600);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) { launch(); }

}