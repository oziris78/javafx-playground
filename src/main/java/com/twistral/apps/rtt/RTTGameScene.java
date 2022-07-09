package com.twistral.apps.rtt;

import com.twistral.Main;
import com.twistral.toriafx.TScene;
import com.twistral.toriafx.ToriaFX;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;


class RTTGameScene extends TScene<RTTApplication, BorderPane> {

    private Text textTimer;
    private HBox paneCenter;
    private ImageView iviewTarget;
    private MediaPlayer mplayerButton, mplayerCountdown;

    private int clickAmount = 0;

    private Timer timer;
    public static int minutes = 0, seconds = 0, miliseconds = 0;
    public static String score = "";

    private final int CLICK_LIMIT = 5;
    private final long INITIAL_DELAY = 5000;

    public RTTGameScene(RTTApplication app, BorderPane root) {
        super(app, root, Color.BLACK);

        root.setPrefSize(1280,720);
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        // top
        textTimer = new Text(RTTLocalization.sTimeCounter);
        textTimer.setFont(Main.res.getAbhayaFont(60d));
        textTimer.setFill(Color.LIGHTGRAY);
        StackPane.setMargin(textTimer, ToriaFX.insetsOnlyVertical(10));

        root.setTop(new StackPane(textTimer));

        // center
        iviewTarget = new ImageView(Main.res.getImage("rttTarget"));
        iviewTarget.setPreserveRatio(true);
        iviewTarget.setFitWidth(48d);
        iviewTarget.setFitHeight(48d);
        iviewTarget.setManaged(false);
        iviewTarget.setVisible(false);

        paneCenter = new HBox(iviewTarget);
        paneCenter.setPadding(ToriaFX.insetsAll(50));

        relocateImage();
        root.setCenter(paneCenter);

        // events
        initHandlers();

        // sounds
        mplayerButton = new MediaPlayer(Main.res.getMedia("button"));
        mplayerButton.setVolume( RTTApplication.IS_SOUND_ON ? 0.2d : 0.0d);
    }

    private void initHandlers() {
        timer = new Timer();

        iviewTarget.setOnMouseClicked(event -> {
            clickAmount++;

            if(clickAmount <= CLICK_LIMIT - 1){
                relocateImage();
            }
            else{
                timer.cancel();
                clickAmount = 0;
                app.resetRTTGameOver();
                app.getStage().setScene(app.getSceneRTTGameOver());
                app.getStage().centerOnScreen();
            }

            ToriaFX.playFromStart(mplayerButton);
        });

    }


    public void startTimer(){
        mplayerCountdown = new MediaPlayer(Main.res.getMedia("rttCountDown"));
        ToriaFX.playFromStart(mplayerCountdown);
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                iviewTarget.setVisible(true);

                miliseconds++;

                if(miliseconds >= 1000) {
                    miliseconds -= 1000;
                    seconds++;
                }
                if(seconds >= 60) {
                    seconds -= 60;
                    minutes++;
                }

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        String minStr = (minutes < 10) ? "0" + minutes : String.valueOf(minutes);
                        String secStr = (seconds < 10) ? "0" + seconds : String.valueOf(seconds);
                        String milisecStr = String.valueOf(miliseconds);
                        if(milisecStr.length() == 1) milisecStr = "00" + milisecStr;
                        if(milisecStr.length() == 2) milisecStr = "0" + milisecStr;
                        if(milisecStr.length() == 3) milisecStr = "" + milisecStr;
                        score = RTTLocalization.sTime + " " + minStr + ":" + secStr + ":" + milisecStr;
                        textTimer.setText(score);
                    }
                });
            }
        }, INITIAL_DELAY, 1);

    }

    private void relocateImage() {
        double imageWidth = iviewTarget.getFitWidth();
        double imageHeight = iviewTarget.getFitHeight();
        double paneWidth = paneCenter.getWidth() >= 1000 ? paneCenter.getWidth() : 1000;
        double paneHeight = paneCenter.getHeight() >= 500 ? paneCenter.getHeight() : 500;
        double randomWidth = Math.random() * (paneWidth-imageWidth);
        double randomHeight = Math.random() * (paneHeight-imageHeight);
        iviewTarget.relocate(randomWidth, randomHeight);
    }


}
