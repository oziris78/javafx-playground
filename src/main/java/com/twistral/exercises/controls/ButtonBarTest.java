package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonBarTest extends Application {

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();

        Button btnYes = new Button("Yes");
        Button btnNo = new Button("No");

        ButtonBar btnBar = new ButtonBar();
        btnBar.getButtons().addAll(btnYes, btnNo);
        ButtonBar.setButtonData(btnYes, ButtonBar.ButtonData.YES);
        ButtonBar.setButtonData(btnNo, ButtonBar.ButtonData.NO);
        btnBar.setButtonOrder("NY"); // siralarini belirtir

        System.out.println(ButtonBar.ButtonData.APPLY.getTypeCode());
        System.out.println(ButtonBar.ButtonData.BACK_PREVIOUS.getTypeCode());
        System.out.println(ButtonBar.ButtonData.BIG_GAP.getTypeCode());
        System.out.println(ButtonBar.ButtonData.CANCEL_CLOSE.getTypeCode());
        System.out.println(ButtonBar.ButtonData.FINISH.getTypeCode());
        System.out.println(ButtonBar.ButtonData.HELP.getTypeCode());
        System.out.println(ButtonBar.ButtonData.HELP_2.getTypeCode());
        System.out.println(ButtonBar.ButtonData.LEFT.getTypeCode());
        System.out.println(ButtonBar.ButtonData.NEXT_FORWARD.getTypeCode());
        System.out.println(ButtonBar.ButtonData.NO.getTypeCode());
        System.out.println(ButtonBar.ButtonData.OK_DONE.getTypeCode());
        System.out.println(ButtonBar.ButtonData.OTHER.getTypeCode());
        System.out.println(ButtonBar.ButtonData.RIGHT.getTypeCode());
        System.out.println(ButtonBar.ButtonData.SMALL_GAP.getTypeCode());
        System.out.println(ButtonBar.ButtonData.YES.getTypeCode());

        pane.getChildren().addAll(btnBar);

        pane.setVgap(20);
        pane.setHgap(20);
        pane.setPadding(new Insets(15));
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}