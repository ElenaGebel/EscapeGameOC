package com.company.Controller;

import com.company.Controller.Strategy.IStrategy;
import com.company.Controller.Strategy.Player.ArtificialIntelligence;
import com.company.Controller.Strategy.Player.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.company.Model.GameModel;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class GameController {

    private Logger logger;
    private Scanner scanner;
    private IStrategy currentStrategyInstance;

    public GameController() {

        logger = LogManager.getLogger(GameController.class.getName());
    }

    public void initGame()  {
        restoreDefault();

        printOutMessageAndLog("Bienvenue dans le jeu",
                "InitGame", "info");

        int strategyType = 0;

        do {
            printOutMessageAndLog("Pour commencer veillez choisir un mode de jeu:%n 1 - Challenger, 2 - Defenseur, 3 - Duel",
                    "Menu of the game proposed", "info");

            scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                strategyType = scanner.nextInt();

                if (strategyType < 1 || strategyType > 3){
                    printOutMessageAndLog("Veuillez essayer encore", "Illegal Choice", "info");
                    strategyType = 0;
                }
            } else {
                strategyType = 0;
                printOutMessageAndLog("Veuillez essayer encore", "Illegal Choice", "info");

            }
        } while (strategyType == 0);

        GameModel.setCurrentStrategyType(strategyType);

        printOutMessageAndLog("Vous avez choisi un mod de jeu "+ GameModel.getCurrentStrategyTypeName(),
                "StrategyType choosed: " + GameModel.getCurrentStrategyTypeName(), "info");

        try {
            Class<?> newClass = Class.forName(String.format(GameModel.getStrategyClassPath() + GameModel.getCurrentStrategyTypeName()));
            try {
                currentStrategyInstance = (IStrategy) newClass.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                printOutMessageAndLog("Une erreur est survenu lors de l'exécution du jeu " + e.getMessage(),
                        "InstantiationException" + e.getMessage(), "error");
            } catch (IllegalAccessException e) {
                printOutMessageAndLog("Une erreur est survenu lors de l'exécution du jeu " + e.getMessage(),
                        "IllegalAccessException" + e.getMessage(), "error");

            } catch (InvocationTargetException e) {
                printOutMessageAndLog("Une erreur est survenu lors de l'exécution du jeu " + e.getMessage(),
                        "InvocationTargetException" + e.getMessage(), "error");

            } catch (NoSuchMethodException e) {
                printOutMessageAndLog("Une erreur est survenu lors de l'exécution du jeu " + e.getMessage(),
                        "NoSuchMethodException" + e.getMessage(), "error");

            }

        }catch(ClassNotFoundException e){
                    printOutMessageAndLog("Une erreur est survenu lors de l'exécution du jeu " + e.getMessage(),
                            "Une erreur est survenu lors de l'exécution du jeu " + e.getMessage(), "error");
        }
        if (currentStrategyInstance != null)
            currentStrategyInstance.play(new User(), new ArtificialIntelligence());
        else
            printOutMessageAndLog("Une erreur est survenu lors de l'exécution du jeu",
                    "currentStrategyInstance is null", "error");

     }
     private void printOutMessageAndLog(String outMessage,String logMessage, String logType){
        if(outMessage != "")
            System.out.println(outMessage);

         if((GameModel.isModeDevelopeur() || logType != "debug") && logMessage != ""){
             switch (logType) {
                 case "debug":
                     logger.debug(logMessage);
                     break;
                 case "error":
                     logger.error(logMessage);
                     break;
                 default:
                     logger.info(logMessage);
             }
         }

     }


     private void restoreDefault() {
        currentStrategyInstance = null;
        GameModel.setCurrentStrategyType(1);
    }


}
