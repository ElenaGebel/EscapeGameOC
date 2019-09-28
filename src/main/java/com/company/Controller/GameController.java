package com.company.Controller;

import com.company.Controller.Strategy.Challenger;
import com.company.Controller.Strategy.Defenseur;
import com.company.Controller.Strategy.Duel;
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
        System.out.println("Bienvenue dans le jeu");
        logger.info("InitGame");

        int strategyType = 0;

        do {
            System.out.println("Pour commencer veillez choisir un mode de jeu:");
            System.out.println("1 - Challenger, 2 - Defenseur, 3 - Duel");

            scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                strategyType = scanner.nextInt();

                if (strategyType < 1 || strategyType > 3){
                    System.out.println("Veuillez essayer encore(\"1 - Challenger, 2 - Defenseur, 3 - Duel\")");
                    logger.debug("Illegal Choice");
                    strategyType = 0;
                }
            } else {
                strategyType = 0;
                System.out.println("Veuillez essayer encore(\"1 - Challenger, 2 - Defenseur, 3 - Duel\")");
                logger.debug("Illegal Choice");
            }
        } while (strategyType == 0);

        GameModel.setCurrentStrategyType(strategyType);

        if(GameModel.isModeDevelopeur()){
            logger.info("StrategyType choosed: " + strategyType);
        }


        try {
            Class<?> newClass = Class.forName(String.format(GameModel.getStrategyClassPath() + GameModel.getCurrentStrategyTypeName()]));
            try {
                currentStrategyInstance = (IStrategy) newClass.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                System.out.println("InstantiationException "+ e.getMessage());
            } catch (IllegalAccessException e) {
                System.out.println("IllegalAccessException "+ e.getMessage());
            } catch (InvocationTargetException e) {
                System.out.println("InvocationTargetException "+ e.getMessage());
            } catch (NoSuchMethodException e) {
                System.out.println("NoSuchMethodException "+ e.getMessage());
            }

        }catch(ClassNotFoundException e){
                    System.out.println("ClassNotFoundException "+ e.getMessage());
        }
        if (currentStrategyInstance != null){
            currentStrategyInstance.play(new User(), new ArtificialIntelligence());
        }
     }

    private void restoreDefault() {
        currentStrategyInstance = null;
        GameModel.setCurrentStrategyType(1);
    }


}
