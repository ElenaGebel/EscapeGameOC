package com.company.Controller.Strategy.Player;
import java.util.ArrayList;
import java.util.Random;

import com.company.Model.GameModel;

public class ArtificialIntelligence extends AbstactPlayer{
    @Override
    public ArrayList getCombination() {
        if(this.combinationArrayList.size() == 0)
            generateCombination();
        return combinationArrayList;
    }

    private void generateCombination() {
        combinationArrayList = new ArrayList<>();
        for (int i = 0; i < GameModel.getCombinationNum(); i++)
            combinationArrayList.add(new Random().nextInt(9) + 1);

    }


}
