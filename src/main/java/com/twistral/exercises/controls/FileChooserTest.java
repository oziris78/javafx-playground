package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


public class FileChooserTest extends Application {

    public void start(Stage stage) {
        VBox pane = new VBox();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );

        TextArea taContent = new TextArea("");

        Button btnOpenFileChooser = new Button("click to choose a text file");
        btnOpenFileChooser.setOnAction(e -> {
            File selectedFile = fileChooser.showSaveDialog(stage);
            if(selectedFile == null) return;
            taContent.appendText(getContentOfFile(selectedFile));
        });





        pane.getChildren().addAll(
                btnOpenFileChooser, taContent
        );

        pane.setSpacing(10);
        pane.setPadding(new Insets(20));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private String getContentOfFile(File selectedFile) {
        try {
            List<String> lines = Files.readAllLines(selectedFile.toPath());
            StringBuilder sb = new StringBuilder();
            for(String s : lines) sb.append(s + "\n");
            sb.deleteCharAt(sb.length()-1);
            return sb.toString();
        }
        catch (IOException e) { e.printStackTrace(); return "test"; }
    }

    public static void main(String[] args) { launch(); }

}