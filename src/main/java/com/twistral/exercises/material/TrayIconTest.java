package com.twistral.exercises.material;

import com.dustinredmond.fxtrayicon.FXTrayIcon;
import com.twistral.Main;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.net.URL;


public class TrayIconTest extends Application {

    @Override
    public void start(Stage stage) throws MalformedURLException {

        BorderPane root = new BorderPane();
        stage.setScene(new Scene(root));

        stage.setTitle("FXTrayIcon test!");

        FXTrayIcon trayIcon = new FXTrayIcon(stage, Main.class.getResource("images/twistralTrans600.png"));
        trayIcon.show();

        trayIcon.setTrayIconTooltip("An alternative tooltip!");
        MenuItem menuItemTest = new MenuItem("Create some JavaFX component!");
        menuItemTest.setOnAction(e ->
                new Alert(Alert.AlertType.INFORMATION, "We just ran some JavaFX code from an AWT MenuItem!").showAndWait());
        trayIcon.addMenuItem(menuItemTest);

        // We can also nest menus, below is an Options menu with sub-items
        Menu menuOptions = new Menu("Options");
        MenuItem miOn = new MenuItem("On");
        miOn.setOnAction(e -> System.out.println("Options -> On clicked"));
        MenuItem miOff = new MenuItem("Off");
        miOff.setOnAction(e -> System.out.println("Options -> Off clicked"));
        menuOptions.getItems().addAll(miOn, miOff);
        trayIcon.addMenuItem(menuOptions);

        VBox vBox = new VBox(5);
        vBox.getChildren().add(new Label("You should see a tray icon!\nTry closing this window " +
                "and double-clicking the icon.\n" +
                "Try single-clicking it."));
        Button buttonRemoveTrayIcon = new Button("Remove TrayIcon");
        vBox.getChildren().add(buttonRemoveTrayIcon);

        buttonRemoveTrayIcon.setOnAction(e -> trayIcon.hide());

        Button buttonDefaultMsg = new Button("Show a \"Default\" message");
        buttonDefaultMsg.setOnAction(e -> trayIcon.showMessage("A caption text", "Some content text."));

        Button buttonInfoMsg = new Button("Show an \"Info\" message");
        buttonInfoMsg.setOnAction(e -> trayIcon.showInfoMessage("A caption text", "Some content text"));

        Button buttonWarnMsg = new Button("Show a \"Warn\" message");
        buttonWarnMsg.setOnAction(e -> trayIcon.showWarningMessage("A caption text", "Some content text"));

        Button buttonErrorMsg = new Button("Show an \"Error\" message");
        buttonErrorMsg.setOnAction(e -> trayIcon.showErrorMessage("A caption text", "Some content text"));

        HBox hBox = new HBox(5, buttonDefaultMsg, buttonInfoMsg, buttonWarnMsg, buttonErrorMsg);
        vBox.getChildren().add(hBox);

        root.setCenter(vBox);
        stage.sizeToScene();
        stage.show();
    }


}