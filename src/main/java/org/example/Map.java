package org.example;

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

        // Opret våben og tilføj dem til rummene
        MeleeWeapon knife = new MeleeWeapon("Knife", "A sharp knife", 10);
        room1.addWeapon(knife);

        RangedWeapon pistol = new RangedWeapon("Pistol", "A semi-automatic pistol", 20, 10);
        room2.addWeapon(pistol);

        MeleeWeapon bat = new MeleeWeapon("BaseballBat", "A baseball bat", 15);
        room3.addWeapon(bat);

        // Sæt dørforbindelser mellem rummene som tidligere

        // Sæt det startende rum
        currentRoom = room1;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
