package me.colinpalombo.rps.choice;

import me.colinpalombo.rps.choice.choices.Paper;
import me.colinpalombo.rps.choice.choices.Rock;
import me.colinpalombo.rps.choice.choices.Scissors;

import java.util.*;
import java.util.function.Function;

public interface Choice {

    Choice ROCK = new Rock();
    Choice PAPER = new Paper();
    Choice SCISSORS = new Scissors();

    List<Choice> choices = new ArrayList<Choice>() {{
        add(ROCK);
        add(PAPER);
        add(SCISSORS);
    }};

    Function<String, Optional<Choice>> getChoice = s -> {
        Choice selectedChoice = null;

        for (Choice choice : choices) {
            if (Arrays.stream(choice.getInputKeys()).anyMatch(s::equalsIgnoreCase)) {
                selectedChoice = choice;
                break;
            }
        }

        return Optional.ofNullable(selectedChoice);
    };

    String[] getInputKeys();
    String getDisplayName();
    Choice getCanBeat();

    default boolean canBeat(Choice choice) {
        return this.getCanBeat().equals(choice);
    }
}
