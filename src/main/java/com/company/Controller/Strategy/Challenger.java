package com.company.Controller.Strategy;

import com.company.Controller.Strategy.Player.AbstactPlayer;
import com.company.Utility.PrintOutUtility;
import com.company.Model.GameModel;
/**
 * Classe responsable de la logique du mode Challenger
 */
public class Challenger implements IStrategy{

    /**
     * Constructeur Challenger
     */
    public Challenger() {
    }
    /**
     * Lance le jeu en mode Challenger
     * @param player1 - intance of User
     * @param player2 - intance of Itelligence Artificielle
     */
    @Override
    public void play(AbstactPlayer player1, AbstactPlayer player2) {
        PrintOutUtility.printOutMessageAndLog("", "Strategy Challenger Activated", "info");

        player2.getSecretCombination();

        String message = "L’intelligence artificielle a choisi sa combinaison secrète";
        if(GameModel.isModeDeveloper())
            message +=  ": " + player2.getSecretCombinationToString() + " (affiché en mode developpeur).";
        else
            message += ". ";

        PrintOutUtility.printOutMessageAndLog(message + System.lineSeparator() + "Veillez saisir votre proposition.",
                "IA generated a number " + player2.getSecretCombinationToString(), "info");

      //  User user = (User) player1;
        String result = "";

        for(int i=0; i <  GameModel.getTryNum(); i++){

            result = player2.compare(player2.getSecretCombination(), player1.getCombination(true, ""));

            if(result != "" && result.length() > 0 && result.indexOf('+') == -1 &&  result.indexOf('-') == -1){
                PrintOutUtility.printOutMessageAndLog("Félicitations! Vous avez trouvé combinaison: "
                        + player1.getCombinationToString(), "User winned. User guessed a number "
                        + player1.getCombinationToString(), "info");
                break;
            }
            else{
                if (i <  GameModel.getTryNum() - 1)
                    PrintOutUtility.printOutMessageAndLog("Proposition: "+ player1.getCombinationToString() +
                            " -> réponse: " + result, "User suggestion: "+ player1.getCombinationToString()
                            + " -> answer: " + result, "info");
                result = "";
            }
        }
        if(result == "")
            PrintOutUtility.printOutMessageAndLog("Game over. L’intelligence artificielle a gagné. " +
                    "Combinaison secrète: " + player2.getSecretCombinationToString(), "Game Over. IA winned.", "info");



    }
}
