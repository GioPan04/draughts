package it.gioelepannetto.dama.errors;

public class OnlyDiagonalMoves extends GameError {
    public OnlyDiagonalMoves() {
        super("You can only move diagonally");
    }
}
