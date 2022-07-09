package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ListViewTest extends Application {

    public void start(Stage stage) {
        VBox pane = new VBox();

        Label label = new Label("Choose a programming language");

        ListView<String> list = new ListView<>();
        list.getItems().addAll("Java", "C/C++", "Python", "Javascript", "Kotlin",
                "Typescript", "Ruby", "SASS", "R", "Go", "C# (Microsoft Java)");
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        list.setEditable(true);
        list.setCellFactory(TextFieldListCell.forListView());
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String currentItem = list.getSelectionModel().getSelectedItem();
                if(currentItem.contentEquals("Python")) label.setText("Go learn a real programming language retard");
                else label.setText(currentItem);
            }
        });

        Button btn = new Button("get text");
        btn.setOnAction(e -> { for(String s : list.getItems()) System.out.println(s); });



        pane.getChildren().addAll(label, list, btn);
        pane.getChildren().addAll();

        for(Node node : pane.getChildren())
            VBox.setMargin(node, new Insets(5));

        pane.setPadding(new Insets(15));
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}