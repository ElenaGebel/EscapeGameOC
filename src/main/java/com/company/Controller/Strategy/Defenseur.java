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

        player1.getCombination(true);
        GameView.printOutMessageAndLog("Votre combinaison secrète : " +  player1.getCombinationToString(), "User guessed a secret combination " + player1.getCombinationToString(), "info");

        User user = (User) player1;
        String result = "";

        for(int i = 0; i <  GameModel.getTryNum(); i++){
            player2.getCombination(true);
            GameView.printOutMessageAndLog("Proposition de Itelligence Artificielle: " + player2.getCombinationToString(), "Itelligence Artificielle guessed a number " + player2.getCombinationToString(), "info");
            result = player2.compare(user.getCombination(false));
            user.askUserForReponse(result);

            if(result != "" && result.length() > 0 && result.indexOf('+') == -1 &&  result.indexOf('-') == -1){
                GameView.printOutMessageAndLog("Itelligence Artificielle a gagne. Votre combinaison secrète :" + player2.getCombinationToString(), "User guessed a number " + player2.getCombinationToString(), "info");
                break;
            }
            else{
                if (i <  GameModel.getTryNum() - 1)
                    GameView.printOutMessageAndLog("Proposition: "+ player2.getCombinationToString() + " -> Réponse :" + result, "Proposition: "+ player2.getCombinationToString() + " -> Réponse :" + result, "info");
                result = "";
            }
        }
        if(result == "")
            GameView.printOutMessageAndLog("Game over. Vous avez gagne. Combinaison secrète : " + player2.getCombinationToString(), "Game Over", "info");

    }
}
