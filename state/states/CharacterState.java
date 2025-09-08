package state.states;

public interface CharacterState {
    void train();
    void meditate();
    void fight();
    void displayAvailableActions();
    String getLevelName();
}