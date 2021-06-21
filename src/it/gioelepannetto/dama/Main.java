package it.gioelepannetto.dama;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Game game = Game.startNew();

        while (!game.won()) {
            System.out.println(game);

            System.out.println("Position you want to move from:");
            final Position from = getPosFromUser(scanner);
            System.out.println("Position you want to move to:");
            final Position to = getPosFromUser(scanner);

            game.move(from, to);
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
