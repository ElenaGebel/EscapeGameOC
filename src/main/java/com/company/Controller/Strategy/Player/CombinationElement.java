package com.company.Controller.Strategy.Player;

public class CombinationElement {

    int min;
    int max;
    int proposition;

    public CombinationElement(int min, int max, int proposition) {
        this.min = min;
        this.max = max;
        countProposition();
    }
    public int getMin() {
        return min;
    }


    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getProposition() {
        return proposition;
    }

    public void countProposition() {
        this.proposition = min + (max - min)/2;
    }

}
