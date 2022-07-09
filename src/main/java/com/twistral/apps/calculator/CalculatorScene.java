package com.twistral.apps.calculator;

import com.twistral.toriafx.TScene;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;


class CalculatorScene extends TScene<CalculatorApplication, VBox> {

    private HBox paneBottom, paneTop;
    private GridPane paneMiddle;

    private TextField textField;

    private Button btn1, btn2, btn3, btnPlus, btn4, btn5, btn6, btnMinus, btn7, btn8, btn9, btnMultiply,
            btnDot, btn0, btnEquals, btnDivide, btnClear, btnSign, btnDelete;

    private double num1 = 0;
    private char operator = '@';


    public CalculatorScene(CalculatorApplication app, VBox root) {
        super(app, root);
        // init layout stuff
        initPanes();

        // paneTop
        initTopElements();

        // paneMiddle
        initGridButtons();
        initGridEventHandlers();

        // paneBottom
        initBottomButtons();
        initBottomEventHandlers();

    }


    private void initPanes() {
        paneBottom = new HBox();
        paneMiddle = new GridPane();
        paneTop = new HBox();
        root.getChildren().addAll(paneTop, paneMiddle, paneBottom);

        // TODO: 25/09/2021 make gridpane be resized

        VBox.setVgrow(paneTop, Priority.ALWAYS);
        VBox.setVgrow(paneMiddle, Priority.ALWAYS);
        VBox.setVgrow(paneBottom, Priority.ALWAYS);

        for(Node node : root.getChildren()) VBox.setMargin(node, new Insets(15));
        root.setPadding(new Insets(10));

    }

    private void initTopElements() {
        textField = new TextField();
        textField.setDisable(true);
        textField.setFont(Font.font("arial", 50d));
        textField.setPrefSize(350, 80);

        HBox.setHgrow(textField, Priority.ALWAYS);
        paneTop.getChildren().add(textField);
    }

    private void initBottomButtons() {
        btnClear = new Button("CLE");
        btnSign = new Button("+/-");
        btnDelete = new Button("DEL");

        Button[] buttons = new Button[]{btnClear, btnSign, btnDelete};

        for(Button btn : buttons){
            btn.setPrefSize(90, 60);
            btn.setFont(Font.font("arial", 25d));
            HBox.setHgrow(btn, Priority.ALWAYS);
        }

        paneBottom.getChildren().addAll(btnSign, btnDelete, btnClear);
    }

    private void initBottomEventHandlers() {
        btnClear.setOnAction(event -> { textField.setText(""); });
        btnSign.setOnAction(event -> {
            double temp = getValueFromTextField();
            if(temp == Integer.MAX_VALUE) return;
            temp *= -1;
            textField.setText(String.valueOf(temp));
        });
        btnDelete.setOnAction(event -> {
            if( textField.getLength() <= 0) return;
            textField.setText( textField.getText().substring(0, textField.getText().length()-1) );
            if( textField.getLength() > 0){
                if( textField.getText().charAt( textField.getLength() - 1 ) == '.' ) btnDelete.fire();
            }
        });
    }



    private void initGridButtons() {
        btn1 = new Button("1"); btn2 = new Button("2"); btn3 = new Button("3"); btnPlus = new Button("+");
        btn4 = new Button("4"); btn5 = new Button("5"); btn6 = new Button("6"); btnMinus = new Button("-");
        btn7 = new Button("7"); btn8 = new Button("8"); btn9 = new Button("9"); btnMultiply = new Button("*");
        btnDot = new Button("."); btn0 = new Button("0"); btnEquals = new Button("="); btnDivide = new Button("/");

        Button[] buttons = new Button[]{btn1, btn2, btn3, btnPlus, btn4, btn5,
                btn6, btnMinus, btn7, btn8, btn9, btnMultiply, btnDot, btn0, btnEquals, btnDivide};

        for (int rowIndex = 0; rowIndex < buttons.length; rowIndex+=4) {
            paneMiddle.add(buttons[rowIndex], 0, rowIndex);
            paneMiddle.add(buttons[rowIndex+1], 1, rowIndex);
            paneMiddle.add(buttons[rowIndex+2], 2, rowIndex);
            paneMiddle.add(buttons[rowIndex+3], 3, rowIndex);
        }

        for(Button btn : buttons){
            btn.setPrefWidth(90);
            btn.setPrefHeight(60);
            btn.setFont(Font.font("arial", 30d));
        }
    }


    private void initGridEventHandlers() {
        btn1.setOnAction(event -> { textField.appendText("1");});
        btn2.setOnAction(event -> { textField.appendText("2");});
        btn3.setOnAction(event -> { textField.appendText("3");});
        btn4.setOnAction(event -> { textField.appendText("4");});
        btn5.setOnAction(event -> { textField.appendText("5");});
        btn6.setOnAction(event -> { textField.appendText("6");});
        btn7.setOnAction(event -> { textField.appendText("7");});
        btn8.setOnAction(event -> { textField.appendText("8");});
        btn9.setOnAction(event -> { textField.appendText("9");});
        btn0.setOnAction(event -> { textField.appendText("0");});
        btnDot.setOnAction(event -> {
            if(textField.getText().contains(".")) return;
            textField.appendText( (textField.getLength() == 0 ? "0" : "") + ".");
        });
        btnPlus.setOnAction(event -> { operatorButtons('+'); });
        btnMinus.setOnAction(event -> { operatorButtons('-'); });
        btnMultiply.setOnAction(event -> { operatorButtons('*'); });
        btnDivide.setOnAction(event -> { operatorButtons('/'); });

        btnEquals.setOnAction(event -> {
            if(operator == '@') return;
            if( textField.getLength() <= 0 ) return;
            double num2 = getValueFromTextField();
            if(num2 == Integer.MAX_VALUE) return;
            double result = 404;
            switch(operator) {
                case'+':
                    result = num1 + num2;
                    break;
                case'-':
                    result = num1 - num2;
                    break;
                case'*':
                    result = num1 * num2;
                    break;
                case'/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
            operator = '@';
        });

    }

    private void operatorButtons(char operator){
        this.num1 = getValueFromTextField();
        if(num1 == Integer.MAX_VALUE) return;
        this.textField.setText("");
        this.operator = operator;
    }

    private double getValueFromTextField() {
        try{
            if(textField.getLength() <= 0) return Integer.MAX_VALUE;
            return Double.parseDouble(textField.getText());
        }
        catch (Exception e){ e.printStackTrace(); return Integer.MAX_VALUE; }
    }

}
