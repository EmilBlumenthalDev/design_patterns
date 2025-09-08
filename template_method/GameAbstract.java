package template_method;

public abstract class GameAbstract {
    public final void play(int numberOfPlayers) {
        initializeGame(numberOfPlayers);
        
        int totalParticipants = (numberOfPlayers == 1) ? 2 : numberOfPlayers;

        int playerInTurn = 0;
        while (!endOfGame()) {
            playSingleTurn(playerInTurn);
            playerInTurn = ++playerInTurn % totalParticipants;
        }
        displayWinner();
    }

    public abstract void initializeGame(int numberOfPlayers);
    public abstract boolean endOfGame();
    public abstract void playSingleTurn(int player);
    public abstract void displayWinner();
}