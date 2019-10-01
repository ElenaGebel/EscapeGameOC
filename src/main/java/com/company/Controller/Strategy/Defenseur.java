package com.company.Controller.Strategy;

import com.company.Controller.Strategy.Player.AbstactPlayer;
import com.company.Controller.Strategy.Player.User;
import com.company.Model.GameModel;
import com.company.View.GameView;

public class Defenseur implements IStrategy {
    public Defenseur() {
    }

    @Override
    public void play(AbstactPlayer player1, AbstactPlayer player2) {

        GameView.printOutMessageAndLog("Veillez entrer votre combinaison secrète : ", "Strategy Defenseur Activated", "info");

        player1.getSecretCombination();
        GameView.printOutMessageAndLog("", "User entered a secret combination " + player1.getSecretCombinationToString(), "info");

        String result = "";

        for(int i = 0; i <  GameModel.getTryNum(); i++){

            player2.getCombination(true,
                    player1.compare(player1.getSecretCombination(), player2.getCombination(false, "")));

            GameView.printOutMessageAndLog("Votre combinaison secrète : " +  player1.getSecretCombinationToString() + ". Proposition de Itelligence Artificielle: " + player2.getCombinationToString(), "Itelligence Artificielle guessed a number " + player2.getCombinationToString(), "info");
            GameView.printOutMessageAndLog("Veillez donner la reponse en utilisant les symbols +-=, " +
                    "(+) plus grand, plus petit (-) ou si c’est le bon (=)", "", "info");

            result = player1.compare(player1.getSecretCombination(), player2.getCombination(false, ""));
            player1.askToCompare(result);

            if(result != "" && result.length() > 0 && result.indexOf('+') == -1 &&  result.indexOf('-') == -1){
                GameView.printOutMessageAndLog("Itelligence Artificielle a gagne. Votre combinaison secrète :" + player1.getSecretCombinationToString(), "User guessed a number " + player1.getCombinationToString(), "info");
                break;
            } else{
                if (i <  GameModel.getTryNum() - 1)
                    GameView.printOutMessageAndLog("Proposition: "+ player2.getCombinationToString() + " -> Réponse :" + result, "Proposition: "+ player2.getCombinationToString() + " -> Réponse :" + result, "info");

                result = "";
            }
        }
        if(result == "")
            GameView.printOutMessageAndLog("Game over. Vous avez gagne. Combinaison secrète : " + player1.getSecretCombinationToString(), "Game Over", "info");

    }
}
