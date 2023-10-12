package org.example;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private List<Item> items;
    private List<Enemy> enemies;  // Tilføj en liste over fjender i rummet

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.enemies = new ArrayList<>();  // Initialiser listen over fjender
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorthRoom(Room northRoom) {
        this.north = northRoom;
    }

    public Room getEast() {
        return east;
    }

    public void setEastRoom(Room eastRoom) {
        this.east = eastRoom;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouthRoom(Room southRoom) {
        this.south = southRoom;
    }

    public Room getWest() {
        return west;
    }

    public void setWestRoom(Room westRoom) {
        this.west = westRoom;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItemByName(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the room.");
        } else {
            System.out.println("Items in the room:");
            for (Item item : items) {
                System.out.println("- " + item.getName());
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }
    public List<Enemy> getEnemies() {
        return enemies;
    }
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    }


