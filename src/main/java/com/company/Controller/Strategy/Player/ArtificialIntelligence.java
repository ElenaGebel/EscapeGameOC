package com.company.Controller.Strategy.Player;
import java.util.ArrayList;
import java.util.Random;

import com.company.Model.GameModel;
import com.sun.org.apache.xpath.internal.objects.XNull;

public class ArtificialIntelligence extends AbstactPlayer{
    @Override
    public ArrayList getCombination(Boolean generateNewCombitation, String pattern) {
        if(this.combinationArrayList.size() == 0 || generateNewCombitation) {
            generateCombination(pattern);
        }
            return combinationArrayList;

    }

    public void generateCombination(String pattern) {

        if(pattern != "" && pattern.length() ==  GameModel.getCombinationNum()
                && checkSymbolString(pattern) && combinationArrayList != null
                && combinationArrayList.size() ==  GameModel.getCombinationNum()){
            char[] patternArray = pattern.toCharArray();
            for (int i = 0; i < combinationArrayList.size(); i++){

                if(Character.toString(patternArray[i]) == "<" && combinationArrayList.get(i) > 0){
                    combinationArrayList.set(i, new Random().nextInt(combinationArrayList.get(i)));

                }else if (Character.toString(patternArray[i]) == ">" && combinationArrayList.get(i) < 9)
                    combinationArrayList.set(i, new Random().nextInt(10 - combinationArrayList.get(i)) + combinationArrayList.get(i));
            }

        } else{
            combinationArrayList = new ArrayList<>();
            for (int i = 0; i < GameModel.getCombinationNum(); i++)
                combinationArrayList.add(new Random().nextInt(10));
        }

    }


}
