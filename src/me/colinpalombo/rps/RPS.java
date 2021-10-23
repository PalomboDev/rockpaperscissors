package me.colinpalombo.rps;

import me.colinpalombo.rps.game.Game;
import me.colinpalombo.rps.game.IGame;
import me.colinpalombo.rps.player.IPlayer;
import me.colinpalombo.rps.player.Player;

import java.util.Random;
import java.util.Scanner;

public class RPS {

    public static final Random RANDOM = new Random();
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("What is your name: ");

        String playerOneName = SCANNER.nextLine();
        IPlayer playerOne = new Player(playerOneName, false);

        // TODO: Support two players
        IPlayer playerTwo = new Player("AI", true);

        IGame game = new Game(playerOne, playerTwo);

        game.start();
    }
}
