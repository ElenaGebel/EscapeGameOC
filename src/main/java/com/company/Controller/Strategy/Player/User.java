package com.company.Controller.Strategy.Player;

import java.util.ArrayList;
import java.util.Scanner;
import com.company.Model.GameModel;
import com.company.View.GameView;

public class User extends AbstactPlayer{
    Scanner scanner;
    @Override
    public ArrayList getCombination() {
        combinationArrayList = new ArrayList<>();
        String userCombination = Integer.toString(askUserForCombination());

        for(int i=0; i < userCombination.length(); i++){
            combinationArrayList.add(Character.getNumericValue(userCombination.charAt(i)));
        }
        return combinationArrayList;
    }

    private int askUserForCombination() {

        int result = 0;
        do {
            scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                if(Integer.toString(result).length() != GameModel.getCombinationNum()){
                    result = 0;
                    GameView.printOutMessageAndLog("Veillez choisir " + GameModel.getCombinationNum() + "numeros entre 1 et 9.", "Illegal Choice", "info");
                }
            } else {
                GameView.printOutMessageAndLog("Veillez choisir " + GameModel.getCombinationNum() + "numeros entre 1 et 9.", "Illegal Choice", "info");
                result = 0;
            }
        } while (result == 0);

        return result;
    }
}
