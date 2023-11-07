package org.example;

//Metode
public class Map {

    //Attributter
    private Room currentRoom;

    //Kontruktør (ingen argumenter i parenteserne, hvilket betyder, at den er en "default constructor)
    public Map() {
        initializeRooms();
    }



    //fortæl om rummene
    private void initializeRooms() {

        // Opret de forskellige rum
        Room room1 = new Room("Room 1", "A dark room with two doors to the south and east.");
        room1.addItem(new MeleeWeapon("sword","does physical damage",15)); // navn, skade

        Room room2 = new Room("Room 2", "A dark room with two doors to the west and east.");

        Room room3 = new Room("Room 3", "A dark room with two doors to the west and south.");

        Room room4 = new Room("Room 4", "A dark room with two doors to the north and south.");

        Room room5 = new Room("Room 5", "A dark room with a door to the south.");
        room5.addItem(new RangedWeapon("pistol","shoot bullets",20,7)); // navn, skade, skud

        Room room6 = new Room("Room 6", "A dark room with two doors to the north and south.");

        Room room7 = new Room("Room 7", "A dark room with two doors to the north and east.");
        room7.addItem(new RangedWeapon("bow","shoot arrows",10,10));

        Room room8 = new Room("Room 8", "A dark room with three doors to the west, north, and east.");

        Room room9 = new Room("Room 9", "A dark room with two doors to the north and west.");
        //RangedWeapons er våben, der er designet til at angribe fjender på afstand.
        //MeleeWeapons er våben, der bruges til nærtkamp.


        //fortæl om det her
        Food apple = new Food("Apple", "A red apple", 10);
        room1.addItem(apple);

        Food sandwich = new Food("Sandwich", "A tasty sandwich", 15);
        room7.addItem(sandwich);

        Food burger = new Food("Burger", "A delicious burger", 20);
        room5.addItem(burger);

        Food carrot = new Food("Carrot", "A fresh carrot", 5);
        room3.addItem(carrot);

        Food energyBar = new Food("EnergyBar", "An energy bar", 25);
        room8.addItem(energyBar);




        // Sæt det startende rum
        currentRoom = room1;

        // Dørforbindelser
        room1.setSouthRoom(room4);
        room1.setEastRoom(room2);

        room2.setWestRoom(room1);
        room2.setEastRoom(room3);

        room3.setWestRoom(room2);
        room3.setSouthRoom(room6);

        room4.setNorthRoom(room1);
        room4.setSouthRoom(room5);

        room5.setSouthRoom(room8);

        room6.setNorthRoom(room3);
        room6.setSouthRoom(room7);

        room7.setNorthRoom(room6);
        room7.setEastRoom(room8);

        room8.setWestRoom(room7);
        room8.setNorthRoom(room5);
        room8.setEastRoom(room9);

        room9.setWestRoom(room8);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
