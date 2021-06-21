package it.gioelepannetto.dama;

import it.gioelepannetto.dama.errors.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int PLAYERS = 12;
    private static final int SIZE = 8;

    private List<Man> men;
    private Team winner;
    private Team turn;

    public Game(List<Man> men) {
        this.men = men;
        this.turn = Team.white;
    }

    public boolean won() {
        return winner != null;
    }

    public Team getTurn() {
        return turn;
    }

    public Team winner() {
        return winner;
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

    private Team checkWinner() {
        if(men.stream().noneMatch(m -> m.team == Team.white)) return Team.black;
        if(men.stream().noneMatch(m -> m.team == Team.black)) return Team.white;
        return null;
    }

    public void move(final Position from, final Position to) throws GameError {
        if(this.winner != null) return;

        // Check if in the selected point there is a player
        final Man man = getMan(from);
        if(man == null) throw new NoPlayerFound(from);

        // You can't stay in position
        if(from == to) throw new SamePosition();

        // Check if the player wants to move non currently playing team
        if(man.team != turn) throw new NotGamingTeam();

        // Can't move if there is someone at that position
        if(getMan(to) != null) throw new PlayerAlreadyPresent();

        // Can't move if distance is more than 1
        if(from.distance(to) > 2) throw new TooLongDistance();

        // Check the angle between the points and allow only diagonal moves
        final double angle = from.angle(to) / 90;
        if(angle % 1 == 0) throw new OnlyDiagonalMoves();

        // White men can only go up (increasing y)
        // Black men can only go down (decreasing y)
        // White and black kings can go up and down
        if(man.type == Man.Type.man) {
            if(man.team == Team.white) {
                if(angle < 0) throw new OnlyForward();
            } else {
                if(angle > 0) throw new OnlyForward();
            }
        }

        // Update the turn and the current player position
        turn = turn == Team.white ? Team.black : Team.white;
        man.position = to;

        // Became a king only if the man touched the up (whites) or down (black) edge
        if(man.type == Man.Type.man) {
            if(man.team == Team.black) {
                if(to.y == SIZE - 1) man.type = Man.Type.king;
            } else {
                if(to.y == 0) man.type = Man.Type.king;
            }
        }

        // Set a winner if there is one
        final Team winner = checkWinner();
        if(winner != null) this.winner = winner;
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
