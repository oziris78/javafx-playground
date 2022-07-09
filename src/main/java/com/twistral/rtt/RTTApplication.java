package com.twistral.rtt;


import com.twistral.Main;
import com.twistral.toriafx.TScene;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class RTTApplication extends Application {

    private Stage stage;
    private TScene sceneRTTGameOver;

    public static boolean IS_SOUND_ON = true;

    @Override
    public void init() {}

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        // main
        stage.setScene(getSceneRTTMain());

        // stage setup
        stage.setTitle("Reaction Time Tester");
        stage.getIcons().add(Main.res.getImage("appImage"));
        stage.show();
    }


    @Override
    public void stop() {
        System.exit(0);
        Platform.exit();
    }


    /*  SCENE RESETTERS  */
    public void resetRTTGameOver(){
        RTTGameOverScene scene = (RTTGameOverScene) sceneRTTGameOver;
        if(scene != null)
            scene.updateScores();
    }


    /*  GETTERS AND SETTERS  */
    public Stage getStage() { return stage; }

    public TScene getSceneRTTMain() {
        return new RTTMainScene(this, new VBox());
    }

    public TScene getSceneRTTGame() {
        return  new RTTGameScene(this, new BorderPane());
    }

    public TScene getSceneRTTGameOver() {
        return sceneRTTGameOver = new RTTGameOverScene(this, new VBox());
    }

    public TScene getSceneRTTSettings() {
        return new RTTSettingsScene(this, new VBox());
    }

    public TScene getSceneRTTHelp() {
        return new RTTHelpScene(this, new AnchorPane());
    }



}
