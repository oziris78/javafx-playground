package com.twistral.rtt;

import com.twistral.Main;
import com.twistral.toriafx.*;
import com.twistral.utils.consts.AppConsts;
import javafx.scene.effect.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;


class RTTMainScene extends TScene<RTTApplication, VBox> {


    private Text textRTT, textStart, textSetting, textHelp;
    private MediaPlayer mplayerButton;

    public RTTMainScene(RTTApplication app, VBox root) {
        super(app, root);

        // init layout
        root.setPrefSize(1280, 720);
        ToriaFX.setResizableBackgroundImage(root, Main.res.getImage("rttStars"));

        initTexts();
        initEventHandlers();


        // sounds
        mplayerButton = new MediaPlayer(Main.res.getMedia("button"));
        mplayerButton.setVolume( RTTApplication.IS_SOUND_ON ? 0.2d : 0.0d);
    }


    private void initTexts() {
        textRTT = new Text(RTTLocalization.sRTT);
        textRTT.setFont(Main.res.getAbhayaFont(80d));
        textRTT.setFill(Color.LIGHTGRAY);
        StackPane.setMargin(textRTT, ToriaFX.insetsOnlyTop(70));

        textStart = new Text(RTTLocalization.sStart);
        StackPane.setMargin(textStart,  ToriaFX.insetsOnlyTop(110));

        textSetting = new Text(RTTLocalization.sSettings);
        StackPane.setMargin(textSetting,  ToriaFX.insetsOnlyTop(45));

        textHelp = new Text(RTTLocalization.sHelp);
        StackPane.setMargin(textHelp,  ToriaFX.insetsOnlyTop(45));

        for(Text t : new Text[]{textStart,textSetting,textHelp}){
            t.setFont(Main.res.getAbhayaFont(45d));
            t.setFill(AppConsts.clrYellow);
        }

        root.getChildren().addAll(new StackPane(textRTT), new StackPane(textStart), new StackPane(textSetting),
                new StackPane(textHelp));
    }


    private void initEventHandlers() {
        for(Text t : new Text[]{textStart, textSetting, textHelp}){
            t.setOnMouseEntered(event -> {
                Glow glow = new Glow();
                glow.setInput(new Bloom());
                t.setEffect(glow);
            } );
            t.setOnMouseExited(event -> t.setEffect(null) );
        }

        textStart.setOnMouseClicked(event -> {
            playButtonSound();
            RTTGameScene gameScene = (RTTGameScene) app.getSceneRTTGame();
            gameScene.startTimer();
            app.getStage().setScene(gameScene);
            app.getStage().centerOnScreen();
        });

        textSetting.setOnMouseClicked(event -> {
            playButtonSound();
            app.getStage().setScene( app.getSceneRTTSettings() );
            app.getStage().centerOnScreen();
        });

        textHelp.setOnMouseClicked(event -> {
            playButtonSound();
            app.getStage().setScene( app.getSceneRTTHelp() );
            app.getStage().centerOnScreen();

        });
    }

    private void playButtonSound(){
        mplayerButton.seek(Duration.ZERO);
        mplayerButton.play();
    }


}

