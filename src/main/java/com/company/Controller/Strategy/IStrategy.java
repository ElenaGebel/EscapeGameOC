package com.company.Controller.Strategy;

import com.company.Controller.Strategy.Player.AbstactPlayer;

public interface IStrategy {

    /**
     * Lance le jeux
     */
    void play(AbstactPlayer player1, AbstactPlayer player2);
}
