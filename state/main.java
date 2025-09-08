package state;
import java.util.Scanner;
import state.states.*;

public class main {
    public static void main(String[] args) {
        Character character = new Character("Matti");
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("\033\143");

            character.getCharachterStatus();
            System.out.println("-----------------------");
            character.getAvailableActions();
            System.out.println("-----------------------");
            System.out.print("Choose an action: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    character.train();
                    break;
                case 2:
                    character.meditate();
                    break;
                case 3:
                    character.fight();
                    break;
                case 4:
                    System.out.println("Exiting game.");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }
        } while (true);
    }
}