package com.example.tiles;

public class ForestTile implements Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }

    @Override
    public String getType() {
        return "Grass";
    }

    @Override
    public void action() {
        System.out.println("You are on grass. It's a safe place.");
    }
}