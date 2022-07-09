package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;


public class AllDialogsTest extends Application {

    public void start(Stage stage) {
        VBox pane = new VBox();


        Button button = new Button("click for an alert");
        button.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.showAndWait().ifPresent(response -> {
                if(response == ButtonType.OK){
                    System.out.println("OK DUDE");
                }
                if(response == ButtonType.CANCEL){
                    System.out.println("CANCEL IT DUDE NOOO");
                }
            });
        });

        Button button2 = new Button("click for an choiceDialog");
        button2.setOnAction(event -> {
            List<String> programmingLanguages = List.of("Python", "C/C++", "Go", "C#", "Java");
            ChoiceDialog<String> choiceDialog = new ChoiceDialog<>(programmingLanguages.get(0), programmingLanguages);
            choiceDialog.showAndWait().ifPresent(response -> {
                System.out.println(response);
            });
        });

        Button button3 = new Button("click for an textInputDialog");
        button3.setOnAction(event -> {
            TextInputDialog textInputDialog = new TextInputDialog("Bob");
            textInputDialog.setTitle("Enter Your Name");
            textInputDialog.setHeaderText("What is your name?");
            textInputDialog.setContentText("Please enter your name in the textField to the right.");
            textInputDialog.showAndWait().ifPresent(response -> {
                System.out.println(response);
            });
        });



        pane.getChildren().addAll(button, button2, button3);

        pane.setSpacing(10);
        pane.setPadding(new Insets(20));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) { launch(); }

}