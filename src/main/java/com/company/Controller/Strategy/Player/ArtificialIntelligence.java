package com.company.Controller.Strategy.Player;
import java.util.ArrayList;
import java.util.Random;

import com.company.Model.GameModel;
import com.company.View.GameView;

public class ArtificialIntelligence extends AbstactPlayer{
    @Override
    public ArrayList getCombination(Boolean generateNewCombitation, String pattern) {
        if(generateNewCombitation) {
            generateCombinationWithPattern(pattern);
        }
            return combinationArrayList;
    }

    @Override
    public ArrayList getSecretCombination() {
        if(secretCombinationArrayList.size() == 0)
            generateCombination(secretCombinationArrayList);

        return secretCombinationArrayList;
    }

    private void generateCombinationWithPattern(String pattern) {

        if(pattern != "" && pattern.length() ==  GameModel.getCombinationNum()
                && checkSymbolString(pattern) && combinationArrayList != null
                && combinationArrayList.size() ==  GameModel.getCombinationNum()){
            char[] patternArray = pattern.toCharArray();

            for (int i = 0; i < combinationArrayList.size(); i++){

                if(Character.toString(patternArray[i]).equals("-")  && combinationArrayList.get(i) > 0){
                     combinationArrayList.set(i, new Random().nextInt(combinationArrayList.get(i)));

                }else if (Character.toString(patternArray[i]).equals("+") && combinationArrayList.get(i) < 9){

                    combinationArrayList.set(i, new Random().nextInt(10 - combinationArrayList.get(i)) + combinationArrayList.get(i));
                }
             }

        } else{
            generateCombination(combinationArrayList);
        }

    }

    private void generateCombination(ArrayList arrayList) {
        arrayList = new ArrayList<>();
        for (int i = 0; i < GameModel.getCombinationNum(); i++)
            arrayList.add(new Random().nextInt(10));
    }


}
