package com.company.Controller.Strategy;

import com.company.Controller.Strategy.Player.AbstactPlayer;

public class Duel implements IStrategy {
    public Duel() {
    }

    @Override
    public void play(AbstactPlayer player1, AbstactPlayer player2) {
        System.out.println("Strategy Duel Activated");
    }
}
