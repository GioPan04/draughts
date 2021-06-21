package it.gioelepannetto.dama.errors;

import it.gioelepannetto.dama.Position;

public class NoPlayerFound extends GameError {
    public NoPlayerFound(final Position position) {
        super(String.format("There is no player in %d %d", position.x, position.y));
    }
}
