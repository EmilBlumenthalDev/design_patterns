package state.states;
import state.Character;

public class IntermediateState implements CharacterState {
    private Character character;

    public IntermediateState(Character character) {
        this.character = character;
    }

    public void train() {
        System.out.println(character.getName() + " is training...");
        character.gainExperience(10);
    }

    public void meditate() {
        System.out.println(character.getName() + " is meditating...");
        character.increaseHealth(10);
    }

    public void fight() {
        System.out.println(character.getName() + " cannot fight at INTERMIDIATE level.");
    }

    public void displayAvailableActions() {
        System.out.println("The following actions are available to " + character.getName() + ":");
        System.out.println("1. Train to gain experience");
        System.out.println("2. Meditate to restore health");
    }

    public String getLevelName() {
        return "Intermidiate";
    }
}
