package it.gioelepannetto.dama.errors;

public class SamePosition extends GameError {
    public SamePosition() {
        super("You have to move to another position");
    }
}
