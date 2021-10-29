package me.colinpalombo.rps;

import me.colinpalombo.rps.game.GameImpl;
import me.colinpalombo.rps.game.Game;
import me.colinpalombo.rps.player.Player;
import me.colinpalombo.rps.player.PlayerImpl;

import java.util.Random;
import java.util.Scanner;

public class RPS {

    public static final Random RANDOM = new Random();
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("What is your name: ");

        String playerOneName = SCANNER.nextLine();
        Player playerOne = new PlayerImpl(playerOneName, false);

        // TODO: Support two players
        Player playerTwo = new PlayerImpl("AI", true);

        Game game = new GameImpl(playerOne, playerTwo);

        game.start();
    }
}
