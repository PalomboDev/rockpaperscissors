package me.colinpalombo.rps.player;

import me.colinpalombo.rps.choice.IChoice;

public interface IPlayer {

    String getName();
    boolean isAI();
    void setChoice(IChoice choice);
    IChoice getChoice();
}
