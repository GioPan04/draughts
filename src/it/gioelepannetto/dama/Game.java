package it.gioelepannetto.dama;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int PLAYERS = 12;
    private static final int SIZE = 8;

    private List<Man> men;

    public Game(List<Man> men) {
        this.men = men;
    }

    private Team getTeamAtPosition(Position position) {
        for(Man man: men) {
            if(man.position.equals(position)) {
                return man.team;
            }
        }

        return null;
    }

    private Man getMan(Position pos) {
        for(Man man: men) {
            if(man.position.equals(pos)) return man;
        }

        return null;
    }

    public void move(final Position from, final Position to) {
        final Man man = getMan(from);

        if(man == null) return;
        if(getMan(to) != null) return;

        man.position = to;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int y = 0; y < SIZE; y++) {
            stringBuilder.append("|");
            for(int x = 0; x < SIZE; x++) {
                final Team foundTeam = getTeamAtPosition(new Position(x, y));
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
        List<Man> men = new ArrayList<>();

        for(int i = 0; i < PLAYERS; i++) {
            if(i % 2 == 0) {
                final Position position1 = new Position(i, 0);
                final Man man1 = new Man(Team.black, position1, Man.Type.man);

                final Position position2 = new Position(i, 2);
                final Man man2 = new Man(Team.black, position2, Man.Type.man);

                men.add(man1);
                men.add(man2);
            } else {
                final Position position = new Position(i, 1);
                final Man man = new Man(Team.black, position, Man.Type.man);

                men.add(man);
            }

            if(i % 2 == 0) {
                final Position position = new Position(i, SIZE - 2);
                final Man man = new Man(Team.white, position, Man.Type.man);

                men.add(man);
            } else {
                final Position position1 = new Position(i, SIZE - 1);
                final Man man1 = new Man(Team.white, position1, Man.Type.man);

                final Position position2 = new Position(i, SIZE - 3);
                final Man man2 = new Man(Team.white, position2, Man.Type.man);

                men.add(man1);
                men.add(man2);
            }
        }

        return new Game(men);
    }
}
