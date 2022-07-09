package com.twistral.minesweeper;


import com.twistral.Main;
import com.twistral.calculator.CalculatorScene;
import com.twistral.toriafx.TScene;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MineSweeperApplication extends Application {

    private Stage stage;

    @Override
    public void init() {}

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        // main
        stage.setScene(getSceneMinesweeper());

        // stage setup
        stage.setTitle("Minesweeper");
        stage.getIcons().add(Main.res.getImage("appImage"));
        stage.show();
    }


    @Override
    public void stop() {
        System.exit(0);
        Platform.exit();
    }


    /*  GETTERS AND SETTERS  */
    public Stage getStage() { return stage; }

    public TScene getSceneMinesweeper() {
        return new MineSweeperScene(this, new VBox());
    }



}
