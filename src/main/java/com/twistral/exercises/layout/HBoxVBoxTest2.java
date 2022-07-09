package com.twistral.exercises.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HBoxVBoxTest2 extends Application {

    public void start(Stage stage) {
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 600, 600);
        stage.setScene(scene);

        HBox paneTop = new HBox(15);
        Button btnTop1 = new Button("left");
        Button btnTop2 = new Button("left2");
        Region regTop1 = new Region();
        Button btnTop3 = new Button("right");

        btnTop1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnTop2.setMaxWidth(Double.MAX_VALUE);
        btnTop2.setPrefHeight(30);
        regTop1.setMaxWidth(Double.MAX_VALUE);
        btnTop3.setPrefWidth(80);
        HBox.setHgrow(btnTop1, Priority.ALWAYS);
        HBox.setHgrow(btnTop2, Priority.ALWAYS);
        HBox.setHgrow(regTop1, Priority.ALWAYS);
        HBox.setHgrow(btnTop3, Priority.NEVER);
        paneTop.setPadding(new Insets(15));
        paneTop.getChildren().addAll(btnTop1, btnTop2, regTop1, btnTop3);

        HBox paneMiddle = new HBox(20);
        TextArea taMid1 = new TextArea();
        taMid1.setPrefWidth(350);
        TextArea taMid2 = new TextArea();
        taMid2.setPrefWidth(150);
        HBox.setHgrow(taMid1, Priority.ALWAYS);
        HBox.setHgrow(taMid2, Priority.ALWAYS);
        paneMiddle.setPadding(new Insets(15));
        paneMiddle.getChildren().addAll(taMid1, taMid2);


        HBox paneBottom = new HBox();
        Button btnBot1 = new Button("bruh");
        btnBot1.setPrefWidth(120);
        Region regBot1 = new Region();
        HBox.setHgrow(btnBot1, Priority.NEVER);
        HBox.setHgrow(regBot1, Priority.ALWAYS);
        paneBottom.getChildren().addAll(btnBot1, regBot1);
        paneBottom.setPadding(new Insets(15));

        vbox.getChildren().addAll(
                paneTop,
                paneMiddle,
                paneBottom
        );

        VBox.setVgrow(paneTop, Priority.NEVER);
        VBox.setVgrow(paneMiddle, Priority.ALWAYS);
        VBox.setVgrow(paneBottom, Priority.NEVER);

        stage.show();
    }

    public static void main(String[] args) { launch(); }

}