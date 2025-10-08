package com.example;
import com.example.tiles.SwampTile;
import com.example.tiles.WaterTile;
import com.example.tiles.ForestTile;
import com.example.tiles.Tile;
import java.util.Random;

public class WildernessMap extends Map {
    @Override
    public Tile createTile() {
        Random random = new Random();
        int tileType = random.nextInt(3);
        switch (tileType) {
            case 0: return new SwampTile();
            case 1: return new WaterTile();
            case 2: return new ForestTile();
            default: return new ForestTile();
        }
    }
}
