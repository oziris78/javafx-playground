package com.twistral.apps.quizapp;

import java.util.ArrayList;


class Question {

    private final String questionString;
    private final ArrayList<String> options;
    private final int rightAnswerIndex;

    public Question(String questionString, int answerIndexStartingFromZero, String... optionsWithoutOptionNumbers){
        this.questionString = questionString;
        this.rightAnswerIndex = answerIndexStartingFromZero;
        this.options = new ArrayList<>();
        for (int i = 0; i < optionsWithoutOptionNumbers.length; i++){
            String letter = (i == 0) ? "A" : String.valueOf((char) ((int) 'A' + i));
            this.options.add(letter + optionsWithoutOptionNumbers[i]);
        }
    }

    public boolean isRightAnswer(String choosenOption){
        int indexOfOption = this.options.indexOf(choosenOption);
        return (indexOfOption == -1) ? false : indexOfOption == rightAnswerIndex;
    }

    /*  GETTERS AND SETTERS  */
    public ArrayList<String> getOptions() { return options; }
    public String getQuestionString() { return questionString; }

}
