package it.gioelepannetto.dama.errors;

public class NotGamingTeam extends GameError {
    public NotGamingTeam() {
        super("You can move only your team");
    }
}