package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ChoiceBoxTest extends Application {

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll(
                "test1",
                "test2",
                "test3",
                "agaTest1",
                "agaTest2",
                "agaTest3",
                "test123"
        );
        choiceBox.setValue("sjsjsjsjs");

        choiceBox.setOnShowing(event -> System.out.println("Showing") );
        choiceBox.setOnShown(event -> System.out.println("Shown") );

        pane.getChildren().addAll(choiceBox);

        pane.setVgap(20); pane.setHgap(20);
        pane.setPadding(new Insets(15));
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}