package com.company.Controller;

import com.company.Controller.Strategy.IStrategy;
import com.company.Controller.Strategy.Player.ArtificialIntelligence;
import com.company.Controller.Strategy.Player.User;
import com.company.View.GameView;
import com.company.Model.GameModel;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class GameController {

    private Scanner scanner;
    private IStrategy currentStrategyInstance;

    public GameController() {


    }

    public void initGame()  {
        restoreDefault();

        GameView.printOutMessageAndLog("", "InitGame", "info");

        int strategyType = 0;
        GameView.printOutMessageAndLog("Pour commencer veillez choisir un mode de jeu: 1 - Challenger, 2 - Defenseur, 3 - Duel",
                "Menu of the game proposed", "info");
        do {
            scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                strategyType = scanner.nextInt();

                if (strategyType < 1 || strategyType > 3){
                    GameView.printOutMessageAndLog("Veuillez choisir le numero entre 1 et 3", "Illegal Choice", "info");
                    strategyType = 0;
                }
            } else {
                strategyType = 0;
                GameView.printOutMessageAndLog("Veuillez choisir le numero entre 1 et 3", "Illegal Choice", "info");

            }
        } while (strategyType == 0);

        GameView.printOutMessageAndLog("Vous avez choisi le mode de jeu "+ GameModel.getCurrentStrategyTypeName(),
                "StrategyType: " + GameModel.getCurrentStrategyTypeName(), "info");

        try {
            Class<?> newClass = Class.forName(String.format(GameModel.getStrategyClassPath() + GameModel.getCurrentStrategyTypeName()));
            try {
                currentStrategyInstance = (IStrategy) newClass.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                GameView.printOutMessageAndLog("Une erreur est survenu lors de l'exécution du jeu " + e.getMessage(),
                        "InstantiationException" + e.getMessage(), "error");
            } catch (IllegalAccessException e) {
                GameView.printOutMessageAndLog("Une erreur est survenu lors de l'exécution du jeu " + e.getMessage(),
                        "IllegalAccessException" + e.getMessage(), "error");

            } catch (InvocationTargetException e) {
                GameView.printOutMessageAndLog("Une erreur est survenu lors de l'exécution du jeu " + e.getMessage(),
                        "InvocationTargetException" + e.getMessage(), "error");

            } catch (NoSuchMethodException e) {
                GameView.printOutMessageAndLog("Une erreur est survenu lors de l'exécution du jeu " + e.getMessage(),
                        "NoSuchMethodException" + e.getMessage(), "error");

            }

        }catch(ClassNotFoundException e){
            GameView.printOutMessageAndLog("Une erreur est survenu lors de l'exécution du jeu " + e.getMessage(),
                            "Une erreur est survenu lors de l'exécution du jeu " + e.getMessage(), "error");
        }
        if (currentStrategyInstance != null)
            currentStrategyInstance.play(new User(), new ArtificialIntelligence());
        else
            GameView.printOutMessageAndLog("Une erreur est survenu lors de l'exécution du jeu",
                    "currentStrategyInstance is null", "error");

     }

     private void restoreDefault() {
        currentStrategyInstance = null;
        GameModel.setCurrentStrategyType(1);
    }


}
