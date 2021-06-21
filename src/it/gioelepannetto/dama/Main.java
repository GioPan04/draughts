package it.gioelepannetto.dama;

import it.gioelepannetto.dama.errors.GameError;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Game game = Game.startNew();

        while (!game.won()) {
            System.out.println(game);
            System.out.printf("Plays %s team %n", game.getTurn());

            System.out.println("Position you want to move from:");
            final Position from = getPosFromUser(scanner);
            System.out.println("Position you want to move to:");
            final Position to = getPosFromUser(scanner);

            try {
                game.move(from, to);
            } catch (GameError error) {
                System.out.println("You can't do that: " + error.detail);
            }

        }

        scanner.close();

    }

    private static Position getPosFromUser(Scanner scanner) {
        System.out.print("X: ");
        final int x = Integer.parseInt(scanner.nextLine());
        System.out.print("Y: ");
        final int y = Integer.parseInt(scanner.nextLine());
        return new Position(x, y);
    }
}
