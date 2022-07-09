package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class PaginationTest extends Application {

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();

        String[] pages = new String[]{
                "this is page 1",
                "this is page 2",
                "this is page 3",
                "this is page 4",
                "fuck you bruh",
                "this is page 6"
        };
        Pagination pagination = new Pagination(100, 0);
        pagination.setPageFactory(pageIndex -> {
            Label lb = null;
            if(pageIndex >= pages.length) lb = new Label("this page doesnt exist");
            else lb = new Label(pages[pageIndex]);
            return lb;
        });
        Pagination pagination2 = new Pagination(100, 0);
        pagination2.setPageFactory(pageIndex -> {
            Button lb = null;
            if(pageIndex >= pages.length) lb = new Button("this page doesnt exist");
            else lb = new Button(pages[pageIndex]);
            return lb;
        });

        pane.getChildren().addAll(pagination, pagination2);

        pane.setVgap(20); pane.setHgap(20);
        pane.setPadding(new Insets(15));
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}