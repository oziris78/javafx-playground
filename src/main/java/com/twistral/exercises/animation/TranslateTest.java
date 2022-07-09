package com.twistral.exercises.animation;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TranslateTest extends Application {

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
            TranslateTransition tt = new TranslateTransition();
            tt.setDuration(Duration.seconds(3d));
            tt.setNode(text);
            tt.setAutoReverse(true);
            if(text.getTranslateX() == 0d && text.getTranslateY() == 0d){
                tt.setByX(-300d);
                tt.setByY(-300d);
            }
            else if(text.getTranslateX() == -300d && text.getTranslateY() == -300d){
                tt.setByX(+300d);
                tt.setByY(+300d);
            }
            tt.play();
        });

        stage.setScene(scene);
        stage.show();
    }



}