package com.twistral.exercises.layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class GridPaneTest extends Application {

    private static final boolean DEBUG = false;

    public void start(Stage stage) {
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(DEBUG);

        pane.add(new Label("Username: "), 0, 0);
        pane.add(new TextField(), 1, 0);
        pane.add(new Label("Email: "), 0, 1);
        pane.add(new TextField(), 1, 1);
        pane.add(new Label("Password: "), 0, 2);
        pane.add(new PasswordField(), 1, 2);

        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(100));

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}