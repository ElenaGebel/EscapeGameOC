package com.company.Controller.Strategy.Player;

import java.util.ArrayList;
import java.util.Scanner;
import com.company.Model.GameModel;
import com.company.Utility.PrintOutUtility;

/**
 * Classe User classe de l'utilisateur
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
     * @param generateNewCombination sert pour demander à l'utilisateur à saisir la combinaison encore une fois
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
     * Retourne la combinaison secrète
     * @return la combinaison secrète
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
     * Demande à l'utilisateur à saisir la combinaison
     * @return la combinaison saisi
     */
    private String askForCombination() {

        String result = "";
        do {
            scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                result = scanner.nextLine();

                if(result.length() != GameModel.getCombinationNum() || !checkNumberString(result)){
                    result = "";
                    PrintOutUtility.printOutMessageAndLog("Veillez choisir " + GameModel.getCombinationNum() + " chiffres entre 0 et 9.", "Illegal Choice", "info");
                }

            } else {
                PrintOutUtility.printOutMessageAndLog("Veillez choisir " + GameModel.getCombinationNum() + " chiffres entre 0 et 9.", "Illegal Choice", "info");
                result = "";
            }
        } while (result.equals(""));

        return result;
    }

    /**
     * Demande à l'utilisateur comparer la proposition de l’ordinateur
     * et la combinaison secrète
     * @param compareAnswer paramètre pour comparer la réponse de l'utilisateur et la combinaison secrète
     * @return reponse de l'utilisateur
     */
    @Override
    public String askToCompare(String compareAnswer)  {

        String result = "";
        do {
            scanner = new Scanner(System.in);

            if (scanner.hasNextLine()) {
                result = scanner.nextLine();

                if(!checkSymbolString(result)){

                    PrintOutUtility.printOutMessageAndLog("Veillez donner la reponse en utilisant les symbols +-=, (+) plus grand, plus petit (-) ou si c’est le bon (=).", "Illegal reponse: "+result, "info");
                    result = "";
                }
                else if (!compareAnswer.equals(result)){
                    PrintOutUtility.printOutMessageAndLog("La reponse n est pas bonne. Veillez essayer encore.", "Illegal reponse: "+result, "info");
                    result = "";
                }
            } else {
                PrintOutUtility.printOutMessageAndLog("Veillez donner la reponse en utilisant les symbols +-=, (+) plus grand, plus petit (-) ou si c’est le bon (=).", "Illegal reponse", "info");
                result = "";
            }
        } while (result.equals(""));

        return result;
    }


}
