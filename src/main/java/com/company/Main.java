package com.company;

import com.company.Controller.GameController;
import com.company.Loader.ConfigLoader;
import com.company.Utility.PrintOutUtility;
import java.io.IOException;

public class Main {
     public static void main(String[] args){

         ConfigLoader loader = new ConfigLoader();
         try{
             loader.load();
             PrintOutUtility.printOutMessageAndLog( "Bienvenue dans le jeu", "", "info");

             GameController gameController = new GameController();
             gameController.initGames();
         }catch (IOException e)
         {
             PrintOutUtility.printOutMessageAndLog("Une erreur est survenu lors de l'exécution du jeu " + e.getMessage(),
                     "" + e.getMessage(), "error");
         }
    }
}


