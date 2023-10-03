package org.example;

import org.example.Room;
import org.example.Food;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private Room currentRoom;

    public Map() {
        initializeRooms();
    }

    private void initializeRooms() {
        // Opret de forskellige rum
        Room room1 = new Room("Room 1", "A dark room with two doors to the south and east.");
        Room room2 = new Room("Room 2", "A dark room with two doors to the west and east.");
        Room room3 = new Room("Room 3", "A dark room with two doors to the west and south.");
        Room room4 = new Room("Room 4", "A dark room with two doors to the north and south.");
        Room room5 = new Room("Room 5", "A dark room with a door to the south.");
        Room room6 = new Room("Room 6", "A dark room with two doors to the north and south.");
        Room room7 = new Room("Room 7", "A dark room with two doors to the north and east.");
        Room room8 = new Room("Room 8", "A dark room with three doors to the west, north, and east.");
        Room room9 = new Room("Room 9", "A dark room with two doors to the north and west.");

        // Tilføj Food objekter til rum
        Food apple = new Food("Apple", "A red apple", 10);
        room1.addItem(apple);

        Food sandwich = new Food("Sandwich", "A tasty sandwich", 15);
        room2.addItem(sandwich);

        Food burger = new Food("Burger", "A delicious burger", 20);
        room3.addItem(burger);

        Food carrot = new Food("Carrot", "A fresh carrot", 5);
        room4.addItem(carrot);

        Food energyBar = new Food("EnergyBar", "An energy bar", 25);
        room5.addItem(energyBar);

        // Forbind rummene her
        room1.setSouth(room4);
        room1.setEast(room2);

        room2.setWest(room1);
        room2.setEast(room3);

        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);

        room9.setWest(room8);
        room9.setNorth(room6);

        // Sæt det startende rum
        currentRoom = room1;  // Sæt det indledende rum som nødvendigt
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
