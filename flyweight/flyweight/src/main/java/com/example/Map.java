package com.example;
import com.example.tiles.Tile;

public abstract class Map {
    int rows = 5;
    int columns = 8;

    abstract Tile createTile();

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Tile tile = createTile();
                System.out.print(tile.getCharacter());
            }
            System.out.println();
        }
    }
}