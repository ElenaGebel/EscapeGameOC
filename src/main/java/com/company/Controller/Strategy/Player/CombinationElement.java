package com.company.Controller.Strategy.Player;

public class CombinationElement {

    private int min;
    private int max;
    private int proposition;

    public CombinationElement(int min, int max) {
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

    @Override
    public String toString() {
        return "min=" + min + " max=" + max + " proposition= "+ proposition;
    }
}