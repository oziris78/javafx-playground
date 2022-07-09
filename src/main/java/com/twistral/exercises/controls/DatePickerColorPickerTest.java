package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DatePickerColorPickerTest extends Application {

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();

        Label lb = new Label("date will show here");
        lb.setFont(Font.font("arial", 30d));
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        datePicker.setOnAction(event -> {
            lb.setText( datePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) );
        });

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setOnAction(event -> {
            pane.setBackground(new Background(new BackgroundFill(colorPicker.getValue(),null,null)));
        });


        pane.getChildren().addAll(lb, datePicker, colorPicker);
        pane.getChildren().addAll();

        pane.setVgap(20); pane.setHgap(20);
        pane.setPadding(new Insets(15));
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}