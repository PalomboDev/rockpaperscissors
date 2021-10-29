package me.colinpalombo.rps.player;

import me.colinpalombo.rps.choice.Choice;

public interface Player {

    String getName();
    boolean isAI();
    void setChoice(Choice choice);
    Choice getChoice();
}
