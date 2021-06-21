package it.gioelepannetto.dama;

import java.util.Objects;

public class Man {
    public Position position;
    public Type type;

    public Man(Position position, Type type) {
        this.position = position;
        this.type = type;
    }

    public static class Position {
        public int x;
        public int y;

        public Position(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public enum Type {
        man, king
    }
}
