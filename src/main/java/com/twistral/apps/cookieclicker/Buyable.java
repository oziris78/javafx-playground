package com.twistral.apps.cookieclicker;

import javafx.scene.text.Text;


class Buyable {

    public int cost, clickPower, income;
    public Buyable(int cost, int clickPower, int income){
        this.cost = cost; this.clickPower = clickPower; this.income = income;
    }
    @Override
    public String toString() {
        return String.format("[cost:%d, clickPower:%d, income:%d]", cost, clickPower, income);
    }


    public static Buyable getBuyable(Text text, int pageNumber, int nth){
        if(pageNumber == 0 && nth == 0)      return new Buyable((int) (5d * ( (double) text.getUserData() )), 1, 1);
        else if(pageNumber == 0 && nth == 1) return new Buyable((int) (50d * ( (double) text.getUserData() )), 3, 3);
        else if(pageNumber == 0 && nth == 2) return new Buyable((int) (150d * ( (double) text.getUserData() )), 5, 5);
        else if(pageNumber == 0 && nth == 3) return new Buyable((int) (350d * ( (double) text.getUserData() )), 10, 10);
        else if(pageNumber == 0 && nth == 4) return new Buyable((int) (700d * ( (double) text.getUserData() )), 15, 15);
        else if(pageNumber == 1 && nth == 0) return new Buyable((int) (1500d * ( (double) text.getUserData() )), 20, 20);
        else if(pageNumber == 1 && nth == 1) return new Buyable((int) (5000d * ( (double) text.getUserData() )), 25, 25);
        else if(pageNumber == 1 && nth == 2) return new Buyable((int) (10000d * ( (double) text.getUserData() )), 35, 50);
        else if(pageNumber == 1 && nth == 3) return new Buyable((int) (25000d * ( (double) text.getUserData() )), 45, 100);
        else if(pageNumber == 1 && nth == 4) return new Buyable((int) (75000d * ( (double) text.getUserData() )), 55, 150);
        else if(pageNumber == 2 && nth == 0) return new Buyable((int) (150000d * ( (double) text.getUserData() )), 70, 250);
        else if(pageNumber == 2 && nth == 1) return new Buyable((int) (350000d * ( (double) text.getUserData() )), 80, 300);
        else if(pageNumber == 2 && nth == 2) return new Buyable((int) (1000000d * ( (double) text.getUserData() )), 100, 400);
        else if(pageNumber == 2 && nth == 3) return new Buyable((int) (5000000d * ( (double) text.getUserData() )), 120, 500);
        else if(pageNumber == 2 && nth == 4) return new Buyable((int) (10000000d * ( (double) text.getUserData() )), 150, 750);
        return null;
    }

}
