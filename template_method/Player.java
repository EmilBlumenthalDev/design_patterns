package template_method;

public class Player {
    private int id;
    private String name;
    private char character;

    public Player(int id, String name, char character) {
        this.name = name;
        this.id = id;
        this.character = character;
    }

    public char getSymbol() {
        return character;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}