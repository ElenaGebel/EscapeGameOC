package com.company.Controller.Strategy.Player;

import java.util.ArrayList;
import java.util.Scanner;
import com.company.Model.GameModel;

public class User extends AbstactPlayer{
    Scanner scanner;
    @Override
    public ArrayList getCombination() {
        combinationArrayList = new ArrayList<>();
        String userCombination = Integer.toString(askUserForNumber());

        for(int i=0; i < userCombination.length(); i++){
            combinationArrayList.add(Character.getNumericValue(userCombination.charAt(i)));
        }
        return combinationArrayList;
    }

    public int askUserForNumber() {

        int result = 0;
        do {
            scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                if(Integer.toString(result).length() != GameModel.getCombinationNum())
                    result = 0;

            } else {
                result = 0;

            }
        } while (result == 0);

        return result;
    }
}
