package it.gioelepannetto.dama.errors;

public class GameError extends Exception {
    public final String detail;

    public GameError(String detail) {
        super("Game Error");
        this.detail = detail;
    }
}
