package com.company.Model;

public final class GameModel {

    private static Boolean modeDevelopeur;
    private static int tryNum;
    private static int combinationNum;



    private static int currentStrategyType;
    private static String configPath;
    private static String[] strategyTypeArray;
    private static String strategyClassPath;
    private static String currentStrategyTypeName;


    private static GameModel instance = new GameModel();

    private GameModel() {
        combinationNum=4;
        tryNum=4;
        modeDevelopeur=false;
        configPath = "config.properties";
        strategyTypeArray = new String[]{StrategyType.CHALLENGER, StrategyType.DEFENSEUR, StrategyType.DUEL};
        strategyClassPath = "com.company.Controller.Strategy.";
        currentStrategyType = 1;
        currentStrategyTypeName = strategyTypeArray[currentStrategyType];
    }

    public static String getCurrentStrategyTypeName() {
        return currentStrategyTypeName;
    }

    public static String[] getStrategyTypeArray() {
        return strategyTypeArray;
    }

    public static String getStrategyClassPath() {
        return strategyClassPath;
    }

    public static String getConfigPath() {

        return configPath;
    }


    public static void setCurrentStrategyType(int currentStrategyType) {
        if( currentStrategyType >= 1 && currentStrategyType <= 3)
            GameModel.currentStrategyType = currentStrategyType;
        else
            GameModel.currentStrategyType = 1;
        currentStrategyTypeName = strategyTypeArray[currentStrategyType-1];
    }

    public static int getCurrentStrategyType() {
        return currentStrategyType;
    }

    public static Boolean isModeDevelopeur() {

        return modeDevelopeur;
    }

    public static void setModeDevelopeur(Boolean modeDevelopeur) {

        GameModel.modeDevelopeur = modeDevelopeur;
    }

    public static int getTryNum() {

        return tryNum;
    }

    public static void setTryNum(int tryNum) {

        GameModel.tryNum = tryNum;
    }

    public static int getCombinationNum() {

        return combinationNum;
    }

    public static void setCombinationNum(int combinationNum) {

        GameModel.combinationNum = combinationNum;
    }

}
