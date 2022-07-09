package com.twistral.apps.quizapp;


import com.twistral.Main;
import com.twistral.toriafx.TScene;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class QuizAppApplication extends Application {

    private Stage stage;

    @Override
    public void init() {}

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        // main
        stage.setScene(getSceneQuizAppScene());

        // stage setup
        stage.setTitle("Quiz App");
        stage.getIcons().add(Main.res.getImage("twistral"));
        stage.show();
    }


    @Override
    public void stop() {
        System.exit(0);
        Platform.exit();
    }


    /*  GETTERS AND SETTERS  */
    public Stage getStage() { return stage; }

    public TScene getSceneQuizAppScene() {
        return new QuizAppScene(this, new GridPane());
    }



}
