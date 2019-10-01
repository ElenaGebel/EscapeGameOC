package com.company.Controller.Strategy.Player;

import java.util.ArrayList;
import java.util.Scanner;
import com.company.Model.GameModel;
import com.company.View.GameView;

public class User extends AbstactPlayer{
    private Scanner scanner;
    @Override
    public ArrayList<Integer> getCombination(Boolean generateNewCombitation, String pattern) {
        if(generateNewCombitation){
            combinationArrayList = new ArrayList<>();
            String userCombination = askForCombination();

            for(int i=0; i < userCombination.length(); i++){
                combinationArrayList.add(Character.getNumericValue(userCombination.charAt(i)));
            }
        }
        return combinationArrayList;
    }

    @Override
    public ArrayList<Integer> getSecretCombination() {
        if(secretCombinationArrayList.size() == 0){
            String userSecretCombination = askForCombination();

            for(int i=0; i < userSecretCombination.length(); i++){
                secretCombinationArrayList.add(Character.getNumericValue(userSecretCombination.charAt(i)));
            }
        }

        return secretCombinationArrayList;
    }

    private String askForCombination() {

        String result = "";
        do {
            scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                result = scanner.nextLine();

                if(result.length() != GameModel.getCombinationNum() || !checkNumberString(result)){
                    result = "";
                    GameView.printOutMessageAndLog("Veillez choisir " + GameModel.getCombinationNum() + " numeros entre 0 et 9.", "Illegal Choice", "info");
                }

            } else {
                GameView.printOutMessageAndLog("Veillez choisir " + GameModel.getCombinationNum() + " numeros entre 0 et 9.", "Illegal Choice", "info");
                result = "";
            }
        } while (result.equals(""));

        return result;
    }

    @Override
    public String askToCompare(String compareAnswer)  {

        String result = "";
        do {
            scanner = new Scanner(System.in);

            if (scanner.hasNextLine()) {
                result = scanner.nextLine();

                if(!checkSymbolString(result)){

                    GameView.printOutMessageAndLog("Veillez donner la reponse en utilisant les symbols +-=, (+) plus grand, plus petit (-) ou si c’est le bon (=).", "Illegal reponse: "+result, "info");
                    result = "";
                }
                else if (!compareAnswer.equals(result)){
                    GameView.printOutMessageAndLog("La reponse n est pas bonne. Veillez essayer encore.", "Illegal reponse: "+result, "info");
                    result = "";
                }
            } else {
                GameView.printOutMessageAndLog("Veillez donner la reponse en utilisant les symbols +-=, (+) plus grand, plus petit (-) ou si c’est le bon (=).", "Illegal reponse", "info");
                result = "";
            }
        } while (result.equals(""));

        return result;
    }


}
