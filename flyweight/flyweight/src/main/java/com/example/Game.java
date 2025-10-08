package com.example;
public class Game {
    public Map createMap(String type) {
        if (type.equals("City")) {
            return new CityMap();
        } else if (type.equals("Forest")) {
            return new WildernessMap();
        }
        return null;
    }

    public static void main(String[] args) {
        Game game = new Game();
        
        Map cityMap = game.createMap("City");
        System.out.println("City Map:");
        cityMap.display();
        
        Map wildernessMap = game.createMap("Forest");
        System.out.println("Wilderness Map:");
        wildernessMap.display();
    }
}
