package com.company.Utility;

import com.company.Model.GameModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Classe PrintOutUtility Enregistre le log et
 * affiche le texte dans la console.
 */

public final class PrintOutUtility {
    private static Logger logger = LogManager.getLogger();
    /**
     * Constructeur PrintOutUtility
     */
    private PrintOutUtility() {

    }

    /**
     * Classe PrintOutUtility Enregistre le log et
     * affiche le texte dans la console.
     * @param outMessage message a afficher dans la console
     * @param logMessage message pour enregistrer dans le log
     * @param logType type de log: debug, error ou info
     */
    public static void printOutMessageAndLog(String outMessage,String logMessage, String logType){

        if(!outMessage.equals(""))
            System.out.println(outMessage);

        if((GameModel.isModeDeveloper() || !logType.equals("debug")) && !logMessage.equals("")){
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
}

