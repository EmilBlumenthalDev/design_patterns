package com.example.tiles;

public class BuildingTile implements Tile {
    @Override
    public char getCharacter() {
        return 'B';
    }

    @Override
    public String getType() {
        return "Building";
    }

    @Override
    public void action() {
        System.out.println("You are in a building. It's a safe place.");
    }
}
