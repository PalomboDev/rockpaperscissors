package me.colinpalombo.rps.game;

import me.colinpalombo.rps.RPS;
import me.colinpalombo.rps.choice.IChoice;
import me.colinpalombo.rps.player.IPlayer;

import java.util.List;
import java.util.Optional;

public class Game implements IGame {

    private final IPlayer playerOne;
    private final IPlayer playerTwo;

    public Game(IPlayer playerOne, IPlayer playerTwo) {
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

        IChoice playerOneChoice = this.askForPlayerChoice(this.playerOne);
        IChoice playerTwoChoice = this.askForPlayerChoice(this.playerTwo);

        this.getPlayerOne().setChoice(playerOneChoice);
        System.out.printf("%s selected %s", this.playerOne.getName(), playerOneChoice.getDisplayName());

        this.getPlayerTwo().setChoice(playerTwoChoice);
        System.out.printf("\n%s selected %s", this.playerTwo.getName(), playerTwoChoice.getDisplayName());

        this.end();
    }

    @Override
    public void end() {
        Optional<IPlayer[]> optionalWinners = this.getWinners();

        if (optionalWinners.isPresent()) {
            IPlayer[] winners = optionalWinners.get();

            if (winners.length > 0) {
                System.out.println("\n----------------------------");
                if (winners.length > 1) {
                    // Tie
                    System.out.println("Game Tied!");
                } else {
                    IPlayer winner = winners[0];

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

    public Optional<IPlayer[]> getWinners() {
        IPlayer[] winners = null;

        IPlayer playerOne = this.getPlayerOne();
        IChoice playerOneChoice = playerOne.getChoice();

        IPlayer playerTwo = this.getPlayerTwo();
        IChoice playerTwoChoice = playerTwo.getChoice();

        if (playerOneChoice != null && playerTwoChoice != null) {
            if (playerOneChoice.canBeat(playerTwoChoice)) {
                winners = new IPlayer[] {playerOne};
            } else if (playerTwoChoice.canBeat(playerOneChoice)) {
                winners = new IPlayer[] {playerTwo};
            } else {
                winners = new IPlayer[] {playerOne, playerTwo};
            }
        }

        return Optional.ofNullable(winners);
    }

    public IChoice askForPlayerChoice(IPlayer player) {
        if (player.isAI()) {
            List<IChoice> choices = IChoice.choices;
            int randomChoiceIndex = RPS.RANDOM.nextInt(choices.size());
            IChoice choice = choices.get(randomChoiceIndex);

            return choice;
        }

        System.out.printf("\n%s what is your choice (Rock (r), Paper (p), Scissors (s)): ", player.getName());
        String choiceString = RPS.SCANNER.nextLine();
        Optional<IChoice> optionalChoice = IChoice.getChoice.apply(choiceString);

        if (optionalChoice.isPresent()) {
            IChoice choice = optionalChoice.get();

            return choice;
        } else {
            System.out.print("Invalid Choice!");

            return this.askForPlayerChoice(player);
        }
    }

    @Override
    public IPlayer getPlayerOne() {
        return this.playerOne;
    }

    @Override
    public IPlayer getPlayerTwo() {
        return this.playerTwo;
    }
}
