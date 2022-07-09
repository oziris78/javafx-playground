package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;


public class HTMLEditorTest extends Application {

    private static final boolean DEBUG = false;

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();

        pane.setPadding(new Insets(15));
        pane.setHgap(30d);

        Button btn = new Button("click to get html");
        HTMLEditor html = new HTMLEditor();

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(html.getHtmlText());
            }
        });


        pane.getChildren().addAll(btn, html);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}