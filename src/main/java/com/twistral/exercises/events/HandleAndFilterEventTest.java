package com.twistral.exercises.events;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class HandleAndFilterEventTest extends Application {

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();


        Button btn1 = new Button("both");
        btn1.addEventFilter(ActionEvent.ACTION, e -> { System.out.println("filter happened"); });
        btn1.addEventHandler(ActionEvent.ACTION, e -> { System.out.println("handler happened"); });

        Button btn2 = new Button("only filter");
        btn2.addEventFilter(ActionEvent.ACTION, e -> { System.out.println("only filter happened"); e.consume(); });
        btn2.addEventHandler(ActionEvent.ACTION, e -> { System.out.println("you wont see this text"); });

        Button btn3 = new Button("nothing");
        EventHandler<ActionEvent> eventEventHandler = e -> { System.out.println("handler happened"); };
        btn3.addEventHandler(ActionEvent.ACTION, eventEventHandler);
        btn3.removeEventHandler(ActionEvent.ACTION,eventEventHandler );


        pane.getChildren().addAll(
                btn1, btn2, btn3
        );

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}