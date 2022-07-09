package com.twistral.rtt;



class RTTLocalization {

    public static String sRTT, sStart, sHelp, sSettings, sTryAgain, sTime, sScore, sTimeCounter, sLanguage,
            sHelpText, sBack, sPreviousScores, sSaveAsTxt;


    static{
        changeLanguageToEnglish();
    }



    public static void changeLanguageToTurkish() {
        sRTT = "REACTION TIME TESTER";
        sStart = "BA\u015eLA";
        sHelp = "YARDIM";
        sSettings = "AYARLAR";
        sTryAgain = "Yeniden Dene";
        sTime = "S\u00fcre: ";
        sScore = "Sonu\u00e7: ";
        sTimeCounter = "S\u00fcre: 00:00:00";
        sLanguage = "Dil";
        sHelpText = "NASIL OYNANIR:\n\n"
                + "\"BA\u015eLA\" d\u00fc\u011fmesine bast\u0131\u011f\u0131nda be\u015f saniyelik bir gerisay\u0131m ba\u015flayacak.\n"
                + "\nGerisay\u0131m bitti\u011finde ekran\u0131nda beliren hedeflere olabildi\u011fince h\u0131zl\u0131 bir bi\u00e7imde t\u0131klamal\u0131s\u0131n. "
                + "\n\nHedefler teker teker ekran\u0131nda belirecektir. Sonucun (skorun) hedeflerin hepsine t\u0131klarken ge\u00e7en s\u00fcredir. "
                + "\n \nBol \u015fanslar!";
        sBack = "GER\u0130";
        sPreviousScores = "Eski sonu\u00e7lar:";
        sSaveAsTxt = ".txt Olarak Kaydet";
    }


    public static void changeLanguageToGerman() {
        sRTT = "REACTION TIME TESTER";
        sStart = "STARTEN";
        sHelp = "HILFE";
        sSettings = "EINSTELLUNGEN";
        sTryAgain = "Erneut versuchen";
        sTime = "Zeit: ";
        sScore = "Ergebnis: ";
        sTimeCounter = "Zeit: 00:00:00";
        sLanguage = "Sprache";
        sHelpText = "SO WIRD GESPIELT:\n\n"
                + "Wenn Sie den Knopf 'START' dr\u00fccken, wird ein Countdown von f\u00fcnf Sekunden gestartet.\n"
                + "\nWenn der Countdown endet, m\u00fcssen Sie so schnell wie m\u00f6glich auf die angezeigten Ziele auf ihrem Bildschirm klicken. "
                + "\n\nDie Ziele werden jeweils nur einmal angezeigt. Ihre Punktzahl ist die Zeit, die sie ben\u00f6tigen, um auf alle 15 Ziele zu klicken. "
                + "\n \nViel Gl\u00fcck!";
        sBack = "ZUR\u00dcCK";
        sPreviousScores = "Vorherige Ergebnisse:";
        sSaveAsTxt = "Sichern Als .txt";
    }

    public static void changeLanguageToEnglish() {
        sRTT = "REACTION TIME TESTER";
        sStart = "START";
        sHelp = "HELP";
        sSettings = "SETTINGS";
        sTryAgain = "Try Again";
        sTime = "Time: ";
        sScore = "Score: ";
        sTimeCounter = "Time: 00:00:00";
        sLanguage = "Language";
        sHelpText = "HOW TO PLAY:\n\n"
                + "When you press the \"START\" button, a five second countdown will start.\n"
                + "\nWhen the countdown ends, you are supposted to click the appearing targets on your screen "
                + "as fast as possible.\n\nThey will only appear once at a time. Your score is the time you take "
                + "to click all 15 targets.\n \nGood Luck!";
        sBack = "BACK";
        sPreviousScores = "Previous Scores:";
        sSaveAsTxt = "Save as .txt";
    }


}
