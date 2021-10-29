package me.colinpalombo.rps.game;

import me.colinpalombo.rps.RPS;
import me.colinpalombo.rps.choice.Choice;
import me.colinpalombo.rps.player.Player;

import java.util.List;
import java.util.Optional;

public class GameImpl implements Game {

    private final Player playerOne;
    private final Player playerTwo;

    public GameImpl(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    @Override
    public void start() {
        System.out.printf("%s VS %s", playerOne.getName(), playerTwo.getName());

        if (this.getPlayerOne() == null || this.getPlayerTwo() == null) {
            this.end();
            return;
        }

        Choice playerOneChoice = this.askForPlayerChoice(this.playerOne);
        Choice playerTwoChoice = this.askForPlayerChoice(this.playerTwo);

        this.getPlayerOne().setChoice(playerOneChoice);
        System.out.printf("%s selected %s", this.playerOne.getName(), playerOneChoice.getDisplayName());

        this.getPlayerTwo().setChoice(playerTwoChoice);
        System.out.printf("\n%s selected %s", this.playerTwo.getName(), playerTwoChoice.getDisplayName());

        this.end();
    }

    @Override
    public void end() {
        Optional<Player[]> optionalWinners = this.getWinners();

        if (optionalWinners.isPresent()) {
            Player[] winners = optionalWinners.get();

            if (winners.length > 0) {
                System.out.println("\n----------------------------");
                if (winners.length > 1) {
                    // Tie
                    System.out.println("Game Tied!");
                } else {
                    Player winner = winners[0];

                    if (winner.equals(this.getPlayerOne())) {
                        // Player 1 Wins
                        System.out.printf("Player One (%s) Wins!\n", this.getPlayerOne().getName());
                    } else {
                        // Player 2 Wins
                        System.out.printf("Player Two (%s) Wins!\n", this.getPlayerTwo().getName());
                    }
                }
                System.out.println("----------------------------");
                System.out.println(" ");

                this.start();

                return;
            }
        }

        System.out.println("Something went wrong!");
    }

    public Optional<Player[]> getWinners() {
        Player[] winners = null;

        Player playerOne = this.getPlayerOne();
        Choice playerOneChoice = playerOne.getChoice();

        Player playerTwo = this.getPlayerTwo();
        Choice playerTwoChoice = playerTwo.getChoice();

        if (playerOneChoice != null && playerTwoChoice != null) {
            if (playerOneChoice.canBeat(playerTwoChoice)) {
                winners = new Player[] {playerOne};
            } else if (playerTwoChoice.canBeat(playerOneChoice)) {
                winners = new Player[] {playerTwo};
            } else {
                winners = new Player[] {playerOne, playerTwo};
            }
        }

        return Optional.ofNullable(winners);
    }

    public Choice askForPlayerChoice(Player player) {
        if (player.isAI()) {
            List<Choice> choices = Choice.choices;
            int randomChoiceIndex = RPS.RANDOM.nextInt(choices.size());
            Choice choice = choices.get(randomChoiceIndex);

            return choice;
        }

        System.out.printf("\n%s what is your choice (Rock (r), Paper (p), Scissors (s)): ", player.getName());
        String choiceString = RPS.SCANNER.nextLine();
        Optional<Choice> optionalChoice = Choice.getChoice.apply(choiceString);

        if (optionalChoice.isPresent()) {
            Choice choice = optionalChoice.get();

            return choice;
        } else {
            System.out.print("Invalid Choice!");

            return this.askForPlayerChoice(player);
        }
    }

    @Override
    public Player getPlayerOne() {
        return this.playerOne;
    }

    @Override
    public Player getPlayerTwo() {
        return this.playerTwo;
    }
}
