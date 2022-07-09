package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class WebViewYoutubeTest extends Application {

    public void start(Stage stage) {
        VBox pane = new VBox();

        WebView webView = new WebView();
        webView.getEngine().load("https://www.youtube.com/embed/eI4an8aSsgw");

        pane.getChildren().addAll(webView);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) { launch(); }

}