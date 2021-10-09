package it.gioelepannetto.dama.errors;

public class TooLongDistance extends GameError {
    public TooLongDistance() {
        super("You can't go that far away");
    }
}
