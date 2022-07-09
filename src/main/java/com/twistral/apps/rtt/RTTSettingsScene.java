package com.twistral.apps.rtt;

import com.twistral.Main;
import com.twistral.toriafx.TScene;
import com.twistral.toriafx.ToriaFX;
import com.twistral.utils.consts.AppConsts;
import javafx.geometry.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.scene.text.*;
import javafx.util.*;



class RTTSettingsScene extends TScene<RTTApplication, VBox> {

    private Text textLanguage, textBack;
    private ImageView iviewTR, iviewEN, iviewGER;

    private MediaPlayer mplayerButton;

    public RTTSettingsScene(RTTApplication app, VBox root) {
        super(app, root);

        root.setPrefSize(1280, 720);
        ToriaFX.setResizableBackgroundImage(root, Main.res.getImage("rttStars"));

        iviewTR = new ImageView(Main.res.getImage("rttTrFlag"));
        iviewEN = new ImageView(Main.res.getImage("rttUkFlag"));
        iviewGER = new ImageView(Main.res.getImage("rttGerFlag"));

        for(ImageView iview : new ImageView[]{iviewTR, iviewEN, iviewGER}){
            iview.setFitWidth(75);
            iview.setPreserveRatio(true);
        }

        textLanguage = new Text(RTTLocalization.sLanguage);
        textLanguage.setFont(Main.res.getAbhayaFont(50));
        textLanguage.setFill(AppConsts.clrYellow);
        HBox.setMargin(textLanguage, new Insets(100,0,20,0));

        textBack = new Text(RTTLocalization.sBack);
        textBack.setFont(Main.res.getAbhayaFont(40));
        textBack.setFill(AppConsts.clrYellow);
        HBox.setMargin(textBack, new Insets(100,0,0,0));

        textBack.setOnMouseEntered(event -> {
            Glow glow = new Glow();
            glow.setInput(new Bloom());
            textBack.setEffect(glow);
        } );
        textBack.setOnMouseExited(event -> textBack.setEffect(null) );
        textBack.setOnMouseClicked(event -> {
            playButtonSound();
            app.getStage().setScene( app.getSceneRTTMain() );
            app.getStage().centerOnScreen();
        });

        Region reg1 = new Region(); Region reg2 = new Region(); Region reg3 = new Region(); Region reg4 = new Region();
        HBox.setHgrow(reg1,Priority.ALWAYS); HBox.setHgrow(reg2,Priority.ALWAYS);
        HBox.setHgrow(reg3,Priority.ALWAYS); HBox.setHgrow(reg4,Priority.ALWAYS);

        HBox paneTop = new HBox(textLanguage);
        paneTop.setSpacing(50);
        paneTop.setPrefHeight(100);
        paneTop.setAlignment(Pos.CENTER);

        HBox paneMid = new HBox(reg1, iviewEN, iviewTR, iviewGER, reg2);
        paneMid.setAlignment(Pos.CENTER);
        paneMid.setPrefHeight(100);
        paneMid.setSpacing(50);

        root.getChildren().addAll( paneTop, paneMid, new HBox(reg3, textBack, reg4));

        initHandlers();

        // sounds
        mplayerButton = new MediaPlayer(Main.res.getMedia("button"));
        mplayerButton.setVolume( RTTApplication.IS_SOUND_ON ? 0.2d : 0.0d);
    }




    private void initHandlers() {
        iviewTR.setOnMouseClicked(event -> {
            playButtonSound();
            RTTLocalization.changeLanguageToTurkish();
            updateTextsWithNewLanguage();
        });

        iviewEN.setOnMouseClicked(event -> {
            playButtonSound();
            RTTLocalization.changeLanguageToEnglish();
            updateTextsWithNewLanguage();
        });

        iviewGER.setOnMouseClicked(event -> {
            playButtonSound();
            RTTLocalization.changeLanguageToGerman();
            updateTextsWithNewLanguage();
        });
    }


    private void updateTextsWithNewLanguage(){
        textLanguage.setText(RTTLocalization.sLanguage);
        textBack.setText(RTTLocalization.sBack);
    }

    private void playButtonSound() {
        mplayerButton.seek(Duration.ZERO);
        mplayerButton.play();
    }


}
