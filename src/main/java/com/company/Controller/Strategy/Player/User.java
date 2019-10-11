package com.company.Controller.Strategy.Player;

import java.util.ArrayList;
import java.util.Scanner;
import com.company.Model.GameModel;
import com.company.Utility.PrintOutUtility;

/**
 * Classe User classe de l utilisateur
 */

public class User extends AbstactPlayer{
    private Scanner scanner;

    /**
     * Constructeur User
     */
    public User() {
    }
    /**
     * Retourne la combinaison
     * @param generateNewCombination sert pour demander a l utilisateur a saisir la combinaison encore une fois
     * @param pattern
     * @return la combinaison
     */
    @Override
    public ArrayList<Integer> getCombination(Boolean generateNewCombination, String pattern) {
        if(generateNewCombination){
            combinationArrayList = new ArrayList<>();
            String userCombination = askForCombination();

            for(int i=0; i < userCombination.length(); i++){
                combinationArrayList.add(Character.getNumericValue(userCombination.charAt(i)));
            }
        }
        return combinationArrayList;
    }
    /**
     * Retourne la combinaison secrete
     * @return la combinaison secrete
     */
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

    /**
     * Demande a l utilisateur a saisir la combinaison
     * @return la combinaison saisi
     */
    private String askForCombination() {

        String message = " chiffre";
        if(GameModel.getCombinationNum() > 1)
            message += "s";
        String result = "";
        do {
            scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                result = scanner.nextLine();

                if(result.length() != GameModel.getCombinationNum() || !checkNumberString(result)){
                    result = "";
                    PrintOutUtility.printOutMessageAndLog("Veillez saisir " + GameModel.getCombinationNum()
                            + message +" entre 0 et 9.", "Illegal answer when choose combination proposed", "info");
                }

            } else {
                PrintOutUtility.printOutMessageAndLog("Veillez saisir " + GameModel.getCombinationNum()
                        + message +" entre 0 et 9.", "Illegal answer when choose combination proposed", "info");
                result = "";
            }
        } while (result.equals(""));

        return result;
    }

    /**
     * Demande a l utilisateur comparer la proposition de l ordinateur
     * et la combinaison secrete
     * @param compareAnswer parametre pour comparer la reponse de l utilisateur et la combinaison secrete
     * @return reponse de l utilisateur
     */
    @Override
    public String askToCompare(String compareAnswer)  {

        String result = "";
        do {
            scanner = new Scanner(System.in);

            if (scanner.hasNextLine()) {
                result = scanner.nextLine();

                if(!checkSymbolString(result)){

                    PrintOutUtility.printOutMessageAndLog("Veillez donner la réponse en utilisant les caractères +-="
                                    + System.lineSeparator() + "(+) plus grand, plus petit (-) ou si c’est le bon (=)",
                            "Illegal answer when asked to compare: " + result, "info");
                    result = "";
                }
                else if (!compareAnswer.equals(result)){
                    PrintOutUtility.printOutMessageAndLog("La réponse n'est pas bonne. Veillez essayer encore.",
                            "Illegal answer when asked to compare: " + result, "info");
                    result = "";
                }
            } else {
                PrintOutUtility.printOutMessageAndLog("Veillez donner la réponse en utilisant les caractères +-= "
                        + System.lineSeparator() + "(+) plus grand, plus petit (-) ou si c’est le bon (=)",
                        "Illegal answer when asked to compare" + result, "info");
                result = "";
            }
        } while (result.equals(""));

        return result;
    }


}
