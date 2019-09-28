package com.company.Controller.Strategy.Player;

import java.util.ArrayList;

public abstract class AbstactPlayer {

    protected ArrayList<Integer> combinationArrayList = new ArrayList<>();

    public ArrayList getCombination(){
        return combinationArrayList;
    }

    public String compare(ArrayList<Integer> arrayListToCompare) {
        String result = "";
        if(combinationArrayList.size() == arrayListToCompare.size()){
            for (int i = 0; i < combinationArrayList.size(); i++) {
                if (combinationArrayList.get(i).compareTo(arrayListToCompare.get(i)) == 0)
                    result +="=";
                else if (combinationArrayList.get(i).compareTo(arrayListToCompare.get(i)) == 1)
                    result +="+";
                else if (combinationArrayList.get(i).compareTo(arrayListToCompare.get(i)) == -1)
                    result +="-";

            }
        }
        return result;
    }

}
