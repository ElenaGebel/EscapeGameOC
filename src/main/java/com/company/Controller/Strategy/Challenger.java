package com.company.Controller.Strategy;

import com.company.Controller.Strategy.Player.AbstactPlayer;
import com.company.Utility.PrintOutUtility;
import com.company.Model.GameModel;

public class Challenger implements IStrategy{


    public Challenger() {
    }

    @Override
    public void play(AbstactPlayer player1, AbstactPlayer player2) {
        PrintOutUtility.printOutMessageAndLog("", "Strategy Challenger Activated", "info");

        player2.getSecretCombination();

        String message = "Itelligence Artificielle a choisi sa combinaison secrète";
        if(GameModel.isModeDevelopeur())
            message +=  ": " + player2.getSecretCombinationToString() + ". ";
        else
            message += ". ";

        PrintOutUtility.printOutMessageAndLog(message + "Veillez entrer votre proposition.", "IA generated a number " + player2.getSecretCombinationToString(), "info");

      //  User user = (User) player1;
        String result = "";

        for(int i=0; i <  GameModel.getTryNum(); i++){

            result = player2.compare(player2.getSecretCombination(), player1.getCombination(true, ""));

            if(result != "" && result.length() > 0 && result.indexOf('+') == -1 &&  result.indexOf('-') == -1){
                PrintOutUtility.printOutMessageAndLog("Felicitations! Vous avez trouve combinaison: " + player1.getCombinationToString(), "User guessed a number " + player1.getCombinationToString(), "info");
                break;
            }
            else{
                if (i <  GameModel.getTryNum() - 1)
                    PrintOutUtility.printOutMessageAndLog("Proposition: "+ player1.getCombinationToString() + " -> Réponse: " + result, "Proposition: "+ player1.getCombinationToString() + " -> Réponse: " + result, "info");
                result = "";
            }
        }
        if(result == "")
            PrintOutUtility.printOutMessageAndLog("Game over. Itelligence Artificielle a gagne. Combinaison secrète: " + player2.getSecretCombinationToString(), "Game Over", "info");



    }
}
