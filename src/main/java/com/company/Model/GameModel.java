package com.company.Model;

/**
 * Classe Modele represente les donnees de l'application
 */
public final class GameModel {

    private static Boolean modeDeveloper;
    private static int tryNum;
    private static int combinationNum;

    // 1 pour algorithme binaire et 2 pour algorithme random
    private static int algorithmType;

    private static int currentStrategyType;
    private static String configPath;
    private static String[] strategyTypeArray;
    private static String strategyClassPath;
    private static String currentStrategyTypeName;

    private static GameModel instance = new GameModel();
    /**
     * Constructeur GameModel
     */
    private GameModel() {
        combinationNum=4;
        tryNum=4;
        modeDeveloper=false;
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

    public static int getAlgorithmType() {
        return algorithmType;
    }

    public static void setAlgorithmType(int algorithmType)
    {
        GameModel.algorithmType = algorithmType;
    }


    public static void setCurrentStrategyType(int currentStrategyType) {
        if( currentStrategyType >= 1 && currentStrategyType <= 3)
            GameModel.currentStrategyType = currentStrategyType;
        else
            GameModel.currentStrategyType = 1;
        currentStrategyTypeName = strategyTypeArray[GameModel.currentStrategyType-1];
    }

    public static int getCurrentStrategyType() {
        return currentStrategyType;
    }

    public static Boolean isModeDeveloper() {

        return modeDeveloper;
    }

    public static void setModeDeveloper(Boolean modeDeveloper) {

        GameModel.modeDeveloper = modeDeveloper;
    }

    public static int getTryNum() {

        return tryNum;
    }

    public static void setTryNum(int tryNum) {
        if(tryNum > 0)
            GameModel.tryNum = tryNum;
        else
            GameModel.tryNum = 1;
    }

    public static int getCombinationNum() {

        return combinationNum;
    }

    public static void setCombinationNum(int combinationNum) {

        if(combinationNum > 0)
            GameModel.combinationNum = combinationNum;
        else
            GameModel.combinationNum = 1;
    }

}
