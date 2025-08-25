package tiles;

public class WaterTile implements Tile {
    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    public String getType() {
        return "Water";
    }

    @Override
    public void action() {
        System.out.println("You are in water. You can swim here.");
    }
}