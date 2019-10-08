package com.company;

import com.company.Controller.GameController;
import com.company.Loader.ConfigLoader;
import com.company.Utility.PrintOutUtility;
import java.io.IOException;

/**
 * Classe Main le point d'entrée du programme.
 */
public class Main {

    /**
     * la première fonction exécutée lors du lancement du programme
     * Ici on crée une nouvelle instance de ConfigLoader et de GameController
     * et on lance le jeu
     */
     public static void main(String[] args){

         ConfigLoader loader = new ConfigLoader();
         try{
             loader.load();
             PrintOutUtility.printOutMessageAndLog( "Bienvenue dans le jeu", "", "info");

             GameController gameController = new GameController();
             gameController.initGames();
         }catch (IOException e)
         {
             PrintOutUtility.printOutMessageAndLog("Une erreur est survenue lors de l'exécution du jeu " +
                             e.getMessage(),
                     "" + e.getMessage(), "error");
         }
    }
}


