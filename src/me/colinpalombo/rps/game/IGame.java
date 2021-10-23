package me.colinpalombo.rps.game;

import me.colinpalombo.rps.player.IPlayer;

public interface IGame {

    void start();
    void end();

    IPlayer getPlayerOne();
    IPlayer getPlayerTwo();
}
