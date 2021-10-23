package me.colinpalombo.rps.player;

import me.colinpalombo.rps.choice.IChoice;

public class Player implements IPlayer {

    private final String name;
    private final boolean ai;

    private IChoice choice;

    public Player(String name, boolean ai) {
        this.name = name;
        this.ai = ai;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isAI() {
        return this.ai;
    }

    @Override
    public void setChoice(IChoice choice) {
        this.choice = choice;
    }

    @Override
    public IChoice getChoice() {
        return this.choice;
    }
}
