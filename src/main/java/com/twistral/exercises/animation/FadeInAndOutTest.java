package com.twistral.exercises.animation;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadeInAndOutTest extends Application {

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
            FadeTransition ft = new FadeTransition();
            ft.setDuration(Duration.seconds(0.5d));
            ft.setNode(text);
            if(text.getOpacity() == 1d){
                ft.setToValue(0d);
            }
            else if(text.getOpacity() == 0d){
                ft.setToValue(1d);
            }
            ft.play();
        });

        stage.setScene(scene);
        stage.show();
    }



}