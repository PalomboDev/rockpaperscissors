package me.colinpalombo.rps.choice.choices;

import me.colinpalombo.rps.choice.IChoice;

public class Scissors implements IChoice {

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
    public IChoice getCanBeat() {
        return IChoice.PAPER;
    }
}
