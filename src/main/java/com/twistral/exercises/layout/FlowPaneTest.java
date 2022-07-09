package com.twistral.exercises.layout;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class FlowPaneTest extends Application {

    public void start(Stage stage) {

        FlowPane flow = new FlowPane(Orientation.VERTICAL);
        flow.setAlignment(Pos.CENTER);
        flow.setVgap(10);
        for (int i = 0; i < 20; i++) {
            flow.getChildren().add(new Label(String.valueOf(i)));
        }

        flow.setColumnHalignment(HPos.RIGHT); // align labels on right

        Scene scene = new Scene(flow, 600, 600);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) { launch(); }

}