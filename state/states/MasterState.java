package state.states;
import state.Character;

public class MasterState implements CharacterState {
    private Character character;

    public MasterState(Character character) {
        this.character = character;
    }

    public void train() {
        System.out.println("You are already a Master. The journey is complete.");
    }

    public void meditate() {
        System.out.println("You are already a Master. The journey is complete.");
    }

    public void fight() {
        System.out.println("You are already a Master. The journey is complete.");
    }

    public void displayAvailableActions() {
        System.out.println("You are already a Master. The journey is complete.");
    }

    public String getLevelName() {
        return "Master";
    }
}
