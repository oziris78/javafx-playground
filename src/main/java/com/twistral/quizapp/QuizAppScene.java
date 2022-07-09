package com.twistral.quizapp;

import com.twistral.toriafx.TScene;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class QuizAppScene extends TScene<QuizAppApplication, GridPane> {

    private TextField tfQuestionNumber, tfQuestion;
    private Button[] currentQuestionButtons;

    private final ArrayList<Question> questions;
    private int curQuestionIndex = 0, correctAnswers = 0;

    public QuizAppScene(QuizAppApplication app, GridPane root) {
        super(app, root);

        // init layout
        questions = QuizQuestions.getQuizQuestions();

        tfQuestionNumber = new TextField();
        tfQuestionNumber.setPrefSize(650,50);
        tfQuestionNumber.setAlignment(Pos.CENTER);
        tfQuestionNumber.setFont(Font.font("arial", 35d));
        tfQuestionNumber.setDisable(true);

        tfQuestion = new TextField();
        tfQuestion.setPrefSize(650,50);
        tfQuestion.setAlignment(Pos.CENTER);
        tfQuestion.setFont(Font.font("arial", 28d));
        tfQuestion.setDisable(true);

        root.add(tfQuestionNumber, 0, 0, 6, 1);
        root.add(tfQuestion, 0, 1, 6, 1);

        for (int i = 0; i < 6; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100d / 6d); // any num works
            col.setHgrow(Priority.ALWAYS);
            root.getColumnConstraints().add(col);
        }

        setOptionsAndExitBtn();
    }


    private void setOptionsAndExitBtn() {
        fillTextFields();

        Question curQuestion = this.questions.get(curQuestionIndex);
        int optionCount = curQuestion.getOptions().size();
        curQuestionIndex++;

        root.getRowConstraints().clear();
        for (int i = 0; i < optionCount + 3; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100 / optionCount); // any num works
            row.setPrefHeight(50);
            row.setVgrow(Priority.ALWAYS);
            root.getRowConstraints().add(row);
        }

        currentQuestionButtons = new Button[optionCount];
        for (int i = 0; i < optionCount; i++) {
            String option = curQuestion.getOptions().get(i);
            String optionLetter = String.valueOf(option.charAt(0));
            option = option.substring(1);
            Button btn = new Button(optionLetter);
            btn.setFont(Font.font("arial", 30d));
            TextField tfOption = new TextField(option);
            tfOption.setAlignment(Pos.CENTER_LEFT);
            tfOption.setDisable(true);
            tfOption.setFont(Font.font("arial", 30d));
            btn.setUserData(tfOption);
            btn.setPrefSize(50,50);
            btn.setMaxSize(500,500);
            tfOption.setPrefSize(300,50);
            tfOption.setMaxSize(3000,500);
            root.add(btn, 0, 2+i, 1, 1);
            root.add(tfOption, 1, 2+i, 5, 1);
            currentQuestionButtons[i] = btn;
            btn.setOnAction(event -> {
                String selectedOption = btn.getText() + ((TextField) btn.getUserData()).getText();
                boolean isRight = curQuestion.isRightAnswer(selectedOption);
                if(isRight) correctAnswers++;
                for(Button b : currentQuestionButtons) {
                    b.setDisable(true);
                    TextField tfOfB = (TextField) b.getUserData();
                    if(curQuestion.isRightAnswer(b.getText() + tfOfB.getText())) tfOfB.setStyle("-fx-text-fill: green;");
                    else tfOfB.setStyle("-fx-text-fill: red;");
                }
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if(curQuestionIndex != questions.size()){
                            Platform.runLater(new Runnable() {@Override public void run() {
                                for(Button b : currentQuestionButtons){
                                    root.getChildren().remove(b);
                                    root.getChildren().remove( (TextField) b.getUserData() );
                                }
                                setOptionsAndExitBtn();
                            }});
                        }
                        else{
                            Platform.runLater(new Runnable() {@Override public void run() {
                                showStatsAndGoBack();
                            }});
                        }
                    }
                }, 2000);
            });
        }
    }

    private void showStatsAndGoBack(){
        root.getChildren().removeAll(tfQuestion, tfQuestionNumber);
        for(Button b : currentQuestionButtons){
            root.getChildren().remove(b);
            root.getChildren().remove( (TextField) b.getUserData() );
        }

        TextField tfScore = new TextField();
        double scorePercentage = ((double) correctAnswers) / ((double) questions.size()) * 100d;
        tfScore.setText(String.format("%d / %d, your score is %.2f%%", correctAnswers, questions.size(), scorePercentage));

        tfScore.setDisable(true);
        tfScore.setFont(Font.font("arial", 50d));
        tfScore.setAlignment(Pos.CENTER);
        tfScore.setPrefSize(200, 80);
        tfScore.setStyle("-fx-text-fill: red;");


        BorderPane newRoot = new BorderPane();
        newRoot.setCenter(tfScore);
        this.setRoot(newRoot);
    }


    private void fillTextFields(){
        Question curQuestion = this.questions.get(curQuestionIndex);
        tfQuestionNumber.setText("QUESTION #" + (curQuestionIndex + 1));
        tfQuestion.setText(curQuestion.getQuestionString());
    }

}
