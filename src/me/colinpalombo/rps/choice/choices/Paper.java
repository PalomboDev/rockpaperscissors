package me.colinpalombo.rps.choice.choices;

import me.colinpalombo.rps.choice.IChoice;

public class Paper implements IChoice {

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
    public IChoice getCanBeat() {
        return IChoice.ROCK;
    }
}
