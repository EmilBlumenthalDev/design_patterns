package template_method;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game extends GameAbstract {
    private char[][] board;
    private ArrayList<Player> players;
    private int movesMade;
    private Player winner;
    private Scanner scanner;

    @Override
    public void initializeGame(int numberOfPlayers) {
        if (numberOfPlayers < 1 || numberOfPlayers > 2) {
            throw new IllegalArgumentException("Number of players must be 1 or 2.");
        }

        board = new char[3][3];
        movesMade = 0;
        scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';

        players = new ArrayList<>();
        scanner = new Scanner(System.in);

        if (numberOfPlayers == 2) {
            System.out.print("Enter name for Player 1 (X): ");
            players.add(new Player(1, scanner.nextLine(), 'X'));

            System.out.print("Enter name for Player 2 (O): ");
            players.add(new Player(2, scanner.nextLine(), 'O'));
        } else {
            System.out.print("Enter name for Player 1 (X): ");
            players.add(new Player(1, scanner.nextLine(), 'X'));
            players.add(new Player(2, "Computer", 'O'));
        }
    }

    @Override
    public boolean endOfGame() {
        for (Player p : players) {
            if (checkWin(p.getSymbol())) {
                winner = p;
                return true;
            }
        }
        if (movesMade >= 9)
            return true;
        return false;
    }

    @Override
    public void playSingleTurn(int playerIndex) {
        Player current = players.get(playerIndex);

        System.out.println(current.getName() + "'s turn (" + current.getSymbol() + ")");

        int row, col;
        if (current.getName().equals("Computer")) {
            Random rand = new Random();
            do {
                row = rand.nextInt(3);
                col = rand.nextInt(3);
            } while (board[row][col] != ' ');
            System.out.println("Computer chooses: " + row + ", " + col);
        } else {
            while (true) {
                System.out.print("Enter row (0-2): ");
                row = scanner.nextInt();
                System.out.print("Enter col (0-2): ");
                col = scanner.nextInt();

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    break;
                } else {
                    System.out.println("Invalid move, try again.");
                }
            }
        }

        board[row][col] = current.getSymbol();
        movesMade++;
        printBoard();
    }

    @Override
    public void displayWinner() {
        if (winner != null) {
            System.out.println("Winner is: " + winner.getName());
        } else {
            System.out.println("It's a draw!");
        }
    }

    private boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
                return true;
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return true;
        return false;
    }

    private void printBoard() {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("---+---+---");
        }
    }
}
