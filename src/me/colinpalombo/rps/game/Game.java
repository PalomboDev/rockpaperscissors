package me.colinpalombo.rps.game;

import me.colinpalombo.rps.player.Player;

public interface Game {

    void start();
    void end();

    Player getPlayerOne();
    Player getPlayerTwo();
}
