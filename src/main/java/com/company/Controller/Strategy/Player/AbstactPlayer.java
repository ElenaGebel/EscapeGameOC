package com.company.Controller.Strategy.Player;

import java.util.ArrayList;

public abstract class AbstactPlayer {

    protected ArrayList<Integer> combinationArrayList = new ArrayList<>();
    protected ArrayList<Integer> secretCombinationArrayList = new ArrayList<>();

    public ArrayList getCombination(Boolean generateNewCombitation, String pattern){
        return combinationArrayList;
    }

    public ArrayList getSecretCombination(){
        return secretCombinationArrayList;
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

    public String getCombinationToString(){
        return combinationArrayList.toString().replaceAll("\\[|\\]|[,][ ]","");
    }

    public String getSecretCombinationToString(){
        return combinationArrayList.toString().replaceAll("\\[|\\]|[,][ ]","");
    }


    public int getCombinationToInteger(){
        return Integer.valueOf(combinationArrayList.toString().replaceAll("\\[|\\]|[,][ ]",""));
    }

    protected boolean checkNumberString(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
    }

    protected boolean checkSymbolString(String string) {
        if (string == null) return false;
        return string.matches("^[-+=]+$");
    }

}
