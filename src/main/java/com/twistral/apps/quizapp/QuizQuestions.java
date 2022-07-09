package com.twistral.apps.quizapp;

import java.util.ArrayList;
import java.util.List;


class QuizQuestions {

    public static ArrayList<Question> getQuizQuestions(){
        return new ArrayList<Question>(List.of(
            new Question("Which company created Java?",
                    0, "Sun Microsystems", "Facebook", "Starbucks", "Microsoft"),
            new Question("Which year was Java created?",
                    1, "1989","1996","1972","1492", "1453", "2060"),
            new Question("What was Java originally called?",
                    2, "Apple","Latte","Oak","Koffing","TypeScript", "C# But Better - CBB"),
            new Question("Who is credited with creating Java?",
                    4, "Steve Jobs","Bill Gates","Mark Zuckerburg","Twistral Studios","James Gosling")
        ));
    }

}
