package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class AccordionTest extends Application {

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();

        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        Button btn3 = new Button("btn3");
        btn1.setOnAction(event -> System.out.println("btn1"));
        btn2.setOnAction(event -> System.out.println("btn2"));
        btn3.setOnAction(event -> System.out.println("btn3"));

        TitledPane titledPane1 = new TitledPane("titledPane1", btn1);
        TitledPane titledPane2 = new TitledPane("titledPane2", btn2);
        TitledPane titledPane3 = new TitledPane("titledPane3", btn3);

        Accordion accordion = new Accordion(titledPane1, titledPane2, titledPane3);
        accordion.expandedPaneProperty().addListener( (observable, oldValue, newValue) -> {
                System.out.println("TitledPane has changed, random number: " + Math.random());
        });

        pane.getChildren().addAll(accordion);

        pane.setVgap(20); pane.setHgap(20);
        pane.setPadding(new Insets(15));
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}