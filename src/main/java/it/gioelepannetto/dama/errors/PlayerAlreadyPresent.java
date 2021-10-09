package it.gioelepannetto.dama.errors;

public class PlayerAlreadyPresent extends GameError {
    public PlayerAlreadyPresent() {
        super("There is already a player in that position");
    }
}
