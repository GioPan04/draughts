package it.gioelepannetto.dama;

import it.gioelepannetto.dama.errors.GameError;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Game game = Game.startNew();

        try {
            game.move(new Position(1,5), new Position(2, 4));
            game.move(new Position(0,2), new Position(1, 3));
            game.move(new Position(2,4), new Position(0, 2));
        } catch (GameError e) {
            System.out.println(e.detail);
        }

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

        System.out.printf("%s team won!", game.winner());

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
