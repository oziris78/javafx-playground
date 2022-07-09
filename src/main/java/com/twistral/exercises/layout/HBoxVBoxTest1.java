package com.twistral.exercises.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class HBoxVBoxTest1 extends Application {

    private static final boolean COLOR_AREAS = false;

    public void start(Stage stage) {
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox, 600, 600);
        stage.setScene(scene);

        HBox paneTop = new HBox();
        Button btnReflesh = new Button("Reflesh");
        Region region = new Region();
        Button btnSignOut = new Button("Sign Out");
        HBox.setHgrow(btnReflesh, Priority.SOMETIMES);
        HBox.setHgrow(region, Priority.ALWAYS);
        HBox.setHgrow(btnSignOut, Priority.SOMETIMES);
        paneTop.setPadding(new Insets(10));
        paneTop.getChildren().addAll(btnReflesh, region, btnSignOut);

        VBox paneMiddle = new VBox();
        TextArea taText = new TextArea();
        VBox.setVgrow(taText, Priority.ALWAYS);
        paneMiddle.setPadding(new Insets(10));
        paneMiddle.getChildren().add(taText);

        HBox paneBottom = new HBox();
        Region region2 = new Region();
        Button btnClose = new Button("Close");
        HBox.setHgrow(region2, Priority.ALWAYS);
        HBox.setHgrow(btnClose, Priority.NEVER);
        paneBottom.setPadding(new Insets(10));
        paneBottom.getChildren().addAll(region2, btnClose);


        vbox.getChildren().addAll(
                paneTop,
                paneMiddle,
                new Separator(),
                paneBottom
        );
        VBox.setVgrow(paneTop, Priority.NEVER);
        VBox.setVgrow(paneMiddle, Priority.ALWAYS);
        VBox.setVgrow(paneBottom, Priority.NEVER);

        if(COLOR_AREAS){
            paneTop.setBackground(new Background(new BackgroundFill(Color.DARKSLATEGRAY, null, null)));
            paneMiddle.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, null, null)));
            paneBottom.setBackground(new Background(new BackgroundFill(Color.DARKSALMON, null, null)));
        }

        stage.show();
    }

    public static void main(String[] args) { launch(); }

}