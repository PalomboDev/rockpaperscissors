package me.colinpalombo.rps.choice.choices;

import me.colinpalombo.rps.choice.Choice;

public class Rock implements Choice {

    @Override
    public String[] getInputKeys() {
        return new String[] {
                "r",
                "rock"
        };
    }

    @Override
    public String getDisplayName() {
        return "Rock";
    }

    @Override
    public Choice getCanBeat() {
        return Choice.SCISSORS;
    }
}
