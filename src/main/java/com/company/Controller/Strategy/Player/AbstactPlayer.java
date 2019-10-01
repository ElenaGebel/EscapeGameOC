package com.company.Controller.Strategy.Player;

import java.util.ArrayList;

public abstract class AbstactPlayer {

    protected ArrayList<Integer> combinationArrayList = new ArrayList<>();
    protected ArrayList<Integer> secretCombinationArrayList = new ArrayList<>();

    public ArrayList<Integer> getCombination(Boolean generateNewCombitation, String pattern){
        return combinationArrayList;
    }

    public ArrayList<Integer>  getSecretCombination(){
        return secretCombinationArrayList;
    }

    public String compare(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2) {
        String result = "";

        if(arrayList1.size() == arrayList2.size()){
            for (int i = 0; i < arrayList1.size(); i++) {
                if (arrayList1.get(i).compareTo(arrayList2.get(i)) == 0)
                    result +="=";
                else if (arrayList1.get(i).compareTo(arrayList2.get(i)) == 1)
                    result +="+";
                else if (arrayList1.get(i).compareTo(arrayList2.get(i)) == -1)
                    result +="-";
            }
        }
        return result;
    }

    public String askToCompare(String compareAnswer)  {
        return compareAnswer;
    }

    public String getCombinationToString(){
        return combinationArrayList.toString().replaceAll("\\[|\\]|[,][ ]","");
    }

    public String getSecretCombinationToString(){
        return secretCombinationArrayList.toString().replaceAll("\\[|\\]|[,][ ]","");
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
