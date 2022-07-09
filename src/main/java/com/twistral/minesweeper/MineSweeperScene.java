package com.twistral.minesweeper;

import com.twistral.Main;
import com.twistral.toriafx.TScene;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.util.*;
import java.util.*;



public class MineSweeperScene extends TScene<MineSweeperApplication, VBox> {

    private HBox paneTop;
    private GridPane paneMiddle;
    private Button[] gridButtons;
    private boolean[] boolMineGrid;
    private int[] intMineGrid;
    private ImageView imageView;
    private int mines = 0;
    private int foundEmptySpots = 0;
    private MediaPlayer mplayerExplosion;
    private final double difficulty = 0.9; // [0,1] closer to 1 means easier

    public MineSweeperScene(MineSweeperApplication app, VBox root) {
        super(app, root);

        // init layout stuff
        initPanes();

        // paneTop
        initTopElements();
        initTopEventHandlers();

        // paneMiddle
        initGridButtons();
        initGridEventHandlers();

        // sounds
        mplayerExplosion = new MediaPlayer(Main.res.getMedia("minesweeperExplosion"));
        mplayerExplosion.setVolume(0.2d);
    }


    private void initPanes() {
        paneTop = new HBox();
        paneMiddle = new GridPane();
        root.getChildren().addAll(paneTop, paneMiddle);

        for (int i = 0; i < 10; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(10);
            col.setHgrow(Priority.ALWAYS);
            paneMiddle.getColumnConstraints().addAll(col);

            RowConstraints row = new RowConstraints();
            row.setPercentHeight(10);
            row.setVgrow(Priority.ALWAYS);
            paneMiddle.getRowConstraints().addAll(row);
        }

        VBox.setVgrow(paneTop, Priority.NEVER);
        VBox.setVgrow(paneMiddle, Priority.ALWAYS);

        for(Node node : root.getChildren()) VBox.setMargin(node, new Insets(5));
        root.setPadding(new Insets(10));
    }

    private void initTopElements() {
        Region region = new Region();
        Region region2 = new Region();

        imageView = new ImageView(Main.res.getImage("mineSweeperOkFace"));
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);
        HBox.setMargin(imageView, new Insets(-5,0,0,0));

        Region reg = new Region();
        HBox.setHgrow(reg, Priority.SOMETIMES);
        HBox.setHgrow(region, Priority.ALWAYS);
        HBox.setHgrow(imageView, Priority.SOMETIMES);
        HBox.setHgrow(region2, Priority.ALWAYS);

        paneTop.getChildren().addAll(reg, region, imageView, region2);
    }


    private void initTopEventHandlers() {
        imageView.setOnMouseClicked(event -> {
            app.getStage().setScene( app.getSceneMinesweeper() );
            app.getStage().centerOnScreen();
        });
    }


    private void initGridButtons() {
        gridButtons = new Button[100];
        int row = 0, col = 0;
        for (int i = 0; i < gridButtons.length; i++) {
            gridButtons[i] = new Button("");
            gridButtons[i].setPrefSize(50,50);
            gridButtons[i].setMaxSize(500,500);
            gridButtons[i].setFont(Font.font("arial", 20d));
            paneMiddle.add(gridButtons[i], col++, row);
            if(col == 10) {
                col = 0;
                row++;
            }
            if(row == 10) row = 0;
        }
    }

    private void initGridEventHandlers() {
        // place in mines
        Random random = new Random();
        int mineCount = 30;
        boolMineGrid = new boolean[100];
        for (int i = 0; i < boolMineGrid.length; i++) {
            double curDouble = random.nextDouble();
            boolMineGrid[i] = (mineCount > 0 && curDouble > difficulty);
            if(mineCount > 0 && curDouble > difficulty) {
                mineCount--;
                mines++;
            }
        }

        // get mine count into memory
        intMineGrid = new int[100];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                int adjacentMines = 0;
                if(row != 0 && col != 0){ if(boolMineGrid[row * 10 + col - 1 - 10]) adjacentMines++; }
                if(row != 0 && col != 9){ if(boolMineGrid[row * 10 + col + 1 - 10]) adjacentMines++; }
                if(row != 9 && col != 0){ if(boolMineGrid[row * 10 + col - 1 + 10]) adjacentMines++; }
                if(row != 9 && col != 9){ if(boolMineGrid[row * 10 + col + 1 + 10]) adjacentMines++; }
                if(col != 0){ if(boolMineGrid[row * 10 + col - 1]) adjacentMines++; }
                if(col != 9){ if(boolMineGrid[row * 10 + col + 1]) adjacentMines++; }
                if(row != 0){ if(boolMineGrid[row * 10 + col - 10]) adjacentMines++; }
                if(row != 9){ if(boolMineGrid[row * 10 + col + 10]) adjacentMines++; }
                intMineGrid[row * 10 + col] = adjacentMines;
                gridButtons[row * 10 + col].setTextFill(getColor(adjacentMines));
            }
        }

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                int buttonIndex = row * 10 + col;
                Button btn = gridButtons[buttonIndex];
                btn.setOnMouseClicked(event -> {
                    if(event.getButton() == MouseButton.PRIMARY){
                        if(btn.getText() == "M") return;
                        if(boolMineGrid[buttonIndex]) gameOver(false);
                        else{
                            btn.setDisable(true);
                            btn.setText(String.valueOf(intMineGrid[buttonIndex]));
                            foundEmptySpots++;
                            if(100 - foundEmptySpots == mines) gameOver(true);
                        }
                    }
                    else if(event.getButton() == MouseButton.SECONDARY){
                        boolean isLetter = btn.getText() == "M";
                        if(isLetter) {
                            btn.setTextFill(getColor(intMineGrid[paneMiddle.getChildren().indexOf(btn)]));
                            btn.setText("");
                        }
                        else{
                            btn.setTextFill(Color.BLACK);
                            btn.setText("M");
                        }
                    }
                });
            }
        }


    }

    private void gameOver(boolean hasWon) {
        if(hasWon){
            imageView.setImage(Main.res.getImage("mineSweeperCoolFace"));
        }
        else{
            mplayerExplosion.play();
            mplayerExplosion.seek(Duration.ZERO);
            imageView.setImage(Main.res.getImage("mineSweeperSadFace"));
            for(Button btn : gridButtons) {
                btn.setDisable(true);
                btn.setOnAction(event -> {});
            }
            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {
                    int buttonIndex = row * 10 + col;
                    Button btn = gridButtons[buttonIndex];
                    boolean hasMine = boolMineGrid[buttonIndex];
                    if(hasMine) {
                        btn.setText("!!!");
                        btn.setTextFill(Color.RED);
                    }
                    else btn.setText(String.valueOf(intMineGrid[buttonIndex]));
                }
            }

        }
    }

    private Color getColor(int mineCount){
        if(mineCount == 0) return Color.BLACK;
        if(mineCount == 1) return Color.GREEN;
        if(mineCount == 2) return Color.PURPLE;
        if(mineCount == 3) return Color.RED;
        if(mineCount == 4) return Color.DARKRED;
        if(mineCount == 5) return Color.DARKRED;
        if(mineCount == 6) return Color.DARKRED;
        if(mineCount == 7) return Color.DARKRED;
        if(mineCount == 8) return Color.DARKRED;
        return Color.BLACK;
    }



}
