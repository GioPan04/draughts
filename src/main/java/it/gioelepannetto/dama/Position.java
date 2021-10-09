package it.gioelepannetto.dama;

import java.util.Objects;

public class Position {
    public int x;
    public int y;

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public double angle(final Position other) {
        return Math.toDegrees(Math.atan2(this.y - other.y, this.x - other.x));
    }

    public double distance(final Position other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    public Position middle(final Position other) {
        return new Position((this.x + other.x) / 2, (this.y + other.y) / 2);
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
