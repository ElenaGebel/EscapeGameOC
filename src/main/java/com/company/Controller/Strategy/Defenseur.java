package com.company.Controller.Strategy;

import com.company.Controller.Strategy.Player.AbstactPlayer;

public class Defenseur implements IStrategy {
    public Defenseur() {
    }

    @Override
    public void play(AbstactPlayer player1, AbstactPlayer player2) {
        System.out.println("Strategy Defenseur Activated");
    }
}
