package com.company;

import com.company.Controller.GameController;
import com.company.Loader.ConfigLoader;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.company.Model.GameModel;

import java.io.IOException;

public class Main {
     public static void main(String[] args){

         Logger LOGGER = LogManager.getLogger(Main.class.getName());
         ConfigLoader loader = new ConfigLoader();
         try{
             loader.load();
             if(GameModel.isModeDevelopeur())
                 LOGGER.debug("App is ready");
             GameController gameController = new GameController();
             gameController.initGame();
         }catch (IOException e)
         {

         }



    }
}


