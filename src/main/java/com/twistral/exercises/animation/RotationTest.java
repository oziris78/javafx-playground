package com.twistral.exercises.animation;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class RotationTest extends Application {

    static boolean currentlyRunning = false;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        Group root = new Group();
        Scene scene = new Scene(root, 600, 600);

        Button btn = new Button("start animation");
        btn.translateXProperty().set(100d);
        btn.translateYProperty().set(100d);
        btn.setUserData(Button.class);

        Text text = new Text("text");
        text.setX(500d);
        text.setY(500d);
        text.setFont(Font.font(40d));
        text.setUserData(Text.class);

        root.getChildren().add(text);
        root.getChildren().add(btn);

        btn.setOnAction( (event) -> {
            RotateTransition rt = new RotateTransition();
            rt.setDuration(Duration.seconds(0.5d));
            rt.setNode(text);
            if(text.getRotate() == 0d){
                rt.setToAngle(180d);
            }
            else if(text.getRotate() == 180d){
                rt.setToAngle(0d);
            }

            if(!currentlyRunning){
                rt.play();
                currentlyRunning = !currentlyRunning;
                new Timer().schedule(new TimerTask() {
                    public void run() {
                        currentlyRunning = false;
                    }
                }, (long) rt.getDuration().toMillis() );
            }
        });

        stage.setScene(scene);
        stage.show();
    }



}