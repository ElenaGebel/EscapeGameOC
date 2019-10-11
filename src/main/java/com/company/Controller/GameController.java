package com.company.Controller;

import com.company.Controller.Strategy.IStrategy;
import com.company.Controller.Strategy.Player.ArtificialIntelligence;
import com.company.Controller.Strategy.Player.User;
import com.company.Utility.PrintOutUtility;
import com.company.Model.GameModel;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * Classe responsable de la logique du jeu
 */

public class GameController {

    private IStrategy currentStrategyInstance;
    private Boolean replay = true;

    /**
     * Constructeur GameController
     */
    public GameController() {

    }

    /**
     * Init le jeu pour la premier fois.
     * Propose rejouer le jeu.
     */
    public void initGames(){
        initGame(true);

        Scanner scanner;
        int choice;
        do {
            PrintOutUtility.printOutMessageAndLog("Veillez choisir: 1 - rejouer au même mode, " +
                            "2 - lancer un autre mode, 3 - quitter l'application",
                    "Play again proposed", "info");
            choice = 0;
            do {
                scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();

                    if (choice >= 1 && choice <= 3){
                        switch (choice) {
                            case 1:
                                initGame(false);
                                break;
                            case 2:
                                initGame(true);
                                break;
                            case 3:
                                replay = false;
                                break;
                        }
                    }
                    else{
                        PrintOutUtility.printOutMessageAndLog("Veuillez saisir un chiffre entre 1 et 3",
                                "Illegal answer when play again proposed", "info");
                        choice = 0;
                    }
                }
                else {
                    choice = 0;
                    PrintOutUtility.printOutMessageAndLog("Veuillez saisir un chiffre entre 1 et 3",
                            "Illegal answer when play again proposed", "info");
                }
            } while (choice == 0);
        } while (replay);
    }

    /**
     * Sert a creer une nouvelle classe Strategy en fonction de mode du jeu choisi
     * 1 - Challenger, 2 - Defenseur, 3 - Duel
     * @param askForStrategyType - parametre sert pour proposer choisir le mode du jeu ou pas
     */

    private void initGame(Boolean askForStrategyType)  {

        if (askForStrategyType || GameModel.getCurrentStrategyType() < 1 || GameModel.getCurrentStrategyType() > 3)
            askForStrategyType();

        PrintOutUtility.printOutMessageAndLog("", "InitGame", "info");
        String message = "Une erreur est survenue lors de l'exécution du jeu ";
        try {
            Class<?> newClass = Class.forName(GameModel.getStrategyClassPath() + GameModel.getCurrentStrategyTypeName());
            try {
                currentStrategyInstance = (IStrategy) newClass.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                PrintOutUtility.printOutMessageAndLog(message + e.getMessage(),
                        "InstantiationException" + e.getMessage(), "error");
            } catch (IllegalAccessException e) {
                PrintOutUtility.printOutMessageAndLog(message + e.getMessage(),
                        "IllegalAccessException" + e.getMessage(), "error");

            } catch (InvocationTargetException e) {
                PrintOutUtility.printOutMessageAndLog(message + e.getMessage(),
                        "InvocationTargetException" + e.getMessage(), "error");

            } catch (NoSuchMethodException e) {
                PrintOutUtility.printOutMessageAndLog(message + e.getMessage(),
                        "NoSuchMethodException" + e.getMessage(), "error");
            }

        }catch(ClassNotFoundException e){
            PrintOutUtility.printOutMessageAndLog(message + e.getMessage(),
                            "ClassNotFoundException " + e.getMessage(), "error");
        }
        if (currentStrategyInstance != null)
            currentStrategyInstance.play(new User(), new ArtificialIntelligence());
        else
            PrintOutUtility.printOutMessageAndLog(message, "currentStrategyInstance is null", "error");

     }

    /**
     * Propose de choisir un mode du jeu
     * 1 - Challenger, 2 - Defenseur, 3 - Duel
     */
     private void askForStrategyType(){
         restoreDefault();
         Scanner scanner;
         int strategyType = 0;
         PrintOutUtility.printOutMessageAndLog("Pour commencer veillez choisir un mode de jeu:" +
                         System.lineSeparator() + "1 - Challenger, 2 - Defenseur, 3 - Duel",
                 "Menu of the game proposed", "info");
         do {
             scanner = new Scanner(System.in);

             if (scanner.hasNextInt()) {
                 strategyType = scanner.nextInt();

                 if (strategyType < 1 || strategyType > 3){
                     PrintOutUtility.printOutMessageAndLog("Veuillez saisir un chiffre entre 1 et 3",
                             "Illegal answer when menu of the game proposed", "info");
                     strategyType = 0;
                 }
                 else{
                     GameModel.setCurrentStrategyType(strategyType);
                 }
             } else {
                 strategyType = 0;
                 PrintOutUtility.printOutMessageAndLog("Veuillez saisir un chiffre entre 1 et 3",
                         "Illegal answer when menu of the game proposed", "info");

             }
         } while (strategyType == 0);

         PrintOutUtility.printOutMessageAndLog("Vous avez choisi le mode de jeu "+ GameModel.getCurrentStrategyTypeName(),
                 "StrategyType choosed: " + GameModel.getCurrentStrategyTypeName(), "info");

     }

    /**
     * Set les parametres a zero
     */
     private void restoreDefault() {
        currentStrategyInstance = null;
        GameModel.setCurrentStrategyType(1);
    }


}
