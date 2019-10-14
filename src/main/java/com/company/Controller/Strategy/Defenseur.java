package com.company.Controller.Strategy;

import com.company.Controller.Strategy.Player.AbstactPlayer;
import com.company.Model.GameModel;
import com.company.Utility.PrintOutUtility;

/**
 * Classe responsable de la logique du mode Defenseur
 */
public class Defenseur implements IStrategy {
    /**
     * Constructeur Defenseur
     */
    public Defenseur() {
    }

    /**
     * Lance le jeu en mode Defenseur
     * @param player1 - intance of User
     * @param player2 - intance of Intelligence Artificielle
     */

    @Override
    public void play(AbstactPlayer player1, AbstactPlayer player2) {
        if(GameModel.isModeDeveloper() && GameModel.getAlgorithmType() == 1)
            PrintOutUtility.printOutMessageAndLog("algorithme de recherche binaire (affiché en mode développeur).",
                    "", "info");
        else if(GameModel.isModeDeveloper() && GameModel.getAlgorithmType() != 1)
            PrintOutUtility.printOutMessageAndLog("algorithme de recherche random (affiché en mode développeur).",
                    "", "info");

        PrintOutUtility.printOutMessageAndLog("Veuillez saisir votre combinaison secrète : ",
                "Strategy Defenseur Activated", "info");

        player1.getSecretCombination();
        PrintOutUtility.printOutMessageAndLog("", "User entered a secret combination "
                + player1.getSecretCombinationToString(), "info");

        String result = "";

        for(int i = 0; i <  GameModel.getTryNum(); i++){

            player2.getCombination(true,
                    player1.compare(player1.getSecretCombination(), player2.getCombination(false, "")));

            PrintOutUtility.printOutMessageAndLog("Votre combinaison secrète: "
                    +  player1.getSecretCombinationToString() + ". Proposition de l'intelligence artificielle: "
                    + player2.getCombinationToString(), "IA guessed a number "
                    + player2.getCombinationToString(), "info");
            PrintOutUtility.printOutMessageAndLog("Veuillez saisir la réponse en utilisant les caractères +-=, "
                            + System.lineSeparator() + "(+) plus grand, plus petit (-) ou si c’est le bon (=)", "", "info");

            result = player1.compare(player1.getSecretCombination(), player2.getCombination(false, ""));

            if(GameModel.isModeDeveloper())
                PrintOutUtility.printOutMessageAndLog("La bonne réponse: " + result + " (affiché en mode developpeur).",
                        "", "info");

            player1.askToCompare(result);

            if(!result.equals("") && result.length() > 0 && result.indexOf('+') == -1 &&  result.indexOf('-') == -1){
                PrintOutUtility.printOutMessageAndLog("L'intelligence artificielle a gagné. Votre combinaison secrète: "
                        + player1.getSecretCombinationToString(), "IA winned. User guessed a number "
                        + player1.getCombinationToString(), "info");
                break;
            } else{
                if (i <  GameModel.getTryNum() - 1)
                    PrintOutUtility.printOutMessageAndLog("Proposition: "+ player2.getCombinationToString()
                            + " -> réponse :" + result, "IA suggestion: "+ player2.getCombinationToString()
                            + " -> answer :" + result, "info");

                result = "";
            }
        }
        if(result.equals(""))
            PrintOutUtility.printOutMessageAndLog("Game over. Vous avez gagné. La combinaison secrète: "
                    + player1.getSecretCombinationToString(), "User winned. Game Over", "info");

    }
}
