package com.twistral;

import com.twistral.exercises.controls.*;
import com.twistral.exercises.material.TrayIconTest;
import com.twistral.utils.resources.Resources;
import javafx.application.Application;


public class Main {

    public static final Resources res = new Resources();

    public static void main(String[] args) {
        Application.launch(TrayIconTest.class, args);
    }

}
