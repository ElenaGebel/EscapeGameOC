package com.company;

import com.company.Controller.GameController;
import com.company.Loader.ConfigLoader;

import com.company.Model.GameModel;
import com.company.View.GameView;
import java.io.IOException;

public class Main {
     public static void main(String[] args){

         ConfigLoader loader = new ConfigLoader();
         try{
             loader.load();
             GameView.printOutMessageAndLog( "Bienvenue dans le jeu", "", "info");

             GameController gameController = new GameController();
             gameController.initGame();
         }catch (IOException e)
         {

         }
    }
}


