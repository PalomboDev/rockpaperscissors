package me.colinpalombo.rps.choice.choices;

import me.colinpalombo.rps.choice.IChoice;

public class Rock implements IChoice {

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
    public IChoice getCanBeat() {
        return IChoice.SCISSORS;
    }
}
