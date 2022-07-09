package com.twistral.exercises.controls;

import com.twistral.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;


public class VideoPlayerTest extends Application {


    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.show();

        MediaPlayer mediaPlayer = new MediaPlayer(Main.res.getMedia("nolonger"));
        MediaView mediaView = new MediaView(mediaPlayer);

        Button btnStart = new Button("Start");
        Button btnStop = new Button("Stop");
        Button btnReset = new Button("Reset");
        btnStart.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {
            mediaPlayer.play();
        }});
        btnStop.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {
            mediaPlayer.pause();
        }});
        btnReset.setOnAction(new EventHandler<ActionEvent>() { @Override public void handle(ActionEvent event) {
            if(mediaPlayer.getStatus() != MediaPlayer.Status.READY) // ilk basta reset e basilip start a basilirsa hata olmasini engeller
                mediaPlayer.seek(Duration.seconds(0.0d));
        }});

        root.getChildren().addAll(btnStart, btnStop, btnReset);
        btnStart.relocate(350d, 550d);
        btnStop.relocate(400d, 550d);
        btnReset.relocate(450d, 550d);

        root.getChildren().add(mediaView);
    }

    public static void main(String[] args) { launch(); }

}