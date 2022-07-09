package com.twistral.exercises.general;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChangeScenesTest extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Group group1 = new Group();
        Group group2 = new Group();
        Scene scene1 = new Scene(group1, 500, 500, Color.GRAY);
        Scene scene2 = new Scene(group2, 500, 500, Color.DARKSLATEGRAY);
        Button btn1 = new Button("this is button 1");
        Button btn2 = new Button("this is button 2");
        btn1.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent event) {
            stage.setScene(scene2);
            center(scene1, btn1);
            center(scene2, btn2);
        }});
        btn2.setOnAction(new EventHandler<ActionEvent>() {@Override public void handle(ActionEvent event) {
            stage.setScene(scene1);
            center(scene1, btn1);
            center(scene2, btn2);
        }});
        group1.getChildren().add(btn1);
        group2.getChildren().add(btn2);

        stage.setScene(scene1);
        stage.show();

        center(scene1, btn1);
        center(scene2, btn2);
    }

    private void center(Scene scene, Button button){
        button.setTranslateX( scene.getWidth() / 2 - button.getWidth() / 2 );
        button.setTranslateY( scene.getHeight() / 2 - button.getHeight() / 2 );
    }


}