package com.example.tiles;

public class SwampTile implements Tile {
    @Override
    public char getCharacter() {
        return 'S';
    }

    @Override
    public String getType() {
        return "Swamp";
    }

    @Override
    public void action() {
        System.out.println("You are in a swamp. Watch out for quicksand!");
    }
}
