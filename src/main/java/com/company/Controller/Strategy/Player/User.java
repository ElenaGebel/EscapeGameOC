package com.company.Controller.Strategy.Player;

import java.util.ArrayList;
import java.util.Scanner;
import com.company.Model.GameModel;

public class User extends AbstactPlayer{
    Scanner scanner;
    @Override
    public ArrayList getCombination() {
        askUserForCombination();
        return combinationArrayList;
    }

    public void askUserForCombination() {

        int result = 0;
        do {
            scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                if( GameModel.getCombinationNum())

                if (strategyType < 1 || strategyType > 3){
                    printOutMessageAndLog("Veuillez essayer encore", "Illegal Choice", "info");
                    strategyType = 0;
                }
            } else {
                result = 0;

            }
        } while (result == 0);
    }
}
