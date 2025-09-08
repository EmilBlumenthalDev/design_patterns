package state.states;
import state.Character;

public class NoviceState implements CharacterState {
    private Character character;

    public NoviceState(Character character) {
        this.character = character;
    }

    public void train() {
        System.out.println(character.getName() + " is training...");
        character.gainExperience(10);
    }

    public void meditate() {
        System.out.println(character.getName() + " cannot meditate at NOVICE level.");
    }

    public void fight() {
        System.out.println(character.getName() + " cannot fight at NOVICE level.");
    }

    public void displayAvailableActions() {
        System.out.println("The following actions are available to " + character.getName() + ":");
        System.out.println("1. Train to gain experience");
    }

    public String getLevelName() {
        return "Novice";
    }
}
