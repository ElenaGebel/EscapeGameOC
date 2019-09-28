package com.company.Controller.Strategy;

import com.company.Controller.Strategy.Player.AbstactPlayer;
import com.company.Controller.Strategy.Player.User;

public class Challenger implements IStrategy{


    public Challenger() {
    }

    @Override
    public void play(AbstactPlayer player1, AbstactPlayer player2) {
        System.out.println("Strategy Challenger Activated");

    }
}
