package com.company.Controller.Strategy;

import com.company.Controller.Strategy.Player.AbstactPlayer;
import com.company.Model.GameModel;
import com.company.Utility.PrintOutUtility;
/**
 * Classe responsable de la logique du mode Duel
 */
public class Duel implements IStrategy {
    /**
     * Constructeur Duel
     */
    public Duel() {
    }

    /**
     * Lance le jeu en mode Duel
     * @param player1 - intance of User
     * @param player2 - intance of Itelligence Artificielle
     */

    @Override
    public void play(AbstactPlayer player1, AbstactPlayer player2) {

        if(GameModel.isModeDeveloper() && GameModel.getAlgorithmType() == 1)
            PrintOutUtility.printOutMessageAndLog("algorithme de recherche binaire (affiché en mode developpeur).",
                    "", "info");
        else if(GameModel.isModeDeveloper() && GameModel.getAlgorithmType() != 1)
            PrintOutUtility.printOutMessageAndLog("algorithme de recherche random (affiché en mode developpeur).",
                    "", "info");

        PrintOutUtility.printOutMessageAndLog("Veillez saisir votre combinaison secrète : ",
                "Strategy Duel Activated", "info");

        player1.getSecretCombination();
        PrintOutUtility.printOutMessageAndLog("Votre combinaison secrète : " +
                player1.getSecretCombinationToString(), "User choosed a secret combination " +
                player1.getSecretCombinationToString(), "info");


        player2.getSecretCombination();

        String message = "L'intelligence artificielle a choisi sa combinaison secrète";
        if(GameModel.isModeDeveloper())
            message +=  ": " + player2.getSecretCombinationToString() + " (affiché en mode développeur)";

        PrintOutUtility.printOutMessageAndLog(message ,
                "IA generated a secret combination " +
                player2.getSecretCombinationToString(), "info");

        String resultPlayer1 = "";
        String resultPlayer2 = "";

        for(int i = 0; i <  GameModel.getTryNum(); i++){
            PrintOutUtility.printOutMessageAndLog("Veillez saisir votre proposition", "", "info");

            player1.getCombination(true, "");

            player2.getCombination(true, player1.compare(player1.getSecretCombination(),
                    player2.getCombination(false, "")));

            resultPlayer1 = player1.compare(player1.getCombination(false, ""), player2.getSecretCombination());
            resultPlayer2 = player2.compare(player2.getCombination(false, ""), player1.getSecretCombination());

            if(!resultPlayer1.equals("")  && resultPlayer1.length() > 0 && resultPlayer1.indexOf('+') == -1
                    &&  resultPlayer1.indexOf('-') == -1){
                PrintOutUtility.printOutMessageAndLog("Félicitations! Vous avez trouvé la combinaison secrète: " +
                                player1.getCombinationToString(),
                        "User winned " + player1.getCombinationToString(), "info");
                break;
            }else{
                if (i <  GameModel.getTryNum() - 1)
                    PrintOutUtility.printOutMessageAndLog("Votre proposition: "
                                    + player1.getCombinationToString() + " -> réponse: " + resultPlayer1,
                            "User suggestion: "+ player1.getCombinationToString() + " -> answer: " + resultPlayer1,
                            "info");
                resultPlayer1 = "";
            }

            if(!resultPlayer2.equals("") && resultPlayer2.length() > 0 && resultPlayer2.indexOf('+') == -1 &&
                    resultPlayer2.indexOf('-') == -1){
                PrintOutUtility.printOutMessageAndLog("L'intelligence artificielle a gagné. Votre combinaison secrète: " +
                        player1.getSecretCombinationToString(), "IA winned " +
                        player2.getCombinationToString(), "info");
                break;
            } else{
                if (i <  GameModel.getTryNum() - 1)
                    PrintOutUtility.printOutMessageAndLog("Proposition de IA: "+
                            player2.getCombinationToString() + " -> réponse: " + resultPlayer2,
                            "IA suggestion: "+ player2.getCombinationToString() +
                                    " -> answer :" + resultPlayer2, "info");

                resultPlayer2 = "";
            }
        }
        PrintOutUtility.printOutMessageAndLog("*******Game over*******", "Game over", "info");

        if(resultPlayer1.equals(""))
            PrintOutUtility.printOutMessageAndLog("Vous n'avez pas trouvé la combinaison secrète de l'intelligence artificielle: " +
                    player2.getSecretCombinationToString(), "User has not found the secret combination: "+
                    player2.getSecretCombinationToString(), "info");

        if(resultPlayer2.equals(""))
            PrintOutUtility.printOutMessageAndLog("L'intelligence artificielle n'a pas trouvé votre combinaison secrète: " +
                    player1.getSecretCombinationToString(), "IA has not found the secret combination: "+
                    player1.getSecretCombinationToString(), "info");
    }
}