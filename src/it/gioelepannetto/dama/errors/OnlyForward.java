package it.gioelepannetto.dama.errors;

public class OnlyForward extends GameError {
    public OnlyForward() {
        super("You can go only forward");
    }
}
