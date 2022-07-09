package com.twistral.cookieclicker;


import com.twistral.Main;
import com.twistral.minesweeper.MineSweeperScene;
import com.twistral.toriafx.TScene;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CookieClickerApplication extends Application {

    private Stage stage;

    @Override
    public void init() {}

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        // main
        stage.setScene(getSceneCookieClicker());

        // stage setup
        stage.setTitle("Cookie Clicker");
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

    public TScene getSceneCookieClicker() {
        return new CookieClickerScene(this, new AnchorPane());
    }



}
