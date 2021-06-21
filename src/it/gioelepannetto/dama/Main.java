package it.gioelepannetto.dama;

public class Main {

    public static void main(String[] args) {
        Game game = Game.startNew();
        System.out.println(game);

        game.move(new Position(1, 5), new Position(1, 2));
        System.out.println(game);
    }
}
