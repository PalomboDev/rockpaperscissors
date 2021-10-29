package me.colinpalombo.rps.player;

import me.colinpalombo.rps.choice.Choice;

public class PlayerImpl implements Player {

    private final String name;
    private final boolean ai;

    private Choice choice;

    public PlayerImpl(String name, boolean ai) {
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
    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    @Override
    public Choice getChoice() {
        return this.choice;
    }
}
