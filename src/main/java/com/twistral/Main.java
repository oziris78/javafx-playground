package com.twistral;

import com.twistral.calculator.CalculatorApplication;
import com.twistral.cookieclicker.CookieClickerApplication;
import com.twistral.minesweeper.MineSweeperApplication;
import com.twistral.quizapp.QuizAppApplication;
import com.twistral.rtt.RTTApplication;
import com.twistral.utils.resources.Resources;
import javafx.application.Application;


public class Main {

    public static final Resources res = new Resources();

    public static void main(String[] args) {
        Application.launch(RTTApplication.class, args);
    }

}
