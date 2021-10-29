package me.colinpalombo.rps.choice.choices;

import me.colinpalombo.rps.choice.Choice;

public class Scissors implements Choice {

    @Override
    public String[] getInputKeys() {
        return new String[] {
                "s",
                "scissors"
        };
    }

    @Override
    public String getDisplayName() {
        return "Scissors";
    }

    @Override
    public Choice getCanBeat() {
        return Choice.PAPER;
    }
}
