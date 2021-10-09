package it.gioelepannetto.dama.errors;

public class EatSameTeam extends GameError {
    public EatSameTeam() {
        super("You can't eat someone from your team");
    }
}
