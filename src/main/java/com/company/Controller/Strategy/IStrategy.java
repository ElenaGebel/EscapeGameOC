package com.company.Controller.Strategy;

import com.company.Controller.Strategy.Player.AbstactPlayer;
/**
 * interface IStrategy sert a realiser les differantes modes de jeu
 */
public interface IStrategy {

    /**
     * Lance un mode de jeu
     */
    void play(AbstactPlayer player1, AbstactPlayer player2);
}
