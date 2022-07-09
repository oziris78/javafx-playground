package com.twistral.exercises.material;

import com.twistral.Main;
import com.twistral.toriafx.ToriaFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.net.URISyntaxException;


public class JMetroTest extends Application {

    public void start(Stage stage) throws URISyntaxException {
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

        MediaPlayer mediaPlayer = new MediaPlayer(Main.res.getMedia("music"));
        Button btn123 = new Button("play music");
        btn123.setOnAction(event -> mediaPlayer.play());

        MediaPlayer mediaPlayer2 = new MediaPlayer(Main.res.getMedia("button"));
        Button btn1232 = new Button("play sfx");
        btn1232.setOnAction(event -> mediaPlayer2.play());

        ImageView imageView = new ImageView(Main.res.getImage("twistral"));

        pane.setVgap(15);
        pane.setHgap(15);
        pane.setPadding(ToriaFX.insetsOnlyHorizontal(20));
        pane.getChildren().addAll(
                btn1, btn2, btn3, btn4,
                btn5, btn6, btn7, btn8,
                btn9, btn10, btn11,
                btn123, btn1232, imageView

        );

        Scene scene = new Scene(pane);

        JMetro jMetro = new JMetro(Style.LIGHT);
        jMetro.setScene(scene);

        stage.setScene(scene);
        stage.show();
    }


}