package com.twistral.exercises.material;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import io.github.palexdev.materialfx.controls.MFXToggleButton;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.net.URISyntaxException;


public class MaterialFXTest extends Application {

    public void start(Stage stage) throws URISyntaxException {
        FlowPane pane = new FlowPane();

        Hyperlink btn1 = new Hyperlink("www.twistral.com");
        Button btn2 = new MFXButton("set unvisited");
        btn2.setOnAction(e -> { btn1.setVisited(false); });
        CheckBox btn3 = new MFXCheckbox("checkbox indeterminate");
        btn3.setIndeterminate(true);
        CheckBox btn4 = new MFXCheckbox("checkbox determinate checked");
        btn4.setIndeterminate(false);
        btn4.setSelected(true);
        CheckBox btn5 = new MFXCheckbox("checkbox determinate unchecked");
        btn5.setIndeterminate(false);
        btn5.setSelected(false);

        ToggleButton btn6 = new MFXToggleButton("toggle button no group");
        ToggleButton btn7 = new MFXToggleButton("toggle button 2");
        ToggleButton btn8 = new MFXToggleButton("toggle button 3");
        ToggleGroup group = new ToggleGroup();
        btn7.setToggleGroup(group);
        btn8.setToggleGroup(group);

        RadioButton btn9 = new MFXRadioButton("radiobutton no group");
        RadioButton btn10 = new MFXRadioButton("radiobutton 2");
        RadioButton btn11 = new MFXRadioButton("radiobutton 3");
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