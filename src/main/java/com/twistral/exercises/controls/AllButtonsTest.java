package com.twistral.exercises.controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class AllButtonsTest extends Application {

    public void start(Stage stage) {
        FlowPane pane = new FlowPane();

        Hyperlink btn1 = new Hyperlink("www.twistral.com");
        Button btn2 = new Button("set unvisited");
        btn2.setOnAction(e -> { btn1.setVisited(false); });
        CheckBox btn3 = new CheckBox("checkbox indeterminate");
        btn3.setIndeterminate(true);
        CheckBox btn4 = new CheckBox("checkbox determinate checked");
        btn4.setIndeterminate(false);
        btn4.setSelected(true);
        CheckBox btn5 = new CheckBox("checkbox determinate unchecked");
        btn5.setIndeterminate(false);
        btn5.setSelected(false);


        ToggleButton btn6 = new ToggleButton("toggle button no group");
        ToggleButton btn7 = new ToggleButton("toggle button 2");
        ToggleButton btn8 = new ToggleButton("toggle button 3");
        ToggleGroup group = new ToggleGroup();
        btn7.setToggleGroup(group);
        btn8.setToggleGroup(group);


        RadioButton btn9 = new RadioButton("radiobutton no group");
        RadioButton btn10 = new RadioButton("radiobutton 2");
        RadioButton btn11 = new RadioButton("radiobutton 3");
        ToggleGroup group2 = new ToggleGroup();
        btn10.setToggleGroup(group2);
        btn11.setToggleGroup(group2);



        pane.setVgap(30);
        pane.setHgap(30);
        pane.setPadding(new Insets(50));
        pane.getChildren().addAll(
                btn1, btn2, btn3, btn4,
                btn5, btn6, btn7, btn8,
                btn9, btn10, btn11 
        );

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }

}