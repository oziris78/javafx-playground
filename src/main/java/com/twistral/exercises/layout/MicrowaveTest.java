package com.twistral.exercises.layout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class MicrowaveTest extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 300);

        Button btn = new Button("OPEN ME");
        btn.setDisable(true);
        btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        root.setCenter(btn);

        BorderPane rightSide = new BorderPane();
        root.setRight(rightSide);

        TextField tf = new TextField("shows time cooking");
        tf.setAlignment(Pos.BASELINE_CENTER);
        rightSide.setTop(tf);


        GridPane gridPane = new GridPane();
        for (int i = 0; i < 12; i++) {
            String content = String.valueOf(i);
            if(i == 9) content = "START";
            if(i == 11) content = "STOP";
            Button myButton = new Button(content);
            myButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            myButton.resize(10d, 5d);
            gridPane.add(myButton, i % 3, (int) Math.floor( i / 3) );
        }

        RowConstraints row = new RowConstraints();
        row.setPercentHeight(25d);
        gridPane.getRowConstraints().addAll(row, row, row, row);
        ColumnConstraints col = new ColumnConstraints();
        col.setPercentWidth(33d);
        gridPane.getColumnConstraints().addAll(col, col, col);

        rightSide.setCenter(gridPane);

        stage.setTitle("Microwave lmao");
        stage.setScene(scene);
        stage.show();
    }



}