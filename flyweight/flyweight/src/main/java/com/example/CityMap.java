package com.example;
import com.example.tiles.BuildingTile;
import com.example.tiles.ForestTile;
import com.example.tiles.RoadTile;
import com.example.tiles.Tile;
import java.util.Random;

public class CityMap extends Map {
    @Override
    public Tile createTile() {
        Random random = new Random();
        int tileType = random.nextInt(3);

        switch (tileType) {
            case 0: return new RoadTile();
            case 1: return new ForestTile();
            case 2: return new BuildingTile();
            default: return new BuildingTile();
        }
    }
}
