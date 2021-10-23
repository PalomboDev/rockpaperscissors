package me.colinpalombo.rps.choice;

import me.colinpalombo.rps.choice.choices.Paper;
import me.colinpalombo.rps.choice.choices.Rock;
import me.colinpalombo.rps.choice.choices.Scissors;

import java.util.*;
import java.util.function.Function;

public interface IChoice {

    IChoice ROCK = new Rock();
    IChoice PAPER = new Paper();
    IChoice SCISSORS = new Scissors();

    List<IChoice> choices = new ArrayList<IChoice>() {{
        add(ROCK);
        add(PAPER);
        add(SCISSORS);
    }};

    Function<String, Optional<IChoice>> getChoice = s -> {
        IChoice selectedChoice = null;

        for (IChoice choice : choices) {
            if (Arrays.stream(choice.getInputKeys()).anyMatch(s::equalsIgnoreCase)) {
                selectedChoice = choice;
                break;
            }
        }

        return Optional.ofNullable(selectedChoice);
    };

    String[] getInputKeys();
    String getDisplayName();
    IChoice getCanBeat();

    default boolean canBeat(IChoice choice) {
        return this.getCanBeat().equals(choice);
    }
}
