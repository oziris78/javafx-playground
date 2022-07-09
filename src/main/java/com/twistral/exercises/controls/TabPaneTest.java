package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class TabPaneTest extends Application {

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();

        TabPane tabPane = new TabPane();
        tabPane.setMaxWidth(300); // bu olmazsa sonsuza dek gider ve ok ile secmeyi koymaz

        for (int i = 1; i < 30; i++) {
            FlowPane flowPane = new FlowPane(
                    new Button(String.valueOf(i)),
                    new Button(String.valueOf(i)),
                    new Button(String.valueOf(i)),
                    new Button(String.valueOf(i))
            );
            flowPane.setBackground(new Background(new BackgroundFill(Color.TURQUOISE, null, null)));
            flowPane.setHgap(15); flowPane.setVgap(15);
            flowPane.setPadding(new Insets(15));
            Tab tab = new Tab("Tab" + i, flowPane);
            if(i > 5) tab.setClosable(false);
            tabPane.getTabs().add(tab);
        }

        pane.getChildren().addAll(tabPane);





        pane.setHgap(15); pane.setVgap(15);
        pane.setPadding(new Insets(15));
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}