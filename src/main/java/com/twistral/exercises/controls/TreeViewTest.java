package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class TreeViewTest extends Application {

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();

        Label label = new Label("No current selection");
        Button button = new Button("Click to change selection model");
        TreeView<String> treeView = new TreeView<>();

        TreeItem<String> root = new TreeItem<>("Root");

        TreeItem<String> branch1 = new TreeItem<>("branch1");
        TreeItem<String> leaf11 = new TreeItem<>("leaf11");
        TreeItem<String> leaf12 = new TreeItem<>("leaf12");
        TreeItem<String> leaf13 = new TreeItem<>("leaf13");
        branch1.getChildren().addAll(leaf11, leaf12, leaf13);

        TreeItem<String> branch2 = new TreeItem<>("branch2");
        TreeItem<String> leaf21 = new TreeItem<>("leaf21");
        TreeItem<String> leaf22 = new TreeItem<>("leaf22");
        TreeItem<String> leaf23 = new TreeItem<>("leaf23");
        branch2.getChildren().addAll(leaf21, leaf22, leaf23);

        TreeItem<String> branch3 = new TreeItem<>("branch3");
        TreeItem<String> leaf31 = new TreeItem<>("leaf31");
        TreeItem<String> leaf32 = new TreeItem<>("leaf32");
        TreeItem<String> leaf33 = new TreeItem<>("leaf33");
        branch3.getChildren().addAll(leaf31, leaf32, leaf33);


        root.getChildren().addAll(branch1, branch2, branch3);
        treeView.setRoot(root);

        EventHandler eventHandler = event -> {
            if(treeView.getSelectionModel().getSelectionMode().equals(SelectionMode.SINGLE)){
                TreeItem<String> selectedItem = treeView.getSelectionModel().getSelectedItem();
                if(selectedItem == null) return;
                label.setText("Selected item is " + selectedItem.getValue());
            }
            else{
                ObservableList<TreeItem<String>> selectedItems = treeView.getSelectionModel().getSelectedItems();
                if(selectedItems.size() == 0) return;
                StringBuilder sb = new StringBuilder("Selected items are ");
                for(TreeItem<String> selectedItem : selectedItems)
                    sb.append(selectedItem.getValue() + ",");
                label.setText(sb.toString().substring(0, sb.length()-1));
            }
        };

        button.setOnAction(e -> {
            if(treeView.getSelectionModel().getSelectionMode().equals(SelectionMode.SINGLE)){
                treeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                button.setText("MULTIPLE is active");
            }
            else{
                treeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                button.setText("SINGLE is active");
            }
        });

        treeView.setOnMouseClicked(eventHandler);
        treeView.setOnContextMenuRequested(eventHandler);

//        treeView.setShowRoot(false);

        pane.getChildren().addAll(label, treeView, button);

        pane.setHgap(15); pane.setVgap(15);
        pane.setPadding(new Insets(15));
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}