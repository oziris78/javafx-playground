package com.twistral.rtt;

import com.twistral.Main;
import com.twistral.toriafx.TScene;
import com.twistral.toriafx.ToriaFX;
import com.twistral.utils.consts.AppConsts;
import javafx.geometry.Pos;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;

import java.io.*;

class RTTGameOverScene extends TScene<RTTApplication, VBox> {


    private Text textScore, textTryAgain, textSaveAsTxt;

    private MediaPlayer mplayerButton;

    public RTTGameOverScene(RTTApplication app, VBox root) {
        super(app, root);

        root.setPrefSize(1280,720);
        ToriaFX.setResizableBackgroundImage(root, Main.res.getImage("rttStars"));



        textScore = new Text(RTTLocalization.sScore + " " + RTTGameScene.score.replaceAll(RTTLocalization.sTime + " ", ""));
        textScore.setFill(Color.LIGHTGRAY);
        textScore.setFont(Main.res.getAbhayaFont(45d));

        textTryAgain = new Text(RTTLocalization.sTryAgain);
        textTryAgain.setFill(AppConsts.clrYellow);
        textTryAgain.setFont(Main.res.getAbhayaFont(55d));

        textSaveAsTxt = new Text(RTTLocalization.sSaveAsTxt);
        textSaveAsTxt.setFill(AppConsts.clrYellow);
        textSaveAsTxt.setFont(Main.res.getAbhayaFont(55d));

        for(Text t : new Text[]{textSaveAsTxt, textTryAgain}){
            t.setOnMouseEntered(event -> {
                Glow glow = new Glow();
                glow.setInput(new Bloom());
                t.setEffect(glow);
            } );
            t.setOnMouseExited(event -> t.setEffect(null) );
        }

        StackPane.setMargin(textScore, ToriaFX.insetsAll(30));
        StackPane.setMargin(textTryAgain, ToriaFX.insetsAll(30));

        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(new StackPane(textScore), new StackPane(textTryAgain), new StackPane(textSaveAsTxt));


        // events
        initHandlers();

        // sounds
        mplayerButton = new MediaPlayer(Main.res.getMedia("button"));
        mplayerButton.setVolume( RTTApplication.IS_SOUND_ON ? 0.2d : 0.0d);
    }


    private void initHandlers() {
        textTryAgain.setOnMouseClicked(event -> {
            ToriaFX.playFromStart(mplayerButton);
            RTTGameScene.miliseconds = 0; RTTGameScene.seconds = 0; RTTGameScene.minutes = 0;
            app.getStage().setScene( app.getSceneRTTMain() );
            app.getStage().centerOnScreen();
        });
        textSaveAsTxt.setOnMouseClicked(event -> {
            ToriaFX.playFromStart(mplayerButton);
            DirectoryChooser dirChooser = new DirectoryChooser();
            dirChooser.setTitle("Choose the directory for your text file");
            File folder = dirChooser.showDialog(app.getStage());
            if(folder != null){
                try{
                    File file = new File(folder.getAbsolutePath() + "\\save" + String.valueOf((int) (Math.random() * 1000000)) + ".txt");
                    file.setWritable(true);

                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(textScore.getText());
                    writer.close();
                }
                catch (Exception e){ e.printStackTrace(); }
            }
            textSaveAsTxt.setDisable(true);
            textSaveAsTxt.setFill(Color.DARKRED.darker());
        });
    }


    public void updateScores() {
        textScore.setText(RTTLocalization.sScore + " " + RTTGameScene.score.replaceAll(RTTLocalization.sTime + " ", ""));
        textSaveAsTxt.setDisable(false);
        textSaveAsTxt.setFill(AppConsts.clrYellow);
    }


}
