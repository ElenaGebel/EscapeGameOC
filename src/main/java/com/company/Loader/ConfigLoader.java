package com.company.Loader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import com.company.Model.GameModel;


public class ConfigLoader {

    private String result = "";
    private InputStream inputStream;
    private String configName;
    private Properties properties;

    public ConfigLoader() {
        configName = GameModel.getConfigPath();
    }

        public void load() throws IOException {

            inputStream = getClass().getClassLoader().getResourceAsStream(configName);
            try {
                properties = new Properties();

                if (inputStream != null) {
                    properties.load(inputStream);
                } else {
                    throw new FileNotFoundException("property file '" + configName + "' not found in the classpath");
                }

                Date time = new Date(System.currentTimeMillis());
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
                Boolean modeDevelopeur = Boolean.parseBoolean(properties.getProperty("modeDevelopeur"));

                GameModel.setCombinationNum(combinationNum);
                GameModel.setTryNum(tryNum);
                GameModel.setModeDevelopeur(modeDevelopeur);

                if(modeDevelopeur)
                   System.out.println("Config loaded combinationNum=" + combinationNum + " tryNum=" + tryNum);

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            } finally {
                inputStream.close();
            }
        }

}
