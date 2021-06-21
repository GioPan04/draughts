package it.gioelepannetto.dama;

import java.util.Objects;

public class Man {
    final public Team team;
    public Position position;
    public Type type;

    public Man(Team team, Position position, Type type) {
        this.team = team;
        this.position = position;
        this.type = type;
    }

    public enum Type {
        man, king
    }
}
