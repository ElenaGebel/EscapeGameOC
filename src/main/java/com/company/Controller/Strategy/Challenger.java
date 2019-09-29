package com.company.Controller.Strategy;

import com.company.Controller.Strategy.Player.AbstactPlayer;
import com.company.Controller.Strategy.Player.User;
import com.company.View.GameView;
import com.company.Model.GameModel;

public class Challenger implements IStrategy{


    public Challenger() {
    }

    @Override
    public void play(AbstactPlayer player1, AbstactPlayer player2) {
        GameView.printOutMessageAndLog("", "Strategy Challenger Activated", "info");

        player2.getCombination();
        GameView.printOutMessageAndLog("Veillez entrer votre proposition", "IA generated number " + player2.getCombinationToString(), "info");

        User user = (User) player1;
        String result = "";

        for(int i=0; i <  GameModel.getTryNum(); i++){

            result = player2.compare(user.getCombination());

            if(result != "" && result.length() > 0 && result.indexOf('+') == -1 &&  result.indexOf('-') == -1){
                GameView.printOutMessageAndLog("Felicitations! Vous avez trouve combinaison" + user.getCombinationToString(), "User guessed a number " + user.getCombinationToString(), "info");
                break;
            }
            else{
                if (i <  GameModel.getTryNum() - 1)
                    GameView.printOutMessageAndLog("Proposition: "+ user.getCombinationToString() + " -> Réponse :" + result, "Proposition: "+ user.getCombinationToString() + " -> Réponse :" + result, "info");
                result = "";
            }
        }
        if(result == "")
            GameView.printOutMessageAndLog("Game over. Itelligence Artificielle a gagne. Combinaison secrète : " + player2.getCombinationToString(), "Game Over", "info");



    }
}
