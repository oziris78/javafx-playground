package com.twistral.exercises.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;


public class TextFlowTest extends Application {


    public void start(Stage stage) {
        TextFlow textFlow = new TextFlow();

        Text text1 = new Text("Big italic red text\n");
        text1.setFill(Color.RED);
        text1.setFont(Font.font("Helvetica", FontPosture.ITALIC, 40));

        Text text2 = new Text(" little bold blue text"); // \n konulmadigindan satir atlamiyor
        text2.setFill(Color.BLUE);
        text2.setFont(Font.font("Helvetica", FontWeight.BOLD, 10));

        Text text3 = new Text("EXTRA THICC TEXT DAMN BRUH\n");
        text3.setFill(Color.DARKGRAY);
        text3.setFont(Font.font("Helvetica", FontWeight.EXTRA_BOLD, 60));

        textFlow.getChildren().addAll(text1, text2, text3);

        Scene scene = new Scene(textFlow);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}