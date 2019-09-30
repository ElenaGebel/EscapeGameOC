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
        String userCombination = askUserForCombination();

        for(int i=0; i < userCombination.length(); i++){
            combinationArrayList.add(Character.getNumericValue(userCombination.charAt(i)));
        }
        return combinationArrayList;
    }

    private String askUserForCombination() {

        String result = "";
        do {
            scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                result = scanner.nextLine();

                if(result.length() != GameModel.getCombinationNum() || !checkString(result)){
                    result = "";
                    GameView.printOutMessageAndLog("Veillez choisir " + GameModel.getCombinationNum() + " numeros entre 0 et 9.", "Illegal Choice", "info");
                }

            } else {
                GameView.printOutMessageAndLog("Veillez choisir " + GameModel.getCombinationNum() + " numeros entre 0 et 9.", "Illegal Choice", "info");
                result = "";
            }
        } while (result == "");

        return result;
    }

    public boolean checkString(String string) {
        if (string == null) return false;
        return string.matches("^-?\\d+$");
    }
}
