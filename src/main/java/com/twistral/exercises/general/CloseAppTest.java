package com.twistral.exercises.general;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class CloseAppTest extends Application {

    public static void main(String[] args) {
        launch();
    }



    @Override
    public void start(Stage stage) {

        Group root = new Group();
        Scene scene = new Scene(root, 600, 600);

        Button button = new Button("button");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                closeTheApp();
            }
        });
        root.getChildren().add(button);

        stage.setOnCloseRequest( event -> {
            System.out.println("closing with saving stuff");
            closeTheApp();
        });
        stage.setScene(scene);
        stage.show();

        button.setTranslateX( scene.getWidth() / 2 - button.getWidth() / 2);
        button.setTranslateY( scene.getHeight() / 2 - button.getHeight() / 2);


    }

    private void closeTheApp(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about the close the app");
        alert.setContentText("Do you want to exit the program?");
        if(alert.showAndWait().get() == ButtonType.OK) Platform.exit();
    }


}