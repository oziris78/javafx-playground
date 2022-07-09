package com.twistral.apps.calculator;


import com.twistral.Main;
import com.twistral.toriafx.TScene;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CalculatorApplication extends Application {

    private Stage stage;

    @Override
    public void init() {}

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        // main
        stage.setScene(getSceneCalculator());

        // stage setup
        stage.setTitle("Calculator");
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

    public TScene getSceneCalculator() {
        return new CalculatorScene(this, new VBox());
    }



}
