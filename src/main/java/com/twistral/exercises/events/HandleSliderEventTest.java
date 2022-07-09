package com.twistral.exercises.events;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class HandleSliderEventTest extends Application {

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();

        Button btn = new Button("test");
        btn.setOnAction(e -> {
            System.out.println(e.getEventType());
            btn.setDisable(true);
        });

        TextField tf = new TextField();
        tf.setOnAction(e -> {
            System.out.println(e.getEventType());
            System.out.println(tf.getText());
            tf.setDisable(true);
        });

        Slider slider = new Slider(-100, 100, 0);
        Label lb = new Label(String.valueOf((double) slider.getValue()));
        slider.setOrientation(Orientation.VERTICAL);
        slider.setMajorTickUnit(20);
        slider.setMinorTickCount(1);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lb.setText(String.format("%.5f", slider.getValue()));
            }
        });

        // bu da olur
//        slider.valueProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                lb.setText(String.format("%.5f", newValue.doubleValue()));
//            }
//        });

        pane.setPadding(new Insets(50));
        pane.setHgap(25);
        pane.setVgap(25);

        pane.getChildren().addAll(
                btn, tf, slider, lb
        );

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}