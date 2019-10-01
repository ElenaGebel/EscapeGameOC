package com.company.Controller.Strategy;

import com.company.Controller.Strategy.Player.AbstactPlayer;
import com.company.Model.GameModel;
import com.company.View.GameView;

public class Duel implements IStrategy {
    public Duel() {
    }

    @Override
    public void play(AbstactPlayer player1, AbstactPlayer player2) {

        GameView.printOutMessageAndLog("Veillez entrer votre combinaison secrète : ",
                "Strategy Duel Activated", "info");

        player1.getSecretCombination();
        GameView.printOutMessageAndLog("Votre combinaison secrète : " +
                player1.getSecretCombinationToString(), "User choosed a secret combination " +
                player1.getSecretCombinationToString(), "info");


        player2.getSecretCombination();

        String message = "Itelligence Artificielle a choisi sa combinaison secrète";
        if(GameModel.isModeDevelopeur())
            message +=  ": " + player2.getSecretCombinationToString();

        GameView.printOutMessageAndLog(message ,
                "IA generated a secret combination " +
                player2.getSecretCombinationToString(), "info");

        String resultPlayer1 = "";
        String resultPlayer2 = "";

        for(int i = 0; i <  GameModel.getTryNum(); i++){
            GameView.printOutMessageAndLog("Veillez entrer votre proposition", "", "info");

            player1.getCombination(true, "");

            player2.getCombination(true, player1.compare(player1.getSecretCombination(),
                    player2.getCombination(false, "")));

          //  GameView.printOutMessageAndLog("Votre combinaison secrète : " +  player1.getSecretCombinationToString() + ". Proposition de Itelligence Artificielle: " + player2.getCombinationToString(), "Itelligence Artificielle guessed a number " + player2.getCombinationToString(), "info");

            resultPlayer1 = player1.compare(player1.getCombination(false, ""), player2.getSecretCombination());
            resultPlayer2 = player2.compare(player2.getCombination(false, ""), player1.getSecretCombination());



            if(resultPlayer1.equals("")  && resultPlayer1.length() > 0 && resultPlayer1.indexOf('+') == -1 &&  resultPlayer1.indexOf('-') == -1){
                GameView.printOutMessageAndLog("Felicitations! Vous avez trouve combinaison: " + player1.getCombinationToString(),
                        "User winned " + player1.getCombinationToString(), "info");
                break;
            }else{
                if (i <  GameModel.getTryNum() - 1)
                    GameView.printOutMessageAndLog("Votre proposition: "+ player1.getCombinationToString() + " -> Réponse: " +
                            resultPlayer1, "User proposition: "+ player1.getCombinationToString() + " -> Réponse: " + resultPlayer1,
                            "info");
                resultPlayer1 = "";
            }

            if(resultPlayer2.equals("") && resultPlayer2.length() > 0 && resultPlayer2.indexOf('+') == -1 &&  resultPlayer2.indexOf('-') == -1){
                GameView.printOutMessageAndLog("Itelligence Artificielle a gagne. Votre combinaison secrète :" +
                        player1.getSecretCombinationToString(), "IA winned " +
                        player2.getCombinationToString(), "info");
                break;
            } else{
                if (i <  GameModel.getTryNum() - 1)
                    GameView.printOutMessageAndLog("Proposition de IA: "+ player2.getCombinationToString() + " -> Réponse :" + resultPlayer2, "Proposition de IA: "+ player2.getCombinationToString() + " -> Réponse :" + resultPlayer2, "info");

                resultPlayer2 = "";
            }
        }
        GameView.printOutMessageAndLog("*******Game over*******", "Game over", "info");

        if(resultPlayer1.equals("") )
            GameView.printOutMessageAndLog("Vous n'avez pas trouve la combinaison secrète de l'Itelligence Artificielle: " +
                    player2.getSecretCombinationToString(), "User n'a pas trouve la combinaison secret: "+
                    player2.getSecretCombinationToString(), "info");

        if(resultPlayer2.equals("") )
            GameView.printOutMessageAndLog("L'itelligence artificielle n'a pas trouve votre combinaison secrète.: " +
                    player1.getSecretCombinationToString(), "IA n'a pas trouve la combinaison secret: "+
                    player1.getSecretCombinationToString(), "info");
    }
}