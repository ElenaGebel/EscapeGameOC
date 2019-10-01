package com.company.Controller.Strategy;

import com.company.Controller.Strategy.Player.AbstactPlayer;
import com.company.Controller.Strategy.Player.User;
import com.company.Model.GameModel;
import com.company.View.GameView;

public class Duel implements IStrategy {
    public Duel() {
    }

    @Override
    public void play(AbstactPlayer player1, AbstactPlayer player2) {

        User user = (User) player1;
        GameView.printOutMessageAndLog("Veillez entrer votre combinaison secrète : ", "Strategy Defenseur Activated", "info");

        user.getSecretCombination();
        GameView.printOutMessageAndLog("Votre combinaison secrète : " +  user.getCombinationToString(), "User guessed a secret combination " + user.getCombinationToString(), "info");

        player2.getCombination(true,"");

        String resultPlayer1 = "";
        String resultPlayer2 = "";

        for(int i = 0; i <  GameModel.getTryNum(); i++){

            GameView.printOutMessageAndLog("Veillez entrer votre proposition", "IA generated number " + player2.getCombinationToString(), "info");
            user.getCombination(true, "");

            player2.getCombination(true, user.compare(player2.getCombination(false, "")));

            GameView.printOutMessageAndLog("Votre combinaison secrète : " +  user.getCombinationToString() + ". Proposition de Itelligence Artificielle: " + player2.getCombinationToString(), "Itelligence Artificielle guessed a number " + player2.getCombinationToString(), "info");

            resultPlayer1 = user.compare(player2.getCombination(false, ""));
            resultPlayer2 = player2.compare(user.getCombination(false, ""));


            if(result != "" && result.length() > 0 && result.indexOf('+') == -1 &&  result.indexOf('-') == -1){
                GameView.printOutMessageAndLog("Itelligence Artificielle a gagne. Votre combinaison secrète :" + user.getCombinationToString(), "User guessed a number " + user.getCombinationToString(), "info");
                break;
            } else{
                if (i <  GameModel.getTryNum() - 1)
                    GameView.printOutMessageAndLog("Proposition: "+ player2.getCombinationToString() + " -> Réponse :" + result, "Proposition: "+ player2.getCombinationToString() + " -> Réponse :" + result, "info");

                result = "";
            }
        }
        if(result == "")
            GameView.printOutMessageAndLog("Game over. Vous avez gagne. Combinaison secrète : " + user.getCombinationToString(), "Game Over", "info");
    }
}