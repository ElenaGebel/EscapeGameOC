package com.company.Loader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.company.Model.GameModel;
import com.company.Utility.PrintOutUtility;

public class ConfigLoader {

    private String result = "";
    private InputStream inputStream;
    private String configName;
    private Properties properties;

    /**
     * Classe ConfigLoader est responsable pour télécharger le fichier de configuration et sauvegarder
     * les paramètres dans la classe Modéle.
     */
    public ConfigLoader() {
        configName = GameModel.getConfigPath();
    }

    /**
     *  Télécharge le fichier de configuration et sauvegarde
     *  les paramètres dans la classe Modéle.
     */
    public void load() throws IOException {

        inputStream = getClass().getClassLoader().getResourceAsStream(configName);
        try {
            properties = new Properties();

            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + configName + "' is not found in the classpath");
            }

            int combinationNum;
            try {
                combinationNum = Integer.parseInt(properties.getProperty("combinationNum"));
            }
            catch (NumberFormatException e)
            {
                combinationNum = 4;
            }

            int tryNum;
            try {
                tryNum = Integer.parseInt(properties.getProperty("tryNum"));
            }
            catch (NumberFormatException e)
            {
                tryNum = 3;
            }

            Boolean modeDeveloper;

            try {
                modeDeveloper = Boolean.parseBoolean(properties.getProperty("modeDeveloper"));
            }
            catch (NumberFormatException e)
            {
                modeDeveloper = false;
            }

            int algorithmType;
            try {
                algorithmType = Integer.parseInt(properties.getProperty("algorithmType"));
            }
            catch (NumberFormatException e)
            {
                algorithmType = 1;
            }

            GameModel.setCombinationNum(combinationNum);
            GameModel.setTryNum(tryNum);
            GameModel.setModeDeveloper(modeDeveloper);
            GameModel.setAlgorithmType(algorithmType);

            PrintOutUtility.printOutMessageAndLog("", "Config loaded combinationNum=" + combinationNum + " tryNum=" + tryNum, "info");

        } catch (Exception e) {
            PrintOutUtility.printOutMessageAndLog("Une erreur est survenue lors de l'exécution du jeu " + e.getMessage(),
                    "Exception" + e.getMessage(), "error");
        } finally {
            inputStream.close();
        }
    }

}
