package com.twistral.exercises.events;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HandleKeyEventTest extends Application {

    public void start(Stage stage) {
        VBox pane = new VBox(new Text("Press WASD and look at console"));
        Scene scene = new Scene(pane);

        scene.setOnKeyPressed(event -> {
            KeyCode keyPressed = event.getCode();
            if(keyPressed == KeyCode.A) System.out.println("you pressed A");
            if(keyPressed == KeyCode.W) System.out.println("you pressed W");
            if(keyPressed == KeyCode.D) System.out.println("you pressed D");
            if(keyPressed == KeyCode.S) System.out.println("you pressed S");
        });


        pane.setSpacing(10);
        pane.setPadding(new Insets(20));

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) { launch(); }

}