package com.twistral.rtt;

import com.twistral.Main;
import com.twistral.toriafx.TScene;
import com.twistral.toriafx.ToriaFX;
import com.twistral.utils.consts.AppConsts;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.util.Duration;


class RTTHelpScene extends TScene<RTTApplication, AnchorPane> {

    Text textInfo, textBack;
    private MediaPlayer mplayerButton;

    public RTTHelpScene(RTTApplication app, AnchorPane root) {
        super(app, root);

        // init layout
        root.setPrefSize(1280, 720);
        ToriaFX.setResizableBackgroundImage(root, Main.res.getImage("rttStars"));

        textInfo = new Text(RTTLocalization.sHelpText);
        textInfo.setFont(Main.res.getAbhayaFont(30d));
        textInfo.setFill(AppConsts.clrYellow);
        textInfo.wrappingWidthProperty().bind(this.widthProperty().multiply(0.75d));
        ToriaFX.setAnchorPaneConstraints(textInfo, 100d, 150d, null, 150d);

        textBack = new Text(RTTLocalization.sBack);
        textBack.setFont(Main.res.getAbhayaFont(45d));
        textBack.setFill(AppConsts.clrYellow);
        ToriaFX.setAnchorPaneConstraints(textBack, null, 100d, 80d, null);

        textBack.setOnMouseEntered(event -> {
            Glow glow = new Glow();
            glow.setInput(new Bloom());
            textBack.setEffect(glow);
        } );
        textBack.setOnMouseExited(event -> textBack.setEffect(null) );
        textBack.setOnMouseClicked(event -> {
            mplayerButton.seek(Duration.ZERO);
            mplayerButton.play();
            app.getStage().setScene(app.getSceneRTTMain());
            app.getStage().centerOnScreen();
        });


        root.getChildren().addAll(textInfo, textBack);

        // sounds
        mplayerButton = new MediaPlayer(Main.res.getMedia("button"));
        mplayerButton.setVolume( RTTApplication.IS_SOUND_ON ? 0.2d : 0.0d);
    }

}
