package com.company.Utility;

import com.company.Model.GameModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PrintOutUtility {
    public static Logger logger = LogManager.getLogger();;

    private PrintOutUtility() {

    }

    public static void printOutMessageAndLog(String outMessage,String logMessage, String logType){

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
}

