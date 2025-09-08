package state.states;

import state.Character;

public class ExpertState implements CharacterState {
    private Character character;

    public ExpertState(Character character) {
        this.character = character;
    }

    public void train() {
        System.out.println(character.getName() + " is training...");
        character.gainExperience(15);

    }

    public void meditate() {
        System.out.println(character.getName() + " is meditating...");
        character.increaseHealth(20);
    }

    public void fight() {
        System.out.println(character.getName() + " is fighting...");
        character.decreaseHealth(30);
        character.gainExperience(20);
    }

    public void displayAvailableActions() {
        System.out.println("The following actions are available to " + character.getName() + ":");
        System.out.println("1. Train to gain experience");
        System.out.println("2. Meditate to restore health");
        System.out.println("3. Fight to gain experience and lose health");
    }

    public String getLevelName() {
        return "Expert";
    }
}
