package me.colinpalombo.rps.choice.choices;

import me.colinpalombo.rps.choice.Choice;

public class Paper implements Choice {

    @Override
    public String[] getInputKeys() {
        return new String[] {
                "p",
                "paper"
        };
    }

    @Override
    public String getDisplayName() {
        return "Paper";
    }

    @Override
    public Choice getCanBeat() {
        return Choice.ROCK;
    }
}
