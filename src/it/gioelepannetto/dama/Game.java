package it.gioelepannetto.dama;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int PLAYERS = 12;
    private static final int SIZE = 8;

    private List<Man> white;
    private List<Man> black;

    public Game(List<Man> white, List<Man> black) {
        this.white = white;
        this.black = black;
    }

    private Team getTeamAtPosition(Man.Position position) {
        for(Man man: white) {
            if(man.position.equals(position)) {
                System.out.printf("W: X: %d Y: %d %n", man.position.x, man.position.y);
                return Team.white;
            }
        }

        for(Man man: black) {
            if(man.position.equals(position)) {
                System.out.printf("B: X: %d Y: %d %n", man.position.x, man.position.y);
                return Team.black;
            }
        }

        return null;
    }

    public void move() {

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int y = 0; y < SIZE; y++) {
            stringBuilder.append("|");
            for(int x = 0; x < SIZE; x++) {
                final Team foundTeam = getTeamAtPosition(new Man.Position(x, y));
                if(foundTeam != null) {
                    stringBuilder.append(foundTeam == Team.white ? "W" : "B");
                } else {
                    stringBuilder.append(" ");
                }
                stringBuilder.append("|");
            }
            stringBuilder.append(System.getProperty("line.separator"));
        }

        return stringBuilder.toString();
    }

    static Game startNew() {
        List<Man> black = new ArrayList<>();
        List<Man> white = new ArrayList<>();

        for(int i = 0; i < PLAYERS; i++) {
            if(i % 2 == 0) {
                final Man.Position position1 = new Man.Position(i, 0);
                final Man man1 = new Man(position1, Man.Type.man);

                final Man.Position position2 = new Man.Position(i, 2);
                final Man man2 = new Man(position2, Man.Type.man);

                black.add(man1);
                black.add(man2);
            } else {
                final Man.Position position = new Man.Position(i, 1);
                final Man man = new Man(position, Man.Type.man);

                black.add(man);
            }

            if(i % 2 == 0) {
                final Man.Position position = new Man.Position(i, SIZE - 2);
                final Man man = new Man(position, Man.Type.man);

                white.add(man);
            } else {
                final Man.Position position1 = new Man.Position(i, SIZE - 1);
                final Man man1 = new Man(position1, Man.Type.man);

                final Man.Position position2 = new Man.Position(i, SIZE - 3);
                final Man man2 = new Man(position2, Man.Type.man);

                white.add(man1);
                white.add(man2);
            }
        }

        return new Game(white, black);
    }

    public enum Team {
        white, black
    }
}
