package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class TitledPaneTest extends Application {

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();

        Button btn = new Button("B1");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("bruh moment");
            }
        });
        TitledPane t1 = new TitledPane("t1", btn);
        TitledPane t2 = new TitledPane("t2", t1);
        TitledPane t3 = new TitledPane("t3", t2);
        TitledPane t4 = new TitledPane("t4", t3);
        TitledPane t5 = new TitledPane("t5", t4);
        TitledPane t6 = new TitledPane("t6", t5);
        t1.setExpanded(false);
        t2.setExpanded(false);
        t3.setExpanded(false);
        t4.setExpanded(false);
        t5.setExpanded(false);
        t6.setExpanded(false);


        pane.setHgap(25);
        pane.setVgap(25);
        pane.getChildren().addAll(t6);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setHeight(400d);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}